package com.Bank.BRBNMPL.controller;
import com.Bank.BRBNMPL.dto.BGClosureRequest;
import com.Bank.BRBNMPL.dto.BankGuaranteeRequestDto;
import com.Bank.BRBNMPL.dto.BankGuranteeform1Response;
import com.Bank.BRBNMPL.dto.BgAmendmentRequest;
import com.Bank.BRBNMPL.entity.BankGuarantee;
import com.Bank.BRBNMPL.service.BankGuaranteeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/api/bg")
@CrossOrigin(origins = "http://localhost:8086")
public class BankGuranteeController {
    private final BankGuaranteeService bankGuaranteeService;
    public BankGuranteeController (BankGuaranteeService bankGuaranteeService) {
        this.bankGuaranteeService = bankGuaranteeService;
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

}
