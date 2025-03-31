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
public class BGClosureRequest {
    private String bgNumber;
    private LocalDate returnedDate;
    private String returnedToDept;
    private String status;
}
