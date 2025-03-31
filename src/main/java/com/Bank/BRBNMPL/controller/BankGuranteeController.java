package com.Bank.BRBNMPL.controller;
import com.Bank.BRBNMPL.dto.BGClosureRequest;
import com.Bank.BRBNMPL.dto.BankGuaranteeRequestDto;
import com.Bank.BRBNMPL.dto.BgAmendmentRequest;
import com.Bank.BRBNMPL.dto.ReportRequest;
import com.Bank.BRBNMPL.entity.BankGuarantee;
import com.Bank.BRBNMPL.service.BankGuaranteeService;
import com.Bank.BRBNMPL.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/bg")
@CrossOrigin(origins = "http://localhost:8086")
public class BankGuranteeController {
    @Value("${excel.contentType}")
    private String excelContentType;
    private final BankGuaranteeService bankGuaranteeService;
    private final ReportService reportService;
    public BankGuranteeController (BankGuaranteeService bankGuaranteeService, ReportService reportService) {
        this.bankGuaranteeService = bankGuaranteeService;
        this.reportService=reportService;
    }
    @PostMapping("/submit-form")
    public ResponseEntity<?> getBankData(@RequestBody BankGuaranteeRequestDto bankGuaranteeRequestDto){
        bankGuaranteeService.saveBankGuarantee(bankGuaranteeRequestDto);
        return new ResponseEntity<>("data saved success fully",HttpStatus.OK);
    }

    @GetMapping("/getBankGuarantee")
    public BankGuarantee getbankGuranteeByBgNumber(@RequestParam String bgNumber ){
      return bankGuaranteeService.getBankGuranteeDetails(bgNumber);
    }

    @PutMapping("/updateBgAmendment")
    public ResponseEntity<?> updateBgAmendmentForm(@RequestBody BgAmendmentRequest bgAmendmentRequest){
     String response= bankGuaranteeService.updateAmendmentDates(bgAmendmentRequest);
     return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/updateBgClosure")
    public ResponseEntity<?> upDateBGClosure(@RequestBody BGClosureRequest bgClosureRequest){
   String response=bankGuaranteeService.updateBgClosure(bgClosureRequest);
   return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/downLoadReport")
    public ResponseEntity<Resource> downLoadXl(@RequestBody  ReportRequest reportRequest) throws IOException {
        List<BankGuarantee> bankGuarantees=bankGuaranteeService.getBankGuranteeList(reportRequest);
        Workbook workbook=reportService.generateReport(bankGuarantees);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=AllApplicationsData.xlsx");
        InputStreamResource inputStreamResource = new InputStreamResource(new ByteArrayInputStream(outputStream.toByteArray()));
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType(excelContentType))
                .body(inputStreamResource);
    }


}
