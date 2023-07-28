package com.dft.api.shopify.v202307.model.transactions;

import com.dft.api.shopify.v202307.model.common.ShopifyPresentmentMoney;
import com.dft.api.shopify.v202307.model.common.ShopifyShopMoney;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyTransactionTotalUnsettledSet {

    public ShopifyShopMoney shopMoney;
    public ShopifyPresentmentMoney presentmentMoney;
}