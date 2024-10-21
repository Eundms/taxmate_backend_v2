package com.eundms.backend.bank;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KoreaBankController {
	private KoreaBankService koreaBankService;

	public KoreaBankController(KoreaBankService koreaBankService) {
		this.koreaBankService = koreaBankService;
	}

	@PostMapping("/product/{productId}/join")
	public ResponseEntity<?> setBaseRate(@RequestBody BigDecimal baseRate) {


		return new ResponseEntity<>("", HttpStatus.OK);
	}
}
