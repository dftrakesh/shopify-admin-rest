package com.dft.api.shopify.model.webhook202301;

import com.dft.api.shopify.model.ShopifyWebhook;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyWebhooksRoot {

    private List<ShopifyWebhook> webhooks;
}