package com.dft.api.shopify;

import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.model.collection.custom.CustomCollectionWrapper;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;
import static com.dft.api.shopify.constantcode.ConstantCodes.CUSTOM_COLLECTIONS_END_POINT_WITH_JSON;
import static com.dft.api.shopify.constantcode.ConstantCodes.HTTPS;
import static com.dft.api.shopify.constantcode.ConstantCodes.VERSION_2023_01;

public class ShopifyCustomCollectionAPI extends ShopifySdkNew{

    public ShopifyCustomCollectionAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public CustomCollectionWrapper getCustomCollections(HashMap<String, String> params) {
        URI uri = addParameters(new URI(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_01 + CUSTOM_COLLECTIONS_END_POINT_WITH_JSON), params);

        HttpRequest request = get(uri);

        return getRequestWrapped(request, CustomCollectionWrapper.class);
    }
}
