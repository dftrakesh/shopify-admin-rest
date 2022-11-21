package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyWebhookRoot {

    private ShopifyWebhook webhook;

    public ShopifyWebhookRoot(ShopifyWebhook shopifyWebhook) {
        this.webhook = shopifyWebhook;
    }

}
