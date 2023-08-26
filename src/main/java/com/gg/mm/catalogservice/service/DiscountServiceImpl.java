package com.gg.mm.catalogservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gg.mm.catalogservice.models.discount.DiscountMatrixRootObject;
import com.gg.mm.catalogservice.models.promotion.PromotionalCustomerType;
import com.gg.mm.catalogservice.models.promotion.PromotionalInfo;
import com.gg.mm.catalogservice.models.promotion.PromotionalOrderType;
import com.gg.mm.catalogservice.models.promotion.PromotionalProductType;
import com.gg.mm.catalogservice.systeminterface.DiscountMatrixClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.gg.mm.catalogservice.constant.CatalogConstant.*;


@Service
@Transactional
public class DiscountServiceImpl implements DiscountService {

    private static final Logger log = LoggerFactory.getLogger(DiscountServiceImpl.class);


    @Autowired
    private DiscountMatrixClient discountMatrixClient;

    @Override
    public DiscountMatrixRootObject[] getSimoDiscountInfoFromM1() {
        return  discountMatrixClient.getDiscountMatrixResult();
    }

    @Override
    public PromotionalInfo createSimoDiscountInfo(DiscountMatrixRootObject[] discountMatrixRootObjects) throws JsonProcessingException, ParseException {
        ArrayList<PromotionalProductType> billPlanpromotionalProductTypeArrayList = new ArrayList<>();
        PromotionalCustomerType promotionalCustomerTypeAll = new PromotionalCustomerType();
        promotionalCustomerTypeAll.setProductTypeBillPlan(billPlanpromotionalProductTypeArrayList);
        PromotionalOrderType promotionalOrderTypeNew = new PromotionalOrderType();
        promotionalOrderTypeNew.setCustomerTypeAll(promotionalCustomerTypeAll);
        PromotionalInfo promotionalInfo = new PromotionalInfo();
        promotionalInfo.setOrderTypeNewLine(promotionalOrderTypeNew);

        for(DiscountMatrixRootObject discountMatrixRootObject : discountMatrixRootObjects ){

            if (isCommonConditionValid(discountMatrixRootObject)) {

                if ((discountMatrixRootObject.getInputData().getOrderType().equals( ALL_ORDER_TYPE) || discountMatrixRootObject.getInputData().getOrderType().contains(NEW_LINE))) {
                    log.info(NEW_LINE);

                    if (discountMatrixRootObject.getInputData().getCondition() != null &&
                            discountMatrixRootObject.getInputData().getCondition().equals(ALL_CUSTOMER)) {
                        log.info("All Customer Type");

                        if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(BILL_PLAN)) {
                            billPlanpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        }

                    }
                    else if (discountMatrixRootObject.getInputData().getCondition() != null &&
                            discountMatrixRootObject.getInputData().getCondition().equals(SILVER)) {
                        log.info(SILVER);
                        if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(BILL_PLAN)) {
                            billPlanpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        }

                    }
                }
            }
        }

        return promotionalInfo;
    }


    private PromotionalProductType createPromotionalProductType(DiscountMatrixRootObject discountMatrixRootObject){
       var inputData =  discountMatrixRootObject.getInputData();
       var outputData = discountMatrixRootObject.getOutputData();
       return new PromotionalProductType(inputData.getPropertyName(),inputData.getPropertyValue(),inputData.getProductCode(),
               outputData.getPromotionName(), outputData.getPromotionCode(),outputData.getDisplayText(),outputData.getAdjustmentValue(),
               outputData.getAdjustmentType(),outputData.getPriceType(), outputData.getDiscountDuration(),outputData.getAppliesTo(),
               outputData.getExtraData(),outputData.getExcludeCondition(),outputData.getAdditionalInformation(),outputData.getCisDisplay());
    }


    private boolean isCommonConditionValid(DiscountMatrixRootObject discountMatrixRootObject) throws ParseException {

        return
                isDateConditionValid(discountMatrixRootObject)&& discountMatrixRootObject.getInputData().getOrderType() != null

                && discountMatrixRootObject.getInputData().getChannel() != null
                && (discountMatrixRootObject.getInputData().getChannel().contains("iBuy")
               || discountMatrixRootObject.getInputData().getChannel().contains("-"));

    }

    private boolean isDateConditionValid(DiscountMatrixRootObject discountMatrixRootObject) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Date currentDate  = new Date();
        if(discountMatrixRootObject.getOutputData()!=null){
            String promotionStartDateString = discountMatrixRootObject.getOutputData().getPromotionStartDate();
            String promotionEndDateString = discountMatrixRootObject.getOutputData().getPromotionEndDate();
            Date promotionStartDate = simpleDateFormat.parse(promotionStartDateString);
            Date promotionEndDate = simpleDateFormat.parse(promotionEndDateString);
            if(promotionEndDate != null && promotionStartDate != null && (currentDate.compareTo(promotionStartDate))>= 0 && (currentDate.compareTo(promotionEndDate)) <= 0){
                return true;
            }
        }
         return false;
    }


}
