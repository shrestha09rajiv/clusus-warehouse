package com.clusus.warehouse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class DealService {

    @Autowired
    DealRepository dealRepository;

    private Logger log = LoggerFactory.getLogger(DealService.class);

    public List<ValidatorResponseMessage> saveDealRecord(MultipartFile file){

        List<ValidatorResponseMessage> validatorResponseMessageList = new ArrayList<>();
        try{
            List<DealDto> dealList = CsvHelper.dealDataFromCsv(file.getInputStream());
            for(int i=0;i<dealList.size();i++){
                List<ValidatorResponseMessage> validationResponseList = DealContentValidator.checkNullValue(i, dealList.get(i));
                if(validationResponseList.isEmpty()){
                    Deal deal = mapDtoToData(dealList.get(i));
                    dealRepository.save(deal);
                    log.info("Successfully saved the result");
                } else{
                    validatorResponseMessageList.addAll(validationResponseList);
                }
            }

        } catch (Exception e){
            log.error("saveDealRecord",e);
            throw new RuntimeException("fail to store csv record: " + e.getMessage());
        }
        return validatorResponseMessageList;
    }

    public Deal mapDtoToData(DealDto dealDto) {
        Deal deal = new Deal();
        deal.setDealId(dealDto.getDealId());
        deal.setFromCurrencyCode(dealDto.getFromCurrencyCode());
        deal.setToCurrencyCode(dealDto.getToCurrencyCode());
        deal.setDealTime(getDealDate(dealDto.getDealTime()));
        deal.setDealAmount(new BigDecimal(dealDto.getDealAmount()));
        return deal;
    }

    public Date getDealDate(String date) {
        Date newDate = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            newDate = format.parse(date);
        } catch (Exception e) {

        }
        return newDate;
    }
}
