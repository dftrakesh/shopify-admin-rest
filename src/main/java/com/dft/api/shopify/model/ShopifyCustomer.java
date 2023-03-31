package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyCustomer {

    private String id;

    private String email;

    private boolean acceptsMarketing;

    private Date createdAt;

    private Date updatedAt;

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

    public Date acceptsMarketingUpdatedAt;

    public String marketingOptInLevel;

    public List<String> taxExemptions = new LinkedList<String>();

    public String adminGraphqlApiId;

    public List<ShopifyAddress> addresses;

}
