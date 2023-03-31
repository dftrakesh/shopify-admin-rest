package com.dft.api.shopify.model.fulfillments.v202301;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItem {

    private Long id;
    private Long shopId;
    private Long fulfillmentOrderId;
    private Integer quantity;
    private Long lineItemId;
    private Long inventoryItemId;
    private Integer fulfillableQuantity;
    private Long variantId;
}