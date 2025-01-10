package com.cantata.tradetalent;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.SecureRandom;
import java.util.Base64;

@SpringBootTest
class TradetalentApplicationTests {

	@Test
	void contextLoads() {
		SecureRandom secureRandom = new SecureRandom();
		byte[] keyBytes = new byte[32];
		secureRandom.nextBytes(keyBytes);
		String secretKey = Base64.getEncoder().encodeToString(keyBytes);
		System.out.println("Generated Secret Key: " + secretKey);
	}

}
