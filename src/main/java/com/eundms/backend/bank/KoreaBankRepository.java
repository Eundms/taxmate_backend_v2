package com.eundms.backend.bank;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KoreaBankRepository extends JpaRepository<KoreaBank, Long> {
	Optional<KoreaBank> findById(Long id);
	void save(BigDecimal baseInterestRate);
	void update(BigDecimal baseInterestRate);
}
