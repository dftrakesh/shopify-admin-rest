package com.dft.api.shopify.model;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.dft.api.shopify.model.adapters.CurrencyAdapter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.Currency;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyTransaction {

	@XmlElement(name = "id")
    public String id;

	@XmlElement(name = "order_id")
	private String orderId;
	
	private String kind;
	
	private String gateway;
	
	@XmlElement(name = "parent_id")
	private String parentId;
	
	private Double amount;
	
	@XmlJavaTypeAdapter(CurrencyAdapter.class)
	private Currency currency;
	
	@XmlElement(name = "status")
    public String status;
    
	@XmlElement(name = "message")
    public String message;
    
	@XmlElement(name = "created_at")
	@JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime createdAt;
    
	@XmlElement(name = "test")
    public Boolean test;
    
	@XmlElement(name = "authorization")
    public String authorization;
    
	@XmlElement(name = "authorization_expires_at")
	@JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime authorizationExpiresAt;
    
	@XmlElement(name = "location_id")
    public Long locationId;
    
	@XmlElement(name = "user_id")
    public String userId;
    
	@XmlElement(name = "device_id")
    public Long deviceId;
    
	@XmlElement(name = "error_code")
    public String errorCode;
    
	@XmlElement(name = "source_name")
    public String sourceName;
	
	@XmlElement(name = "processed_at")
	@JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime processedAt;
    
	@XmlElement(name = "receipt")
	private ShopifyTransactionReceipt receipt;
	
	@XmlElement(name = "extended_authorization_attributes")
    public ShopifyTransactionExtendedAuthorizationAttributes shopifyTransactionExtendedAuthorizationAttributes;
    
	@XmlElement(name = "currency_exchange_adjustment")
    public ShopifyTransactionCurrencyExchangeAdjustment shopifyTransactionCurrencyExchangeAdjustment;

}
