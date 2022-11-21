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
public class ShopifyCheckoutLineItem {

    private String id;

    private String productId;

    private String userId;

    private String key;

    private Integer destinationLocationId;

    private String fulfillmentService;

    private Boolean giftCard;

    private Integer grams;

    private Integer originLocationId;

    private String presentmentTitle;

    private String presentmentVariantTitle;

    private Integer quantity;

    private Boolean requiresShipping;

    private String sku;

    private Boolean taxable;

    private String title;

    private Integer variantId;

    private String variantTitle;

    private Double variantPrice;

    private String vendor;

    private Double unitPriceMeasurement;

    private String rank;

    private Double compareAtPrice;

    private Double linePrice;

    private Double price;

    private List<ShopifyAppliedDiscount> appliedDiscounts = new LinkedList<>();

    private List<ShopifyProperty> properties = new LinkedList<>();

    private List<ShopifyTaxLine> taxLines = new LinkedList<>();
}
