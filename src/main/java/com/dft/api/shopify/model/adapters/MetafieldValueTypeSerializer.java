package com.dft.api.shopify.model.adapters;

import com.dft.api.shopify.model.ShopifyMetafieldValueType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.util.StdConverter;

import java.io.IOException;
import java.time.LocalDateTime;

public class MetafieldValueTypeSerializer extends StdConverter<ShopifyMetafieldValueType, String> {

	@Override
	public String convert(ShopifyMetafieldValueType shopifyMetafieldValueType) {
		return shopifyMetafieldValueType.toString();
	}
}
