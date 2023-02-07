package com.dft.api.shopify.model;

import java.time.LocalDateTime;
import java.util.List;

public class ShopifyOrderCreationRequest { 

	private final ShopifyOrder request;

	public static interface ProcessedAtStep {
		NameStep withProcessedAt(final LocalDateTime processedAt);
	}

	public static interface NameStep {
		CurrencyStep withName(final String name);
	}

	public static interface CurrencyStep {
		PresentmentCurrencyStep withCurrency(final String currency);
	}

	public static interface PresentmentCurrencyStep {
		EmailStep withPresentmentCurrency(final String currency);
	}

	public static interface EmailStep {
		CustomerStep withEmail(final String email);
	}

	public static interface CustomerStep {
		LineItemsStep withCustomer(final ShopifyCustomer customer);

		LineItemsStep noCustomer();
	}

	public static interface LineItemsStep {
		ShippingAddressStep withLineItems(final List<ShopifyLineItem> lineItems);
	}

	public static interface ShippingAddressStep {
		BillingAddressStep withShippingAddress(final ShopifyAddress shippingAddress);
	}

	public static interface BillingAddressStep {
		MetafieldsStep withBillingAddress(final ShopifyAddress billingAddress);
	}

	public static interface MetafieldsStep {

		ShippingLinesStep withMetafields(List<ShopifyMetafield> shopifyMetafields);
	}

	public static interface ShippingLinesStep {
		DiscountCodesStep withShippingLines(List<ShopifyShippingLine> shippingLines);
	}

	public static interface DiscountCodesStep {
		TaxLinesStep withDiscountCodes(List<ShopifyDiscountCode> discountCodes);
	}

	public static interface TaxLinesStep {
		OptionalsStep withTaxLines(List<ShopifyTaxLine> taxLines);
	}

	public static interface OptionalsStep {
		OptionalsStep withNoteAttributes(final List<ShopifyAttribute> noteAttributes);

		OptionalsStep withNote(final String note);

		OptionalsStep withFinancialStatus(final String financialStatus);

		ShopifyOrderCreationRequest build();

		OptionalsStep withInventoryBehaviour(String decrement_obeying_policy);
	}

	public static ProcessedAtStep newBuilder() {
		return new Steps();
	}

	public ShopifyOrder getRequest() {
		return request;
	}

	private ShopifyOrderCreationRequest(final ShopifyOrder request) {
		this.request = request;
	}

	private static class Steps implements ProcessedAtStep, NameStep, CustomerStep, MetafieldsStep, LineItemsStep,
			                              ShippingAddressStep, BillingAddressStep, ShippingLinesStep, OptionalsStep,
		                                  CurrencyStep, EmailStep, DiscountCodesStep , PresentmentCurrencyStep, TaxLinesStep{

		private final ShopifyOrder request = new ShopifyOrder();

		@Override
		public ShopifyOrderCreationRequest build() {
			return new ShopifyOrderCreationRequest(request);
		}

		@Override
		public OptionalsStep withInventoryBehaviour(String inventoryBehaviour) {
			request.setInventoryBehaviour(inventoryBehaviour);
			return this;
		}

		@Override
		public ShippingAddressStep withLineItems(final List<ShopifyLineItem> lineItems) {
			request.setLineItems(lineItems);
			return this;
		}

		@Override
		public LineItemsStep withCustomer(final ShopifyCustomer customer) {
			request.setCustomer(customer);
			return this;
		}

		@Override
		public LineItemsStep noCustomer() {
			request.setCustomer(null);
			return this;
		}

		@Override
		public NameStep withProcessedAt(final LocalDateTime processedAt) {
			request.setProcessedAt(processedAt);
			return this;
		}

		@Override
		public MetafieldsStep withBillingAddress(final ShopifyAddress shippingAddress) {
			request.setBillingAddress(shippingAddress);
			return this;
		}

		@Override
		public BillingAddressStep withShippingAddress(final ShopifyAddress billingAddress) {
			request.setShippingAddress(billingAddress);
			return this;
		}

		@Override
		public ShippingLinesStep withMetafields(final List<ShopifyMetafield> shopifyMetafields) {
			request.setMetafields(shopifyMetafields);
			return this;
		}

		@Override
		public CurrencyStep withName(final String name) {
			request.setName(name);
			return this;
		}

		@Override
		public PresentmentCurrencyStep withCurrency(String currency) {
			request.setCurrency(currency);
			return this;
		}

		@Override
		public EmailStep withPresentmentCurrency(String currency) {
			request.setPresentmentCurrency(currency);
			return this;
		}

		@Override
		public CustomerStep withEmail(String email) {
			request.setEmail(email);
			return this;
		}

		@Override
		public DiscountCodesStep withShippingLines(final List<ShopifyShippingLine> shippingLines) {
			request.setShippingLines(shippingLines);
			return this;
		}

		@Override
		public OptionalsStep withNoteAttributes(final List<ShopifyAttribute> noteAttributes) {
			request.setNoteAttributes(noteAttributes);
			return this;
		}

		@Override
		public OptionalsStep withNote(final String note) {
			request.setNote(note);
			return this;
		}

		@Override
		public OptionalsStep withFinancialStatus(final String financialStatus) {
			request.setFinancialStatus(financialStatus);
			return this;
		}

		@Override
		public TaxLinesStep withDiscountCodes(List<ShopifyDiscountCode> discountCodes) {
			request.setDiscountCodes(discountCodes);
			return this;
		}

		@Override
		public OptionalsStep withTaxLines(List<ShopifyTaxLine> taxLines) {
			request.setTaxLines(taxLines);
			return this;
		}


//		@Override
//		public MetafieldsStep withBillingAddress(ShopifyAddress billingAddress) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public BillingAddressStep withShippingAddress(ShopifyAddress shippingAddress) {
//			// TODO Auto-generated method stub
//			return null;
//		}

	}

}
