package com.dft.api.shopify;

import com.dft.api.shopify.handler.JsonBodyHandler;
import com.dft.api.shopify.model.ShopifyWebhookRoot;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.model.webhook202301.ShopifyWebhookWrapper;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static com.dft.api.shopify.constantcode.ConstantCodes.HTTPS;
import static com.dft.api.shopify.constantcode.ConstantCodes.VERSION_2023_01;
import static com.dft.api.shopify.constantcode.ConstantCodes.WEBHOOK_END_POINT;
import static com.dft.api.shopify.constantcode.ConstantCodes.WEBHOOK_END_POINT_WITH_JSON;

public class ShopifyWebhookAPI extends ShopifySdkNew {

    public ShopifyWebhookAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ShopifyWebhookRoot createWebhook(ShopifyWebhookRoot shopifyWebhookRoot) {
        URI uri = new URI(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_01 + WEBHOOK_END_POINT_WITH_JSON);

        String jsonBody = objectMapper.writeValueAsString(shopifyWebhookRoot);
        HttpRequest request = post(uri, jsonBody);

        HttpResponse.BodyHandler<ShopifyWebhookRoot> handler = new JsonBodyHandler<>(ShopifyWebhookRoot.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public ShopifyWebhookWrapper getWebhooks() {

        URI uri = new URI(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_01 + WEBHOOK_END_POINT_WITH_JSON);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<ShopifyWebhookWrapper> handler = new JsonBodyHandler<>(ShopifyWebhookWrapper.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public void deleteWebhook(String webhookId) {

        URI uri = new URI(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_01 + WEBHOOK_END_POINT + "/" + webhookId + ".json");

        HttpRequest request = delete(uri);
        HttpResponse.BodyHandler<ShopifyWebhookWrapper> handler = new JsonBodyHandler<>(ShopifyWebhookWrapper.class);
        getRequestWrapped(request, handler);
    }
}