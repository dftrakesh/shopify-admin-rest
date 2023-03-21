package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopifyImage {

    private String id;
    private String productId;
    private int position;
    private String name;

    private String src;

    private List<String> variantIds = new LinkedList<>();

    private List<ShopifyMetafield> shopifyMetafields = new LinkedList<>();

    private String attachment;

    private String filename;

    private String height;

    private String width;

    private Date createdAt;

    private Date updatedAt;

    private String alt;
}
