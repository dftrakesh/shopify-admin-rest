package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyLineItem {

    private String id;

    private String variantId;

    private String title;

    private Long quantity;

    private Double price;

    private Long grams;

    private String sku;

    private String variantTitle;

    private String vendor;

    private String productId;

    private Boolean requiresShipping;

    private Boolean taxable;

    private Boolean giftCard;

    private String name;

    private String variantInventoryManagement;

    private Integer fulfillableQuantity;

    private Double totalDiscount;

    private String fulfillmentStatus;

    private String fulfillmentService;

    private String adminGraphqlApiId;

    private Boolean productExists;

    private String barcode;

    private List<ShopifyDiscountAllocation> discountAllocations = new LinkedList<>();

    private ShopifyOriginLocation originLocation;

    private List<ShopifyTaxLine> taxLines = new LinkedList<>();

    private List<ShopifyDuty> duties = new LinkedList<>();

    private List<ShopifyProperty> properties = new LinkedList<>();

    private ShopifyAmountSet priceSet;

    private ShopifyAmountSet totalDiscountSet;
}
