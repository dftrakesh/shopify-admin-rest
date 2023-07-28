package com.dft.api.shopify.v202307.model.common;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyPriceSet {

    private ShopifyShopMoney shopMoney;
    private ShopifyPresentmentMoney presentmentMoney;
}