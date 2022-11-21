package com.dft.api.shopify.model;

import java.util.Arrays;
import java.util.List;

public class ImageAltTextCreationRequest {

	static final String KEY = "alt";
	static final String NAMESPACE = "tags";
	static final ShopifyMetafieldValueType VALUE_TYPE = ShopifyMetafieldValueType.STRING;

	public static interface ImageAltTextStep {
		public BuildStep withImageAltText(final String imageAltText);
	}

	public static interface BuildStep {
		public List<ShopifyMetafield> build();
	}

	public static ImageAltTextStep newBuilder() {
		return new Steps();
	}

	private static class Steps implements ImageAltTextStep, BuildStep {

		private ShopifyMetafield imageAltTextMetafield;

		@Override
		public List<ShopifyMetafield> build() {
			return Arrays.asList(imageAltTextMetafield);
		}

		@Override
		public BuildStep withImageAltText(String imageAltText) {
			this.imageAltTextMetafield = new ShopifyMetafield();
			imageAltTextMetafield.setKey(KEY);
			imageAltTextMetafield.setValue(imageAltText);
			imageAltTextMetafield.setNamespace(NAMESPACE);
			imageAltTextMetafield.setValueType(VALUE_TYPE);
			return this;
		}

	}

}
