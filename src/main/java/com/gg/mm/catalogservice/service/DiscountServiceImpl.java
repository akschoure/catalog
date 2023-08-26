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
public class DiscountServiceImpl implements DiscountService{

    private static final Logger log = LoggerFactory.getLogger(DiscountServiceImpl.class);


    @Autowired
    private DiscountMatrixClient discountMatrixClient;

    @Override
    public DiscountMatrixRootObject[] getSimoDiscountInfoFromM1() {
        return  discountMatrixClient.getDiscountMatrixResult();
    }

    @Override
    public PromotionalInfo createSimoDiscountInfo(DiscountMatrixRootObject[] discountMatrixRootObjects) throws JsonProcessingException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
       //All----------------------------------------------------------------------------------------------->

        ArrayList<PromotionalProductType> billPlanpromotionalProductTypeArrayList = new ArrayList<>();
        ArrayList<PromotionalProductType> vaspromotionalProductTypeArrayList = new ArrayList<>();
        ArrayList<PromotionalProductType> otherpromotionalProductTypeArrayList = new ArrayList<>();
        ArrayList<PromotionalProductType> allpromotionalProductTypeArrayList = new ArrayList<>();


        //promotionalCustomerTypeAll
        PromotionalCustomerType promotionalCustomerTypeAll = new PromotionalCustomerType(); //billplan vas other all
        promotionalCustomerTypeAll.setProductTypeBillPlan(billPlanpromotionalProductTypeArrayList); //billplan
        promotionalCustomerTypeAll.setProductTypeVas(vaspromotionalProductTypeArrayList);
        promotionalCustomerTypeAll.setProductTypeOthers(otherpromotionalProductTypeArrayList);
        promotionalCustomerTypeAll.setProductTypeAll(allpromotionalProductTypeArrayList);

        //promotionalCustomerTypeSilver
        PromotionalCustomerType promotionalCustomerTypeSilver = new PromotionalCustomerType(); //billplan vas other all
        promotionalCustomerTypeSilver.setProductTypeBillPlan(billPlanpromotionalProductTypeArrayList); //billplan
        promotionalCustomerTypeSilver.setProductTypeVas(vaspromotionalProductTypeArrayList);
        promotionalCustomerTypeSilver.setProductTypeOthers(otherpromotionalProductTypeArrayList);
        promotionalCustomerTypeSilver.setProductTypeAll(allpromotionalProductTypeArrayList);

        //promotionalCustomerTypeSafra
        PromotionalCustomerType promotionalCustomerTypeSafra = new PromotionalCustomerType(); //billplan vas other all
        promotionalCustomerTypeSafra.setProductTypeBillPlan(billPlanpromotionalProductTypeArrayList); //billplan
        promotionalCustomerTypeSafra.setProductTypeVas(vaspromotionalProductTypeArrayList);
        promotionalCustomerTypeSafra.setProductTypeOthers(otherpromotionalProductTypeArrayList);
        promotionalCustomerTypeSafra.setProductTypeAll(allpromotionalProductTypeArrayList);

        //promotionalCustomerTypeCori
        PromotionalCustomerType promotionalCustomerTypeCori = new PromotionalCustomerType(); //billplan vas other all
        promotionalCustomerTypeCori.setProductTypeBillPlan(billPlanpromotionalProductTypeArrayList); //billplan
        promotionalCustomerTypeCori.setProductTypeVas(vaspromotionalProductTypeArrayList);
        promotionalCustomerTypeCori.setProductTypeOthers(otherpromotionalProductTypeArrayList);
        promotionalCustomerTypeCori.setProductTypeAll(allpromotionalProductTypeArrayList);

        //New
        PromotionalOrderType promotionalOrderTypeNew = new PromotionalOrderType();

        //All
        promotionalOrderTypeNew.setCustomerTypeAll(promotionalCustomerTypeAll);

        //Silver
        promotionalOrderTypeNew.setCustomerTypeSilver(promotionalCustomerTypeSilver); //consumer

        //Safra
        promotionalOrderTypeNew.setCustomerTypeSafra(promotionalCustomerTypeSafra);

        //Cori
        promotionalOrderTypeNew.setCustomerTypeCori(promotionalCustomerTypeCori);



        //FOR PORT-IN----------------------------------------------------------------------------------------------->

        ArrayList<PromotionalProductType> portInbillPlanpromotionalProductTypeArrayList = new ArrayList<>();
        ArrayList<PromotionalProductType> portInvaspromotionalProductTypeArrayList = new ArrayList<>();
        ArrayList<PromotionalProductType> portInotherpromotionalProductTypeArrayList = new ArrayList<>();
        ArrayList<PromotionalProductType> portInallpromotionalProductTypeArrayList = new ArrayList<>();

        //promotionalCustomerTypeAll
        PromotionalCustomerType portInpromotionalCustomerTypeAll = new PromotionalCustomerType(); //billplan vas other all
        portInpromotionalCustomerTypeAll.setProductTypeBillPlan(portInbillPlanpromotionalProductTypeArrayList); //billplan
        portInpromotionalCustomerTypeAll.setProductTypeVas(portInvaspromotionalProductTypeArrayList);
        portInpromotionalCustomerTypeAll.setProductTypeOthers(portInotherpromotionalProductTypeArrayList);
        portInpromotionalCustomerTypeAll.setProductTypeAll(portInallpromotionalProductTypeArrayList);

        //promotionalCustomerTypeSilver
        PromotionalCustomerType portInpromotionalCustomerTypeSilver = new PromotionalCustomerType(); //billplan vas other all
        portInpromotionalCustomerTypeSilver.setProductTypeBillPlan(portInbillPlanpromotionalProductTypeArrayList); //billplan
        portInpromotionalCustomerTypeSilver.setProductTypeVas(portInvaspromotionalProductTypeArrayList);
        portInpromotionalCustomerTypeSilver.setProductTypeOthers(portInotherpromotionalProductTypeArrayList);
        portInpromotionalCustomerTypeSilver.setProductTypeAll(portInallpromotionalProductTypeArrayList);

        //promotionalCustomerTypeSafra
        PromotionalCustomerType portInpromotionalCustomerTypeSafra = new PromotionalCustomerType(); //billplan vas other all
        portInpromotionalCustomerTypeSafra.setProductTypeBillPlan(portInbillPlanpromotionalProductTypeArrayList); //billplan
        portInpromotionalCustomerTypeSafra.setProductTypeVas(portInvaspromotionalProductTypeArrayList);
        portInpromotionalCustomerTypeSafra.setProductTypeOthers(portInotherpromotionalProductTypeArrayList);
        portInpromotionalCustomerTypeSafra.setProductTypeAll(portInallpromotionalProductTypeArrayList);

        //promotionalCustomerTypeCori
        PromotionalCustomerType portInpromotionalCustomerTypeCori = new PromotionalCustomerType(); //billplan vas other all
        portInpromotionalCustomerTypeCori.setProductTypeBillPlan(portInbillPlanpromotionalProductTypeArrayList); //billplan
        portInpromotionalCustomerTypeCori.setProductTypeVas(portInvaspromotionalProductTypeArrayList);
        portInpromotionalCustomerTypeCori.setProductTypeOthers(portInotherpromotionalProductTypeArrayList);
        portInpromotionalCustomerTypeCori.setProductTypeAll(portInallpromotionalProductTypeArrayList);

        //Port In
        PromotionalOrderType promotionalOrderTypePortIn = new PromotionalOrderType();

        //All
        promotionalOrderTypePortIn.setCustomerTypeAll(portInpromotionalCustomerTypeAll);

        //Silver
        promotionalOrderTypePortIn.setCustomerTypeSilver(portInpromotionalCustomerTypeSilver); //consumer

        //Safra
        promotionalOrderTypePortIn.setCustomerTypeSafra(portInpromotionalCustomerTypeSafra);

        //Cori
        promotionalOrderTypePortIn.setCustomerTypeCori(portInpromotionalCustomerTypeCori);



        //FOR Re-Contract ----------------------------------------------------------------------------------------------->

        ArrayList<PromotionalProductType> reContractbillPlanpromotionalProductTypeArrayList = new ArrayList<>();
        ArrayList<PromotionalProductType> reContractvaspromotionalProductTypeArrayList = new ArrayList<>();
        ArrayList<PromotionalProductType> reContractotherpromotionalProductTypeArrayList = new ArrayList<>();
        ArrayList<PromotionalProductType> reContractallpromotionalProductTypeArrayList = new ArrayList<>();


        //promotionalCustomerTypeAll
        PromotionalCustomerType reContractpromotionalCustomerTypeAll = new PromotionalCustomerType(); //billplan vas other all
        reContractpromotionalCustomerTypeAll.setProductTypeBillPlan(reContractbillPlanpromotionalProductTypeArrayList); //billplan
        reContractpromotionalCustomerTypeAll.setProductTypeVas(reContractvaspromotionalProductTypeArrayList);
        reContractpromotionalCustomerTypeAll.setProductTypeOthers(reContractotherpromotionalProductTypeArrayList);
        reContractpromotionalCustomerTypeAll.setProductTypeAll(reContractallpromotionalProductTypeArrayList);

        //promotionalCustomerTypeSilver
        PromotionalCustomerType reContractpromotionalCustomerTypeSilver = new PromotionalCustomerType(); //billplan vas other all
        reContractpromotionalCustomerTypeSilver.setProductTypeBillPlan(reContractbillPlanpromotionalProductTypeArrayList); //billplan
        reContractpromotionalCustomerTypeSilver.setProductTypeVas(reContractvaspromotionalProductTypeArrayList);
        reContractpromotionalCustomerTypeSilver.setProductTypeOthers(reContractotherpromotionalProductTypeArrayList);
        reContractpromotionalCustomerTypeSilver.setProductTypeAll(reContractallpromotionalProductTypeArrayList);

        //promotionalCustomerTypeSafra
        PromotionalCustomerType reContractpromotionalCustomerTypeSafra = new PromotionalCustomerType(); //billplan vas other all
        reContractpromotionalCustomerTypeSafra.setProductTypeBillPlan(reContractbillPlanpromotionalProductTypeArrayList); //billplan
        reContractpromotionalCustomerTypeSafra.setProductTypeVas(reContractvaspromotionalProductTypeArrayList);
        reContractpromotionalCustomerTypeSafra.setProductTypeOthers(reContractotherpromotionalProductTypeArrayList);
        reContractpromotionalCustomerTypeSafra.setProductTypeAll(reContractallpromotionalProductTypeArrayList);

        //promotionalCustomerTypeCori
        PromotionalCustomerType reContractpromotionalCustomerTypeCori = new PromotionalCustomerType(); //billplan vas other all
        reContractpromotionalCustomerTypeCori.setProductTypeBillPlan(reContractbillPlanpromotionalProductTypeArrayList); //billplan
        reContractpromotionalCustomerTypeCori.setProductTypeVas(reContractvaspromotionalProductTypeArrayList);
        reContractpromotionalCustomerTypeCori.setProductTypeOthers(reContractotherpromotionalProductTypeArrayList);
        reContractpromotionalCustomerTypeCori.setProductTypeAll(reContractallpromotionalProductTypeArrayList);

        //New
        PromotionalOrderType promotionalOrderTypeReContract = new PromotionalOrderType();

        //All
        promotionalOrderTypeReContract.setCustomerTypeAll(reContractpromotionalCustomerTypeAll);

        //Silver
        promotionalOrderTypeReContract.setCustomerTypeSilver(reContractpromotionalCustomerTypeSilver); //consumer

        //Safra
        promotionalOrderTypeReContract.setCustomerTypeSafra(reContractpromotionalCustomerTypeSafra);

        //Cori
        promotionalOrderTypeReContract.setCustomerTypeCori(reContractpromotionalCustomerTypeCori);




        //All NewLine PortIn ReContract
        PromotionalInfo promotionalInfo = new PromotionalInfo();

        promotionalInfo.setOrderTypeNewLine(promotionalOrderTypeNew); // NewLine

        promotionalInfo.setOrderTypePortIn(promotionalOrderTypePortIn); //PortIn

        promotionalInfo.setOrderTypeReContract(promotionalOrderTypeReContract); //Re-contract


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
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(VAS)) {
                            vaspromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(OTHERS)) {
                            otherpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(ALL_PRODUCT)) {
                            allpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        }

                    }
                    else if (discountMatrixRootObject.getInputData().getCondition() != null &&
                            discountMatrixRootObject.getInputData().getCondition().equals(SILVER)) {
                        log.info(SILVER);
                        if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(BILL_PLAN)) {
                            billPlanpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(VAS)) {
                            vaspromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(OTHERS)) {
                            otherpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(ALL_PRODUCT)) {
                            allpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        }

                    }
                    else if (discountMatrixRootObject.getInputData().getCondition() != null &&
                            discountMatrixRootObject.getInputData().getCondition().equals(SAFRA)) {
                        log.info(SAFRA);
                        if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(BILL_PLAN)) {
                            billPlanpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));

                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(VAS)) {
                            vaspromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(OTHERS)) {
                            otherpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(ALL_PRODUCT)) {
                            allpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        }
                    }
                    else if (discountMatrixRootObject.getInputData().getCondition() != null && (discountMatrixRootObject.getInputData().getCondition().equals(CORI)||discountMatrixRootObject.getInputData().getCondition().equals(BUSINESS_SIM))) {
                        log.info(CORI,BUSINESS_SIM);
                        if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(BILL_PLAN)) {
                            billPlanpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(VAS)) {
                            vaspromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(OTHERS)) {
                            otherpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(ALL_PRODUCT)) {
                            allpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        }
                    }

                }
                if ((discountMatrixRootObject.getInputData().getOrderType().equals(ALL_ORDER_TYPE) || discountMatrixRootObject.getInputData().getOrderType().contains(PORT_IN))) {
                    log.info(PORT_IN);

                    if (discountMatrixRootObject.getInputData().getCondition() != null &&
                            discountMatrixRootObject.getInputData().getCondition().equals(ALL_CUSTOMER)) {
                        log.info("All Customer Type");

                        if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(BILL_PLAN)) {
                            portInbillPlanpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(VAS)) {
                            portInvaspromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(OTHERS)) {
                            portInotherpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(ALL_PRODUCT)) {
                            portInallpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        }

                    } else if (discountMatrixRootObject.getInputData().getCondition() != null &&
                            discountMatrixRootObject.getInputData().getCondition().equals(SILVER)) {

                        log.info("Silver");

                        if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(BILL_PLAN)) {
                            portInbillPlanpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(VAS)) {
                            portInvaspromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(OTHERS)) {
                            portInotherpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(ALL_PRODUCT)) {
                            portInallpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        }

                    } else if (discountMatrixRootObject.getInputData().getCondition() != null &&
                            discountMatrixRootObject.getInputData().getCondition().equals(SAFRA)) {

                        log.info("SAFRA");

                        if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(BILL_PLAN)) {
                            portInbillPlanpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));

                        }
                        else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(VAS)) {
                            portInvaspromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(OTHERS)) {
                            portInotherpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(ALL_PRODUCT)) {
                            portInallpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        }
                        }
                    else if (discountMatrixRootObject.getInputData().getCondition() != null && (discountMatrixRootObject.getInputData().getCondition().equals(CORI)||discountMatrixRootObject.getInputData().getCondition().equals(BUSINESS_SIM))) {

                        log.info("CORI");

                        if (discountMatrixRootObject.getInputData().getCondition() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(BILL_PLAN) ) {
                            portInbillPlanpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(VAS)) {
                            portInvaspromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(OTHERS)) {
                            portInotherpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(ALL_PRODUCT)) {
                            portInallpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        }
                    }
                }
                if ((discountMatrixRootObject.getInputData().getOrderType().equals(ALL_ORDER_TYPE) || discountMatrixRootObject.getInputData().getOrderType().contains(RE_CONTRACT))) {
                    log.info(RE_CONTRACT);

                    if (discountMatrixRootObject.getInputData().getCondition() != null &&
                            discountMatrixRootObject.getInputData().getCondition().equals(ALL_CUSTOMER)) {
                        log.info("All Type");

                        if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(BILL_PLAN)) {
                            reContractbillPlanpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(VAS)) {
                            reContractvaspromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(OTHERS)) {
                            reContractotherpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(ALL_PRODUCT)) {
                            reContractallpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        }

                    } else if (discountMatrixRootObject.getInputData().getCondition() != null &&
                            discountMatrixRootObject.getInputData().getCondition().equals(SILVER)) {

                        log.info("Silver");

                        if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(BILL_PLAN)) {
                            reContractbillPlanpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(VAS)) {
                            reContractvaspromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(OTHERS)) {
                            reContractotherpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(ALL_PRODUCT)) {
                            reContractallpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        }

                    } else if (discountMatrixRootObject.getInputData().getCondition() != null &&
                            discountMatrixRootObject.getInputData().getCondition().equals(SAFRA)) {

                        log.info("SAFRA");

                        if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(BILL_PLAN)) {
                            reContractbillPlanpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(VAS)) {
                            reContractvaspromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(OTHERS)) {
                            reContractotherpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(ALL_PRODUCT)) {
                            reContractallpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        }
                    } else if (discountMatrixRootObject.getInputData().getCondition() != null && (discountMatrixRootObject.getInputData().getCondition().equals(CORI)|| discountMatrixRootObject.getInputData().getCondition().equals(BUSINESS_SIM))) {

                        log.info("CORI");

                        if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(BILL_PLAN)) {
                            reContractbillPlanpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(VAS)) {
                            reContractvaspromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(OTHERS)) {
                            reContractotherpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        } else if (discountMatrixRootObject.getInputData().getProductType() != null
                                && discountMatrixRootObject.getInputData().getProductType().equalsIgnoreCase(ALL_PRODUCT)) {
                            reContractallpromotionalProductTypeArrayList.add(createPromotionalProductType(discountMatrixRootObject));
                        }
                    }

                }
            }
        }
        log.info(objectMapper.writeValueAsString(promotionalInfo));
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
