package com.dft.api.shopify.model;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyRefund {

    private String id;

    private String orderId;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;

    private String note;

    private String userId;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime processedAt;

    private Currency currency;

    private List<ShopifyRefundLineItem> refundLineItems;

    private List<ShopifyTransaction> transactions;

    public List<ShopifyRefundOrderAdjustment> orderAdjustments;

    public List<ShopifyDuty> duties;

    public List<ShopifyRefundDuty> refundDuties;
}
