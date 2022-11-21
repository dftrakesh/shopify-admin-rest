package com.dft.api.shopify.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@XmlRootElement
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyCustomersRoot {
	
	private List<ShopifyCustomer> customers = new LinkedList<>();

}
