package com.dft.api.shopify.model.order.v202307;

import com.dft.api.shopify.model.Pagination;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyOrderWrapper {

    private List<ShopifyOrder> orders;
    private Pagination pagination;
}
