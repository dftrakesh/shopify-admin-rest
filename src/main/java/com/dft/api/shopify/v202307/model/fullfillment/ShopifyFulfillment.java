package com.dft.api.shopify.v202307.model.fullfillment;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.dft.api.shopify.mappers.LocalDateTimeSerializer;
import com.dft.api.shopify.v202307.model.orders.ShopifyLineItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyFulfillment {

    private Long id;
    private Long orderId;
    private String status;
    private String message;
    private TrackingInfo trackingInfo;
    private Boolean notifyCustomer;
    private List<ShopifyLineItem> lineItems;
    private List<ShopifyLineItemsByFulfillmentOrder> lineItemsByFulfillmentOrder;

    @JsonDeserialize(using = DateDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;

    @JsonDeserialize(using = DateDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;
}