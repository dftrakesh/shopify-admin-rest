package com.dft.api.shopify.v202307.model.transactions;

import lombok.Data;

import java.util.List;

@Data
public class ShopifyTransactionsWrapper {

    private List<ShopifyTransaction> transactions;
}