package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyCustomerCreationRequest {

    @JsonProperty("customer")
    private ShopifyCustomerCreate shopifyCustomerCreate;
}