package com.dft.api.shopify.v202307.model.fullfillment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyTrackingInfo {

    private Long number;
    private String url;
    private String company;
}