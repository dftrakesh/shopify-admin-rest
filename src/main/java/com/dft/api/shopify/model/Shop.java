package com.dft.api.shopify.model;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Shop {

    private String id;
    private String name;
    private String address1;
    private String address2;
    private Boolean checkoutApiSupported;
    private String city;
    private String country;
    private String countryCode;
    private String countryName;
    private String countyTaxes;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;

    private String customerEmail;
    private String currency;
    private String domain;
    private List<String> enabledPresentmentCurrencies;
    private Boolean eligibleForCardReaderGiveaway;
    private Boolean eligibleForPayments;
    private String email;
    private Boolean finances;
    private Boolean forceSsl;
    private String googleAppsDomain;
    private String googleAppsLoginEnabled;
    private Boolean hasDiscounts;
    private Boolean hasGiftCards;
    private Boolean hasStorefront;
    private String ianaTimezone;
    private Double latitude;
    private Double longitude;
    private String moneyFormat;
    private String moneyInEmailsFormat;
    private String moneyWithCurrencyFormat;
    private String moneyWithCurrencyInEmailsFormat;
    private Boolean multiLocationEnabled;
    private String myshopifyDomain;
    private Boolean passwordEnabled;
    private String phone;
    private String planDisplayName;
    private Boolean preLaunchEnabled;
    private String cookieConsentLevel;
    private String planName;
    private String primaryLocale;
    private String primaryLocationId;
    private String province;
    private String provinceCode;
    private Boolean requiresExtraPaymentsAgreement;
    private Boolean setupRequired;
    private String shopOwner;
    private String source;
    private Boolean taxesIncluded;
    private String taxShipping;
    private String timezone;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;

    private String weightUnit;
    private String zip;
}
