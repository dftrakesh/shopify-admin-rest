package com.dft.api.shopify.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopifyAssets {

	private final Map<String, ShopifyAsset> themeIdToShopifyAsset;

	public ShopifyAssets(final List<ShopifyAsset> shopifyAssets) {
		themeIdToShopifyAsset = new HashMap<>(shopifyAssets.size());
		shopifyAssets.stream().forEach(shopifyAsset -> {
			themeIdToShopifyAsset.put(shopifyAsset.getKey(), shopifyAsset);
		});
	}

	public ShopifyAsset get(final String themeId) {
		return themeIdToShopifyAsset.get(themeId);
	}

	public List<ShopifyAsset> values() {
		return new ArrayList<>(themeIdToShopifyAsset.values());
	}

	
	public int size() {
		return themeIdToShopifyAsset.size();
	}

	public boolean containsKey(final String themeId) {
		return themeIdToShopifyAsset.containsKey(themeId);
	}

}
