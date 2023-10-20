package com.dft.api.shopify.v202307.model.products;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.dft.api.shopify.model.Metafield;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyProduct {

    private Long id;
    private List<ShopifyProductVariant> variants;
    private String handle;
    private String title;
    private String tags;
    private String productType;
    private String status;
    private String bodyHtml;
    private String vendor;
    private String templateSuffix;
    private String publishedScope;
    private List<ShopifyImage> images;
    private List<ShopifyOption> options;
    private ShopifyImage image;
    private List<Metafield> metafields;
    private Boolean published;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;
    
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime publishedAt;
}