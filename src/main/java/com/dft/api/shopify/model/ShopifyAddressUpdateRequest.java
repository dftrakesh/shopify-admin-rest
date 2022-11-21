package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyAddressUpdateRequest {

    private String firstName;
    private String lastname;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String zip;
    private String province;
    private String country;
    private String provinceCode;
    private String countryCode;
    private String phone;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
