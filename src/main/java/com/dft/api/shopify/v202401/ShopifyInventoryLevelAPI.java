package com.dft.api.shopify.v202401;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202401.model.InventoryLevel.InventoryLevelWrapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static com.dft.api.shopify.v202401.ShopifyOrdersAPI.VERSION_2024_01;

public class ShopifyInventoryLevelAPI extends ShopifySdkNew {

    private static final String INVENTORY_LEVELS_ENDPOINT = "/inventory_levels";

    public ShopifyInventoryLevelAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public InventoryLevelWrapper getAllInventoryLevel(HashMap<String, String> params) {
        URI uri = baseUrl(VERSION_2024_01, INVENTORY_LEVELS_ENDPOINT);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);
        return getRequestWrapped(request, InventoryLevelWrapper.class);
    }
}