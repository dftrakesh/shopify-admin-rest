package com.dft.api.shopify.exceptions;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dft.api.shopify.model.ShopifyErrorsRoot;
import com.dft.api.shopify.mappers.ShopifySdkObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShopifyErrorCodeFactory {

	private static final String COULD_NOT_PARSE_ERROR_RESPONSE_MESSAGE = "Could not parse error message from shopify for response body: {}";
	private static final String NO_VALID_ERROR_CODES_FOUND_MESSAGE = "Shopify error format is not readable %s";

	private ShopifyErrorCodeFactory() {
	}

	public static final List<ShopifyErrorCode> create(final String responseBody) {
		final List<ShopifyErrorCode> shopifyErrorCodes = new LinkedList<>();
		try {
			final ObjectMapper objectMapper = ShopifySdkObjectMapper.buildMapper();

			final ShopifyErrorsRoot shopifyErrorsRoot = objectMapper.readValue(responseBody, ShopifyErrorsRoot.class);
			final List<ShopifyErrorCode> shippingAddressErrorCodes = shopifyErrorsRoot.getErrors()
					.getShippingAddressErrors().stream()
					.map(shippingAddress -> new ShopifyErrorCode(ShopifyErrorCode.Type.SHIPPING_ADDRESS,
							shippingAddress))
					.collect(Collectors.toList());
			shopifyErrorCodes.addAll(shippingAddressErrorCodes);

			if (shopifyErrorCodes.isEmpty()) {
				throw new IllegalArgumentException(String.format(NO_VALID_ERROR_CODES_FOUND_MESSAGE, responseBody));
			}
		} catch (final Exception e) {
			final ShopifyErrorCode shopifyErrorCode = new ShopifyErrorCode(ShopifyErrorCode.Type.UNKNOWN, responseBody);
			shopifyErrorCodes.add(shopifyErrorCode);
			log.error(COULD_NOT_PARSE_ERROR_RESPONSE_MESSAGE + " " + responseBody, e);

		}
		return shopifyErrorCodes;
	}
}
