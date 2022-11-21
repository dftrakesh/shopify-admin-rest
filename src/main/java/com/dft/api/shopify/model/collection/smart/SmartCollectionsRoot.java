package com.dft.api.shopify.model.collection.smart;

import com.dft.api.shopify.model.ShopifyCheckout;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmartCollectionsRoot {

    private List<SmartCollection> smartCollections;
    private SmartCollection smartCollection;
}
