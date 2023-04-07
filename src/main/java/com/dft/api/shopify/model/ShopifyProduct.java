package com.dft.api.shopify.model;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopifyProduct {

    private String id;
    private String title;
    private String productType;
    private String bodyHtml;
    private String vendor;
    private String tags;
    private List<ShopifyOption> options = new LinkedList<>();
    private String metafieldsGlobalTitleTag;
    private String metafieldsGlobalDescriptionTag;
    private List<ShopifyImage> images = new LinkedList<>();
    private ShopifyImage image;
    private List<ShopifyVariant> variants = new LinkedList<>();
    private List<Metafield> metafields = new ArrayList<>();

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime publishedAt;

    private Boolean published;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;

    private String handle;
    private String publishedScope;

    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;

    public String templateSuffix;
    public String status;
    public String adminGraphqlApiId;

    public List<String> sortedOptionNames() {
        final Comparator<ShopifyOption> optionPositionCompartor = new Comparator<ShopifyOption>() {
            @Override
            public int compare(final ShopifyOption o1, final ShopifyOption o2) {
                return o1.getPosition() - o2.getPosition();
            }
        };
        return options.stream().sorted(optionPositionCompartor).map(ShopifyOption::getName).collect(Collectors.toList());
    }


    public String getMetafieldsGlobalTitleTag() {
        return metafieldsGlobalTitleTag;
    }

    public void setMetafieldsGlobalTitleTag(String metafieldsGlobalTitleTag) {
        this.metafieldsGlobalTitleTag = metafieldsGlobalTitleTag;
    }

    public String getMetafieldsGlobalDescriptionTag() {
        return metafieldsGlobalDescriptionTag;
    }

    public void setMetafieldsGlobalDescriptionTag(String metafieldsGlobalDescriptionTag) {
        this.metafieldsGlobalDescriptionTag = metafieldsGlobalDescriptionTag;
    }

}
