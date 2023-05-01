package com.dft.api.shopify.model.accessscope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessScopesWrapper {

    @JsonProperty("access_scopes")
    public List<AccessScopes> accessScopes;
}