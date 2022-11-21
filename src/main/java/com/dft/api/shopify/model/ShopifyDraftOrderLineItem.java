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
public class ShopifyDraftOrderLineItem {

    private String id;

    private String orderId;

    private String variantId;

    private String productId;

    private String title;

    private String variantTitle;

    private String sku;

    private String vendor;

    private Integer quantity;

    private Boolean requiresShipping;

    private Boolean taxable;

    private Boolean giftCard;

    private String fulfillmentService;

    private Integer grams;

    private String name;

    private Boolean custom;

    private Double price;

    private String adminGraphqlApiId;

    private List<ShopifyTaxLine> taxLines = new LinkedList<>();

    private ShopifyAppliedDiscount appliedDiscount = new ShopifyAppliedDiscount();

    private List<ShopifyProperty> properties = new LinkedList<>();

}
