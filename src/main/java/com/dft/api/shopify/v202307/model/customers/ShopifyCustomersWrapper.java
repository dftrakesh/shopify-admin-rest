package com.dft.api.shopify.v202307.model.customers;

import com.dft.api.shopify.model.Pagination;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyCustomersWrapper {

    private List<ShopifyCustomer> customers;
    private Pagination pagination;
}