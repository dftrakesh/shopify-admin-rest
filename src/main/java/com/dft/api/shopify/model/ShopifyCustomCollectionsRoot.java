package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyCustomCollectionsRoot {

    @XmlElement(name = "custom_collections")
    private List<ShopifyCustomCollection> customCollections = new LinkedList<ShopifyCustomCollection>();
}
