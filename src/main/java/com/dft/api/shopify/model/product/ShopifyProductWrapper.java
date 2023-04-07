package com.dft.api.shopify.model.product;

import com.dft.api.shopify.model.Pagination;
import com.dft.api.shopify.model.ShopifyProduct;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyProductWrapper {

    private List<ShopifyProduct> products;
    private Pagination pagination;
}