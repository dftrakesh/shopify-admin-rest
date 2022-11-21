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
public class ShopifyTransactionPaymentDetails {

	/*
	The issuer identification number (IIN), formerly known as bank identification number (BIN) of the customer's credit card. This is made up of the first few digits of the credit card number.
	*/
    @XmlElement(name = "credit_card_bin")
    public Integer creditCardBin;
	
	/*
	The response code from the address verification system. The code is always a single letter.
	*/
    @XmlElement(name = "avs_result_code")
    public Character avsResultCode;
	
	/*
	The response code from the credit card company indicating whether the customer entered the card security code, or card verification value, correctly. The code is a single letter or empty string
	*/
	@XmlElement(name = "cvv_result_code")
    public String cvvResultCode;
    
	@XmlElement(name = "credit_card_number")
    public String creditCardNumber;

    @XmlElement(name = "credit_card_company")
    public String creditCardCompany;

}
