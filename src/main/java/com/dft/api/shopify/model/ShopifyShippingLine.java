package com.dft.api.shopify.model;

import java.util.LinkedList;
import java.util.List;

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
public class ShopifyShippingLine {

	@XmlElement(name = "id")
	private String id;
	
	@XmlElement(name = "order_id")
	private String orderId;
	
	@XmlElement(name = "title")
	private String title;
	
	@XmlElement(name = "price")
	private Double price;
	
	@XmlElement(name = "code")
	private String code;
	
	@XmlElement(name = "source")
	private String source;
	
	@XmlElement(name = "discounted_price")
    private Double discountedPrice;
    
	@XmlElement(name = "carrier_identifier")
    private String carrierIdentifier;
    
	@XmlElement(name = "requested_fulfillment_service_id")
    private String requestedFulfillmentServiceId;

	
	
    private ShopifyAmountSet priceSet;
    
    private ShopifyAmountSet discountedPriceSet;
    
    private List<ShopifyTaxLine> taxLines = new LinkedList<>();	
}
