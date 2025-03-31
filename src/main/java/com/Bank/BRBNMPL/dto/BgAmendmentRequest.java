package com.Bank.BRBNMPL.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BgAmendmentRequest {
    private String bgNumber;
    private LocalDate amendmentValidityDate;
    private LocalDate amendmentClaimDate;
}
