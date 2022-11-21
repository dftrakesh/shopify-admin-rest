package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyDraftOrder {

    public String id;

    public String orderId;

    private Boolean taxesIncluded;

    private String currency;

    private Date invoiceSentAt;

    private Date createdAt;

    private Date updatedAt;

    private Date completedAt;

    private Boolean taxExempt;

    private String name;

    private String invoiceUrl;

    private String tags;

    private Double totalPrice;

    private Double subtotalPrice;

    private Double totalTax;

    private String adminGraphqlApiId;

    private ShopifyCustomer customer;


    private List<ShopifyLineItem> lineItems = new LinkedList<>();

    private ShopifyAddress shippingAddress;

    private ShopifyAddress billingAddress;

    private ShopifyAppliedDiscount appliedDiscount;

    private ShopifyDraftOrderShippingLine shippingLine;

    private List<ShopifyTaxLine> taxLines = new LinkedList<>();

    private List<ShopifyAttribute> noteAttributes = new LinkedList<>();


}
