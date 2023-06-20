package com.dft.api.shopify;

import com.dft.api.shopify.model.*;
import com.dft.api.shopify.model.collection.smart.SmartCollection;
import com.dft.api.shopify.model.collection.smart.SmartCollectionsRoot;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.*;


public class SmartCollectionAPI {

    static final String SMART_COLLECTIONS = "smart_collections";
    private final ShopifySdk shopifySdk;

    public SmartCollectionAPI(ShopifySdk shopifySdk) {
        this.shopifySdk = shopifySdk;
    }

    public ShopifyPage<SmartCollection> getSmartCollectios(HashMap<String, String> parameters) {
        WebTarget webTarget = shopifySdk.getWebTarget().path(ShopifySdk.VERSION_2023_01).path(SMART_COLLECTIONS);

        for (String key : parameters.keySet()) {
            String value = parameters.get(key);
            webTarget = webTarget.queryParam(key, value);
        }

        final Response response = shopifySdk.get(webTarget);

        final SmartCollectionsRoot smartCollectionsRoot = response.readEntity(SmartCollectionsRoot.class);
        return shopifySdk.mapPagedResponse(smartCollectionsRoot.getSmartCollections(), response);
    }

    public SmartCollection create(SmartCollectionsRoot smartCollection) {
        WebTarget webTarget = shopifySdk.getWebTarget().path(ShopifySdk.VERSION_2023_01).path(SMART_COLLECTIONS);

       final Response response = shopifySdk.post(webTarget, smartCollection);

        final SmartCollectionsRoot smartCollectionsRoot = response.readEntity(SmartCollectionsRoot.class);
        return smartCollectionsRoot.getSmartCollection();
    }

}