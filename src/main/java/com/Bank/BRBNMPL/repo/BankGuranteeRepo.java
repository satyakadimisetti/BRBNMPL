package com.Bank.BRBNMPL.repo;

import com.Bank.BRBNMPL.entity.BankGuarantee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankGuranteeRepo extends JpaRepository<BankGuarantee,Long> {
    Optional<BankGuarantee> findByBgNumber(String bgNumber);
}
