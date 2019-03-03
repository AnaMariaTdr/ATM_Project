package Functional1;

import java.util.*;

public class BigAccountCreator {
	// accounts should have an account number, a name attached, a pin, an an initial
	// deposit of 0.

	private String firstName;
	private String lastName;
	private String accNo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccNo() {
		return accNo;
	}

	public String setAccNo(String accNo) {
		return this.accNo = accNo;
	}

	@Override
	public String toString() {
		return "BigAccountCreator [firstName=" + firstName + ", lastName=" + lastName + ", accNo=" + accNo + "]";
	}
	public BigAccountCreator(String accNo , String firstName, String lastName ) {
		super();
		this.accNo = accNo;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// lets generate 5 accounts, 5 pins, and add them together in a map 
	AccountNumber_Generator acc1 = new AccountNumber_Generator();

	String accNo1 = setAccNo(acc1.getAccount());
	String accNo2 = setAccNo(acc1.getAccount());
	String accNo3 = setAccNo(acc1.getAccount());
	String accNo4 = setAccNo(acc1.getAccount());
	String accNo5 = setAccNo(acc1.getAccount());

	BigAccountCreator bigAcc1 = new BigAccountCreator("George", "Lazar", accNo1);
	BigAccountCreator bigAcc2 = new BigAccountCreator("Vasile", "Ionel", accNo2);
	BigAccountCreator bigAcc3 = new BigAccountCreator("Ana", "Blandiana", accNo3);
	BigAccountCreator bigAcc4 = new BigAccountCreator("Vladimir", "Putin", accNo4);
	BigAccountCreator bigAcc5 = new BigAccountCreator("Gargarita", "Mica", accNo5);
	

	// lets generate 5 pins numbers

	PIN pin1 = new PIN();
	PIN pin2 = new PIN();
	PIN pin3 = new PIN();
	PIN pin4 = new PIN();
	PIN pin5 = new PIN();

	// lets add them together in a Map

	public void creatingBigAccounts() {
		Map<BigAccountCreator, PIN> bigAccounts = new HashMap<BigAccountCreator, PIN>();
		bigAccounts.put(bigAcc1, pin1);
		bigAccounts.put(bigAcc2, pin2);
		bigAccounts.put(bigAcc3, pin3);
		bigAccounts.put(bigAcc4, pin4);
		bigAccounts.put(bigAcc5, pin5);

	}
}
