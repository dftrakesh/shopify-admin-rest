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
public class ShopifyTransactionCurrencyExchangeAdjustment {

    @XmlElement(name = "id")
    public Integer id;

    @XmlElement(name = "adjustment")
    public String adjustment;

    @XmlElement(name = "original_amount")
    public String originalAmount;

    @XmlElement(name = "final_amount")
    public String finalAmount;

    @XmlElement(name = "currency")
    public String currency;

}
