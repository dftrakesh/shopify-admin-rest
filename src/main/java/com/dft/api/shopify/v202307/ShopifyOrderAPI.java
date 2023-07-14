package com.dft.api.shopify.v202307;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.ShopifyOrder;
import com.dft.api.shopify.model.ShopifyOrderCreationRequest;
import com.dft.api.shopify.model.ShopifyOrderRoot;
import com.dft.api.shopify.model.ShopifyOrderUpdateRequest;
import com.dft.api.shopify.model.ShopifyOrderUpdateRoot;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.model.order.v202307.ShopifyOrderWrapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.client.WebTarget;
import java.net.URI;
import java.net.http.HttpRequest;

import static com.dft.api.shopify.constantcode.ConstantCodes.FORWARD_SLASH;
import static com.dft.api.shopify.constantcode.ConstantCodes.JSON;
import static com.dft.api.shopify.constantcode.ConstantCodes.ORDERS_END_POINT_WITH_JSON;
import static com.dft.api.shopify.constantcode.ConstantCodes.VERSION_2023_07;

@Slf4j
public class ShopifyOrderAPI extends ShopifySdkNew {

    static final String ORDERS = "orders";
    private static final String HTTPS = "https://";


    public ShopifyOrderAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public void getAllOrders() {
        URI uri = URI.create(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_07 + ORDERS_END_POINT_WITH_JSON);
        HttpRequest request = get(uri);
        log.debug("request: {}", request);
        ShopifyOrderWrapper requestWrapped = getRequestWrapped(request, ShopifyOrderWrapper.class);
        System.out.println("Response: "+ requestWrapped);
    }

    public void createOrder(ShopifyOrderCreationRequest shopifyOrderCreationRequest) {
        ShopifyOrderRoot shopifyOrderRoot = new ShopifyOrderRoot();
        ShopifyOrder shopifyOrder = shopifyOrderCreationRequest.getRequest();
        shopifyOrderRoot.setOrder(shopifyOrder);

        URI uri = URI.create(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_07 + ORDERS + JSON);
        HttpRequest httpRequest = postWithObject(uri, shopifyOrderRoot);
        ShopifyOrder requestWrapped = getRequestWrapped(httpRequest, ShopifyOrder.class);
        System.out.println("requestWrapped " + requestWrapped);
    }

    public ShopifyOrder updateOrder(ShopifyOrderUpdateRequest shopifyOrderUpdateRequest) {
        ShopifyOrderUpdateRoot shopifyOrderRoot = new ShopifyOrderUpdateRoot();
        shopifyOrderRoot.setOrder(shopifyOrderUpdateRequest);

        URI uri = URI.create(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_07 + ORDERS + FORWARD_SLASH + shopifyOrderUpdateRequest.getId() + JSON);

        HttpRequest httpRequest = putWithObject(uri, shopifyOrderRoot);
        log.debug("httpRequest: {}", httpRequest);

        ShopifyOrder requestWrapped = getRequestWrapped(httpRequest, ShopifyOrder.class);
        System.out.println("Response: " + requestWrapped);
        return requestWrapped;
    }
}
