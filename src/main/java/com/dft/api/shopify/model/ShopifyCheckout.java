package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyCheckout {

    private String id;

    private String token;

    private String cartToken;

    private String email;

    private String gateway;

    private Date createdAt;

    private Date updatedAt;

    private String landingSite;

    private String note;

    private String referringSite;

    private Boolean taxesIncluded;

    private String currency;

    private Date completedAt;

    private Date closed_at;

    private Integer userId;

    private Integer locationId;

    private String sourceIdentifier;

    private String sourceUrl;

    private Integer deviceId;

    private String phone;

    private String customerLocale;

    private String name;

    private String source;

    private String abandonedCheckoutUrl;

    private String sourceName;

    private String presentmentCurrency;

    private Double totalDiscounts;

    private Double totalLineItemsPrice;

    private Double totalPrice;

    private Double totalTax;

    private Double subtotalPrice;

    private Double totalDuties;


    private ShopifyAddress billingAddress;

    private ShopifyAddress shippingAddress;

    private ShopifyCustomer customer;

    private List<ShopifyAttribute> noteAttributes = new LinkedList<>();

    private List<ShopifyCheckoutShippingLine> checkoutShippingLines = new LinkedList<>();

    private List<ShopifyLineItem> lineItems = new LinkedList<>();

    private List<ShopifyDiscountCode> discountCodes = new LinkedList<>();

    private List<ShopifyTaxLine> taxLines = new LinkedList<>();

}
