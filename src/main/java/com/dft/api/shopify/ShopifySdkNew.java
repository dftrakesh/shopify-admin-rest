package com.dft.api.shopify;

import com.dft.api.shopify.model.Pagination;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.model.product.ShopifyProductWrapper;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.CompletableFuture;
import static com.dft.api.shopify.constantcode.ConstantCodes.ACCESS_TOKEN_HEADER;
import static com.dft.api.shopify.constantcode.ConstantCodes.HTTP_HEADER_CONTENT_TYPE;
import static com.dft.api.shopify.constantcode.ConstantCodes.HTTP_HEADER_VALUE_APPLICATION_JSON;
import static com.dft.api.shopify.constantcode.ConstantCodes.MAX_ATTEMPTS;
import static com.dft.api.shopify.constantcode.ConstantCodes.TIME_OUT_DURATION;

public class ShopifySdkNew {

    protected HttpClient client;
    protected AccessCredential accessCredential;


    public ShopifySdkNew(AccessCredential accessCredential) {
        client = HttpClient.newHttpClient();
        this.accessCredential = accessCredential;
    }

    @SneakyThrows
    protected HttpRequest get(URI uri) {
        return HttpRequest.newBuilder(uri)
                          .header(ACCESS_TOKEN_HEADER, this.accessCredential.getAccessToken())
                          .header(HTTP_HEADER_CONTENT_TYPE, HTTP_HEADER_VALUE_APPLICATION_JSON)
                          .GET()
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
    public <T> T getRequestWrapped(HttpRequest request, HttpResponse.BodyHandler<T> handler) {
        return client.sendAsync(request, handler)
                     .thenComposeAsync(response -> tryResend(client, request, handler, response, 1))
                     .get()
                     .body();
    }

    @SneakyThrows
    public <T> CompletableFuture<HttpResponse<T>> tryResend(HttpClient client,
                                                            HttpRequest request,
                                                            HttpResponse.BodyHandler<T> handler,
                                                            HttpResponse<T> resp, int count) {
        if (resp.statusCode() == 409 && count < MAX_ATTEMPTS) {
            Thread.sleep(TIME_OUT_DURATION);
            return client.sendAsync(request, handler)
                         .thenComposeAsync(response -> tryResend(client, request, handler, response, count + 1));
        }
        setPagination(resp);
        return CompletableFuture.completedFuture(resp);
    }

    @SneakyThrows
    private void setPagination(HttpResponse resp) {
        Pagination pagination = getPaginationLinks(resp);

        if (resp.body() instanceof ShopifyProductWrapper)
            ((ShopifyProductWrapper) resp.body()).setPagination(pagination);
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
}