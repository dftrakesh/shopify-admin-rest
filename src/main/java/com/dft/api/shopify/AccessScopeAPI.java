package com.dft.api.shopify;

import com.dft.api.shopify.model.accessscope.AccessScopesWrapper;
import com.dft.api.shopify.model.auth.AccessCredential;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import static com.dft.api.shopify.constantcode.ConstantCodes.ACCESS_SCOPES;
import static com.dft.api.shopify.constantcode.ConstantCodes.HTTPS;
import static com.dft.api.shopify.constantcode.ConstantCodes.JSON;

public class AccessScopeAPI extends ShopifySdkNew {

    public AccessScopeAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public AccessScopesWrapper getAccessScopes() {
        URI uri = new URI(HTTPS + accessCredential.getStoreDomain() + ACCESS_SCOPES + JSON);

        HttpRequest request = get(uri);

        return getRequestWrapped(request, AccessScopesWrapper.class);
    }
}