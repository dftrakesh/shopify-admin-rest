package com.dft.api.shopify.v202307.model.orders;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyOrderWrapper {

    private ShopifyOrder order;
}