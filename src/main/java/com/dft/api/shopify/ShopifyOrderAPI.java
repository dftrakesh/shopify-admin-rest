package com.dft.api.shopify;

import com.dft.api.shopify.model.ShopifyOrderUpdateRequest;
import com.dft.api.shopify.model.ShopifyOrderUpdateRoot;
import com.dft.api.shopify.model.ShopifyPage;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.model.order.v202307.ShopifyOrder;
import com.dft.api.shopify.model.order.v202307.ShopifyOrderRoot;
import com.dft.api.shopify.model.order.v202307.ShopifyOrdersRoot;
import lombok.SneakyThrows;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static com.dft.api.shopify.constantcode.ConstantCodes.FORWARD_SLASH;
import static com.dft.api.shopify.constantcode.ConstantCodes.HTTPS;
import static com.dft.api.shopify.constantcode.ConstantCodes.JSON;
import static com.dft.api.shopify.constantcode.ConstantCodes.VERSION_2023_07;
import static com.dft.api.shopify.constantcode.ConstantCodes.LIMIT;


public class ShopifyOrderAPI extends ShopifySdkNew {

    static final String ORDERS = "orders";
    private static final String EQUALS = "=";
    private static final String REL_NEXT_HEADER_KEY = "next";
    private static final String REL_PREVIOUS_HEADER_KEY = "previous";
    static final String PAGE_INFO_QUERY_PARAMETER = "page_info";
    private static final String AMPERSAND = "&";

    static final String LIMIT_QUERY_PARAMETER = "limit";
    private static final int DEFAULT_REQUEST_LIMIT = 250;

    public ShopifyOrderAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ShopifyOrder getOrderById(String id) {
        URI uri = URI.create(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_07 + ORDERS + FORWARD_SLASH + id + JSON);
        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyOrderRoot.class).getOrder();
    }

    public ShopifyOrder updateOrder(ShopifyOrderUpdateRequest shopifyOrderUpdateRequest) {
        ShopifyOrderUpdateRoot shopifyOrderRoot = new ShopifyOrderUpdateRoot();
        shopifyOrderRoot.setOrder(shopifyOrderUpdateRequest);
        Response response = put(buildOrdersEndpoint().path(shopifyOrderUpdateRequest.getId()),
                                shopifyOrderRoot);
        ShopifyOrderRoot shopifyOrderRootResponse = response.readEntity(ShopifyOrderRoot.class);
        return shopifyOrderRootResponse.getOrder();
    }

    private WebTarget buildOrdersEndpoint() {
        return getWebTarget().path(VERSION_2023_07).path(ORDERS);
    }

    @SneakyThrows
    public List<ShopifyOrder> getAllOrders() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(LIMIT, String.valueOf(DEFAULT_REQUEST_LIMIT));
        return getAllOrders(hashMap);
    }

    @SneakyThrows
    public List<ShopifyOrder> getAllOrders(HashMap<String, String> hashMap) {
        ShopifyPage<ShopifyOrder> shopifyOrdersPage = getOrders(hashMap);
        List<ShopifyOrder> listOfShopifyOrders = new ArrayList<ShopifyOrder>(shopifyOrdersPage);

        while (shopifyOrdersPage.getNextPageInfo() != null) {
            Integer limit = DEFAULT_REQUEST_LIMIT;
            if (hashMap.containsKey(LIMIT)) {
                limit = Integer.valueOf(hashMap.get(LIMIT));
            }

            shopifyOrdersPage = getOrders(shopifyOrdersPage.getNextPageInfo(), limit);
            listOfShopifyOrders.addAll(shopifyOrdersPage);
        }
        return listOfShopifyOrders;
    }

    private ShopifyPage<ShopifyOrder> getOrders(HashMap<String, String> params) {
        URI uri = addParameters(buildOrdersEndpoint().getUri(), params);
        WebTarget webTarget = buildClient().target(uri);
        Response response = get(webTarget);
        return getOrders(response);
    }

    private ShopifyPage<ShopifyOrder> getOrders(String pageInfo, Integer limit) {
        Response response = get(buildOrdersEndpoint().queryParam(PAGE_INFO_QUERY_PARAMETER, pageInfo)
            .queryParam(LIMIT_QUERY_PARAMETER, limit));
        return getOrders(response);
    }

    private ShopifyPage<ShopifyOrder> getOrders(Response response) {
        ShopifyOrdersRoot shopifyOrderRootResponse = response.readEntity(ShopifyOrdersRoot.class);
        return mapPagedResponse(shopifyOrderRootResponse.getOrders(), response);
    }

    protected <T> ShopifyPage<T> mapPagedResponse(List<T> items, Response response) {

        ShopifyPage<T> shopifyPage = new ShopifyPage<>();
        shopifyPage.addAll(items);

        Set<Link> links = response.getLinks();
        String nextLink = links.stream()
            .filter(link -> link.getRel().equals(REL_NEXT_HEADER_KEY))
            .map(link -> getQueryParam(link.getUri(), PAGE_INFO_QUERY_PARAMETER))
            .findFirst()
            .orElse(null);
        String previousLink = links.stream()
            .filter(link -> link.getRel().equals(REL_PREVIOUS_HEADER_KEY))
            .map(link -> getQueryParam(link.getUri(), PAGE_INFO_QUERY_PARAMETER))
            .findFirst()
            .orElse(null);
        shopifyPage.setNextPageInfo(nextLink);
        shopifyPage.setPreviousPageInfo(previousLink);

        return shopifyPage;
    }

    private String getQueryParam(URI uri, String key) {
        String[] params = uri.getQuery().split(AMPERSAND);
        for (String param : params) {
            String name = param.split(EQUALS)[0];
            String value = param.split(EQUALS)[1];
            if (name.equals(key)) {
                return value;
            }
        }
        return null;
    }
}