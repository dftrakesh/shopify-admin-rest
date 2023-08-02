package com.dft.api.shopify.v202307;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202307.model.fullfillment.ShopifyFulfillmentRequest;
import com.dft.api.shopify.v202307.model.fullfillment.ShopifyFulfillmentWrapper;
import com.dft.api.shopify.v202307.model.fullfillment.ShopifyFulfillmentsWrapper;

import java.net.URI;
import java.net.http.HttpRequest;

import static com.dft.api.shopify.constantcode.ConstantCodes.FORWARD_SLASH;

public class ShopifyFulfillmentAPI extends ShopifySdkNew {

    public static final String VERSION_2023_07 = "/2023-07";
    private static final String ORDERS_ENDPOINT = "/orders";
    private static final String FULFILLMENTS_ENDPOINT = "/fulfillments";
    private static final String FULFILLMENT_ORDERS_ENDPOINT = "/fulfillment_orders";

    public ShopifyFulfillmentAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public ShopifyFulfillmentWrapper createShopifyFulfillment(ShopifyFulfillmentRequest shopifyFulfillmentRequest) {
        URI uri = baseUrl(VERSION_2023_07, FULFILLMENTS_ENDPOINT);

        HttpRequest request = postWithObject(uri, shopifyFulfillmentRequest);
        return getRequestWrapped(request, ShopifyFulfillmentWrapper.class);
    }

    public ShopifyFulfillmentsWrapper getAllShopifyFullfillmentByOrderId(Long orderId) {
        URI uri = baseUrl(VERSION_2023_07, ORDERS_ENDPOINT + FORWARD_SLASH + orderId + FULFILLMENT_ORDERS_ENDPOINT);
        System.out.println("uri = " + uri);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyFulfillmentsWrapper.class);
    }
}
