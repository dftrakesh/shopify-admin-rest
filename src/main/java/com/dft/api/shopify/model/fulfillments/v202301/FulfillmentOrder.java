package com.dft.api.shopify.model.fulfillments.v202301;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FulfillmentOrder {

    private Long id;
    private Long shopId;
    private Long orderId;
    private Long assignedLocationId;
    private String requestStatus;
    private String status;
    private List<String> supportedActions;
    private Destination destination;
    private List<LineItem> lineItems;
    private String fulfillAt;
    private String fulfillBy;
    private String internationalDuties;
    private List<String> fulfillmentHolds;
    private DeliveryMethod deliveryMethod;
    private String createdAt;
    private String updatedAt;
    private AssignedLocation assignedLocation;
    private List<String> merchantRequests;
}