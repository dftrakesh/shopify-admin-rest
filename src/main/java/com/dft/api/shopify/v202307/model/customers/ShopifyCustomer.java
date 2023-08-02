package com.dft.api.shopify.v202307.model.customers;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.dft.api.shopify.mappers.LocalDateSerializer;
import com.dft.api.shopify.v202307.model.address.ShopifyAddress;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyCustomer {

    private Long id;
    private String email;
    private Boolean acceptsMarketing;
    private String firstName;
    private String lastName;
    private String state;
    private String note;
    private Boolean verifiedEmail;
    private Object multipassIdentifier;
    private Boolean taxExempt;
    private String phone;
    private String tags;
    private String currency;
    private ShopifyAddress addresses;
    private String adminGraphqlApiId;
    private ShopifyAddress defaultAddress;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;
}