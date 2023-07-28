package com.dft.api.shopify.v202307.model.transactions;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyTransactionExtendedAuthorizationAttributes {

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime standardAuthorizationExpiresAt;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime extendedAuthorizationExpiresAt;
}