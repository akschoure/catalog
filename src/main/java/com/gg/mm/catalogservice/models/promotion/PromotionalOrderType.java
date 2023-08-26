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
public class PromotionalOrderType implements Serializable {

    @JsonProperty("customer_type_all")
    private PromotionalCustomerType customerTypeAll;

    @JsonProperty("customer_type_silver")
    private PromotionalCustomerType customerTypeSilver;

    @JsonProperty("customer_type_safra")
    private PromotionalCustomerType customerTypeSafra;

    @JsonProperty("customer_type_cori")
    private PromotionalCustomerType customerTypeCori;
}
