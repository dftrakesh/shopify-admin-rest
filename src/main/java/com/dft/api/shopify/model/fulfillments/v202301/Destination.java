package com.dft.api.shopify.model.fulfillments.v202301;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Destination {

    private Long id;
    private String address1;
    private String address2;
    private String city;
    private String company;
    private String country;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String province;
    private String zip;
}