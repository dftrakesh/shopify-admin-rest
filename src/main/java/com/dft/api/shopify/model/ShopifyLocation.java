package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyLocation {

    private String id;

    private String name;

    private String address1;

    private String address2;

    private String city;

    private String zip;

    private String country;

    private String phone;

    private String province;

    private String countryCode;

    private String countryName;

    private String provinceCode;
}
