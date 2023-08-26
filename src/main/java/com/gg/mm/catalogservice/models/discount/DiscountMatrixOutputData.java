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
public class DiscountMatrixOutputData implements Serializable {

    @JsonProperty("VasTile")
    private String vasTitle;

    @JsonProperty("VasRibbon")
    private String vasRibbon;

    @JsonProperty("Promotion Name")
    private String promotionName;

    @JsonProperty("Promotion Code")
    private String promotionCode;

    @JsonProperty("Promo Start Date")
    private String promotionStartDate;

    @JsonProperty("Promo End Date")
    private String promotionEndDate;

    @JsonProperty("Priority Score")
    private String priorityScore;

    @JsonProperty("Price Type")
    private String priceType;

    @JsonProperty("PlanPillar")
    private String planPillar;

    @JsonProperty("Family Plan Eligible")
    private String familyPlanEligible;

    @JsonProperty("ExtraData")
    private String extraData;

    @JsonProperty("Exclude Condition")
    private String excludeCondition;

    @JsonProperty("Display Text")
    private String displayText;

    @JsonProperty("Display Section")
    private String displaySection;

    @JsonProperty("Discount Duration")
    private String discountDuration;

    @JsonProperty("Change Type")
    private String changeType;

    @JsonProperty("CIS Display")
    private String cisDisplay;

    @JsonProperty("Business Plan Eligible")
    private String businessPlanEligible;

    @JsonProperty("Applies To")
    private String appliesTo;

    @JsonProperty("Adjustment Value")
    private String adjustmentValue;

    @JsonProperty("Adjustment Type")
    private String adjustmentType;

    @JsonProperty("Additional Information")
    private String additionalInformation;


    @Override
    public String toString() {
        return "DiscountMatrixOutputData{" +
                "vasTitle='" + vasTitle + '\'' +
                ", vasRibbon='" + vasRibbon + '\'' +
                ", promotionName='" + promotionName + '\'' +
                ", promotionCode='" + promotionCode + '\'' +
                ", promotionStartDate='" + promotionStartDate + '\'' +
                ", promotionEndDate='" + promotionEndDate + '\'' +
                ", priorityScore='" + priorityScore + '\'' +
                ", priceType='" + priceType + '\'' +
                ", planPillar='" + planPillar + '\'' +
                ", familyPlanEligible='" + familyPlanEligible + '\'' +
                ", extraData='" + extraData + '\'' +
                ", excludeCondition='" + excludeCondition + '\'' +
                ", displayText='" + displayText + '\'' +
                ", displaySection='" + displaySection + '\'' +
                ", discountDuration='" + discountDuration + '\'' +
                ", changeType='" + changeType + '\'' +
                ", cisDisplay='" + cisDisplay + '\'' +
                ", businessPlanEligible='" + businessPlanEligible + '\'' +
                ", appliesTo='" + appliesTo + '\'' +
                ", adjustmentValue='" + adjustmentValue + '\'' +
                ", adjustmentType='" + adjustmentType + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}
