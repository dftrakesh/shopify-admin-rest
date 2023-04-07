package com.dft.api.shopify.model;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
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

    private Boolean requiresShipping;

    private Boolean taxable;

    private String inventoryItemId;

    private Integer inventoryQuantity;

    private String inventoryPolicy;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;

    private Long grams;

    private Integer position;

    private BigDecimal price;

    private Long available;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;

    private Double weight;

    private String weightUnit;

    private Long oldInventoryQuantity;
}