package com.dft.api.shopify;

import com.dft.api.shopify.model.fulfillments.v202301.FulfillmentOrdersRoot;
import com.dft.api.shopify.model.fulfillments.v202301.ShopifyFulfillment;
import com.dft.api.shopify.model.fulfillments.v202301.ShopifyFulfillmentCreationRequest;
import com.dft.api.shopify.model.fulfillments.v202301.ShopifyFulfillmentRoot;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class FulfillmentAPI {

    static final String VERSION_2023_01 = "api/2023-01";
    static final String FULFILLMENTS = "fulfillments.json";
    static final String ORDERS = "orders";
    static final String FULFILLMENT_ORDERS = "fulfillment_orders.json";
    private final ShopifySdk shopifySdk;

    public FulfillmentAPI(ShopifySdk shopifySdk) {
        this.shopifySdk = shopifySdk;
    }

    public ShopifyFulfillment createFulfillment(final ShopifyFulfillmentCreationRequest shopifyFulfillmentCreationRequest) {
        WebTarget webTarget = shopifySdk.getWebTarget().path(VERSION_2023_01).path(FULFILLMENTS);
        final Response response = shopifySdk.post(webTarget, shopifyFulfillmentCreationRequest);
        final ShopifyFulfillmentRoot shopifyFulfillmentRootResponse = response.readEntity(ShopifyFulfillmentRoot.class);
        return shopifyFulfillmentRootResponse.getFulfillment();
    }

    public FulfillmentOrdersRoot getFulfillmentOrders(Long orderId) {
        WebTarget webTarget = shopifySdk.getWebTarget().path(VERSION_2023_01).path(ORDERS).path(orderId.toString()).path(FULFILLMENT_ORDERS);
        final Response response = shopifySdk.get(webTarget);
        return response.readEntity(FulfillmentOrdersRoot.class);
    }
}