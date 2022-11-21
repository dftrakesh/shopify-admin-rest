package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyAdjustment {

    public Integer id;

    public Integer orderId;

    public Integer refundId;

    public String amount;

    public String taxAmount;

    public String kind;

    public String reason;

    public ShopifyAmountSet amountSet;

    public ShopifyAmountSet taxAmountSet;
}
