package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyWebhook {

    private String id;

    private String address;

    private String topic;

    private String format;

    private Date createdAt;

    private Date updatedAt;

    private List<String> metafieldNamespaces = new ArrayList<String>();

    private List<String> fields = new ArrayList<String>();

    private String apiVersion;

    private List<String> privateMetafieldNamespaces = new ArrayList<String>();

    public ShopifyWebhook(String address, String topic, String format) {
        this.address = address;
        this.topic = topic;
        this.format = format;
    }

}
