package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyCollection {

    private String id;

    private String handle;

    private Date updatedAt;

    private Date publishedAt;

    private String sortOrder;

    private String templateSuffix;

    private Integer productsCount;

    private String collectionType;

    private String publishedScope;

    private String title;

    private String bodyHtml;

    public List<ShopifyCollectionImage> image = new LinkedList<ShopifyCollectionImage>();

}
