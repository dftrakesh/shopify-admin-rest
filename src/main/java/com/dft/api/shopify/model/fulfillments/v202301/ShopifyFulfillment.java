package com.dft.api.shopify.model.fulfillments.v202301;

import com.dft.api.shopify.model.ShopifyLineItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyFulfillment {

    private String id;
    private String orderId;
    private String status;
    private String createdAt;
    private String service;
    private String updatedAt;
    private String trackingCompany;
    private String shipmentStatus;
    private String locationId;
    private List<ShopifyLineItem> lineItems;
    private String trackingNumber;
    private List<String> trackingNumbers;
    private String trackingUrl;
    private List<String> trackingUrls;
    private String name;
    private String adminGraphqlApiId;
}