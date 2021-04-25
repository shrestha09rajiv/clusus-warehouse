package com.clusus.warehouse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CsvHelperTest {
    CsvHelper csvHelper;

    @BeforeEach
    void setUp() {
        csvHelper = new CsvHelper();
    }

    @Test
    public void fileFormatTest() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("data.csv");
        MockMultipartFile multipartFile = new MockMultipartFile("data","data","text/csv",fileInputStream);
        assertTrue(CsvHelper.hasCSVFormat(multipartFile));
    }

    @Test
    public void testIfOtherFileFormatsPassed() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("data.csv");
        MockMultipartFile multipartFile = new MockMultipartFile("data","data","applcation/json",fileInputStream);
        assertFalse(CsvHelper.hasCSVFormat(multipartFile));
    }

    @Test
    public void testDealDataFromCsv(){
        InputStream inputStream = asStream("DealId,FromCurrency,ToCurrency,DealTime,Amount \n" +
                "S001,USD,INR, 1222,9834\n" +
                "S002,USD,EUR,2021-04-24 10:25:15,1293\n" +
                "S003,INR,NPR,2021-04-25 10:30:15,2356");
        List<DealDto> dealDtoList = CsvHelper.dealDataFromCsv(inputStream);
        assertEquals(4, dealDtoList.size());
    }

    private InputStream asStream(String s) {
        return new ByteArrayInputStream(s.getBytes());
    }
}
