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
public class PromotionalInfo implements Serializable {

    /*@JsonProperty("order_type_all")
    private PromotionalOrderType orderTypeAll;*/

    @JsonProperty("order_type_newline")
    private PromotionalOrderType orderTypeNewLine;

    @JsonProperty("order_type_port_in")
    private PromotionalOrderType orderTypePortIn;


    @JsonProperty("order_type_recontract")
    private PromotionalOrderType orderTypeReContract;


}
