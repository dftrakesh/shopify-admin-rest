package com.dft.api.shopify;

import com.dft.api.shopify.model.ShopifyWebhookRoot;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.model.webhook202301.ShopifyWebhookWrapper;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;

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
        HttpRequest request = postWithObject(uri, shopifyWebhookRoot);
        return getRequestWrapped(request, ShopifyWebhookRoot.class);
    }

    @SneakyThrows
    public ShopifyWebhookWrapper getWebhooks() {
        URI uri = new URI(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_01 + WEBHOOK_END_POINT_WITH_JSON);
        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyWebhookWrapper.class);
    }

    @SneakyThrows
    public void deleteWebhook(String webhookId) {
        URI uri = new URI(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_01 + WEBHOOK_END_POINT + "/" + webhookId + ".json");

        HttpRequest request = delete(uri);
        getRequestWrapped(request, ShopifyWebhookWrapper.class);
    }
}