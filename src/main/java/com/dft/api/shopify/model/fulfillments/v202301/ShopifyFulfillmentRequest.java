package com.dft.api.shopify.model.fulfillments.v202301;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyFulfillmentRequest {

    private String message;
    private Boolean notifyCustomer;
    private TrackingInfo trackingInfo;
    private List<LineItemsByFulfillmentOrder> lineItemsByFulfillmentOrder;
}