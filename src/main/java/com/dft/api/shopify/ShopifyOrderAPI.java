package com.dft.api.shopify;

import com.dft.api.shopify.model.ShopifyOrderUpdateRequest;
import com.dft.api.shopify.model.ShopifyOrderUpdateRoot;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.model.order.v202307.ShopifyOrder;
import com.dft.api.shopify.model.order.v202307.ShopifyOrderRoot;
import com.dft.api.shopify.model.order.v202307.ShopifyOrderWrapper;

import java.net.URI;
import java.net.http.HttpRequest;

import static com.dft.api.shopify.constantcode.ConstantCodes.FORWARD_SLASH;
import static com.dft.api.shopify.constantcode.ConstantCodes.HTTPS;
import static com.dft.api.shopify.constantcode.ConstantCodes.JSON;
import static com.dft.api.shopify.constantcode.ConstantCodes.ORDERS_END_POINT_WITH_JSON;
import static com.dft.api.shopify.constantcode.ConstantCodes.VERSION_2023_07;

public class ShopifyOrderAPI extends ShopifySdkNew {

    static final String ORDERS = "orders";

    public ShopifyOrderAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public ShopifyOrderWrapper getAllOrders() {
        URI uri = URI.create(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_07 + ORDERS_END_POINT_WITH_JSON);
        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyOrderWrapper.class);
    }

    public ShopifyOrder getOrderById(String id) {
        URI uri = URI.create(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_07 + ORDERS + FORWARD_SLASH + id + JSON);
        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyOrderRoot.class).getOrder();
    }

    public ShopifyOrder updateOrder(ShopifyOrderUpdateRequest shopifyOrderUpdateRequest) {
        ShopifyOrderUpdateRoot shopifyOrderRoot = new ShopifyOrderUpdateRoot();
        shopifyOrderRoot.setOrder(shopifyOrderUpdateRequest);

        URI uri = URI.create(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_07 + ORDERS + FORWARD_SLASH + shopifyOrderUpdateRequest.getId() + JSON);
        HttpRequest httpRequest = putWithObject(uri, shopifyOrderRoot);
        return getRequestWrapped(httpRequest, ShopifyOrderRoot.class).getOrder();
    }
}
