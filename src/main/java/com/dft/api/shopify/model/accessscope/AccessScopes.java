package com.dft.api.shopify.model.accessscope;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccessScopes {

    @JsonProperty("handle")
    private String handle;
}