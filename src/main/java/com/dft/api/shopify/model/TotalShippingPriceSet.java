package com.dft.api.shopify.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TotalShippingPriceSet {

    @XmlElement(name = "shop_money")
    private ShopMoney shopMoney;

    @XmlElement(name = "presentment_money")
    private PresentmentMoney presentmentMoney;

    public ShopMoney getShopMoney() {
        return shopMoney;
    }

    public void setShopMoney(ShopMoney shopMoney) {
        this.shopMoney = shopMoney;
    }

    public PresentmentMoney getPresentmentMoney() {
        return presentmentMoney;
    }

    public void setPresentmentMoney(PresentmentMoney presentmentMoney) {
        this.presentmentMoney = presentmentMoney;
    }
}
