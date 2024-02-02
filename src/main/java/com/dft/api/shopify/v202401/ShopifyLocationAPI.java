package com.dft.api.shopify.v202401;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202401.model.location.LocationWrapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static com.dft.api.shopify.v202401.ShopifyOrdersAPI.VERSION_2024_01;

public class ShopifyLocationAPI extends ShopifySdkNew {

    private final String LOCATIONS_ENDPOINT = "/locations";

    public ShopifyLocationAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public LocationWrapper getAllLocations(HashMap<String, String> params) {
        URI uri = baseUrl(VERSION_2024_01, LOCATIONS_ENDPOINT);
        uri = addParameters(uri, params);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, LocationWrapper.class);
    }
}
