package com.gg.mm.catalogservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gg.mm.catalogservice.models.discount.DiscountMatrixRootObject;
import com.gg.mm.catalogservice.service.DiscountService;
import com.gg.mm.catalogservice.service.DiscountServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@Validated
@RequestMapping("/v1/catalog")
public class CatalogController extends AbstractController {
    private static final Logger log = LoggerFactory.getLogger(CatalogController.class);



    private DiscountService discountService;


    @Autowired
    public void setDiscountService(DiscountServiceImpl discountService) {
        this.discountService = discountService;
    }


    @GetMapping("/invokeDiscount")
    public ResponseEntity<?> invokeDiscountMatrix() throws JsonProcessingException, ParseException {
        DiscountMatrixRootObject[] objects = discountService.getSimoDiscountInfoFromM1();
        discountService.createSimoDiscountInfo(objects);
        return new ResponseEntity<>("Import is started", HttpStatus.OK);
    }

}
