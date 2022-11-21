package com.dft.api.shopify.model;

public class GiftCardAdjustmentRequest {

    private static GiftCardAdjustment request;

    public static interface AmountStep {
        RemoteTransactionRefStep withAmountStep(final Double amount);
    }

    public static interface RemoteTransactionRefStep {
        RemoteTransactionUrlStep withRemoteTransactionRefStep(final String remoteTransactionRef);
    }

    public static interface RemoteTransactionUrlStep {
        NoteStep withRemoteTransactionUrlStep(final String remoteTransactionUrl);
    }

    public static interface NoteStep {
        BuildStep withNoteStep(final String note);
    }

    public static interface BuildStep {
        GiftCardAdjustmentRequest build();
    }

    public static AmountStep newBuilder() {
        return new Steps();
    }

    public static GiftCardAdjustment getRequest() {
        return request;
    }

    private GiftCardAdjustmentRequest(final GiftCardAdjustment request) {
        this.request = request;
    }

    private static class Steps implements AmountStep, RemoteTransactionRefStep, RemoteTransactionUrlStep, NoteStep, BuildStep {

        private final GiftCardAdjustment request = new GiftCardAdjustment();

        @Override
        public GiftCardAdjustmentRequest build() {
            return new GiftCardAdjustmentRequest(request);
        }

        @Override
        public RemoteTransactionRefStep withAmountStep(final Double amount) {
            this.request.setAmount(amount);
            return this;
        }

        @Override
        public RemoteTransactionUrlStep withRemoteTransactionRefStep(final String remoteTransactionRef) {
            this.request.setRemoteTransactionRef(remoteTransactionRef);
            return this;
        }

        @Override
        public NoteStep withRemoteTransactionUrlStep(final String remoteTransactionUrl) {
            this.request.setRemoteTransactionUrl(remoteTransactionUrl);
            return this;
        }

        @Override
        public BuildStep withNoteStep(final String note) {
            this.request.setNote(note);
            return this;
        }
    }
}
