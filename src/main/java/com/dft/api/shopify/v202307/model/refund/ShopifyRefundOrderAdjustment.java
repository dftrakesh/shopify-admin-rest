package com.dft.api.shopify.v202307.model.refund;

import com.dft.api.shopify.v202307.model.common.ShopifyAmountSet;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyRefundOrderAdjustment {

    private Long id;
    private Long orderId;
    private Long refundId;
    private String amount;
    private String taxAmount;
    private String kind;
    private String reason;
    private ShopifyAmountSet amountSet;
    private ShopifyAmountSet taxAmountSet;
}