package com.dft.api.shopify.v202307;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202307.model.products.ShopifyProductsWrapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

public class ShopifyCollectionAPI extends ShopifySdkNew {

    public static final String VERSION_2023_07 = "/2023-07";
    private static final String COLLECTIONS_ENDPOINTS = "/collections/";
    private static final String COLLECTION_PRODUCTS_ENDPOINTS = "/products";

    public ShopifyCollectionAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public ShopifyProductsWrapper getAllProductsByCollectionId(HashMap<String, String> params, Long collectionId) {
        URI uri = baseUrl(VERSION_2023_07, COLLECTIONS_ENDPOINTS + collectionId + COLLECTION_PRODUCTS_ENDPOINTS);
        uri = addParameters(uri, params);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyProductsWrapper.class);
    }
}
