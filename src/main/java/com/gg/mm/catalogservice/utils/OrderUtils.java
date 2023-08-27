package com.gg.mm.catalogservice.utils;

import static com.gg.mm.catalogservice.constant.CatalogConstant.ALL_ORDER_TYPE;
import static com.gg.mm.catalogservice.constant.CatalogConstant.NEW_LINE;

import com.gg.mm.catalogservice.models.discount.DiscountMatrixRootObject;

public class OrderUtils {

  public static boolean isCorrectOrderType(DiscountMatrixRootObject discountMatrixRootObject) {
    return discountMatrixRootObject.getInputData()
        .getOrderType()
        .equals(ALL_ORDER_TYPE) || discountMatrixRootObject.getInputData()
        .getOrderType()
        .contains(NEW_LINE);
  }

}
