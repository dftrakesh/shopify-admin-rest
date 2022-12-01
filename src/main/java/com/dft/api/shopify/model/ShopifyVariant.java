package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopifyVariant {

    private String id;

    private String productId;

    private String title;

    private BigDecimal compareAtPrice;

    private String sku;

    private String barcode;

    private String imageId;

    private String inventoryManagement;

    private String option1;

    private String option2;

    private String option3;

    private String fulfillmentService;

    private boolean requiresShipping;

    private boolean taxable;

    private String inventoryItemId;

    private Integer inventoryQuantity;

    private String inventoryPolicy;

    private Date createdAt;

    private Long grams;

    private int position;

    private BigDecimal price;

    private long available;

    private Date updatedAt;

    private double weight;

    private String weightUnit;
}
