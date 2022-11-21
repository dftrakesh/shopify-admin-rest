
package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarrierServiceResponse {

    private Long id;
    private String name;
    private Boolean active;
    private Boolean serviceDiscovery;
    private String carrierServiceType;
    private String adminGraphqlApiId;
    private String format;
    private String callbackUrl;

}
