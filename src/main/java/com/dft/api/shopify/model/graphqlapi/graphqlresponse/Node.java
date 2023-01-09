
package com.dft.api.shopify.model.graphqlapi.graphqlresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Node {

    @SerializedName("id")
    @XmlElement(name = "id")
    @JsonProperty("id")
    @Expose
    private String id;

    @SerializedName("title")
    @XmlElement(name = "title")
    @JsonProperty("title")
    @Expose
    private String title;

    @SerializedName("sku")
    @XmlElement(name = "sku")
    @JsonProperty("sku")
    @Expose
    private Object sku;

    @SerializedName("variantTitle")
    @XmlElement(name = "variantTitle")
    @JsonProperty("variantTitle")
    @Expose
    private String variantTitle;

    @SerializedName("variant")
    @XmlElement(name = "variant")
    @JsonProperty("variant")
    @Expose
    private Variant variant;

}
