package com.clusus.warehouse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Set;

public class DealContentValidator {

    private static Logger log = LoggerFactory.getLogger(DealContentValidator.class);


    public static List<ValidatorResponseMessage> checkNullValue(int rowNumber,DealDto deal){
        Set<Currency> currencies = getCurrencies();
        List<ValidatorResponseMessage> validatorResponseMessageList = new ArrayList<>();
        try{
                if(deal.getDealId() == null || deal.getDealId().isEmpty()){
                    ValidatorResponseMessage validatorResponseMessage = new ValidatorResponseMessage(rowNumber,"DealId","Deal Id is not defined");
                    validatorResponseMessageList.add(validatorResponseMessage);
                }
                if(deal.getFromCurrencyCode() == null || deal.getFromCurrencyCode().isEmpty()
                ||!currencies.contains(deal.getFromCurrencyCode())){
                    ValidatorResponseMessage validatorResponseMessage = new ValidatorResponseMessage(rowNumber,"FromCurrencyCode","From Currency Code is not defined");
                    validatorResponseMessageList.add(validatorResponseMessage);
                }
                if(deal.getToCurrencyCode() == null || deal.getToCurrencyCode().isEmpty()
                        ||!currencies.contains(deal.getToCurrencyCode())){
                    ValidatorResponseMessage validatorResponseMessage = new ValidatorResponseMessage(rowNumber,"ToCurrencyCode","To Currency Code is not defined");
                    validatorResponseMessageList.add(validatorResponseMessage);
                }
                if(deal.getDealTime() == null){
                    ValidatorResponseMessage validatorResponseMessage = new ValidatorResponseMessage(rowNumber,"DealTime","Deal Time is not defined");
                    validatorResponseMessageList.add(validatorResponseMessage);
                }
                if(deal.getDealAmount() == null || deal.getDealAmount().toString().isEmpty()) {
                    ValidatorResponseMessage validatorResponseMessage = new ValidatorResponseMessage(rowNumber, "Amount", "Deal Amount is not defined");
                    validatorResponseMessageList.add(validatorResponseMessage);
                }
        } catch (Exception e){
            log.error("Failed to validate",e);
        }
        return validatorResponseMessageList;
    }

    private static Set<Currency> getCurrencies() {
        Set<Currency> availableCurrencies = Currency.getAvailableCurrencies();
        return availableCurrencies;
    }
}
