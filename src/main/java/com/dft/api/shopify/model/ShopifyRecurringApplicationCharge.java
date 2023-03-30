package com.dft.api.shopify.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.dft.api.shopify.model.adapters.EscapedStringAdapter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyRecurringApplicationCharge {

	private String id;

	@XmlElement(name = "api_client_id")
	private String apiClientId;

	private String name;

	private String terms;

	private BigDecimal price;

	@XmlElement(name = "capped_amount")
	private BigDecimal cappedAmount;

	private String status;

	@XmlElement(name = "return_url")
	@XmlJavaTypeAdapter(EscapedStringAdapter.class)
	private String returnUrl;

	@XmlElement(name = "confirmation_url")
	@XmlJavaTypeAdapter(EscapedStringAdapter.class)
	private String confirmationUrl;

	@XmlElement(name = "trial_days")
	private int trialDays;

	@XmlElement(name = "trial_end_on")
	private String trialEndsOn;

	@XmlElement(name = "activated_on")
	private String activatedOn;

	@XmlElement(name = "billing_on")
	private String billingOn;

	@XmlElement(name = "cancelled_on")
	private String cancelledOn;

	@XmlElement(name = "created_at")
	private String createdAt;

	@XmlElement(name = "updated_on")
	private String updatedOn;
	private Boolean test;

}
