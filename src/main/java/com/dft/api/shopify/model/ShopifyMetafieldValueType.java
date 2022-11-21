package com.dft.api.shopify.model;

public enum ShopifyMetafieldValueType {

	STRING("string"), INTEGER("integer"),JSON_STRING("json_string"),BOOLEAN("boolean");

	static final String NO_MATCHING_ENUMS_ERROR_MESSAGE = "No matching enum found for %s";
	private final String value;

	private ShopifyMetafieldValueType(final String value) {
		this.value = value;
	}

	public static ShopifyMetafieldValueType toEnum(final String value) {
		if (STRING.toString().equals(value)) {
			return ShopifyMetafieldValueType.STRING;
		} else if (INTEGER.toString().equals(value)) {
			return ShopifyMetafieldValueType.INTEGER;
		} else if (JSON_STRING.toString().equals(value)) {
			return ShopifyMetafieldValueType.JSON_STRING;
		} else if (BOOLEAN.toString().equals(value)) {
			return ShopifyMetafieldValueType.BOOLEAN;
		}
		throw new IllegalArgumentException(String.format(NO_MATCHING_ENUMS_ERROR_MESSAGE, value));
	}

	@Override
	public String toString() {
		return value;
	}

}