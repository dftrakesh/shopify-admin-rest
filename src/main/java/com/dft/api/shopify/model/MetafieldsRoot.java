package com.dft.api.shopify.model;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class MetafieldsRoot {

    private List<Metafield> metafields = new LinkedList<>();

}
