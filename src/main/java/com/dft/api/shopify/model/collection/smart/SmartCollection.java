package com.dft.api.shopify.model.collection.smart;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.dft.api.shopify.model.ShopifyRule;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmartCollection {

    private String id;
    private String title;
    private String handle;
    private boolean published;
    private String bodyHtml;
    private String publishedScope;
    private String sortOrder;
    private String templateSuffix;

    @JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime publishedAt;

    @JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime updatedAt;

    private Boolean disjunctive;

    private List<ShopifyRule> rules = new LinkedList<>();
}