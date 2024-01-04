package com.dft.api.shopify.v202310.model;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyVariant {

    private Long id;
    private String productId;
    private String title;
    private BigDecimal price;
    private String sku;
    private Integer position;
    private String inventoryPolicy;
    private BigDecimal compareAtPrice;
    private String fulfillmentService;
    private String inventoryManagement;
    private String option1;
    private String option2;
    private String option3;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;

    private Boolean taxable;
    private String barcode;
    private Long grams;
    private String imageId;
    private Double weight;
    private String weightUnit;
    private String inventoryItemId;
    private Integer inventoryQuantity;
    private Long oldInventoryQuantity;
    private Boolean requiresShipping;
    private String adminGraphqlApiId;
}