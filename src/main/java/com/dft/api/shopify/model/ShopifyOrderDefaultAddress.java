package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyOrderDefaultAddress {

    public Integer id;

    public String customerId;

    public String orderId;

    private String firstName;

    private String lastName;

    private String name;

    private String company;

    private String address1;

    private String address2;

    private String city;

    private String zip;

    private String province;

    private String country;

    private String countryName;

    private String provinceCode;

    private String countryCode;

    private String phone;

    private Boolean isDefault;

}
