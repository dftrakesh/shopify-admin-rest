
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
public class ThrottleStatus {

    @SerializedName("maximumAvailable")
    @XmlElement(name = "maximumAvailable")
    @JsonProperty("maximumAvailable")
    @Expose
    private Integer maximumAvailable;

    @SerializedName("currentlyAvailable")
    @XmlElement(name = "currentlyAvailable")
    @JsonProperty("currentlyAvailable")
    @Expose
    private Integer currentlyAvailable;

    @SerializedName("restoreRate")
    @XmlElement(name = "restoreRate")
    @JsonProperty("restoreRate")
    @Expose
    private Integer restoreRate;

}
