package com.dft.api.shopify.v202307.model.smartcollections;

import com.dft.api.shopify.model.Pagination;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifySmartCollectionsWrapper {

    private List<ShopifySmartCollections> smartCollections;
    private Pagination pagination;
}