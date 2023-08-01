package com.dft.api.shopify.v202307;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202307.model.metafields.ShopifyMetafieldRequest;
import com.dft.api.shopify.v202307.model.metafields.ShopifyMetafieldWrapper;
import com.dft.api.shopify.v202307.model.metafields.ShopifyMetafieldsWrapper;
import com.dft.api.shopify.v202307.model.orders.ShopifyOrderRequest;
import com.dft.api.shopify.v202307.model.orders.ShopifyOrderWrapper;
import com.dft.api.shopify.v202307.model.orders.ShopifyOrdersWrapper;
import com.dft.api.shopify.v202307.model.transactions.ShopifyTransactionRequest;
import com.dft.api.shopify.v202307.model.transactions.ShopifyTransactionWrapper;
import com.dft.api.shopify.v202307.model.transactions.ShopifyTransactionsWrapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static com.dft.api.shopify.constantcode.ConstantCodes.FORWARD_SLASH;

public class ShopifyOrdersAPI extends ShopifySdkNew {

    private static final String ORDERS_ENDPOINT = "/orders";
    public static final String VERSION_2023_07 = "/2023-07";
    public static final String METAFIELDS_ENDPOINT = "/metafields";
    private static final String TRANSACTIONS_ENDPOINT = "/transactions";

    public ShopifyOrdersAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public ShopifyOrdersWrapper getAllOrders(HashMap<String, String> params) {
        URI uri = baseUrl(VERSION_2023_07, ORDERS_ENDPOINT);
        uri = addParameters(uri, params);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyOrdersWrapper.class);
    }

    public ShopifyOrderWrapper getOrder(Long orderId, HashMap<String, String> params) {
        URI uri = baseUrl(VERSION_2023_07, ORDERS_ENDPOINT + FORWARD_SLASH + orderId);
        uri = addParameters(uri, params);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyOrderWrapper.class);
    }

    public ShopifyOrderWrapper createShopifyOrder(ShopifyOrderRequest shopifyOrderRequest) {
        URI uri = baseUrl(VERSION_2023_07, ORDERS_ENDPOINT);

        HttpRequest request = postWithObject(uri, shopifyOrderRequest);
        return getRequestWrapped(request, ShopifyOrderWrapper.class);
    }

    public ShopifyOrderWrapper updateShopifyOrder(Long orderId, ShopifyOrderRequest shopifyOrderRequest) {
        URI uri = baseUrl(VERSION_2023_07, ORDERS_ENDPOINT + FORWARD_SLASH + orderId);

        HttpRequest request = putWithObject(uri, shopifyOrderRequest);
        return getRequestWrapped(request, ShopifyOrderWrapper.class);
    }

    public ShopifyTransactionWrapper createOrderTransactionByOrderId(Long orderId, ShopifyTransactionRequest shopifyTransactionRequest) {
        URI uri = baseUrl(VERSION_2023_07, ORDERS_ENDPOINT + FORWARD_SLASH + orderId + TRANSACTIONS_ENDPOINT);

        HttpRequest request = postWithObject(uri, shopifyTransactionRequest);
        return getRequestWrapped(request, ShopifyTransactionWrapper.class);
    }

    public ShopifyTransactionsWrapper getOrderTransactionByOrderId(Long orderId) {
        URI uri = baseUrl(VERSION_2023_07, ORDERS_ENDPOINT + FORWARD_SLASH + orderId + TRANSACTIONS_ENDPOINT);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyTransactionsWrapper.class);
    }

    public ShopifyMetafieldWrapper createOrderMetafieldsByOrderId(Long orderId, ShopifyMetafieldRequest shopifyMetafieldRequest) {
        URI uri = baseUrl(VERSION_2023_07, ORDERS_ENDPOINT + FORWARD_SLASH + orderId + METAFIELDS_ENDPOINT);

        HttpRequest request = postWithObject(uri, shopifyMetafieldRequest);
        return getRequestWrapped(request, ShopifyMetafieldWrapper.class);
    }

    public ShopifyMetafieldsWrapper getOrderMetafieldsByOrderId(Long orderId) {
        URI uri = baseUrl(VERSION_2023_07, ORDERS_ENDPOINT + FORWARD_SLASH + orderId + METAFIELDS_ENDPOINT);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyMetafieldsWrapper.class);
    }
}