package Functional1;

import java.util.Random;

public class AccountNumber_Generator {
	// this will be used for new customers.
	// and also to generate initial accounts
	private String accountNumber;
	

	public void setAccount(String account) {
		accountNumber = account;
	}

	public String getAccount() {
		return accountNumber;
	}

	public void generateAccount() {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();
		int random = rand.nextInt(10) + 1;

		sb.append("1");
		// first number in Account should be 1
		sb.append(Character.forDigit(random, 10));
		sb.append(Character.forDigit(random, 10));
		sb.append(Character.forDigit(random, 10));
		sb.append(Character.forDigit(random, 10));
		sb.append(Character.forDigit(random, 10));
		sb.append(Character.forDigit(random, 10));

		@SuppressWarnings("unused")
		boolean check = checkAccountNumber(sb.toString());
		if (check = true) {
//if the account we created passes the check below, we set the Account
			setAccount(sb.toString());

		} else
			generateAccount();
	}

	public boolean checkAccountNumber(String Account) {
		// the account number should have 8 digits
		this.accountNumber = getAccount();
		// we get the account we created and check it

		if (Account.length() < 8 || Account.length() > 8)
			throw new NumberFormatException("Account Number must be 8 digits long");

		return true;
	}

}
