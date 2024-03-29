package com.dft.api.shopify;

import com.dft.api.shopify.handler.JsonBodyHandler;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.model.auth.AccessToken;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import static com.dft.api.shopify.constantcode.ConstantCodes.ACCESS_TOKEN_END_POINT_WITH_JSON;
import static com.dft.api.shopify.constantcode.ConstantCodes.HTTPS;

public class ShopifyToken extends ShopifySdkNew {

    public ShopifyToken(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public AccessToken getAccessToken(HashMap<String, String> params) {
        URI uri = addParameters(new URI(HTTPS + accessCredential.getStoreDomain() + ACCESS_TOKEN_END_POINT_WITH_JSON), params);

        HttpRequest request = postWithoutAccessToken(uri);

        return getRequestWrapped(request, AccessToken.class);
    }
}