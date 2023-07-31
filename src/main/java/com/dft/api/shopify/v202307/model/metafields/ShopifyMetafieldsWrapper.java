package com.dft.api.shopify.v202307.model.metafields;

import com.dft.api.shopify.model.Pagination;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyMetafieldsWrapper {

    private List<ShopifyMetafield> metafields;
    private Pagination pagination;
}