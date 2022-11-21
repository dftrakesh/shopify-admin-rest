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
public class ShopifyRefundOrderAdjustment {

	@XmlElement(name = "id")
    private String id;

	@XmlElement(name = "order_id")
	private String orderId;
	
	@XmlElement(name = "amount")
	private Double amount;
	
	@XmlElement(name = "tax_amount")
	private Double taxAmount;
	
	@XmlElement(name = "kind")
	private String kind;
	
	@XmlElement(name = "reason")
	private String reason;
	
    @XmlElement(name = "refund_id")
	private String refundId;

    @XmlElement(name = "amount_set")
    private ShopifyAmountSet amountSet = new ShopifyAmountSet();

    @XmlElement(name = "taxAmount_set")
    private ShopifyAmountSet taxAmountSet = new ShopifyAmountSet();


}
