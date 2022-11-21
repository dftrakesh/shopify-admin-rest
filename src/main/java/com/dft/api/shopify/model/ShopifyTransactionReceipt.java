package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyTransactionReceipt {

	@XmlElement(name = "apple_pay")
	private boolean applePay;

	@XmlElement(name = "gift_card_id")
	private String giftCardId;

	@XmlElement(name = "gift_card_last_characters")
	private String giftCardLastCharacters;
}
