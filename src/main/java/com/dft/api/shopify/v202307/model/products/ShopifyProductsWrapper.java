package com.dft.api.shopify.v202307.model.products;

import com.dft.api.shopify.model.Pagination;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyProductsWrapper {

    private List<ShopifyProduct> products;
    private Pagination pagination;
}