
package com.dft.api.shopify.model.graphqlapi.graphqlresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderEditAddLineItemDiscount {

    @SerializedName("userErrors")
    @Expose
    private List<UserError> userErrors = null;

    @SerializedName("calculatedOrder")
    @Expose
    private CalculatedOrder calculatedOrder;

}
