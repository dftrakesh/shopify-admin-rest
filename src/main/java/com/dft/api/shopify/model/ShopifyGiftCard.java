package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopifyGiftCard {

    private String id;
    private String note;
    private String apiClientId;
    private BigDecimal balance;
    private Date createdAt;
    private BigDecimal initialValue;
    private String currency;
    private String customerId;
    private String code;
    private Date disabledAt;
    private String expiresOn;
    private Date updatedAt;
    private String lastCharacters;
    private String lineItemId;
    private String userId;
    private String templateSuffix;
}
