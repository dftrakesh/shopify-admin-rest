package com.dft.api.shopify.v202307;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202307.model.inventorylevel.ShopifyInventoryLevelRequest;
import com.dft.api.shopify.v202307.model.inventorylevel.ShopifyInventoryLevelWrapper;

import java.net.URI;
import java.net.http.HttpRequest;

public class ShopifyInventoryLevelAPI extends ShopifySdkNew {

    private static final String SET_ENDPOINT = "/set";
    public static final String VERSION_2023_07 = "/2023-07";
    private static final String INVENTORY_LEVELS_ENDPOINT = "/inventory_levels";

    public ShopifyInventoryLevelAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public ShopifyInventoryLevelWrapper updateInventoryLevel(ShopifyInventoryLevelRequest shopifyInventoryLevelRequest) {
        URI uri = baseUrl(VERSION_2023_07, INVENTORY_LEVELS_ENDPOINT + SET_ENDPOINT);

        HttpRequest request = postWithObject(uri, shopifyInventoryLevelRequest);
        return getRequestWrapped(request, ShopifyInventoryLevelWrapper.class);
    }
}