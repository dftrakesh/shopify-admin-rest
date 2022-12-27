package com.dft.api.shopify.model;

import lombok.Data;

@Data
public class ShopifyJWTPayload {

	private String iss;
	private String dest;
	private String aud;
	private String sub;
	private String exp;
	private String nbf;
	private String iat;
	private String jti;
}