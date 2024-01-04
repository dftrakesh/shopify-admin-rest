package com.dft.api.shopify.v202310;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202310.model.ShopifyVariantWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;

import static com.dft.api.shopify.constantcode.ConstantCodes.HTTPS;
import static com.dft.api.shopify.constantcode.ConstantCodes.VERSION_2023_10;

public class ShopifyVariantAPI extends ShopifySdkNew {

    public ShopifyVariantAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ShopifyVariantWrapper updateVariant(Long variantId, ShopifyVariantWrapper shopifyVariantWrapper) {
        URI uri = URI.create(String.format("%s%s%svariants/%s.json", HTTPS, accessCredential.getStoreDomain(), VERSION_2023_10, variantId));
        HttpRequest request = putWithObject(uri, shopifyVariantWrapper);
        return getRequestWrapped(request, ShopifyVariantWrapper.class);
    }
}