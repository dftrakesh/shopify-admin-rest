package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ShopifyShippingLine {
    private String id;
    private String orderId;
    private String title;
    private Double price;
    private String code;
    private String source;
    private Double discountedPrice;
    private String carrierIdentifier;
    private String requestedFulfillmentServiceId;
    private ShopifyAmountSet priceSet;
    private ShopifyAmountSet discountedPriceSet;
    private List<ShopifyTaxLine> taxLines;
    private List<ShopifyDiscountAllocation> discountAllocations;
}
