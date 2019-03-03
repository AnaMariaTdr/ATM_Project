package Functional1;

import java.util.*;

public class BigAccountCreator {
	// accounts should have an account number, a name attached, a pin, an an initial
	// deposit of 0.
	// this should hold the pin and owner

	private String accNo;

	public String getAccNo() {
		return accNo;
	}

	public String setAccNo(String accNo) {
		return this.accNo = accNo;
	}

//account number generator
	AccountNumber_Generator acc1 = new AccountNumber_Generator();

	String accNo1 = setAccNo(acc1.getAccount());
	String accNo2 = setAccNo(acc1.getAccount());
	String accNo3 = setAccNo(acc1.getAccount());
	String accNo4 = setAccNo(acc1.getAccount());
	String accNo5 = setAccNo(acc1.getAccount());

	// pin generator
	PIN pinGenerator = new PIN();
	int pin1 = pinGenerator.generatePIN();
	int pin2 = pinGenerator.generatePIN();
	int pin3 = pinGenerator.generatePIN();
	int pin4 = pinGenerator.generatePIN();
	int pin5 = pinGenerator.generatePIN();

	public void initiateAccount() {
		Map<String, Owner> bankAccount = new HashMap<String, Owner>();
		bankAccount.put(accNo1, new Owner("Ana-Maria", "Tudor", pin1, 0));
		bankAccount.put(accNo2, new Owner("Vladimir", "Putin", pin2, 0));
		bankAccount.put(accNo3, new Owner("Barack", "Obama", pin3, 0));
		bankAccount.put(accNo4, new Owner("Petre", "Ispirescu", pin4, 0));
		bankAccount.put(accNo5, new Owner("Florin", "Salam", pin5, 0));

	}
}
