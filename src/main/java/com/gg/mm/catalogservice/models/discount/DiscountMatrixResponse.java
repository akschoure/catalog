package com.gg.mm.catalogservice.models.discount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscountMatrixResponse implements Serializable {
   // private List<DiscountMatrixRootObject> discountMatrixRootObject;
   private DiscountMatrixRootObject discountMatrixRootObject;

}
