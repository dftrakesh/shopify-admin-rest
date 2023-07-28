package com.dft.api.shopify.v202307.model.transactions;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyCurrencyExchangeAdjustment {

    private Integer id;
    private Double adjustment;
    private Double originalAmount;
    private Double finalAmount;
    private String currency;
}