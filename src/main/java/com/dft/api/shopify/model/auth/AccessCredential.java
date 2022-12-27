package com.dft.api.shopify.model.auth;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AccessCredential {

    private String storeDomain;
    private String accessToken;
    private String apiKey;
    private String apiSecretKey;
}