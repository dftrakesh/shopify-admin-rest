package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyFulfillment {

    private String id;

    private String orderId;

    private String status;

    private Date createdAt;

    private Date updatedAt;

    private String trackingCompany;

    private String trackingNumber;

    private boolean notifyCustomer;

    private List<ShopifyLineItem> lineItems = new LinkedList<>();

    private String trackingUrl;

    private List<String> trackingUrls = new LinkedList<>();

    private String locationId;

}
