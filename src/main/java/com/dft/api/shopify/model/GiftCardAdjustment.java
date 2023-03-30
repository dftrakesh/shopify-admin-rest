package com.dft.api.shopify.model;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

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
    @JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime  processedAt;

    @XmlElement(name = "created_at")
    @JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime  createdAt;

    @XmlElement(name = "updated_at")
    @JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime updatedAt;

    private String note;

    @XmlElement(name = "remote_transaction_ref")
    private String remoteTransactionRef;

    @XmlElement(name = "remote_transaction_url")
    private String remoteTransactionUrl;
}