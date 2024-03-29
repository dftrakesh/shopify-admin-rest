package com.dft.api.shopify.model;

public class ShopifyProductMetafieldCreationRequest {

	private final String productId;
	private final ShopifyMetafield request;

	public static interface ProductIdStep {
		NamespaceStep withProductId(final String productId);
	}

	public static interface NamespaceStep {
		KeyStep withNamespace(final String namespace);
	}

	public static interface KeyStep {
		ValueStep withKey(final String key);
	}

	public static interface ValueStep {
		ValueTypeStep withValue(final String value);
	}

	public static interface ValueTypeStep {
		BuildStep withValueType(final ShopifyMetafieldValueType valueType);
	}

	public static interface BuildStep {
		ShopifyProductMetafieldCreationRequest build();
	}

	public static ProductIdStep newBuilder() {
		return new Steps();
	}

	public String getProductId() {
		return productId;
	}

	public ShopifyMetafield getRequest() {
		return request;
	}

	private ShopifyProductMetafieldCreationRequest(final Steps steps) {
		this.productId = steps.productId;
		this.request = steps.request;
	}

	private static class Steps implements ProductIdStep, NamespaceStep, KeyStep, ValueStep, ValueTypeStep, BuildStep {

		private String productId;
		private ShopifyMetafield request = new ShopifyMetafield();

		@Override
		public ShopifyProductMetafieldCreationRequest build() {
			return new ShopifyProductMetafieldCreationRequest(this);
		}

		@Override
		public BuildStep withValueType(final ShopifyMetafieldValueType valueType) {
			this.request.setValueType(valueType);
			return this;
		}

		@Override
		public ValueTypeStep withValue(final String value) {
			this.request.setValue(value);
			return this;
		}

		@Override
		public ValueStep withKey(final String key) {
			this.request.setKey(key);
			return this;
		}

		@Override
		public KeyStep withNamespace(final String namespace) {
			this.request.setNamespace(namespace);
			return this;
		}

		@Override
		public NamespaceStep withProductId(final String productId) {
			this.productId = productId;
			return this;
		}

	}

}
