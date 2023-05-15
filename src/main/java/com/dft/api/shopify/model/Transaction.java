package com.dft.api.shopify.model;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Transaction {
    public String amount;
    public String authorization;
    public String currency;
    public Integer deviceId;
    public String errorCode;
    public String gateway;
    public Integer id;
    public String kind;
    public String message;
    public Integer orderId;
    public Long parentId;

    @JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime authorizationExpiresAt;

    @JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime createdAt;

    @JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime processedAt;
    public String sourceName;
    public String status;
    public Boolean test;
    public Integer userId;
}