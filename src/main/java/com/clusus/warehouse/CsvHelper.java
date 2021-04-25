package com.clusus.warehouse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvHelper {

    private Logger log;

    public static String TYPE = "text/csv";
    static String[] HEADERS = {"DealId", "FromCurrency", "ToCurrency", "DealTime", "Amount"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<DealDto> dealDataFromCsv(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("data.csv"));
            CSVParser csvParser = new CSVParser(bufferedReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            List<DealDto> dealDtoList = new ArrayList<DealDto>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                DealDto dealDto = new DealDto();
                dealDto.setDealId(csvRecord.get("DealId"));
                dealDto.setFromCurrencyCode(csvRecord.get("FromCurrency") );
                dealDto.setToCurrencyCode(csvRecord.get("ToCurrency"));
                dealDto.setDealTime(csvRecord.get("DealTime"));
                dealDto.setDealAmount(csvRecord.get("Amount"));
                dealDtoList.add(dealDto);
            }

            return dealDtoList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }

    }


}
