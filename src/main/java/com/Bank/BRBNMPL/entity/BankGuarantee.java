package com.Bank.BRBNMPL.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bank_gurantee", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankGuarantee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serialNumber;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "bg_number", nullable = false, unique = true)
    private String bgNumber;

    @Column(name = "bg_date")
    private LocalDate bgDate;

    @Column(name = "type_of_bg")
    private String typeOfBg;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "po_wo_number", nullable = false, unique = true)
    private String poWoNumber;

    @Column(name = "nature_of_supply")
    private String natureOfSupply;

    @Column(name = "currency")
    private String currency;

    @Column(name = "amount")
    private String amount;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "validity_date")
    private LocalDate validityDate;

    @Column(name = "claim_date")
    private LocalDate claimDate;

    @Column(name = "amendment_validity_date")
    private LocalDate amendmentValidityDate;

    @Column(name = "amendment_claim_date")
    private LocalDate amendmentClaimDate;

    @Column(name = "received_date")
    private LocalDate receivedDate;

    @Column(name = "received_from_dept")
    private String receivedFromDept;

    @Column(name = "returned_date")
    private LocalDate returnedDate;

    @Column(name = "returned_to_dept")
    private String returnedToDept;

    @Column(name = "status", nullable = false)
    private String status;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedDate;
}
