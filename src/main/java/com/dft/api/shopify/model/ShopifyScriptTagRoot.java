package com.dft.api.shopify.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyScriptTagRoot {

	@XmlElement(name = "script_tag")
	@JsonProperty("script_tag")
	private ShopifyScriptTag shopifyScriptTag;

	public ShopifyScriptTagRoot(ShopifyScriptTag shopifyScriptTag) {
		this.shopifyScriptTag = shopifyScriptTag;
	}

}
