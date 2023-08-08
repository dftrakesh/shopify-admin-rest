package com.dft.api.shopify.v202307.model.products;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyProductVariant {

    private Long id;
    private String sku;
    private Long productId;
    private String title;
    private Double price;
    private Integer position;
    private String fulfillmentService;
    private String option1;
    private String option2;
    private String option3;
    private Boolean taxable;
    private Boolean requiresShipping;
    private Double grams;
    private Long imageId;
    private String inventoryPolicy;
    private Integer oldInventoryQuantity;
    private Double compareAtPrice;
    private Double weight;
    private String weightUnit;
    private String barcode;
    private Long inventoryItemId;
    private String inventoryManagement;
    private Integer inventoryQuantity;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;
}