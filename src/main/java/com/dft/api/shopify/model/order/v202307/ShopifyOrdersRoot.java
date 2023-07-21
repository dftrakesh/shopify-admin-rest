package com.dft.api.shopify.model.order.v202307;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class ShopifyOrdersRoot {

    private List<ShopifyOrder> orders = new LinkedList<>();
}