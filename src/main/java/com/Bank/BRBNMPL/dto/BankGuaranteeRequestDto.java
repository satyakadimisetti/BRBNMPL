package com.Bank.BRBNMPL.dto;

import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BankGuaranteeRequestDto {
    private LocalDate entryDate;
    private String bgNumber;
    private LocalDate bgDate;
    private String typeOfBg;
    private String vendor;
    private String poWoNumber;
    private LocalDate poWoDate;
    private String natureOfSupply;
    private String currency;
    private String amount;
    private String bankName;
    private LocalDate validityDate;
    private LocalDate claimDate;
    private LocalDate receivedDate;
    private String receivedFromDept;
}
