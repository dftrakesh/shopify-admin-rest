package com.dft.api.shopify.v202307;

import com.dft.api.shopify.ShopifySdkNew;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.v202307.model.metafields.ShopifyMetafieldsWrapper;
import com.dft.api.shopify.v202307.model.products.ShopifyProduct;
import com.dft.api.shopify.v202307.model.products.ShopifyProductVariantWrapper;
import com.dft.api.shopify.v202307.model.products.ShopifyProductWrapper;
import com.dft.api.shopify.v202307.model.products.ShopifyProductsWrapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static com.dft.api.shopify.constantcode.ConstantCodes.FORWARD_SLASH;

public class ShopifyProductsAPI extends ShopifySdkNew {

    public static final String VERSION_2023_07 = "/2023-07";
    private static final String VARIANT_ENDPOINT = "/variants";
    private static final String PRODUCTS_ENDPOINT = "/products";
    public static final String METAFIELDS_ENDPOINT = "/metafields";

    public ShopifyProductsAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public ShopifyProductsWrapper getAllProducts(HashMap<String, String> params) {
        URI uri = baseUrl(VERSION_2023_07, PRODUCTS_ENDPOINT);
        uri = addParameters(uri, params);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyProductsWrapper.class);
    }

    public ShopifyProductWrapper getProductById(Long productId) {
        URI uri = baseUrl(VERSION_2023_07, PRODUCTS_ENDPOINT + FORWARD_SLASH + productId);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyProductWrapper.class);
    }

    public ShopifyProductVariantWrapper getProductVariantByVariantId(Long productVariantId) {
        URI uri = baseUrl(VERSION_2023_07, VARIANT_ENDPOINT + FORWARD_SLASH + productVariantId);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyProductVariantWrapper.class);
    }

    public ShopifyMetafieldsWrapper getProductMetafieldsByProductId(Long productId) {
        URI uri = baseUrl(VERSION_2023_07, PRODUCTS_ENDPOINT + FORWARD_SLASH + productId + METAFIELDS_ENDPOINT);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyMetafieldsWrapper.class);
    }

    public ShopifyProduct createShopifyProduct(ShopifyProductWrapper shopifyProduct) {
        URI uri = baseUrl(VERSION_2023_07, PRODUCTS_ENDPOINT);

        HttpRequest request = postWithObject(uri, shopifyProduct);
        return getRequestWrapped(request, ShopifyProductWrapper.class).getProduct();
    }

    public ShopifyProduct updateShopifyProduct(Long productId, ShopifyProductWrapper shopifyProductWrapper) {
        URI uri = baseUrl(VERSION_2023_07, PRODUCTS_ENDPOINT + FORWARD_SLASH + productId);

        HttpRequest request = putWithObject(uri, shopifyProductWrapper);
        return getRequestWrapped(request, ShopifyProductWrapper.class).getProduct();
    }
}