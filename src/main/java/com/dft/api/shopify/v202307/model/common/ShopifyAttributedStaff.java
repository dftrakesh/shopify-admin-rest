package com.dft.api.shopify.v202307.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopifyAttributedStaff {

    private String id;
    private Integer quantity;
}