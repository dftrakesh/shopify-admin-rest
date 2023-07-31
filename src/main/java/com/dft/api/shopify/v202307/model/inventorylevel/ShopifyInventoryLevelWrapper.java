package com.dft.api.shopify.v202307.model.inventorylevel;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopifyInventoryLevelWrapper {

    private ShopifyInventoryLevel inventoryLevel;
}