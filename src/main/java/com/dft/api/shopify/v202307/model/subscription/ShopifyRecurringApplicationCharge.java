package com.dft.api.shopify.v202307.model.subscription;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyRecurringApplicationCharge {

    private Long id;
    private String name;
    private Double price;
    private Boolean test;
    private String status;
    private String currency;
    private String billingOn;
    private String returnUrl;
    private Integer trialDays;
    private String apiClientId;
    private String confirmationUrl;
    private LocalDateTime activatedOn;
    private LocalDateTime cancelledOn;
    private LocalDateTime trialEndsOn;
    private String decoratedReturnUrl;
}