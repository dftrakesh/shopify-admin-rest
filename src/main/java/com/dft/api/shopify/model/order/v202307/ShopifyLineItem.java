package com.dft.api.shopify.model.order.v202307;

import com.dft.api.shopify.model.ShopifyAmountSet;
import com.dft.api.shopify.model.ShopifyAppliedDiscount;
import com.dft.api.shopify.model.ShopifyDiscountAllocation;
import com.dft.api.shopify.model.ShopifyDiscountCode;
import com.dft.api.shopify.model.ShopifyDuty;
import com.dft.api.shopify.model.ShopifyProperty;
import com.dft.api.shopify.model.ShopifyTaxLine;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
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

    private List<ShopifyDiscountAllocation> discountAllocations;

    private List<ShopifyAppliedDiscount> appliedDiscounts;

    private List<ShopifyTaxLine> taxLines;

    private List<ShopifyDuty> duties;

    private List<ShopifyProperty> properties;

    private List<ShopifyDiscountCode> discountCodes;

    private ShopifyAmountSet priceSet;

    private ShopifyAmountSet totalDiscountSet;
}