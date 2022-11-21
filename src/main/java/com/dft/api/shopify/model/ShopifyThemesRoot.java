package com.dft.api.shopify.model;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ShopifyThemesRoot {

	private List<ShopifyTheme> themes = new LinkedList<ShopifyTheme>();
	
}
