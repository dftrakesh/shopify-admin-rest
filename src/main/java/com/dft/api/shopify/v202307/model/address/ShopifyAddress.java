package com.dft.api.shopify.v202307.model.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyAddress {

    private String address1;
    private String address2;
    private String city;
    private String company;
    private String country;
    private String firstName;
    private String lastName;
    private String phone;
    private String province;
    private String zip;
    private String name;
    private String provinceCode;
    private String countryCode;
    private Double latitude;
    private Double longitude;
    private Long id;
}