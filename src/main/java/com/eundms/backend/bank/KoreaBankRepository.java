package com.eundms.backend.bank;

import java.math.BigDecimal;

public interface KoreaBankRepository {
	void save(BigDecimal baseRate);
}
