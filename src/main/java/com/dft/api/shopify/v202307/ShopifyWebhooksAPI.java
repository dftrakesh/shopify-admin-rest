package com.dft.api.shopify.v202307;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202307.model.webhook.ShopifyWebhookRequest;
import com.dft.api.shopify.v202307.model.webhook.ShopifyWebhookWrapper;
import com.dft.api.shopify.v202307.model.webhook.ShopifyWebhooksWrapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static com.dft.api.shopify.constantcode.ConstantCodes.FORWARD_SLASH;

public class ShopifyWebhooksAPI extends ShopifySdkNew {

    public static final String VERSION_2023_07 = "/2023-07";
    private static final String WEBHOOKS_ENDPOINT = "/webhooks";

    public ShopifyWebhooksAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public ShopifyWebhooksWrapper getAllWebhooks(HashMap<String, String> params) {
        URI uri = baseUrl(VERSION_2023_07, WEBHOOKS_ENDPOINT);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyWebhooksWrapper.class);
    }

    public ShopifyWebhookWrapper createWebhook(ShopifyWebhookRequest shopifyWebhookRequest) {
        URI uri = baseUrl(VERSION_2023_07, WEBHOOKS_ENDPOINT);

        HttpRequest request = postWithObject(uri, shopifyWebhookRequest);
        return getRequestWrapped(request, ShopifyWebhookWrapper.class);
    }

    public ShopifyWebhookWrapper getWebhookById(Long webhookId) {
        URI uri = baseUrl(VERSION_2023_07, WEBHOOKS_ENDPOINT + FORWARD_SLASH + webhookId);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyWebhookWrapper.class);
    }

    public void deleteByWebhookById(Long webhookId) {
        URI uri = baseUrl(VERSION_2023_07, WEBHOOKS_ENDPOINT + FORWARD_SLASH + webhookId);
        System.out.println("uri = " + uri);

        HttpRequest request = delete(uri);
        getRequestWrapped(request, HttpResponse.BodyHandlers.ofString().getClass());
    }
}