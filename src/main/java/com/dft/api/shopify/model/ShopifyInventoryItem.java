package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyInventoryItem {

    private String id;

    private String sku;

    private String requireShipping;

    private String cost;

    private String countryCodeOfOrigin;

    private String provinceCodeOfOrigin;

    private String harmonizedSystemCode;

    private Boolean tracked;
}


