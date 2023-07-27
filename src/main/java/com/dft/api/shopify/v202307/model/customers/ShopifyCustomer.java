package com.dft.api.shopify.v202307.model.customers;

import com.dft.api.shopify.v202307.model.address.ShopifyAddress;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyCustomer {

    private Integer id;
    private String email;
    private Boolean acceptsMarketing;
    private String createdAt;
    private String updatedAt;
    private String firstName;
    private String lastName;
    private String state;
    private String note;
    private Boolean verifiedEmail;
    private Object multipassIdentifier;
    private Boolean taxExempt;
    private TaxExemptions taxExemptions;
    private String phone;
    private String tags;
    private String currency;
    private ShopifyAddress addresses;
    private String adminGraphqlApiId;
    private ShopifyAddress defaultAddress;
}