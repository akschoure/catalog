package com.gg.mm.catalogservice.models.discount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

/**
 * {@link DiscountMatrixRootObject} //TODO description
 * @version 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscountMatrixRootObject implements Serializable {
    @JsonProperty("InputData")
    private DiscountMatrixInputData inputData;

    @JsonProperty("OutputData")
    private DiscountMatrixOutputData outputData;
}