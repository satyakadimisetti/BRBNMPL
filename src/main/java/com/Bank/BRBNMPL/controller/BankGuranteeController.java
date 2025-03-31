package com.Bank.BRBNMPL.controller;
import com.Bank.BRBNMPL.dto.BankGuaranteeRequestDto;
import com.Bank.BRBNMPL.dto.BankGuranteeform1Response;
import com.Bank.BRBNMPL.service.BankGuaranteeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BankGuranteeController {
    @Autowired
    BankGuaranteeService bankGuaranteeService;
    @PostMapping("/bgentryform")
    public ResponseEntity<?> getBankData(@RequestBody BankGuaranteeRequestDto bankGuaranteeRequestDto){
        bankGuaranteeService.saveBankGuarantee(bankGuaranteeRequestDto);
        return new ResponseEntity<>("data saved success fully",HttpStatus.OK);
    }
}
