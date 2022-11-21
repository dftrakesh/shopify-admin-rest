package com.dft.api.shopify.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@Data
public class ShopifyThemeRoot {

	private ShopifyTheme theme;
	
}
