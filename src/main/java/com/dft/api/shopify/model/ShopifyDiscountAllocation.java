package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ShopifyDiscountAllocation {
	
	private String id;
	
    private Double amount;

    private String description;
    
    private Integer discountApplicationIndex;
    
    private ShopifyAmountSet amountSet;

    private String applicationType;
}