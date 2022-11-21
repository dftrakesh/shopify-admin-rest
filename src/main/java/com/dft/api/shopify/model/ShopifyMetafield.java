package com.dft.api.shopify.model;

import com.dft.api.shopify.model.adapters.MetafieldValueTypeDeserializer;
import com.dft.api.shopify.model.adapters.MetafieldValueTypeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyMetafield {

    private String id;

    private String key;

    private String value;

    @JsonDeserialize(converter = MetafieldValueTypeDeserializer.class)
    @JsonSerialize(converter = MetafieldValueTypeSerializer.class)
    private ShopifyMetafieldValueType valueType;

    private String namespace;

    private String ownerId;

    private String ownerResource;

    private Date createdAt;

    private Date updatedAt;

}
