package com.dft.api.shopify.v202307.model.orders;

import com.dft.api.shopify.v202307.model.address.ShopifyAddress;
import com.dft.api.shopify.v202307.model.common.ShopifyAmountSet;
import com.dft.api.shopify.v202307.model.common.ShopifyAttributedStaff;
import com.dft.api.shopify.v202307.model.common.ShopifyDiscountAllocation;
import com.dft.api.shopify.v202307.model.common.ShopifyDuty;
import com.dft.api.shopify.v202307.model.common.ShopifyProperty;
import com.dft.api.shopify.v202307.model.common.ShopifyTaxLine;
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
    private Long variantId;
    private String title;
    private Integer quantity;
    private Double price;
    private Long grams;
    private String sku;
    private String variantTitle;
    private String vendor;
    private Long productId;
    private Boolean requiresShipping;
    private Boolean taxable;
    private Boolean giftCard;
    private String name;
    private Integer fulfillableQuantity;
    private Double totalDiscount;
    private String fulfillmentStatus;
    private String fulfillmentService;
    private List<ShopifyDuty> duties;
    private List<ShopifyProperty> properties;
    private List<ShopifyDiscountAllocation> discountAllocations;
    private List<ShopifyTaxLine> taxLines;
    private ShopifyAmountSet priceSet;
    private ShopifyAmountSet totalDiscountSet;
    private String adminGraphqlApiId;
    private Boolean productExists;
    private String barcode;
    private List<ShopifyAddress> discountCodes;
    private String variantInventoryManagement;
    private List<ShopifyAttributedStaff> attributedStaffs;
}