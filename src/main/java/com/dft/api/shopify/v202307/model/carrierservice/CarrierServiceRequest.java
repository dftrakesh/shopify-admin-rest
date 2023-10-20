package com.dft.api.shopify.v202307.model.carrierservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CarrierServiceRequest {
    public Long id;
    public String format;
    public String name;
    public Boolean active;
    public String callbackUrl;
    public String carrierServiceType;
    public Boolean serviceDiscovery;
    public String adminGraphqlApiId;
}