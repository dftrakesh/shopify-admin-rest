package com.dft.api.shopify.v202307;

import com.dft.api.shopify.ShopifySdk;
import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202307.model.carrierservice.CarrierServiceRequest;
import com.dft.api.shopify.v202307.model.carrierservice.CarrierServiceRequestWrapper;
import com.dft.api.shopify.v202307.model.carrierservice.CarrierServiceResponseWrapper;
import org.checkerframework.checker.units.qual.C;

import java.net.URI;
import java.net.http.HttpRequest;

public class ShopifyCarrierServiceAPI extends ShopifySdkNew {

    public static final String VERSION_2023_07 = "/2023-07";
    private static final String CARRIER_SERVICE_ENDPOINT = "/carrier_services";

    public ShopifyCarrierServiceAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public CarrierServiceResponseWrapper createCarrierService(CarrierServiceRequestWrapper carrierServiceRequestWrapper) {
        URI uri = baseUrl(VERSION_2023_07, CARRIER_SERVICE_ENDPOINT);

        HttpRequest request = postWithObject(uri, carrierServiceRequestWrapper);
        return getRequestWrapped(request, CarrierServiceResponseWrapper.class);
    }
}
