package com.dft.api.shopify.v202307;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202307.model.smartcollections.ShopifySmartCollectionsWrapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

public class ShopifySmartCollectionsAPI extends ShopifySdkNew {

    public static final String VERSION_2023_07 = "/2023-07";
    private static final String SMART_COLLECTIONS_ENDPOINTS = "/smart_collections";

    public ShopifySmartCollectionsAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public ShopifySmartCollectionsWrapper getAllSmartCollections(HashMap<String, String> params) {
        URI uri = baseUrl(VERSION_2023_07, SMART_COLLECTIONS_ENDPOINTS);
        uri = addParameters(uri, params);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifySmartCollectionsWrapper.class);
    }
}