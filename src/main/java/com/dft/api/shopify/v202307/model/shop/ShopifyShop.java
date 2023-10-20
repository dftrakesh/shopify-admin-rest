package com.dft.api.shopify.v202307.model.shop;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyShop {

    private Long id;
    private String name;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private String country;
    private String email;
    private String province;
    private String countryCode;
    private String countryName;
    private String currency;
    private String moneyWithCurrencyFormat;
    private String zip;
    private Long primaryLocationId;
}