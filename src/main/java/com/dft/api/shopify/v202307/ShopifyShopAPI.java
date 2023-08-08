package com.dft.api.shopify.v202307;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202307.model.shop.ShopifyShopWrapper;

import java.net.URI;
import java.net.http.HttpRequest;

public class ShopifyShopAPI extends ShopifySdkNew {

    private static final String SHOP_ENDPOINT = "/shop";
    public static final String VERSION_2023_07 = "/2023-07";

    public ShopifyShopAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public ShopifyShopWrapper getShop() {
        URI uri = baseUrl(VERSION_2023_07, SHOP_ENDPOINT);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyShopWrapper.class);
    }
}