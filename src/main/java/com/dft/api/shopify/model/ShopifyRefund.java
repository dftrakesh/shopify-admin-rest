package com.dft.api.shopify.model;

import java.util.Currency;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.dft.api.shopify.model.adapters.CurrencyAdapter;
import com.dft.api.shopify.model.adapters.DateTimeAdapter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.DateTime;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyRefund {

	private String id;
	
	private String orderId;
	
	@XmlElement(name = "created_at")
	@XmlJavaTypeAdapter(DateTimeAdapter.class)
	private DateTime createdAt;
	
	private String note;
	
	@XmlElement(name = "user_id")
	private String userId;
	
	@XmlElement(name = "processed_at")
	@XmlJavaTypeAdapter(DateTimeAdapter.class)
	private DateTime processedAt;
	
	@XmlJavaTypeAdapter(CurrencyAdapter.class)
	private Currency currency;
	
	
	
	@XmlElement(name = "refund_line_items")
	private List<ShopifyRefundLineItem> refundLineItems = new LinkedList<>();
	
	private List<ShopifyTransaction> transactions = new LinkedList<>();

    @XmlElement(name = "order_adjustments")
    public List<ShopifyRefundOrderAdjustment> orderAdjustments = new LinkedList<>();
	
    @XmlElement(name = "duties")
    public List<ShopifyDuty> duties = new LinkedList<>();

    @XmlElement(name = "refund_duties")
    public List<ShopifyRefundDuty> refundDuties = new LinkedList<>();
}
