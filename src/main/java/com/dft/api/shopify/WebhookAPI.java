package com.dft.api.shopify;


import com.dft.api.shopify.model.ShopifyPage;
import com.dft.api.shopify.model.ShopifyWebhook;
import com.dft.api.shopify.model.webhook202301.ShopifyWebhooksRoot;
import lombok.SneakyThrows;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.Set;

import static com.dft.api.shopify.ShopifySdk.PAGE_INFO_QUERY_PARAMETER;

public class WebhookAPI {

    private static final String REL_NEXT_HEADER_KEY = "next";
    private static final String REL_PREVIOUS_HEADER_KEY = "previous";
    private static final String AMPERSAND = "&";
    private static final String EQUALS = "=";

    static final String VERSION_2023_01 = "api/2023-01";
    static final String WEBHOOKS = "webhooks";
    private final ShopifySdk shopifySdk;

    public WebhookAPI(ShopifySdk shopifySdk) {
        this.shopifySdk = shopifySdk;
    }

    @SneakyThrows
    public ShopifyPage<ShopifyWebhook> getWebhooks() {
        WebTarget webTarget = shopifySdk.getWebTarget().path(VERSION_2023_01).path(WEBHOOKS);
        final Response response = shopifySdk.get(webTarget);

        ShopifyWebhooksRoot shopifyWebhooksRoot = response.readEntity(ShopifyWebhooksRoot.class);
        return mapPagedResponse(shopifyWebhooksRoot.getWebhooks(), response);
    }

    @SneakyThrows
    private <T> ShopifyPage<T> mapPagedResponse(final List<T> items, final Response response) {

        final ShopifyPage<T> shopifyPage = new ShopifyPage<>();
        shopifyPage.addAll(items);

        final Set<Link> links = response.getLinks();
        final String nextLink = links.stream().filter(link -> link.getRel().equals(REL_NEXT_HEADER_KEY))
            .map(link -> getQueryParam(link.getUri(), PAGE_INFO_QUERY_PARAMETER)).findFirst().orElse(null);
        final String previousLink = links.stream().filter(link -> link.getRel().equals(REL_PREVIOUS_HEADER_KEY))
            .map(link -> getQueryParam(link.getUri(), PAGE_INFO_QUERY_PARAMETER)).findFirst().orElse(null);
        shopifyPage.setNextPageInfo(nextLink);
        shopifyPage.setPreviousPageInfo(previousLink);

        return shopifyPage;
    }

    @SneakyThrows
    private String getQueryParam(final URI uri, final String key) {
        final String[] params = uri.getQuery().split(AMPERSAND);
        for (final String param : params) {
            final String name = param.split(EQUALS)[0];
            final String value = param.split(EQUALS)[1];
            if (name.equals(key)) {
                return value;
            }
        }
        return null;
    }
}