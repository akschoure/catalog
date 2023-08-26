package com.gg.mm.catalogservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gg.mm.catalogservice.models.discount.DiscountMatrixRootObject;
import com.gg.mm.catalogservice.models.promotion.PromotionalInfo;

import java.text.ParseException;

public interface DiscountService {

    public  DiscountMatrixRootObject[] getSimoDiscountInfoFromM1();
    public PromotionalInfo createSimoDiscountInfo(DiscountMatrixRootObject[] discountMatrixRootObjects) throws JsonProcessingException, ParseException;


}
