package com.clusus.warehouse;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DealServiceTest {

    @Autowired
    private DealService dealService;

    @Before
    public void init() {

    }


    public static Object[][] dataForSaveDealRecord() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("data.csv");
        MockMultipartFile file = new MockMultipartFile("data", "data", "application/json", fileInputStream);
        List<ValidatorResponseMessage> validatorResponseMessageList = new ArrayList<>();
        ValidatorResponseMessage validatorResponseMessage = new ValidatorResponseMessage(0, "FromCurrencyCode", "From Currency Code is not defined");
        ValidatorResponseMessage validatorResponseMessage1 = new ValidatorResponseMessage(0, "ToCurrencyCode", "To Currency Code is not defined");
        ValidatorResponseMessage validatorResponseMessage2 = new ValidatorResponseMessage(1, "FromCurrencyCode", "From Currency Code is not defined");
        ValidatorResponseMessage validatorResponseMessage3 = new ValidatorResponseMessage(1, "ToCurrencyCode", "To Currency Code is not defined");
        ValidatorResponseMessage validatorResponseMessage4 = new ValidatorResponseMessage(2, "FromCurrencyCode", "From Currency Code is not defined");
        ValidatorResponseMessage validatorResponseMessage5 = new ValidatorResponseMessage(2, "ToCurrencyCode", "To Currency Code is not defined");
        ValidatorResponseMessage validatorResponseMessage6 = new ValidatorResponseMessage(2, "Amount", "Deal Amount is not defined");
        ValidatorResponseMessage validatorResponseMessage7 = new ValidatorResponseMessage(3, "FromCurrencyCode", "From Currency Code is not defined");
        ValidatorResponseMessage validatorResponseMessage8 = new ValidatorResponseMessage(3, "ToCurrencyCode", "To Currency Code is not defined");
        validatorResponseMessageList.add(validatorResponseMessage);
        validatorResponseMessageList.add(validatorResponseMessage1);
        validatorResponseMessageList.add(validatorResponseMessage2);
        validatorResponseMessageList.add(validatorResponseMessage3);
        validatorResponseMessageList.add(validatorResponseMessage4);
        validatorResponseMessageList.add(validatorResponseMessage5);
        validatorResponseMessageList.add(validatorResponseMessage6);
        validatorResponseMessageList.add(validatorResponseMessage7);
        validatorResponseMessageList.add(validatorResponseMessage8);
        return new Object[][]{
                {file, validatorResponseMessageList, validatorResponseMessageList}
        };
    }

    @Test
    public void saveDealRecordTest() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("data.csv");
        MockMultipartFile file = new MockMultipartFile("data", "data", "application/json", fileInputStream);
        List<ValidatorResponseMessage> validatorResponseMessageList = new ArrayList<>();
        ValidatorResponseMessage validatorResponseMessage = new ValidatorResponseMessage(0, "FromCurrencyCode", "From Currency Code is not defined");
        ValidatorResponseMessage validatorResponseMessage1 = new ValidatorResponseMessage(0, "ToCurrencyCode", "To Currency Code is not defined");
        ValidatorResponseMessage validatorResponseMessage2 = new ValidatorResponseMessage(1, "FromCurrencyCode", "From Currency Code is not defined");
        ValidatorResponseMessage validatorResponseMessage3 = new ValidatorResponseMessage(1, "ToCurrencyCode", "To Currency Code is not defined");
        ValidatorResponseMessage validatorResponseMessage4 = new ValidatorResponseMessage(2, "FromCurrencyCode", "From Currency Code is not defined");
        ValidatorResponseMessage validatorResponseMessage5 = new ValidatorResponseMessage(2, "ToCurrencyCode", "To Currency Code is not defined");
        ValidatorResponseMessage validatorResponseMessage6 = new ValidatorResponseMessage(2, "Amount", "Deal Amount is not defined");
        ValidatorResponseMessage validatorResponseMessage7 = new ValidatorResponseMessage(3, "FromCurrencyCode", "From Currency Code is not defined");
        ValidatorResponseMessage validatorResponseMessage8 = new ValidatorResponseMessage(3, "ToCurrencyCode", "To Currency Code is not defined");
        validatorResponseMessageList.add(validatorResponseMessage);
        validatorResponseMessageList.add(validatorResponseMessage1);
        validatorResponseMessageList.add(validatorResponseMessage2);
        validatorResponseMessageList.add(validatorResponseMessage3);
        validatorResponseMessageList.add(validatorResponseMessage4);
        validatorResponseMessageList.add(validatorResponseMessage5);
        validatorResponseMessageList.add(validatorResponseMessage6);
        validatorResponseMessageList.add(validatorResponseMessage7);
        validatorResponseMessageList.add(validatorResponseMessage8);
        List<ValidatorResponseMessage> validatorResponseMessages = dealService.saveDealRecord(file);
        assertEquals(validatorResponseMessages.size(), validatorResponseMessageList.size());
        assertTrue(validatorResponseMessages.contains(validatorResponseMessage));
        assertTrue(validatorResponseMessages.contains(validatorResponseMessage1));
        assertTrue(validatorResponseMessages.contains(validatorResponseMessage2));
        assertTrue(validatorResponseMessages.contains(validatorResponseMessage3));
        assertTrue(validatorResponseMessages.contains(validatorResponseMessage4));
        assertTrue(validatorResponseMessages.contains(validatorResponseMessage5));
        assertTrue(validatorResponseMessages.contains(validatorResponseMessage6));
        assertTrue(validatorResponseMessages.contains(validatorResponseMessage7));
        assertTrue(validatorResponseMessages.contains(validatorResponseMessage8));
    }

    @Test
    public void mapDtoToDataTest() {
        DealDto dealDto = new DealDto("S001","USD","EUR","2021-04-25 14:20:00","1500.00");
        Deal deal = dealService.mapDtoToData(dealDto);
        assertNotNull(deal);
        assertEquals(dealDto.getDealId(),deal.getDealId());
    }

}
