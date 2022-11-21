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
public class ShopifyTransactionExtendedAuthorizationAttributes {

    @XmlElement(name = "standard_authorization_expires_at")
    public String standardAuthorizationExpiresAt;

    @XmlElement(name = "extended_authorization_expires_at")
    public String extendedAuthorizationExpiresAt;

}
