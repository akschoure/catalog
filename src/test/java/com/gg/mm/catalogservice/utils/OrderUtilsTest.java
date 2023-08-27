package com.gg.mm.catalogservice.utils;

import static com.gg.mm.catalogservice.constant.CatalogConstant.ALL_CUSTOMER;
import static com.gg.mm.catalogservice.constant.CatalogConstant.ALL_ORDER_TYPE;
import static com.gg.mm.catalogservice.constant.CatalogConstant.NEW_LINE;
import static com.gg.mm.catalogservice.utils.OrderUtils.isCorrectOrderType;
import static org.junit.jupiter.api.Assertions.*;

import com.gg.mm.catalogservice.models.discount.DiscountMatrixInputData;
import com.gg.mm.catalogservice.models.discount.DiscountMatrixRootObject;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderUtilsTest {

/*  @Test
  void testIsCorrectOrderType_AllOrderType() {
    DiscountMatrixRootObject discountMatrixRootObject = new DiscountMatrixRootObject();
    var discountMatrixInputData = new DiscountMatrixInputData();
    discountMatrixInputData.setOrderType(ALL_ORDER_TYPE);
    discountMatrixRootObject.setInputData(discountMatrixInputData);

    assertTrue(isCorrectOrderType(discountMatrixRootObject));
  }

  @Test
  void testIsCorrectOrderType_NewLine() {
    DiscountMatrixRootObject discountMatrixRootObject = new DiscountMatrixRootObject();
    var discountMatrixInputData = new DiscountMatrixInputData();
    discountMatrixInputData.setOrderType(NEW_LINE);
    discountMatrixRootObject.setInputData(discountMatrixInputData);

    assertTrue(isCorrectOrderType(discountMatrixRootObject));
  }*/

  @ParameterizedTest
  @ValueSource(strings = { ALL_ORDER_TYPE, NEW_LINE})
  void testIsCorrectOrderType(String orderType) {
    DiscountMatrixRootObject discountMatrixRootObject = new DiscountMatrixRootObject();
    var discountMatrixInputData = new DiscountMatrixInputData();
    discountMatrixInputData.setOrderType(orderType);
    discountMatrixRootObject.setInputData(discountMatrixInputData);

    assertTrue(isCorrectOrderType(discountMatrixRootObject));
  }



  }