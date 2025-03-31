package com.Bank.BRBNMPL.dto;

import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BankGuaranteeRequestDto {
    
    private String serialNumber;
    private LocalDate entryDate;
    private String bgNumber;
    private LocalDate bgDate;
    private String typeOfBg;
    private String vendor;
    private String poWoNumber;
    private String natureOfSupply;
    private String currency;
    private String amount;
    private String bankName;
    private LocalDate validityDate;
    private LocalDate claimDate;
    private LocalDate amendmentValidityDate;
    private LocalDate amendmentClaimDate;
    private LocalDate receivedDate;
    private String receivedFromDept;
    private LocalDate returnedDate;
    private String returnedToDept;
    private String status;
}
