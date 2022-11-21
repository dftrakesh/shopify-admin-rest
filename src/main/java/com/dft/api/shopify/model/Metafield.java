package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metafield {

    private String id;
    private String key;
    private String value;
    private MetafieldValueType valueType;
    private String namespace;
    private String ownerId;
    private String ownerResource;
    private Date createdAt;
    private Date updatedAt;

}
