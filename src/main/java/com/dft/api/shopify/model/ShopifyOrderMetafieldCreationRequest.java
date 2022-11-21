package com.dft.api.shopify.model;

public class ShopifyOrderMetafieldCreationRequest {

	private final String orderId;
	private final Metafield request;

	public static interface OrderIdStep {
		NamespaceStep withOrderId(final String orderId);
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
		BuildStep withValueType(final MetafieldValueType valueType);
	}

	public static interface BuildStep {
		ShopifyOrderMetafieldCreationRequest build();
	}

	public static OrderIdStep newBuilder() {
		return new Steps();
	}

	public String getOrderId() {
		return orderId;
	}

	public Metafield getRequest() {
		return request;
	}

	private ShopifyOrderMetafieldCreationRequest(final Steps steps) {
		this.orderId = steps.orderId;
		this.request = steps.request;
	}

	private static class Steps implements OrderIdStep, NamespaceStep, KeyStep, ValueStep, ValueTypeStep, BuildStep {

		private String orderId;
		private Metafield request = new Metafield();

		@Override
		public ShopifyOrderMetafieldCreationRequest build() {
			return new ShopifyOrderMetafieldCreationRequest(this);
		}

		@Override
		public BuildStep withValueType(final MetafieldValueType valueType) {
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
		public NamespaceStep withOrderId(final String orderId) {
			this.orderId = orderId;
			return this;
		}

	}

}
