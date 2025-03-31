package com.Bank.BRBNMPL.service;
import com.Bank.BRBNMPL.dto.BGClosureRequest;
import com.Bank.BRBNMPL.dto.BankGuaranteeRequestDto;
import com.Bank.BRBNMPL.dto.BgAmendmentRequest;
import com.Bank.BRBNMPL.entity.BankGuarantee;
import com.Bank.BRBNMPL.repo.BankGuranteeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BankGuaranteeService {
    @Autowired
    private BankGuranteeRepo bankGuranteeRepo;

    public BankGuarantee saveBankGuarantee(BankGuaranteeRequestDto dto) {
        BankGuarantee bankGuarantee = BankGuarantee.builder()
                .entryDate(dto.getEntryDate())
                .bgNumber(dto.getBgNumber())
                .bgDate(dto.getBgDate())
                .typeOfBg(dto.getTypeOfBg())
                .vendor(dto.getVendor())
                .poWoNumber(dto.getPoWoNumber())
                .poWoDate(dto.getPoWoDate())
                .natureOfSupply(dto.getNatureOfSupply())
                .currency(dto.getCurrency())
                .amount(dto.getAmount())
                .bankName(dto.getBankName())
                .validityDate(dto.getValidityDate())
                .claimDate(dto.getClaimDate())
                .receivedDate(dto.getReceivedDate())
                .receivedFromDept(dto.getReceivedFromDept())
                .status("OPEN")
                .build();
        return bankGuranteeRepo.save(bankGuarantee);
    }

    public BankGuarantee getBankGuranteeDetails  (String bgNumber){
        BankGuarantee bankGuarantee=bankGuranteeRepo.findByBgNumber(bgNumber).get();
        return bankGuarantee;
    }

    @Transactional
    public String updateAmendmentDates(BgAmendmentRequest bgAmendmentRequest) {
       Optional<BankGuarantee> existingBG = bankGuranteeRepo.findByBgNumber(bgAmendmentRequest.getBgNumber());
        if (!existingBG.isPresent()) {
            throw new RuntimeException("Bank Guarantee not found with bgNumber: " + bgAmendmentRequest.getBgNumber());
        }
        bankGuranteeRepo.updateAmendmentDates(bgAmendmentRequest.getBgNumber(), bgAmendmentRequest.getAmendmentValidityDate(), bgAmendmentRequest.getAmendmentClaimDate());
        return "upDated successfully";
    }

    @Transactional
    public String updateBgClosure(BGClosureRequest bgClosureRequest) {
        Optional<BankGuarantee> existingBG = bankGuranteeRepo.findByBgNumber(bgClosureRequest.getBgNumber());
        if (!existingBG.isPresent()) {
            throw new RuntimeException("Bank Guarantee not found with bgNumber: " + bgClosureRequest.getBgNumber());
        }
        bankGuranteeRepo.bgClosureUpdate(bgClosureRequest.getBgNumber(), bgClosureRequest.getReturnedDate(),bgClosureRequest.getReturnedToDept(),bgClosureRequest.getStatus());
        return "upDated successfully";
    }

}
