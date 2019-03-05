package Functional1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM_Menu extends ATM{

// we create a static map where pe pun the PIN as an integer and the Owner
	public static Map<Integer, Owner> bankAccount = new HashMap<Integer, Owner>();

//account number generator, we create the account number 
	AccountNumber_Generator acc1 = new AccountNumber_Generator();

	String accNo1 = acc1.generateAccount();
	String accNo2 = acc1.generateAccount();
	String accNo3 = acc1.generateAccount();
	String accNo4 = acc1.generateAccount();
	String accNo5 = acc1.generateAccount();

	// pin generator, we create the pin
	PIN pinGenerator = new PIN();
	int pin1 = pinGenerator.generatePIN();
	int pin2 = pinGenerator.generatePIN();
	int pin3 = pinGenerator.generatePIN();
	int pin4 = pinGenerator.generatePIN();
	int pin5 = pinGenerator.generatePIN();

	// here we initiate the account after we open the ATM

	public void initiateAccounts() {

		bankAccount.put(pin1, new Owner("Ana-Maria", "Tudor", accNo1, 0));
		bankAccount.put(pin2, new Owner("Vladimir", "Putin", accNo2, 0));
		bankAccount.put(pin3, new Owner("Barack", "Obama", accNo3, 0));
		bankAccount.put(pin4, new Owner("Petre", "Ispirescu", accNo4, 0));
		bankAccount.put(pin5, new Owner("Florin", "Salam", accNo5, 0));

	}

// we open the scan here because we will use input from the keyboard multiple times
	Scanner sc = new Scanner(System.in);

	int pinFromKeyboard;

	public void start() {

		initiateAccounts();
		System.out.println("Welcome ! ");
		System.out.println("Please enter your PIN");
	}

	public void checkPIN() {

		while (sc.hasNext()) {
			int i = sc.nextInt();
			if (bankAccount.containsKey(i)) {
// here we assign the object bank account created earlier to the account to which the pin from the keyboard matches
				pinFromKeyboard = i;
				continueAfterStart();

			}

			else {
				System.out.println("Your PIN is invalid. Please try again");
			}

		}

	}

	public void continueAfterStart() {
		System.out.println("Welcome ! ");
		System.out.println("Please select what would you like to do?");
		System.out.println("1. Verify current available amount ");
		System.out.println("2. Deposit amount");
		System.out.println("3. Withdraw");
		System.out.println("4. Change PIN");

		optionsSwitchStatement();
	}

	public void optionsSwitchStatement() {

		int optionFromKeyboard = sc.nextInt();
		Owner or = bankAccount.get(pinFromKeyboard);

		switch (optionFromKeyboard) {

		case 1:
			System.out.println("The current amount is : " + (or.getSoldAmount()));

			break;
		case 2:
			System.out.println("Please enter amount to be deposited");
			int amountDeposited = sc.nextInt();
			addDeposit(or, amountDeposited);
			break;

		case 3:

			System.out.println("Please enter the amount you wish to withdraw");
			int amountToBeWithdraw = sc.nextInt();
			removeAmount(or, amountToBeWithdraw);

			break;
		case 4:
			System.out.println("Please enter the new PIN");
			int newPIN = sc.nextInt();
			PIN pin = new PIN();
			pin.changePIN(newPIN);

			break;

		default:

			System.out.println("Option selected is not a valid option");
			System.out.println("If you wish to cancel please type : ' cancel '  ");
			System.out.println("If you wish to get back to the main menu, please type : ' menu ' ");
			if (sc.next() == "menu") {
				optionsSwitchStatement();
			} else if (sc.next() == "cancel") {
				stop();

			} else {
				System.out.println("Your option is not valid. Closing this request");
				stop();
			}

		}
	}

	private void stop() {
		// TODO Auto-generated method stub
		System.out.println("Thank you and Have a Great Day ! ");

	}

	private void removeAmount(Owner or, int amountToBeWithdraw) {
		validatorWithdraw vw = new validatorWithdraw();
		@SuppressWarnings("unused")
		boolean check = vw.checkWithdraw(amountToBeWithdraw);

		if ((check = true) && (or.getSoldAmount() > amountToBeWithdraw)) {
			or.setSoldAmount(amountToBeWithdraw);
			System.out.println("Amount has been wihdraw");

		} else {
			System.out.println("Insuficient funds ! ");
		}
	}

	private void addDeposit(Owner or, int amountDeposited) {
		validatorDeposit vd = new validatorDeposit();
		@SuppressWarnings("unused")
		boolean check = vd.checkDeposit(amountDeposited);
		if (check = true) {

			or.setSoldAmount(amountDeposited);
			System.out.println("Amount has been deposited");

		}
		sc.close();
	}
}
