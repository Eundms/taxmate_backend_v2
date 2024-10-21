package com.eundms.backend.bank;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class KoreaBankServiceImpl implements KoreaBankService {
	private final KoreaBankRepository koreaBankRepository;

	public KoreaBankServiceImpl(KoreaBankRepository koreaBankRepository) {
		this.koreaBankRepository = koreaBankRepository;
	}

	@Override
	public void setBaseRate(BigDecimal baseRate) {
		koreaBankRepository.save(baseRate);
	}
}
