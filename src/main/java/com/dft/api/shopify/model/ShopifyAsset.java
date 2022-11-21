package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyAsset {

    private String key;

    private String privateUrl;

    private String value;

    private Date createdAt;

    private Date updatedAt;

    private String contentType;

    private int size;

    private String checksum;

    private String themeId;

    public ShopifyAsset(String key, String value) {
        this.key = key;
        this.value = value;
    }

}
