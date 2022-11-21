package com.dft.api.shopify.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopifyThemes {

	private final Map<String, ShopifyTheme> themeIdToShopifyTheme;

	public ShopifyThemes(final List<ShopifyTheme> shopifyThemes) {
		themeIdToShopifyTheme = new HashMap<>(shopifyThemes.size());
		shopifyThemes.stream().forEach(shopifyTheme -> {
			themeIdToShopifyTheme.put(shopifyTheme.getId(), shopifyTheme);
		});
	}

	public ShopifyTheme get(final String themeId) {
		return themeIdToShopifyTheme.get(themeId);
	}

	public List<ShopifyTheme> values() {
		return new ArrayList<>(themeIdToShopifyTheme.values());
	}

	
	public int size() {
		return themeIdToShopifyTheme.size();
	}

	public boolean containsKey(final String themeId) {
		return themeIdToShopifyTheme.containsKey(themeId);
	}

}
