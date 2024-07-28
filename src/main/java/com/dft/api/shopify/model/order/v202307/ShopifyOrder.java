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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopifyOrder {

    private String id;

    private String email;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime closedAt;

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

    private Boolean buyerAcceptsMarketing;

    private String name;

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

    private ShopifyOrderDefaultAddress defaultAddress;

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

    private List<Transaction> transactions;
}