package com.dft.api.shopify.v202307.model.refund;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.dft.api.shopify.v202307.model.common.ShopifyDuty;
import com.dft.api.shopify.v202307.model.transactions.ShopifyTransaction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyRefund {

    private String id;
    private String note;
    private String userId;
    private String orderId;
    private Boolean restock;
    private Currency currency;
    private List<ShopifyDuty> duties;
    private List<ShopifyRefundDuty> refundDuties;
    private List<ShopifyTransaction> transactions;
    private List<ShopifyRefundLineItem> refundLineItems;
    private List<ShopifyRefundOrderAdjustment> orderAdjustments;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime processedAt;
}
