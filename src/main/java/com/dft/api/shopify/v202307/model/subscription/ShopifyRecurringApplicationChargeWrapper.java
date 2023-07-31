package com.dft.api.shopify.v202307.model.subscription;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyRecurringApplicationChargeWrapper {

    private ShopifyRecurringApplicationCharge recurringApplicationCharge;
}