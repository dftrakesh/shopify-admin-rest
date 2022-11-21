package com.dft.api.shopify.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyRefundLineItem {

	private String id;
	
	private Integer quantity;
	
	@XmlElement(name = "line_item_id")
	private String lineItemId;
	
	@XmlElement(name = "location_id")
	private String locationId;
	
	@XmlElement(name = "restock_type")
	private String restockType;
	
	private Double subtotal;
	
	@XmlElement(name = "total_tax")
	private Double totalTax;
	
	@XmlElement(name = "line_item")
	private ShopifyLineItem lineItem;

	@XmlElement(name = "subtotal_set")
    public ShopifyAmountSet subtotalSet;

	@XmlElement(name = "total_tax_set")
    public ShopifyAmountSet totalTaxSet;


}
