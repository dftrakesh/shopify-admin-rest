package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyDuty {

    private String id;

    private String harmonizedSystemCode;

    private String countryCodeOfOrigin;

    private String adminGraphqlApiId;

    private List<ShopifyTaxLine> taxLines = new LinkedList<>();

    private ShopifyShopMoney shopMoney;

    private ShopifyPresentmentMoney presentmentMoney;
}
