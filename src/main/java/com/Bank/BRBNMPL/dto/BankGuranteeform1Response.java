package com.Bank.BRBNMPL.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankGuranteeform1Response {
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
}
