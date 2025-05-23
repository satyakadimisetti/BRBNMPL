package com.Bank.BRBNMPL.repo;

import com.Bank.BRBNMPL.entity.BankGuarantee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BankGuranteeRepo extends JpaRepository<BankGuarantee,Long> {
    Optional<BankGuarantee> findByBgNumber(String bgNumber);

    @Modifying
    @Transactional
    @Query("UPDATE BankGuarantee bg SET bg.amendmentValidityDate = :amendmentValidityDate, bg.amendmentClaimDate = :amendmentClaimDate WHERE bg.bgNumber = :bgNumber")
    int updateAmendmentDates(String bgNumber, LocalDate amendmentValidityDate, LocalDate amendmentClaimDate);

    @Modifying
    @Transactional
    @Query("UPDATE BankGuarantee bg SET bg.returnedDate = :returnedDate, bg.returnedToDept = :returnedToDept, bg.status = :status  WHERE bg.bgNumber = :bgNumber")
    int bgClosureUpdate(String bgNumber, LocalDate returnedDate, String returnedToDept,String status);

    @Query("SELECT bg FROM BankGuarantee bg WHERE (:status IS NULL OR bg.status = :status) AND bg.entryDate <= :entryDate")
    List<BankGuarantee> findByStatusAndEntryDateBeforeOrEqual(@Param("status") String status, @Param("entryDate") LocalDate entryDate);

}
