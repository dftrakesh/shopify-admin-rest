package com.dft.api.shopify.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@XmlRootElement
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyTaxLine {

	private String id;
	
	private String title;
	
	private Double price;
	
	private Double rate;
}
