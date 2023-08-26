package com.gg.mm.catalogservice.service;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
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
          // line no.216 condition returns true
              // line no.219 returns true
              // line no.219 returns false
                  // line no. 238 return true
                  // line no. 238 return false
          // line no.216 condition returns false
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



}