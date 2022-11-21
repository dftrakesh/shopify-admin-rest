package com.dft.api.shopify.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class GiftCardAdjustmentsRoot {

    @XmlElement(name = "adjustments")
    private List<GiftCardAdjustment> adjustments;

    public List<GiftCardAdjustment> getGiftCardAdjustments() {
        return adjustments;
    }

    public void setGiftCardAdjustments(final List<GiftCardAdjustment> adjustments) {
        this.adjustments = adjustments;
    }
}
