package com.dft.api.shopify.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyCustomerCreate {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Boolean verifiedEmail;
    private Boolean acceptsMarketing;
    private List<ShopifyAddress> addresses;
}