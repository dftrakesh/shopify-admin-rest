package com.dft.api.shopify.model.adapters;

import com.dft.api.shopify.model.ShopifyMetafieldValueType;
import com.fasterxml.jackson.databind.util.StdConverter;

public class MetafieldValueTypeDeserializer extends StdConverter<String, ShopifyMetafieldValueType> {

    @Override
    public ShopifyMetafieldValueType convert(String s) {
        return ShopifyMetafieldValueType.toEnum(s);
    }
}
