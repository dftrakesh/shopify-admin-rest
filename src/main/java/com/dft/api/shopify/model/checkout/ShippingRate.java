package com.dft.api.shopify.model.checkout;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingRate {
    public String id;
    public String price;
    public String title;
}