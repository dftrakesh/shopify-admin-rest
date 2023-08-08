package com.dft.api.shopify.v202307.model.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyWebhook {

    private Long id;
    private String address;
    private String format;
    private String topic;
}