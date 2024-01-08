package com.dft.api.shopify.v202401.model.orders;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.dft.api.shopify.mappers.LocalDateTimeSerializer;
import com.dft.api.shopify.v202307.model.address.ShopifyAddress;
import com.dft.api.shopify.v202307.model.common.ShopifyAmountSet;
import com.dft.api.shopify.v202307.model.common.ShopifyAttribute;
import com.dft.api.shopify.v202307.model.common.ShopifyShippingLine;
import com.dft.api.shopify.v202307.model.common.ShopifyTaxLine;
import com.dft.api.shopify.v202307.model.customers.ShopifyCustomer;
import com.dft.api.shopify.v202307.model.fullfillment.ShopifyFulfillment;
import com.dft.api.shopify.v202307.model.metafields.ShopifyMetafield;
import com.dft.api.shopify.v202307.model.refund.ShopifyRefund;
import com.dft.api.shopify.v202401.model.transactions.ShopifyTransaction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyOrder {

    private Long id;
    private String email;
    private String note;
    private Double totalPrice;
    private String appId;
    private Double subtotalPrice;
    private Long totalWeight;
    private Double totalTax;
    private String currency;
    private String financialStatus;
    private Double totalDiscounts;
    private Double totalLineItemsPrice;
    private Boolean buyerAcceptsMarketing;
    private String name;
    private String cancelReason;
    private Long userId;
    private Long locationId;
    private String browserIp;
    private String orderNumber;
    private String sourceName;
    private String fulfillmentStatus;
    private String landingSite;
    private String landingSiteRef;
    private String referringSite;
    private Double totalOutstanding;
    private Double totalPriceUsd;
    private Double totalTipReceived;
    private String tags;
    private String orderStatusUrl;
    private String adminGraphqlApiId;
    private Long checkoutId;
    private Boolean confirmed;
    private String contactEmail;
    private Double currentSubtotalPrice;
    private Double currentTotalDiscounts;
    private Double currentTotalPrice;
    private Double currentTotalTax;
    private String customerLocale;
    private Long deviceId;
    private String phone;
    private String presentmentCurrency;
    private String reference;
    private String sourceIdentifier;
    private String sourceUrl;
    private List<String> paymentGatewayNames;
    private Boolean taxesIncluded;
    private String inventoryBehaviour;
    private String numberOfBoxes;
    private List<ShopifyLineItem> lineItems;
    private List<ShopifyFulfillment> fulfillments;
    private ShopifyAddress billingAddress;
    private ShopifyAddress shippingAddress;
    private ShopifyAddress defaultAddress;
    private ShopifyCustomer customer;
    private List<ShopifyShippingLine> shippingLines;
    private List<ShopifyTaxLine> taxLines;
    private List<ShopifyAttribute> noteAttributes;
    private List<ShopifyRefund> refunds;
    private List<ShopifyMetafield> metafields;
    private ShopifyAmountSet currentSubtotalPriceSet;
    private ShopifyAmountSet currentTotalDutiesSet;
    private ShopifyAmountSet currentTotalPriceSet;
    private ShopifyAmountSet currentTotalTaxSet;
    private ShopifyAmountSet originalTotalDutiesSet;
    private ShopifyAmountSet subtotalPriceSet;
    private ShopifyAmountSet totalLineItemsPriceSet;
    private ShopifyAmountSet totalPriceSet;
    private ShopifyAmountSet totalShippingPriceSet;
    private ShopifyAmountSet totalTaxSet;
    private List<ShopifyTransaction> transactions;

    @JsonDeserialize(using = DateDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;

    @JsonDeserialize(using = DateDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;

    @JsonDeserialize(using = DateDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime closedAt;

    @JsonDeserialize(using = DateDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime cancelledAt;

    @JsonDeserialize(using = DateDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime processedAt;
}