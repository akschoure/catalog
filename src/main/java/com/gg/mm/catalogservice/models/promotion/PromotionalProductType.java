package com.gg.mm.catalogservice.models.promotion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
public class PromotionalProductType implements Serializable {

    @JsonProperty("PropertyName")
    private String propertyName;

    @JsonProperty("PropertyValue")
    private String propertyValue;

    @JsonProperty("ProductCode")
    private String productCode;

    @JsonProperty("PromotionName")
    private String promotionName;

    @JsonProperty("PromotionCode")
    private String promotionCode;

    @JsonProperty("DisplayText")
    private String displayText;

    @JsonProperty("AdjustmentValue")
    private String adjustmentValue;

    @JsonProperty("AdjustmentType")
    private String adjustmentType;

    @JsonProperty("PriceType")
    private String priceType;

    @JsonProperty("DiscountDuration")
    private String discountDuration;

    @JsonProperty("AppliesTo")
    private String appliesTo;

    @JsonProperty("ExtraData")
    private String extraData;

    @JsonProperty("ExcludeCondition")
    private String excludeCondition;

    @JsonProperty("AdditionalInformation")
    private String additionalInformation;

    @JsonProperty("CISDisplay")
    private String cisDisplay;

}
