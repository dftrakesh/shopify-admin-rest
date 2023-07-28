package com.dft.api.shopify.v202307.model.transactions;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyTransaction {

    private Double amount;
    private String authorization;
    private String currency;
    private Integer deviceId;
    private String errorCode;
    private String gateway;
    private Integer id;
    private String kind;
    private String message;
    private Integer orderId;
    private Long parentId;
    private String sourceName;
    private String status;
    private Boolean test;
    private Integer userId;
    private ShopifyTransactionLocationId locationId;
    private ShopifyTransactionPaymentDetails paymentDetails;
    private ShopifyTransactionPaymentsRefundAttributes paymentsRefundAttributes;
    private ShopifyTransactionTotalUnsettledSet totalUnsettledSet;
    private ShopifyCurrencyExchangeAdjustment currencyExchangeAdjustment;
    private ShopifyTransactionExtendedAuthorizationAttributes extendedAuthorizationAttributes;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime authorizationExpiresAt;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime processedAt;
}