package com.dft.api.shopify.v202307.model.webhook;

import lombok.Data;

import java.util.List;

@Data
public class ShopifyWebhooksWrapper {

    private List<ShopifyWebhook> webhooks;
}