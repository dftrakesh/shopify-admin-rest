package com.dft.api.shopify.model.collection.smart;

import com.dft.api.shopify.model.Pagination;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmartCollectionWrapper {

    private List<SmartCollection> smartCollections;
    private Pagination pagination;
}