package com.dft.api.shopify.v202307.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyShippingLine {

    private Long id;
    private String carrierIdentifier;
    private String code;
    private String discountedPrice;
    private ShopifyPriceSet discountedPriceSet;
    private Object phone;
    private String price;
    private ShopifyPriceSet priceSet;
    private Object requestedFulfillmentServiceId;
    private String source;
    private String title;
    private List<ShopifyTaxLine> taxLines;
    private List<ShopifyDiscountAllocation> discountAllocations;
}