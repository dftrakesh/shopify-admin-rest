package com.dft.api.shopify.model;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyCustomer {

    private String id;

    private String email;

    private boolean acceptsMarketing;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;

    private String firstName;

    private String lastName;

    private String phone;

    private Integer ordersCount;

    private String state;

    private BigDecimal totalSpent;

    public long lastOrderId;

    private String note;

    public boolean verifiedEmail;

    public String multipassIdentifier;

    public boolean taxExempt;

    public String tags;

    public String lastOrderName;

    public String currency;

    @JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime acceptsMarketingUpdatedAt;

    public String marketingOptInLevel;

    public List<String> taxExemptions = new LinkedList<String>();

    public String adminGraphqlApiId;

    public List<ShopifyAddress> addresses;

    public ShopifyAddress defaultAddress;

}
