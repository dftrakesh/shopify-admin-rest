package com.dft.api.shopify;

import com.dft.api.shopify.handler.JsonBodyHandler;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.model.product.ShopifyProductWrapper;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import static com.dft.api.shopify.constantcode.ConstantCodes.HTTPS;
import static com.dft.api.shopify.constantcode.ConstantCodes.PRODUCTS_END_POINT_WITH_JSON;
import static com.dft.api.shopify.constantcode.ConstantCodes.VERSION_2023_01;

public class ShopifyProductAPI extends ShopifySdkNew {

    public ShopifyProductAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ShopifyProductWrapper getProducts(HashMap<String, String> params) {
        URI uri = addParameters(new URI(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_01 + PRODUCTS_END_POINT_WITH_JSON), params);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<ShopifyProductWrapper> handler = new JsonBodyHandler<>(ShopifyProductWrapper.class);

        return getRequestWrapped(request, handler);
    }
}