package com.dft.api.shopify.model;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class ShopifyOrdersRoot {

    private List<ShopifyOrder> orders = new LinkedList<>();

}
