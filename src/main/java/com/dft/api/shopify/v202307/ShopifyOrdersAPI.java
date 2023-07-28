package com.dft.api.shopify.v202307;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202307.model.orders.ShopifyOrderRequest;
import com.dft.api.shopify.v202307.model.orders.ShopifyOrderWrapper;

import java.net.URI;
import java.net.http.HttpRequest;

import static com.dft.api.shopify.constantcode.ConstantCodes.FORWARD_SLASH;

public class ShopifyOrdersAPI extends ShopifySdkNew {

    private static final String ORDERS_ENDPOINT = "/orders";
    public static final String VERSION_2023_07 = "/2023-07";

    public ShopifyOrdersAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public ShopifyOrderWrapper updateShopifyOrder(Long orderId, ShopifyOrderRequest shopifyOrderRequest) {
        URI uri = baseUrl(VERSION_2023_07, ORDERS_ENDPOINT + FORWARD_SLASH + orderId);

        HttpRequest request = putWithObject(uri, shopifyOrderRequest);
        return getRequestWrapped(request, ShopifyOrderWrapper.class);
    }
}