package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyRecurringApplicationChargeRoot {

	@XmlElement(name = "recurring_application_charge")
	private ShopifyRecurringApplicationCharge recurringApplicationCharge;

	public ShopifyRecurringApplicationCharge getRecurringApplicationCharge() {
		return recurringApplicationCharge;
	}

	public void setRecurringApplicationCharge(ShopifyRecurringApplicationCharge recurringApplicationCharge) {
		this.recurringApplicationCharge = recurringApplicationCharge;
	}

}
