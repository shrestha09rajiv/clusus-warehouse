package com.clusus.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Currency;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/deal/csv")
public class DealController {

    @Autowired
    DealService dealService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        if (CsvHelper.hasCSVFormat(file)) {
                List<ValidatorResponseMessage> errorResponseList = dealService.saveDealRecord(file);
                return new ResponseEntity(errorResponseList,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity("Please upload CSV file",HttpStatus.BAD_REQUEST);
    }


}
