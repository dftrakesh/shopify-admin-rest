package com.dft.api.shopify.v202307.model.smartcollections;

import lombok.Data;

@Data
public class ShopifyRules {

    private String column;
    private String relation;
    private String condition;
}