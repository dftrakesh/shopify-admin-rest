package com.dft.api.shopify.v202307;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202307.model.subscription.ShopifyRecurringApplicationChargeWrapper;

import java.net.URI;
import java.net.http.HttpRequest;

import static com.dft.api.shopify.v202307.ShopifyOrdersAPI.VERSION_2023_07;

public class ShopifySubscriptionAPI extends ShopifySdkNew {

    private static final String APPLICATION_CHARGE_ENDPOINT = "/recurring_application_charges";

    public ShopifySubscriptionAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public ShopifyRecurringApplicationChargeWrapper createRecurringApplicationCharge(ShopifyRecurringApplicationChargeWrapper recurringApplicationChargeRequest) {
        URI uri = baseUrl(VERSION_2023_07, APPLICATION_CHARGE_ENDPOINT);

        HttpRequest request = postWithObject(uri, recurringApplicationChargeRequest);
        return getRequestWrapped(request, ShopifyRecurringApplicationChargeWrapper.class);
    }
}
