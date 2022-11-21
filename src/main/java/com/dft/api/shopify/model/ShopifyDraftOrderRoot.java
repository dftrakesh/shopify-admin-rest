package com.dft.api.shopify.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyDraftOrderRoot {

	private List<ShopifyDraftOrder> draftOrders;
}
