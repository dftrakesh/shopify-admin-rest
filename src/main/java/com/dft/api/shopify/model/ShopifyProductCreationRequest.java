package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Data
public class ShopifyProductCreationRequest implements ShopifyProductRequest {

	@JsonProperty("product")
	private final ShopifyProduct request;

	private final Map<Integer, Integer> variantPositionToImagePosition;

	public static interface TitleStep {
		public MetafieldsGlobalTitleTagStep withTitle(final String title);
	}

	public static interface MetafieldsGlobalTitleTagStep {
		public ProductTypeStep withMetafieldsGlobalTitleTag(final String metafieldsGlobalTitleTag);
	}

	public static interface ProductTypeStep {
		public BodyHtmlStep withProductType(final String productType);
	}

	public static interface BodyHtmlStep {
		public MetafieldsGlobalDescriptionTagStep withBodyHtml(final String bodyHtml);
	}

	public static interface MetafieldsGlobalDescriptionTagStep {
		public VendorStep withMetafieldsGlobalDescriptionTag(final String metafieldsGlobalDescriptionTag);
	}

	public static interface VendorStep {
		public TagsStep withVendor(final String vendor);
	}

	public static interface TagsStep {
		public SortedOptionNamesStep withTags(final String tags);
	}

	public static interface SortedOptionNamesStep {
		public ImageSourcesStep withSortedOptionNames(final List<String> sortedOptionNames);
	}

	public static interface ImageSourcesStep {
		public VariantCreationRequestsStep withImageSources(final List<String> imageSources);
	}

	public static interface VariantCreationRequestsStep {
		public PublishedStep withVariantCreationRequests(
				final List<ShopifyVariantCreationRequest> variantCreationRequests);
	}

	public static interface PublishedStep {
		public BuildStep withPublished(final boolean published);
	}

	public static interface BuildStep {
		public ShopifyProductCreationRequest build();
	}

	public static TitleStep newBuilder() {
		return new Steps();
	}

	@Override
	public ShopifyProduct getRequest() {
		return request;
	}

	@Override
	public int getVariantImagePosition(final int variantPosition) {
		return variantPositionToImagePosition.get(variantPosition);
	}

	@Override
	public boolean hasVariantImagePosition(final int variantPosition) {
		return variantPositionToImagePosition.containsKey(variantPosition);
	}

	@Override
	public boolean hasChanged() {
		return true;
	}

	public ShopifyProductCreationRequest(final ShopifyProduct shopifyProduct,
			final Map<Integer, Integer> variantPositionToImagePosition) {
		this.request = shopifyProduct;
		this.variantPositionToImagePosition = variantPositionToImagePosition;
	}

	private static class Steps implements TitleStep, MetafieldsGlobalTitleTagStep, MetafieldsGlobalDescriptionTagStep,
			ProductTypeStep, BodyHtmlStep, VendorStep, TagsStep, SortedOptionNamesStep, ImageSourcesStep,
			VariantCreationRequestsStep, PublishedStep, BuildStep {

		private final ShopifyProduct shopifyProduct = new ShopifyProduct();
		private final Map<Integer, Integer> variantPositionToImagePosition = new HashMap<>();

		@Override
		public ShopifyProductCreationRequest build() {
			return new ShopifyProductCreationRequest(shopifyProduct, variantPositionToImagePosition);
		}

		@Override
		public PublishedStep withVariantCreationRequests(
				final List<ShopifyVariantCreationRequest> variantCreationRequests) {
			final List<ShopifyVariant> shopifyVariants = new ArrayList<>(variantCreationRequests.size());

			Collections.sort(variantCreationRequests, new ShopifyVariantRequestOption1Comparator());

			for (int i = 0; i < variantCreationRequests.size(); i++) {
				final ShopifyVariantCreationRequest shopifyVariantCreationRequest = variantCreationRequests.get(i);
				final ShopifyVariant shopifyVariant = shopifyVariantCreationRequest.getRequest();
				final int position = i + 1;
				shopifyVariant.setPosition(position);

				if (shopifyVariantCreationRequest.hasImageSource()) {
					final String imageSource = shopifyVariantCreationRequest.getImageSource();
					shopifyProduct.getImages().stream().filter(image -> image.getSrc().equals(imageSource))
							.findFirst().ifPresent(image -> {
								variantPositionToImagePosition.put(position, image.getPosition());
							});
				}
				shopifyVariants.add(shopifyVariant);
			}
			shopifyProduct.setVariants(shopifyVariants);
			return this;
		}

		@Override
		public VariantCreationRequestsStep withImageSources(final List<String> imageSources) {
			final List<ShopifyImage> shopifyImages = new ArrayList<>(imageSources.size());
			int position = 1;
			final Iterator<String> imageSourceIterator = imageSources.iterator();
			while (imageSourceIterator.hasNext()) {
				final String imageSource = imageSourceIterator.next();
				final ShopifyImage shopifyImage = new ShopifyImage();
				shopifyImage.setPosition(position);
				shopifyImage.setSrc(imageSource);
				final List<ShopifyMetafield> shopifyMetafields = ImageAltTextCreationRequest.newBuilder()
						.withImageAltText(shopifyProduct.getTitle()).build();
				shopifyImage.setShopifyMetafields(shopifyMetafields);
				position++;
				shopifyImages.add(shopifyImage);
			}
			shopifyProduct.setImages(shopifyImages);
			return this;
		}

		@Override
		public ImageSourcesStep withSortedOptionNames(final List<String> sortedOptionNames) {
			final List<ShopifyOption> shopifyOptions = new ArrayList<>(sortedOptionNames.size());
			for (int i = 0; i < sortedOptionNames.size(); i++) {
				final String optionKey = sortedOptionNames.get(i);
				final ShopifyOption shopifyOption = new ShopifyOption();
				shopifyOption.setName(optionKey);
				final int position = i + 1;
				shopifyOption.setPosition(position);
				shopifyOptions.add(shopifyOption);
			}
			shopifyProduct.setOptions(shopifyOptions);
			return this;
		}

		@Override
		public SortedOptionNamesStep withTags(final String tags) {
			shopifyProduct.setTags(tags);
			return this;
		}

		@Override
		public TagsStep withVendor(final String vendor) {
			shopifyProduct.setVendor(vendor);
			return this;
		}

		@Override
		public MetafieldsGlobalDescriptionTagStep withBodyHtml(final String bodyHtml) {
			shopifyProduct.setBodyHtml(bodyHtml);
			return this;
		}

		@Override
		public BodyHtmlStep withProductType(final String productType) {
			shopifyProduct.setProductType(productType);
			return this;
		}

		@Override
		public MetafieldsGlobalTitleTagStep withTitle(final String title) {
			shopifyProduct.setTitle(title);
			return this;
		}

		@Override
		public VendorStep withMetafieldsGlobalDescriptionTag(final String metafieldsGlobalDescriptionTag) {
			shopifyProduct.setMetafieldsGlobalDescriptionTag(metafieldsGlobalDescriptionTag);
			return this;
		}

		@Override
		public ProductTypeStep withMetafieldsGlobalTitleTag(final String metafieldsGlobalTitleTag) {
			shopifyProduct.setMetafieldsGlobalTitleTag(metafieldsGlobalTitleTag);
			return this;
		}

		@Override
		public BuildStep withPublished(final boolean published) {
			final LocalDateTime publishedAt = published ? LocalDateTime.now() : null;
			shopifyProduct.setPublishedAt(publishedAt);
			return this;
		}
	}
}