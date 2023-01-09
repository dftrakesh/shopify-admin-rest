package com.dft.api.shopify.model.graphqlapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphQlVariable {

    private String id;

    private String lineItemId;

    private Integer quantity;

    private String variantId;

    private String title;

    private PriceSet price;

    private OrderEditAppliedDiscountInput discount;
}
