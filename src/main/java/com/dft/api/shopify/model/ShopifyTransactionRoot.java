package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopifyTransactionRoot {

    private ShopifyTransaction transaction;
}
