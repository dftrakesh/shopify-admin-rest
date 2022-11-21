package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

    private Long id;

    private String productId;

    private String name;

    private int position;

    private String source;

    private List<String> variantIds = new LinkedList<>();

    private List<Metafield> metafields = new LinkedList<>();

    private String height;

    private String width;

    private String createdAt;

}
