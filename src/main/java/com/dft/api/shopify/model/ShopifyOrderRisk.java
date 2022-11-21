package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyOrderRisk {

    private String id;

    private String orderId;

    private String checkoutId;

    private String source;

    private Double score;

    private OrderRiskRecommendation recommendation;

    private boolean display;

    private boolean causeCancel;

    private String message;

    private String merchantMessage;
}
