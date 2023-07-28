package com.dft.api.shopify.v202307.model.refund;

import com.dft.api.shopify.v202307.model.common.ShopifyAmountSet;
import com.dft.api.shopify.v202307.model.orders.ShopifyLineItem;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
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
    private ShopifyAmountSet subtotalSet;
    private ShopifyAmountSet totalTaxSet;
}