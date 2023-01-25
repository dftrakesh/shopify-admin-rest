package com.dft.api.shopify.model.checkout;

import com.dft.api.shopify.mappers.PropertiesDeserializer;
import com.dft.api.shopify.model.ShopifyAmountSet;
import com.dft.api.shopify.model.ShopifyDiscountAllocation;
import com.dft.api.shopify.model.ShopifyDuty;
import com.dft.api.shopify.model.ShopifyOriginLocation;
import com.dft.api.shopify.model.ShopifyTaxLine;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ShopifyCheckoutLineItem {

    private String id;

    private String variantId;

    private String title;

    private Long quantity;

    private Double price;

    private Long grams;

    private String sku;

    private String variantTitle;

    private Double variantPrice;

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

    @JsonDeserialize(using = PropertiesDeserializer.class)
    private HashMap<String, String> properties;

    private ShopifyAmountSet priceSet;

    private ShopifyAmountSet totalDiscountSet;
}