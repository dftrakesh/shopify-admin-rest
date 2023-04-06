package com.dft.api.shopify;

import com.dft.api.shopify.handler.JsonBodyHandler;
import com.dft.api.shopify.model.ShopifyShop;
import com.dft.api.shopify.model.auth.AccessCredential;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.dft.api.shopify.constantcode.ConstantCodes.HTTPS;
import static com.dft.api.shopify.constantcode.ConstantCodes.SHOP_END_POINT;
import static com.dft.api.shopify.constantcode.ConstantCodes.VERSION_2023_01;

public class ShopifyShopAPI extends ShopifySdkNew {

    public ShopifyShopAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ShopifyShop getShop() {
        URI uri = new URI(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_01 + SHOP_END_POINT);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<ShopifyShop> handler = new JsonBodyHandler<>(ShopifyShop.class);
        return getRequestWrapped(request, handler);
    }
}
