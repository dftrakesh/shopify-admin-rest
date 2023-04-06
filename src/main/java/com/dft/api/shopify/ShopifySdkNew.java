package com.dft.api.shopify;

import com.dft.api.shopify.model.auth.AccessCredential;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import static com.dft.api.shopify.constantcode.ConstantCodes.ACCESS_TOKEN_HEADER;
import static com.dft.api.shopify.constantcode.ConstantCodes.HTTP_HEADER_CONTENT_TYPE;
import static com.dft.api.shopify.constantcode.ConstantCodes.HTTP_HEADER_VALUE_APPLICATION_JSON;
import static com.dft.api.shopify.constantcode.ConstantCodes.MAX_ATTEMPTS;
import static com.dft.api.shopify.constantcode.ConstantCodes.TIME_OUT_DURATION;

public class ShopifySdkNew {

    protected HttpClient client;
    protected AccessCredential accessCredential;
    protected ObjectMapper objectMapper;

    public ShopifySdkNew(AccessCredential accessCredential) {
        client = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
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
        return CompletableFuture.completedFuture(resp);
    }
}