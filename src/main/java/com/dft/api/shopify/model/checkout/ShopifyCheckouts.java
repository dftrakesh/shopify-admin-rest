package com.dft.api.shopify.model.checkout;

import com.dft.api.shopify.mappers.PropertiesDeserializer;
import com.dft.api.shopify.model.ShopifyAddress;
import com.dft.api.shopify.model.ShopifyCheckoutShippingLine;
import com.dft.api.shopify.model.ShopifyCustomer;
import com.dft.api.shopify.model.ShopifyDiscountCode;
import com.dft.api.shopify.model.ShopifyTaxLine;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ShopifyCheckouts {

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

    @JsonDeserialize(using = PropertiesDeserializer.class)
    private HashMap<String, String> noteAttributes;

    private List<ShopifyCheckoutShippingLine> checkoutShippingLines = new LinkedList<>();

    private List<ShopifyCheckoutLineItem> lineItems;

    private List<ShopifyDiscountCode> discountCodes = new LinkedList<>();

    private List<ShopifyTaxLine> taxLines = new LinkedList<>();
}