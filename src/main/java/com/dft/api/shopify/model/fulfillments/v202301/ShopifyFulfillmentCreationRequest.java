package com.dft.api.shopify.model.fulfillments.v202301;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyFulfillmentCreationRequest {

	private ShopifyFulfillmentRequest fulfillment;
}