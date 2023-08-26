package com.gg.mm.catalogservice.service;

import static com.gg.mm.catalogservice.constant.CatalogConstant.ALL_ORDER_TYPE;
import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gg.mm.catalogservice.models.discount.DiscountMatrixInputData;
import com.gg.mm.catalogservice.models.discount.DiscountMatrixRootObject;
import com.gg.mm.catalogservice.models.promotion.PromotionalCustomerType;
import com.gg.mm.catalogservice.models.promotion.PromotionalInfo;
import com.gg.mm.catalogservice.models.promotion.PromotionalOrderType;
import com.gg.mm.catalogservice.models.promotion.PromotionalProductType;
import java.text.ParseException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class DiscountServiceImplTest {

  @Test
  void createSimoDiscountInfo() {

    // empty array - done

    // non-empty array
       // isCommonConditionValid - true
          // line no.54 condition returns true
            // line no. 57 condition returns true
            // line no. 57 condition returns false
               // line no. 62 condition returns true
              // line no. 62 condition returns false
          // line no.54 condition returns false
       // isCommonConditionValid - false
  }

  @Test
  void createSimoDiscountInfo_EmptyArray() throws ParseException, JsonProcessingException {
    // Step 1 :
    // setup
       // creating object of class for which we are writting unit test
    var discountService = new DiscountServiceImpl();
      // creating data
    var data = new DiscountMatrixRootObject[] {};


    // Step 2:
    // execute method which you want to tes
    var result = discountService.createSimoDiscountInfo(data);

    // Step 3:
    // assert way 1
    assertNotNull(result);
    assertNotNull(result.getOrderTypeNewLine());
    assertNotNull(result.getOrderTypeNewLine().getCustomerTypeAll());
    assertNotNull(result.getOrderTypeNewLine().getCustomerTypeAll().getProductTypeBillPlan());
    assertEquals(new ArrayList<>(), result.getOrderTypeNewLine().getCustomerTypeAll().getProductTypeBillPlan());

    // assert way 2
    ArrayList<PromotionalProductType> billPlanpromotionalProductTypeArrayList = new ArrayList<>();
    PromotionalCustomerType promotionalCustomerTypeAll = new PromotionalCustomerType();
    promotionalCustomerTypeAll.setProductTypeBillPlan(billPlanpromotionalProductTypeArrayList);
    PromotionalOrderType promotionalOrderTypeNew = new PromotionalOrderType();
    promotionalOrderTypeNew.setCustomerTypeAll(promotionalCustomerTypeAll);
    PromotionalInfo promotionalInfo = new PromotionalInfo();
    promotionalInfo.setOrderTypeNewLine(promotionalOrderTypeNew);
    assertEquals(promotionalInfo, result);
  }

  @Test
  void createSimoDiscountInfo_NonEmptyArray_isCommonConditionValid_ReturnsFalse() throws ParseException, JsonProcessingException {
    // Step 1 :
    // setup
    // creating object of class for which we are writting unit test
    var discountService = new DiscountServiceImpl();
    // creating data
    var data = new DiscountMatrixRootObject[1];
    var object = new DiscountMatrixRootObject();
    var discountMatrixInputData = new DiscountMatrixInputData();
    discountMatrixInputData.setOrderType(null);
    object.setInputData(discountMatrixInputData);

    // Step 2:
    // execute method which you want to test
    var result = discountService.createSimoDiscountInfo(data);

    // assert way 2
    ArrayList<PromotionalProductType> billPlanpromotionalProductTypeArrayList = new ArrayList<>();
    PromotionalCustomerType promotionalCustomerTypeAll = new PromotionalCustomerType();
    promotionalCustomerTypeAll.setProductTypeBillPlan(billPlanpromotionalProductTypeArrayList);
    PromotionalOrderType promotionalOrderTypeNew = new PromotionalOrderType();
    promotionalOrderTypeNew.setCustomerTypeAll(promotionalCustomerTypeAll);
    PromotionalInfo promotionalInfo = new PromotionalInfo();
    promotionalInfo.setOrderTypeNewLine(promotionalOrderTypeNew);
    assertEquals(promotionalInfo, result);
  }

  @Test
  void createSimoDiscountInfo_NonEmptyArray_isCommonConditionValid_ReturnsTrue_54_Returns_False() throws ParseException, JsonProcessingException {
    // Step 1 :
    // setup
    // creating object of class for which we are writting unit test
    var discountService = new DiscountServiceImpl();
    // creating data
    var data = new DiscountMatrixRootObject[1];
    var object = new DiscountMatrixRootObject();
    var discountMatrixInputData = new DiscountMatrixInputData();
    discountMatrixInputData.setOrderType("OT");
    object.setInputData(discountMatrixInputData);

    // Step 2:
    // execute method which you want to test
    var result = discountService.createSimoDiscountInfo(data);

    // assert way 2
    ArrayList<PromotionalProductType> billPlanpromotionalProductTypeArrayList = new ArrayList<>();
    PromotionalCustomerType promotionalCustomerTypeAll = new PromotionalCustomerType();
    promotionalCustomerTypeAll.setProductTypeBillPlan(billPlanpromotionalProductTypeArrayList);
    PromotionalOrderType promotionalOrderTypeNew = new PromotionalOrderType();
    promotionalOrderTypeNew.setCustomerTypeAll(promotionalCustomerTypeAll);
    PromotionalInfo promotionalInfo = new PromotionalInfo();
    promotionalInfo.setOrderTypeNewLine(promotionalOrderTypeNew);
    assertEquals(promotionalInfo, result);
  }




}