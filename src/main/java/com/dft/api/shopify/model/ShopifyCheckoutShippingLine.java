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
public class ShopifyCheckoutShippingLine {

    private String id;

    private String checkoutId;

    private String title;

    private Double price;

    private String code;

    private String source;

    private List<ShopifyAppliedDiscount> appliedDiscounts = new LinkedList<>();

}
