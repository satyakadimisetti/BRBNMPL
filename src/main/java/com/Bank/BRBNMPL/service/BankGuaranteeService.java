package com.Bank.BRBNMPL.service;

import com.Bank.BRBNMPL.dto.BankGuaranteeRequestDto;
import com.Bank.BRBNMPL.entity.BankGuarantee;
import com.Bank.BRBNMPL.repo.BankGuranteeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankGuaranteeService {
    @Autowired
    private BankGuranteeRepo bankGuranteeRepo;

    public BankGuarantee saveBankGuarantee(BankGuaranteeRequestDto dto) {
        BankGuarantee bankGuarantee = BankGuarantee.builder()
                .serialNumber(dto.getSerialNumber())
                .entryDate(dto.getEntryDate())
                .bgNumber(dto.getBgNumber())
                .bgDate(dto.getBgDate())
                .typeOfBg(dto.getTypeOfBg())
                .vendor(dto.getVendor())
                .poWoNumber(dto.getPoWoNumber())
                .natureOfSupply(dto.getNatureOfSupply())
                .currency(dto.getCurrency())
                .amount(dto.getAmount())
                .bankName(dto.getBankName())
                .validityDate(dto.getValidityDate())
                .claimDate(dto.getClaimDate())
                .amendmentValidityDate(dto.getAmendmentValidityDate())
                .amendmentClaimDate(dto.getAmendmentClaimDate())
                .receivedDate(dto.getReceivedDate())
                .receivedFromDept(dto.getReceivedFromDept())
                .returnedDate(dto.getReturnedDate())
                .returnedToDept(dto.getReturnedToDept())
                .status(dto.getStatus())
                .build();

        return bankGuranteeRepo.save(bankGuarantee);
    }
}
