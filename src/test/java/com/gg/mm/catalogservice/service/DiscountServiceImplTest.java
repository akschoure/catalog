package com.gg.mm.catalogservice.service;

import static com.gg.mm.catalogservice.constant.CatalogConstant.ALL_CUSTOMER;
import static com.gg.mm.catalogservice.constant.CatalogConstant.ALL_ORDER_TYPE;
import static com.gg.mm.catalogservice.constant.CatalogConstant.SILVER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gg.mm.catalogservice.constant.CatalogConstant;
import com.gg.mm.catalogservice.models.discount.DiscountMatrixInputData;
import com.gg.mm.catalogservice.models.discount.DiscountMatrixOutputData;
import com.gg.mm.catalogservice.models.discount.DiscountMatrixRootObject;
import com.gg.mm.catalogservice.models.promotion.PromotionalCustomerType;
import com.gg.mm.catalogservice.models.promotion.PromotionalInfo;
import com.gg.mm.catalogservice.models.promotion.PromotionalOrderType;
import com.gg.mm.catalogservice.models.promotion.PromotionalProductType;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiscountServiceImplTest {

  DiscountServiceImpl discountService;

  @BeforeEach
  void setUp() {
    discountService = new DiscountServiceImpl();
  }

  @Test
  void createSimoDiscountInfo_EmptyArray() throws ParseException, JsonProcessingException {
      // creating data
    var data = new DiscountMatrixRootObject[] {};
    // Step 2:
    // execute method which you want to tes
    var result = discountService.createSimoDiscountInfo(data);

    // Step 3:
    ArrayList<PromotionalProductType> billPlanpromotionalProductTypeArrayList = new ArrayList<>();
    PromotionalInfo promotionalInfo = getPromotionalInfo(billPlanpromotionalProductTypeArrayList);
    assertEquals(promotionalInfo, result);
  }

  @Test
  void createSimoDiscountInfo_NonEmptyArray_isCommonConditionValid_ReturnsTrue_54_Returns_True_57_false_62_true()
      throws ParseException, JsonProcessingException {
    // creating data
    var data = new DiscountMatrixRootObject[1];
    var object = new DiscountMatrixRootObject();
    var discountMatrixInputData = new DiscountMatrixInputData();
    discountMatrixInputData.setOrderType(ALL_ORDER_TYPE);
    discountMatrixInputData.setCondition(ALL_CUSTOMER);
    object.setInputData(discountMatrixInputData);
    object.setOutputData(new DiscountMatrixOutputData());
    data[0]=object;
    // Step 2:
    // execute method which you want to test
    var result = discountService.createSimoDiscountInfo(data);

    PromotionalProductType productType = getProductType(object);

    // assert way 2
    ArrayList<PromotionalProductType> billPlanpromotionalProductTypeArrayList = new ArrayList<>();
    billPlanpromotionalProductTypeArrayList.add(productType);
    PromotionalInfo promotionalInfo = getPromotionalInfo(billPlanpromotionalProductTypeArrayList);

    assertEquals(promotionalInfo, result);
  }

  @Test
  void createSimoDiscountInfo_NonEmptyArray_isCommonConditionValid_ReturnsTrue_54_Returns_True_57_true()
      throws ParseException, JsonProcessingException {
    // creating data
    var data = new DiscountMatrixRootObject[1];
    var object = new DiscountMatrixRootObject();
    var discountMatrixInputData = new DiscountMatrixInputData();
    discountMatrixInputData.setOrderType(ALL_ORDER_TYPE);
    discountMatrixInputData.setCondition(SILVER);
    object.setInputData(discountMatrixInputData);
    object.setOutputData(new DiscountMatrixOutputData());

    data[0]=object;
    // Step 2:
    // execute method which you want to test
    var result = discountService.createSimoDiscountInfo(data);

    PromotionalProductType productType = getProductType(object);
    // assert way 2
    ArrayList<PromotionalProductType> billPlanpromotionalProductTypeArrayList = new ArrayList<>();
    billPlanpromotionalProductTypeArrayList.add(productType);

    PromotionalInfo promotionalInfo = getPromotionalInfo(billPlanpromotionalProductTypeArrayList);
    assertEquals(promotionalInfo, result);
  }

  private static PromotionalProductType getProductType(DiscountMatrixRootObject object) {
    var inputData =  object.getInputData();
    var outputData = object.getOutputData();
    var productType = new PromotionalProductType(inputData.getPropertyName(),inputData.getPropertyValue(),inputData.getProductCode(),
        outputData.getPromotionName(), outputData.getPromotionCode(),outputData.getDisplayText(),outputData.getAdjustmentValue(),
        outputData.getAdjustmentType(),outputData.getPriceType(), outputData.getDiscountDuration(),outputData.getAppliesTo(),
        outputData.getExtraData(),outputData.getExcludeCondition(),outputData.getAdditionalInformation(),outputData.getCisDisplay());
    return productType;
  }

  private static PromotionalInfo getPromotionalInfo(ArrayList<PromotionalProductType> billPlanpromotionalProductTypeArrayList) {
    PromotionalCustomerType promotionalCustomerTypeAll = new PromotionalCustomerType();
    promotionalCustomerTypeAll.setProductTypeBillPlan(billPlanpromotionalProductTypeArrayList);
    PromotionalOrderType promotionalOrderTypeNew = new PromotionalOrderType();
    promotionalOrderTypeNew.setCustomerTypeAll(promotionalCustomerTypeAll);
    PromotionalInfo promotionalInfo = new PromotionalInfo();
    promotionalInfo.setOrderTypeNewLine(promotionalOrderTypeNew);
    return promotionalInfo;
  }



}