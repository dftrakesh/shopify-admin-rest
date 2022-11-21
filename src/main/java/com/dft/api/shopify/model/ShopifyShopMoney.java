package com.dft.api.shopify.model;

import java.util.Currency;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.dft.api.shopify.model.adapters.CurrencyAdapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyShopMoney {
	
	
	@XmlElement(name = "amount")
	private Double amount;
	
	@XmlElement(name = "currency_code")
	@XmlJavaTypeAdapter(CurrencyAdapter.class)
	private Currency currencyCode;
	
}