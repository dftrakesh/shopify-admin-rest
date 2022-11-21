package com.dft.api.shopify.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopifyCustomers {

	private final Map<String, ShopifyCustomer> customerIdToShopifyCustomer;

	public ShopifyCustomers(final List<ShopifyCustomer> shopifyCustomers) {
		customerIdToShopifyCustomer = new HashMap<>(shopifyCustomers.size());
		shopifyCustomers.stream().forEach(shopifyCustomer -> {
			customerIdToShopifyCustomer.put(shopifyCustomer.getId(), shopifyCustomer);
		});
	}

	public ShopifyCustomer get(final String customerId) {
		return customerIdToShopifyCustomer.get(customerId);
	}

	public List<ShopifyCustomer> values() {
		return new ArrayList<>(customerIdToShopifyCustomer.values());
	}

//	public List<ShopifyAddress> getAddresses() {
//		final Collection<ShopifyCustomer> shopifyCustomers = customerIdToShopifyCustomer.values();
//		final List<ShopifyAddress> shopifyAddresses = new ArrayList<>(shopifyCustomers.size());
//		for (ShopifyCustomer shopifyCustomer : shopifyCustomers) {
//			shopifyAddresses.addAll(shopifyCustomer.getAddresses());
//		}
//		return shopifyAddresses;
//	}

	public int size() {
		return customerIdToShopifyCustomer.size();
	}

	public boolean containsKey(final String customerId) {
		return customerIdToShopifyCustomer.containsKey(customerId);
	}

}
