package com.gg.mm.catalogservice.models.promotion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PromotionalCustomerType implements Serializable {

    @JsonProperty("product_type_billplan")
    private ArrayList<PromotionalProductType> productTypeBillPlan;

    @JsonProperty("product_type_vas")
    private ArrayList<PromotionalProductType> productTypeVas;

    @JsonProperty("product_type_others")
    private ArrayList<PromotionalProductType> productTypeOthers;

    @JsonProperty("product_type_all")
    private ArrayList<PromotionalProductType> productTypeAll;

}
