package com.dft.api.shopify.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyScriptTagsRoot {
	
	private List<ShopifyScriptTagRoot> shopifyScriptTags = new ArrayList<>();
}
