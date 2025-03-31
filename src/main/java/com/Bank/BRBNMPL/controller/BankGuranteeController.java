package com.Bank.BRBNMPL.controller;
import com.Bank.BRBNMPL.dto.BankGuaranteeRequestDto;
import com.Bank.BRBNMPL.dto.BankGuranteeform1Response;
import com.Bank.BRBNMPL.entity.BankGuarantee;
import com.Bank.BRBNMPL.service.BankGuaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankGuranteeController {
    @Autowired
    BankGuaranteeService bankGuaranteeService;
    @PostMapping("/bgentryform")
    public ResponseEntity<?> getBankData(@RequestBody BankGuaranteeRequestDto bankGuaranteeRequestDto){
        bankGuaranteeService.saveBankGuarantee(bankGuaranteeRequestDto);
        return new ResponseEntity<>("data saved success fully",HttpStatus.OK);
    }

    @GetMapping("/getBankGurantee")
    public BankGuarantee getbankGuranteeByBgNumber(@RequestParam String bgNumber ){
      return bankGuaranteeService.getBankGuranteeDetails(bgNumber);
    }

}
