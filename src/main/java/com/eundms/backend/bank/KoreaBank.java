package com.eundms.backend.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;

@Entity
public class KoreaBank {
	private Long id;
	private BigDecimal baseInterestRate;
	private LocalDateTime createdAt;
}
