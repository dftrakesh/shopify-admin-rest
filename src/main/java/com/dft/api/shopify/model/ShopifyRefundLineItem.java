package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyRefundLineItem {

    private String id;

    private Integer quantity;

    private String lineItemId;

    private String locationId;

    private String restockType;

    private Double subtotal;

    private Double totalTax;

    private ShopifyLineItem lineItem;

    public ShopifyAmountSet subtotalSet;

    public ShopifyAmountSet totalTaxSet;
}
