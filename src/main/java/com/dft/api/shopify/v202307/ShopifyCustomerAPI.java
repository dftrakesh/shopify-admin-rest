package com.dft.api.shopify.v202307;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202307.model.customers.ShopifyCustomer;
import com.dft.api.shopify.v202307.model.customers.ShopifyCustomersWrapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class ShopifyCustomerAPI extends ShopifySdkNew {

    private static final String CUSTOMERS_ENDPOINT = "/customers";
    public static final String VERSION_2023_07 = "/2023-07";

    public ShopifyCustomerAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public ShopifyCustomersWrapper getAllCustomers(HashMap<String, String> params) {
        URI uri = baseUrl(VERSION_2023_07, CUSTOMERS_ENDPOINT);
        uri = addParameters(uri, params);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyCustomersWrapper.class);
    }


    public ShopifyCustomersWrapper search(HashMap<String, String> params) {
        URI uri = baseUrl(VERSION_2023_07, CUSTOMERS_ENDPOINT + "/search");
        uri = addParameters(uri, params);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyCustomersWrapper.class);
    }

    public void deleteCustomer(String customerId) {
        URI uri = baseUrl(VERSION_2023_07, CUSTOMERS_ENDPOINT + "/" + customerId);
        HttpRequest request = delete(uri);
        deleteRequestWrapped(request,  HttpResponse.BodyHandlers.ofString());
    }

    public ShopifyCustomersWrapper createCustomer(ShopifyCustomer shopifyCustomer) {
        ShopifyCustomersWrapper shopifyCustomersWrapper = new ShopifyCustomersWrapper();
        shopifyCustomersWrapper.setCustomer(shopifyCustomer);
        URI uri = baseUrl(VERSION_2023_07, CUSTOMERS_ENDPOINT);
        HttpRequest request = postWithObject(uri, shopifyCustomersWrapper);
        return getRequestWrapped(request, ShopifyCustomersWrapper.class);
    }
}