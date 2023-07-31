package com.dft.api.shopify;

import com.dft.api.shopify.exceptions.ShopifyClientException;
import com.dft.api.shopify.exceptions.ShopifyErrorResponseException;
import com.dft.api.shopify.mappers.ShopifySdkObjectMapper;
import com.dft.api.shopify.model.Pagination;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.model.collection.smart.SmartCollectionWrapper;
import com.dft.api.shopify.model.product.ShopifyProductWrapper;
import com.dft.api.shopify.model.webhook202301.ShopifyWebhookWrapper;
import com.dft.api.shopify.v202307.model.orders.ShopifyOrdersWrapper;
import com.dft.api.shopify.v202307.model.products.ShopifyProductsWrapper;
import com.fasterxml.jackson.core.util.JacksonFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.RetryListener;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.dft.api.shopify.constantcode.ConstantCodes.ACCESS_TOKEN_HEADER;
import static com.dft.api.shopify.constantcode.ConstantCodes.HTTPS;
import static com.dft.api.shopify.constantcode.ConstantCodes.HTTP_HEADER_CONTENT_TYPE;
import static com.dft.api.shopify.constantcode.ConstantCodes.HTTP_HEADER_VALUE_APPLICATION_JSON;
import static com.dft.api.shopify.constantcode.ConstantCodes.MAX_ATTEMPTS;
import static com.dft.api.shopify.constantcode.ConstantCodes.TIME_OUT_DURATION;

@Slf4j
public class ShopifySdkNew {

    private static final Integer TOO_MANY_REQUESTS_STATUS_CODE = 429;
    private static final Integer UNPROCESSABLE_ENTITY_STATUS_CODE = 422;
    private static final Integer LOCKED_STATUS_CODE = 423;
    static final String DEPRECATED_REASON_HEADER = "X-Shopify-API-Deprecated-Reason";
    private static final String DEPRECATED_SHOPIFY_CALL_ERROR_MESSAGE = "Shopify call is deprecated. Please take note of the X-Shopify-API-Deprecated-Reason and correct the call.\nRequest Location of {}\nResponse Status Code of {}\nResponse Headers of:\n{}";
    private static final String RETRY_FAILED_MESSAGE = "Request retry has failed.";
    private static final String COULD_NOT_BE_SAVED_SHOPIFY_ERROR_MESSAGE = "could not successfully be saved";
    static final String RETRY_AFTER_HEADER = "Retry-After";
    private static final Long DEFAULT_MAXIMUM_REQUEST_RETRY_TIMEOUT_IN_MILLISECONDS = 180000L;
    private static final Long DEFAULT_MAXIMUM_REQUEST_RETRY_RANDOM_DELAY_IN_MILLISECONDS = 5000L;
    private static final Long DEFAULT_MINIMUM_REQUEST_RETRY_RANDOM_DELAY_IN_MILLISECONDS = 1000L;
    private static final Client CLIENT = buildClient();
    private WebTarget webTarget;
    private long minimumRequestRetryRandomDelayMilliseconds;
    private long maximumRequestRetryRandomDelayMilliseconds;
    private long maximumRequestRetryTimeoutMilliseconds;
    private static final String ADMIN_API_ENDPOINT = "/admin/api";
    private static final String JSON_SUFFIX = ".json";
    public static final String SHOPIFY_DOMAIN_SUFFIX = ".myshopify.com";

    protected String baseUrl;
    protected HttpClient client;
    protected AccessCredential accessCredential;
    protected ObjectMapper objectMapper;

    public ShopifySdkNew(AccessCredential accessCredential) {
        this.client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
        this.accessCredential = accessCredential;
        this.baseUrl = HTTPS + getStoreDomain() + ADMIN_API_ENDPOINT;
        this.minimumRequestRetryRandomDelayMilliseconds = DEFAULT_MINIMUM_REQUEST_RETRY_RANDOM_DELAY_IN_MILLISECONDS;
        this.maximumRequestRetryRandomDelayMilliseconds = DEFAULT_MAXIMUM_REQUEST_RETRY_RANDOM_DELAY_IN_MILLISECONDS;
        this.maximumRequestRetryTimeoutMilliseconds = DEFAULT_MAXIMUM_REQUEST_RETRY_TIMEOUT_IN_MILLISECONDS;
    }

    private String getStoreDomain() {
        String domain = this.accessCredential.getStoreDomain();

        if (!domain.endsWith(SHOPIFY_DOMAIN_SUFFIX)) {
            domain += SHOPIFY_DOMAIN_SUFFIX;
        }
        return domain;
    }

    @SneakyThrows
    protected HttpRequest get(URI uri) {
        return HttpRequest.newBuilder(uri)
            .header(ACCESS_TOKEN_HEADER, this.accessCredential.getAccessToken())
            .header(HTTP_HEADER_CONTENT_TYPE, HTTP_HEADER_VALUE_APPLICATION_JSON)
            .GET()
            .build();
    }

    public URI baseUrl(String version, String path) {
        return URI.create(baseUrl + version + path + JSON_SUFFIX);
    }

    protected static Client buildClient() {
        ObjectMapper mapper = ShopifySdkObjectMapper.buildMapper();
        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        provider.setMapper(mapper);

        return ClientBuilder.newClient()
            .register(JacksonFeature.class)
            .register(provider);
    }

    protected WebTarget getWebTarget() {
        if (this.webTarget == null) {
            if (this.accessCredential.getStoreDomain() != null && !this.accessCredential.getStoreDomain().trim().isEmpty()) {
                this.webTarget = CLIENT.target(HTTPS + this.accessCredential.getStoreDomain());
            }
        }
        return webTarget;
    }

    protected Response get(WebTarget webTarget) {
        Callable<Response> responseCallable = () -> webTarget.request(MediaType.APPLICATION_JSON)
            .header(ACCESS_TOKEN_HEADER, this.accessCredential.getAccessToken()).get();
        Response response = invokeResponseCallable(responseCallable);
        return handleResponse(response, Response.Status.OK);
    }

    protected <T> Response put(WebTarget webTarget, T object) {
        Callable<Response> responseCallable = () -> {
            Entity<T> entity = Entity.entity(object, MediaType.APPLICATION_JSON);
            return webTarget.request(MediaType.APPLICATION_JSON)
                            .header(ACCESS_TOKEN_HEADER, accessCredential.getAccessToken())
                            .put(entity);
        };
        Response response = invokeResponseCallable(responseCallable);
        return handleResponse(response, Response.Status.OK);
    }

    public static class ShopifySdkRetryListener implements RetryListener {

        private static final String RETRY_EXCEPTION_ATTEMPT_MESSAGE = "An exception occurred while making an API call to shopify: {} on attempt number {} and {} seconds since first attempt";
        private static final String RETRY_INVALID_RESPONSE_ATTEMPT_MESSAGE = "Waited {} seconds since first retry attempt. This is attempt {}. Please review the following failed request information.\nRequest Location of {}\nResponse Status Code of {}\nResponse Headers of:\n{}\nResponse Body of:\n{}";

        @Override
        public <V> void onRetry(Attempt<V> attempt) {
            if (attempt.hasResult()) {
                Response response = (Response) attempt.getResult();

                response.bufferEntity();
                String responseBody = response.readEntity(String.class);

                if (log.isWarnEnabled() && !hasExceededRateLimit(response) && shouldRetryResponse(response)) {
                    long delaySinceFirstAttemptInSeconds = convertMillisecondsToSeconds(
                        attempt.getDelaySinceFirstAttempt());
                    log.warn(RETRY_INVALID_RESPONSE_ATTEMPT_MESSAGE,
                        delaySinceFirstAttemptInSeconds,
                        attempt.getAttemptNumber(),
                        response.getLocation(),
                        response.getStatus(),
                        response.getStringHeaders(),
                        responseBody);
                }

            } else if (log.isWarnEnabled() && attempt.hasException()) {
                long delaySinceFirstAttemptInSeconds = convertMillisecondsToSeconds(
                    attempt.getDelaySinceFirstAttempt());
                log.warn(RETRY_EXCEPTION_ATTEMPT_MESSAGE, attempt.getAttemptNumber(),
                    delaySinceFirstAttemptInSeconds, attempt.getExceptionCause());
            }
        }

        private long convertMillisecondsToSeconds(long milliiseconds) {
            return TimeUnit.SECONDS
                           .convert(milliiseconds, TimeUnit.MILLISECONDS);
        }
    }

    protected Response handleResponse(Response response, Response.Status... expectedStatus) {
        List<Integer> expectedStatusCodes = getExpectedStatusCodes(expectedStatus);
        if (expectedStatusCodes.contains(response.getStatus())) {
            return response;
        } else {
            if ((response.getHeaders() != null) && response.getHeaders().containsKey(DEPRECATED_REASON_HEADER)) {
                log.error(DEPRECATED_SHOPIFY_CALL_ERROR_MESSAGE,
                    response.getLocation(),
                    response.getStatus(),
                    response.getStringHeaders());
            }
        }
        throw new ShopifyErrorResponseException(response);
    }

    protected List<Integer> getExpectedStatusCodes(Response.Status... expectedStatus) {
        return Arrays.stream(expectedStatus).map(Response.Status::getStatusCode).collect(Collectors.toList());
    }

    protected Response invokeResponseCallable(Callable<Response> responseCallable) {
        Retryer<Response> retryer = buildResponseRetyer();
        try {
            return retryer.call(responseCallable);

        } catch (ExecutionException | RetryException exception) {
            throw new ShopifyClientException(RETRY_FAILED_MESSAGE, exception);
        }
    }

    protected Retryer<Response> buildResponseRetyer() {
        return RetryerBuilder.<Response>newBuilder().retryIfResult(ShopifySdkNew::shouldRetryResponse).retryIfException()
            .withWaitStrategy(WaitStrategies.randomWait(minimumRequestRetryRandomDelayMilliseconds,
                TimeUnit.MILLISECONDS, maximumRequestRetryRandomDelayMilliseconds, TimeUnit.MILLISECONDS))
            .withStopStrategy(
                StopStrategies.stopAfterDelay(maximumRequestRetryTimeoutMilliseconds, TimeUnit.MILLISECONDS))
            .withRetryListener(new ShopifySdkRetryListener()).build();
    }

    private static boolean shouldRetryResponse(Response response) {
        return isServerError(response) || hasExceededRateLimit(response) || hasNotBeenSaved(response) || hasWaitCall(response);
    }

    private static boolean isServerError(Response response) {
        return (Response.Status.Family.SERVER_ERROR == Response.Status.Family.familyOf(response.getStatus()))
            || (LOCKED_STATUS_CODE == response.getStatus());
    }

    private static boolean hasExceededRateLimit(Response response) {
        return TOO_MANY_REQUESTS_STATUS_CODE == response.getStatus()
            && response.getHeaders().containsKey(RETRY_AFTER_HEADER);
    }

    private static boolean hasNotBeenSaved(Response response) {
        response.bufferEntity();
        if ((UNPROCESSABLE_ENTITY_STATUS_CODE == response.getStatus()) && response.hasEntity()) {
            String shopifyErrorResponse = response.readEntity(String.class);
            log.debug(shopifyErrorResponse);
            return shopifyErrorResponse.contains(COULD_NOT_BE_SAVED_SHOPIFY_ERROR_MESSAGE);
        }
        return false;
    }

    private static boolean hasWaitCall(Response response) {
        return 202 == response.getStatus();
    }

    @SneakyThrows
    protected HttpRequest post(URI uri, String json) {
        return HttpRequest.newBuilder(uri)
            .header(ACCESS_TOKEN_HEADER, this.accessCredential.getAccessToken())
            .header(HTTP_HEADER_CONTENT_TYPE, HTTP_HEADER_VALUE_APPLICATION_JSON)
            .POST(HttpRequest.BodyPublishers.ofString(json))
            .build();
    }

    @SneakyThrows
    protected HttpRequest postWithObject(URI uri, Object object) {
        String jsonBody = objectMapper.writeValueAsString(object);

        return HttpRequest.newBuilder(uri)
            .header(ACCESS_TOKEN_HEADER, this.accessCredential.getAccessToken())
            .header(HTTP_HEADER_CONTENT_TYPE, HTTP_HEADER_VALUE_APPLICATION_JSON)
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();
    }

    @SneakyThrows
    protected HttpRequest put(URI uri, String json) {
        return HttpRequest.newBuilder(uri)
            .header(ACCESS_TOKEN_HEADER, this.accessCredential.getAccessToken())
            .header(HTTP_HEADER_CONTENT_TYPE, HTTP_HEADER_VALUE_APPLICATION_JSON)
            .PUT(HttpRequest.BodyPublishers.ofString(json))
            .build();
    }

    @SneakyThrows
    protected HttpRequest putWithObject(URI uri, Object object) {
        String jsonBody = objectMapper.writeValueAsString(object);

        return HttpRequest.newBuilder(uri)
            .header(ACCESS_TOKEN_HEADER, this.accessCredential.getAccessToken())
            .header(HTTP_HEADER_CONTENT_TYPE, HTTP_HEADER_VALUE_APPLICATION_JSON)
            .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();
    }

    @SneakyThrows
    protected HttpRequest delete(URI uri) {
        return HttpRequest.newBuilder(uri)
            .header(ACCESS_TOKEN_HEADER, this.accessCredential.getAccessToken())
            .header(HTTP_HEADER_CONTENT_TYPE, HTTP_HEADER_VALUE_APPLICATION_JSON)
            .DELETE()
            .build();
    }

    @SneakyThrows
    protected HttpRequest postWithoutAccessToken(URI uri) {
        return HttpRequest.newBuilder(uri)
            .header(HTTP_HEADER_CONTENT_TYPE, HTTP_HEADER_VALUE_APPLICATION_JSON)
            .POST(HttpRequest.BodyPublishers.noBody())
            .build();
    }

    @SneakyThrows
    protected URI addParameters(URI uri, HashMap<String, String> params) {
        String query = uri.getQuery();
        StringBuilder builder = new StringBuilder();

        if (query != null)
            builder.append(query);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String keyValueParam = entry.getKey() + "=" + entry.getValue();
            if (!builder.toString().isEmpty())
                builder.append("&");
            builder.append(keyValueParam);
        }
        return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), builder.toString(), uri.getFragment());
    }

    @SneakyThrows
    protected <T> T getRequestWrapped(HttpRequest request, Class<T> tClass) {

        HttpResponse<String> stringHttpResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenComposeAsync(response -> tryResend(client, request, HttpResponse.BodyHandlers.ofString(), response, 1))
                .get();

        T resp = convertBody(stringHttpResponse.body(), tClass);
        Pagination paginationLinks = getPaginationLinks(stringHttpResponse);

        Field[] fields = tClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.getName().equalsIgnoreCase("pagination")) {
                field.setAccessible(true);
                field.set(resp, paginationLinks);
                break;
            }
        }
        return resp;
    }

    @SneakyThrows
    protected <T> CompletableFuture<HttpResponse<T>> tryResend(HttpClient client,
                                                               HttpRequest request,
                                                               HttpResponse.BodyHandler<T> handler,
                                                               HttpResponse<T> resp, Integer count) {

        if (resp.statusCode() == 409 && count < MAX_ATTEMPTS) {
            Thread.sleep(TIME_OUT_DURATION);
            return client.sendAsync(request, handler)
                .thenComposeAsync(response -> tryResend(client, request, handler, response, count + 1));
        }

        return CompletableFuture.completedFuture(resp);
    }


    public Pagination getPaginationLinks(HttpResponse response) {
        Pagination pagination = new Pagination();

        if (response.headers().firstValue("Link").isEmpty()) {
            return pagination;
        }
        String values = response.headers()
            .allValues("Link")
            .get(0);
        if (values == null) {
            return pagination;
        }
        String[] sUrl = values.split(",");

        for (String navigation : sUrl) {
            String[] urlRel = navigation.split(";");
            String url = urlRel[0].replaceAll("<", "")
                .replaceAll(">", "")
                .split("\\?")[1];

            String rel = urlRel[1].split("=")[1]
                .replaceAll("\"", "");

            StringTokenizer stringTokenizer = new StringTokenizer(url, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String token = stringTokenizer.nextToken();
                if (token.startsWith("page_info")) {
                    url = token.split("=")[1];
                }
            }
            if (rel.equalsIgnoreCase("next")) {
                pagination.setNext(url);
            } else if (rel.equalsIgnoreCase("previous")) {
                pagination.setPrevious(url);
            }
        }
        return pagination;
    }

    @SneakyThrows
    private <T> T convertBody(String body, Class<T> tClass) {
        return objectMapper.readValue(body, tClass);
    }
}