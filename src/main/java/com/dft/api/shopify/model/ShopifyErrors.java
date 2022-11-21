package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyErrors {

    @JsonProperty("shipping_address")
    private List<String> shippingAddressErrors = new LinkedList<>();

    public List<String> getShippingAddressErrors() {
        return shippingAddressErrors;
    }

    public void setShippingAddressErrors(final List<String> shippingAddressErrors) {
        this.shippingAddressErrors = shippingAddressErrors;
    }

}
