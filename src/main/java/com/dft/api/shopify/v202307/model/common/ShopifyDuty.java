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
public class ShopifyDuty {

    private String id;
    private String harmonizedSystemCode;
    private String countryCodeOfOrigin;
    private String adminGraphqlApiId;
    private List<ShopifyTaxLine> taxLines;
    private ShopifyShopMoney shopMoney;
    private ShopifyPresentmentMoney presentmentMoney;
}