package com.dft.api.shopify.v202307.model.fullfillment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyFulfillmentOrderLineItem {

    private Long id;
    private Integer quantity;
}