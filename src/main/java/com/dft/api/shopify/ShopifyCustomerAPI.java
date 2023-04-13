package com.dft.api.shopify;

import com.dft.api.shopify.model.ShopifyAddress;
import com.dft.api.shopify.model.ShopifyAddressUpdateResponse;
import com.dft.api.shopify.model.ShopifyAddressUpdateRoot;
import com.dft.api.shopify.model.ShopifyCustomer;
import com.dft.api.shopify.model.ShopifyCustomerCreationRequest;
import com.dft.api.shopify.model.ShopifyCustomerRoot;
import com.dft.api.shopify.model.ShopifyCustomerUpdateRequest;
import com.dft.api.shopify.model.ShopifyCustomerUpdateRoot;
import com.dft.api.shopify.model.auth.AccessCredential;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;

import static com.dft.api.shopify.constantcode.ConstantCodes.ADDRESSES;
import static com.dft.api.shopify.constantcode.ConstantCodes.CUSTOMERS;
import static com.dft.api.shopify.constantcode.ConstantCodes.HTTPS;
import static com.dft.api.shopify.constantcode.ConstantCodes.JSON;
import static com.dft.api.shopify.constantcode.ConstantCodes.VERSION_2023_01;

public class ShopifyCustomerAPI extends ShopifySdkNew {

    public ShopifyCustomerAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ShopifyCustomer createCustomer(final ShopifyCustomerCreationRequest shopifyCustomerCreationRequest) {
        URI uri = new URI(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_01 + CUSTOMERS + JSON);

        HttpRequest request = postWithObject(uri, shopifyCustomerCreationRequest);

        return getRequestWrapped(request, ShopifyCustomerRoot.class).getCustomer();
    }

    @SneakyThrows
    public ShopifyCustomer updateCustomer(final ShopifyCustomerUpdateRequest shopifyCustomerUpdateRequest) {
        final ShopifyCustomerUpdateRoot shopifyCustomerUpdateRequestRoot = new ShopifyCustomerUpdateRoot();
        shopifyCustomerUpdateRequestRoot.setCustomer(shopifyCustomerUpdateRequest);

        URI uri = new URI(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_01 + CUSTOMERS + "/" + shopifyCustomerUpdateRequest.getId() + JSON);

        HttpRequest request = putWithObject(uri, shopifyCustomerUpdateRequestRoot);

        return getRequestWrapped(request, ShopifyCustomerRoot.class).getCustomer();
    }

    @SneakyThrows
    public ShopifyAddress updateAddress(final String customerId, final String addressId, ShopifyAddressUpdateRoot shopifyAddressUpdateRoot) {
        URI uri = new URI(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_01 + CUSTOMERS + "/" + customerId + ADDRESSES + addressId + JSON);

        HttpRequest request = putWithObject(uri, shopifyAddressUpdateRoot);

        return getRequestWrapped(request, ShopifyAddressUpdateResponse.class).getShopifyAddress();
    }
}