package com.dft.api.shopify.v202307.model.smartcollections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifySmartCollections {

    private Long id;
    private String handle;
    private String title;
    private Boolean disjunctive;
    private List<ShopifyRules> rules;
    private String sortOrder;
}