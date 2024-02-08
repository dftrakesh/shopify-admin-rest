package com.dft.api.shopify.v202401.model.InventoryLevel;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.dft.api.shopify.mappers.LocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InventoryLevel {
    private Long inventoryItemId;
    private Long locationId;
    private Integer available;

    @JsonDeserialize(using = DateDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;
    private String adminGraphqlApiId;
}