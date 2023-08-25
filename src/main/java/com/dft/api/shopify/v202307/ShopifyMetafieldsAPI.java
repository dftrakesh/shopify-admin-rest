package com.dft.api.shopify.v202307;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202307.model.metafields.ShopifyMetafieldRequest;
import com.dft.api.shopify.v202307.model.metafields.ShopifyMetafieldsWrapper;

import java.net.URI;
import java.net.http.HttpRequest;

import static com.dft.api.shopify.constantcode.ConstantCodes.FORWARD_SLASH;

public class ShopifyMetafieldsAPI extends ShopifySdkNew {

    private static final String PRODUCTS_ENDPOINT = "/products";
    public static final String VERSION_2023_07 = "/2023-07";
    public static final String METAFIELDS_ENDPOINT = "/metafields";

    public ShopifyMetafieldsAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public ShopifyMetafieldsWrapper getMetafields(String productId) {
        URI uri = baseUrl(VERSION_2023_07, PRODUCTS_ENDPOINT + FORWARD_SLASH + productId + METAFIELDS_ENDPOINT );

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyMetafieldsWrapper.class);
    }

    public ShopifyMetafieldsWrapper updateShopifyMetafield(String productId, String metafieldId, ShopifyMetafieldRequest shopifyMetafieldRequest) {
        URI uri = baseUrl(VERSION_2023_07, PRODUCTS_ENDPOINT + FORWARD_SLASH + productId + METAFIELDS_ENDPOINT + FORWARD_SLASH + metafieldId);

        HttpRequest request = putWithObject(uri, shopifyMetafieldRequest);
        return getRequestWrapped(request, ShopifyMetafieldsWrapper.class);
    }
}