package com.gg.mm.catalogservice.models.discount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

/**
 * //TODO Description
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscountMatrixInputData implements Serializable {

   /* public String name;

    public Object listValues;

    public String lineItemId;

    public Object label;

    public String headerType;

    public int displayOrder;

    public String dataType;

    public String columnKey;*/

    @JsonProperty("VASAction")
    private String vasAction;

    @JsonProperty("Shop Location")
    private String shopLocation;

    @JsonProperty("Property Value")
    private String propertyValue;

    @JsonProperty("Property Name")
    private String propertyName;

    @JsonProperty("Product Type")
    private String productType;

    @JsonProperty("Product Code")
    private String productCode;

    @JsonProperty("Order Type")
    private String orderType;

    @JsonProperty("Condition")
    private String condition;

    @JsonProperty("Channel")
    private String channel;

    @JsonProperty("Category Code")
    private String categoryCode;

    @JsonProperty("Category")
    private String category;

    @Override
    public String toString() {
        return "DiscountMatrixInputData{" +
                "vasAction='" + vasAction + '\'' +
                ", shopLocation='" + shopLocation + '\'' +
                ", propertyValue='" + propertyValue + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", productType='" + productType + '\'' +
                ", productCode='" + productCode + '\'' +
                ", orderType='" + orderType + '\'' +
                ", condition='" + condition + '\'' +
                ", channel='" + channel + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
