package com.dft.api.shopify.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopifyOrders {

	private final Map<String, ShopifyOrder> orderToShopifyOrder;

	public ShopifyOrders(final List<ShopifyOrder> shopifyOrders) {
		orderToShopifyOrder = new HashMap<>(shopifyOrders.size());
		shopifyOrders.stream().forEach(shopifyOrder -> {
			orderToShopifyOrder.put(shopifyOrder.getId(), shopifyOrder);
		});
	}

	public ShopifyOrder get(final String orderId) {
		return orderToShopifyOrder.get(orderId);
	}

	public List<ShopifyOrder> values() {
		return new ArrayList<>(orderToShopifyOrder.values());
	}

//	public List<ShopifyVariant> getVariants() {
//		final Collection<ShopifyProduct> shopifyProducts = productIdToShopifyProduct.values();
//		final List<ShopifyVariant> shopifyVariants = new ArrayList<>(shopifyProducts.size());
//		for (ShopifyProduct shopifyProduct : shopifyProducts) {
//			shopifyVariants.addAll(shopifyProduct.getVariants());
//		}
//		return shopifyVariants;
//	}

	public int size() {
		return orderToShopifyOrder.size();
	}

	public boolean containsKey(final String orderId) {
		return orderToShopifyOrder.containsKey(orderId);
	}

}
