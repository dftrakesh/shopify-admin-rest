package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyDiscountApplication {

    private String id;

    private String type;

    private String title;

    private String description;

    private String value;

    private String valueType;

    private String allocationMethod;

    private String targetSelection;

    private String targetType;

    private String code;

}
