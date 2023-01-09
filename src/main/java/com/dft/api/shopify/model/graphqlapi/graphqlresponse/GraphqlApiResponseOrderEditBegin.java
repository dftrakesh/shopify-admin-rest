
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
public class GraphqlApiResponseOrderEditBegin {

    @SerializedName("data")
    @XmlElement(name = "data")
    @JsonProperty("data")
    @Expose
    private DataOrderEditBegin data;

    @SerializedName("extensions")
    @XmlElement(name = "extensions")
    @JsonProperty("extensions")
    @Expose
    private Extensions extensions;

}
