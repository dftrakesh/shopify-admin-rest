package com.dft.api.shopify.model.collection.custom;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomCollection {

    private Long id;
    private String handle;
    private String title;

    @JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime updatedAt;

    @JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime publishedAt;

    private String sortOrder;
    private String templateSuffix;
    private String publishedScope;
    private String adminGraphqlApiId;
}