package com.dft.api.shopify.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyDiscountAllocation {
	
	private String id;
	
    private Double amount;
    
    private Integer discountApplicationIndex;
    
    private ShopifyAmountSet amountSet;
}
