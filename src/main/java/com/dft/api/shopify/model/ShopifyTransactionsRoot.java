package com.dft.api.shopify.model;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@Data
public class ShopifyTransactionsRoot {

	private List<ShopifyTransaction> transactions = new LinkedList<>();

}
