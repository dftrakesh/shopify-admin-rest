package com.dft.api.shopify.model.order.v202307;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.dft.api.shopify.model.ShopifyAddress;
import com.dft.api.shopify.model.ShopifyAmountSet;
import com.dft.api.shopify.model.ShopifyAttribute;
import com.dft.api.shopify.model.ShopifyCustomer;
import com.dft.api.shopify.model.ShopifyDiscountCode;
import com.dft.api.shopify.model.ShopifyMetafield;
import com.dft.api.shopify.model.ShopifyOrderDefaultAddress;
import com.dft.api.shopify.model.ShopifyRefund;
import com.dft.api.shopify.model.ShopifyShippingLine;
import com.dft.api.shopify.model.ShopifyTaxLine;
import com.dft.api.shopify.model.Transaction;
import com.dft.api.shopify.model.fulfillments.v202301.ShopifyFulfillment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ShopifyOrder {

    private String id;

    private String email;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime closedAt;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;

    private String note;

    private String token;

    private Double totalPrice;

    private String appId;

    private Double subtotalPrice;

    private Long totalWeight;

    private Double totalTax;

    private String currency;

    private String financialStatus;

    private Double totalDiscounts;

    private Double totaLineItemsPrice;

    private String cartToken;

    private Boolean buyerAcceptsMarketing;

    private String name;

    private String referringSite;

    private String landingSite;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime cancelledAt;

    private String cancelReason;

    private String userId;

    private String locationId;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime processedAt;

    private String browserIp;

    private String orderNumber;

    private String sourceName;

    private String fulfillmentStatus;

    private String tags;

    private String orderStatusUrl;

    private String adminGraphqlApiId;

    private String checkoutId;

    private String checkoutToken;

    private Boolean confirmed;

    private String contactEmail;

    private Double currentSubtotalPrice;

    private Double currentTotalDiscounts;

    private Double currentTotalPrice;

    private Double currentTotalTax;

    private String customerLocale;

    private String deviceId;

    private String landingSiteRef;

    private String phone;

    private String presentmentCurrency;

    private String reference;

    private String sourceIdentifier;

    private String sourceUrl;

    private Boolean test;

    private Double totalOutstanding;

    private Double totalTipReceived;

    private List<String> paymentGatewayNames = new ArrayList<String>();

    private Boolean taxesIncluded;

    private String inventoryBehaviour;

    private String numberOfBoxes;

    private List<ShopifyLineItem> lineItems = new LinkedList<>();

    private List<ShopifyFulfillment> fulfillments = new LinkedList<>();

    private ShopifyAddress billingAddress = new ShopifyAddress();

    private ShopifyAddress shippingAddress = new ShopifyAddress();

    private ShopifyOrderDefaultAddress defaultAddress = new ShopifyOrderDefaultAddress();

    private ShopifyCustomer customer = new ShopifyCustomer();

    private List<ShopifyShippingLine> shippingLines = new LinkedList<>();

    private List<ShopifyTaxLine> taxLines = new LinkedList<>();

    private List<ShopifyAttribute> noteAttributes = new LinkedList<>();

    private List<ShopifyRefund> refunds = new LinkedList<>();

    private List<ShopifyMetafield> metafields = new LinkedList<>();

    private List<ShopifyDiscountCode> discountCodes = new LinkedList<>();

    private ShopifyAmountSet currentSubtotalPriceSet = new ShopifyAmountSet();

    private ShopifyAmountSet currentTotalDiscountsSet = new ShopifyAmountSet();

    private ShopifyAmountSet currentTotalDutiesSet = new ShopifyAmountSet();

    private ShopifyAmountSet currentTotalPriceSet = new ShopifyAmountSet();

    private ShopifyAmountSet currentTotalTaxSet = new ShopifyAmountSet();

    private ShopifyAmountSet originalTotalDutiesSet = new ShopifyAmountSet();

    private ShopifyAmountSet subtotalPriceSet = new ShopifyAmountSet();

    private ShopifyAmountSet totalDiscountsSet = new ShopifyAmountSet();

    private ShopifyAmountSet totalLineItemsPriceSet = new ShopifyAmountSet();

    private ShopifyAmountSet totalPriceSet = new ShopifyAmountSet();

    private ShopifyAmountSet totalShippingPriceSet = new ShopifyAmountSet();

    private ShopifyAmountSet totalTaxSet = new ShopifyAmountSet();

    private List<Transaction> transactions;
}