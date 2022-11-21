package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyCustomCollection {

    private String id;
    private String title;
    private String handle;
    private boolean published;

    private String bodyHtml;

    private String publishedScope;

    private String sortOrder;

    private String templateSuffix;

    private Date publishedAt;

    private Date updatedAt;

    public ShopifyCollectionImage shopifyCustomCollectionImage;

    private String adminGraphqlApiId;

}
