package Functional_tests1;
import static org.junit.Assert.*;

import org.junit.Test;

import Functional1.AccountNumber_Generator;

public class Account_Test {

	@Test
	public void validAccountNumber() {
		AccountNumber_Generator validator = new AccountNumber_Generator();
		boolean result = validator.checkAccountNumber("18277584");
		assertTrue(result);
	}

	@Test(expected = NumberFormatException.class)

	public void invalidTooShortAccountNumber() {
		AccountNumber_Generator validator = new AccountNumber_Generator();
		boolean result = validator.checkAccountNumber("1827758");
		assertFalse(result);

	}

	@Test(expected = NumberFormatException.class)

	public void invalidTooLongAccountNumber() {
		AccountNumber_Generator validator = new AccountNumber_Generator();
		boolean result = validator.checkAccountNumber("182775845");
		assertFalse(result);

	}

}
