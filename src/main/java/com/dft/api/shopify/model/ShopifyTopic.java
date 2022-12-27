package com.dft.api.shopify.model;

import java.util.Optional;

/**
 * Shopify Webhook topics
 */
public enum ShopifyTopic {

    APP_UNINSTALLED("app/uninstalled");

    private final String topicName;

    ShopifyTopic(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }

    public static Optional<ShopifyTopic> getByName(String topicName) {
        for (ShopifyTopic topic : ShopifyTopic.values()) {
            if (topicName.equals(topic.topicName)) {
                return Optional.of(topic);
            }
        }

        return Optional.empty();
    }
}