package com.dft.api.shopify.model;

import com.dft.api.shopify.model.adapters.DateTimeAdapter;
import lombok.Data;
import org.joda.time.DateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Data
@XmlRootElement(name = "adjustment")
@XmlAccessorType(XmlAccessType.FIELD)
public class GiftCardAdjustment {

    private String id;
    @XmlElement(name = "gift_card_id")
    private String giftCardId;
    @XmlElement(name = "api_client_id")
    private String apiClientId;
    @XmlElement(name = "user_id")
    private String userId;
    @XmlElement(name = "order_transaction_id")
    private String orderTransactionId;
    private Integer number;
    private Double amount;
    @XmlElement(name = "processed_at")
    @XmlJavaTypeAdapter(DateTimeAdapter.class)
    private DateTime processedAt;
    @XmlElement(name = "created_at")
    @XmlJavaTypeAdapter(DateTimeAdapter.class)
    private DateTime createdAt;
    @XmlElement(name = "updated_at")
    @XmlJavaTypeAdapter(DateTimeAdapter.class)
    private DateTime updatedAt;
    private String note;
    @XmlElement(name = "remote_transaction_ref")
    private String remoteTransactionRef;
    @XmlElement(name = "remote_transaction_url")
    private String remoteTransactionUrl;
}