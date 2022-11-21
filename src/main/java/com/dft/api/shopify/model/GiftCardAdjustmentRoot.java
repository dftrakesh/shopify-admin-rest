package com.dft.api.shopify.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GiftCardAdjustmentRoot {

    @XmlElement(name = "adjustment")
    private GiftCardAdjustment adjustment;

    public GiftCardAdjustment getGiftCardAdjustment() {
        return adjustment;
    }

    public void setGiftCardAdjustment(final GiftCardAdjustment adjustment) {
        this.adjustment = adjustment;
    }
}
