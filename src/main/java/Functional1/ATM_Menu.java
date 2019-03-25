package Functional1;

import java.io.IOException;
import java.util.Scanner;

public class ATM_Menu extends ATM {

	static initialAccountOnATM accounts = new initialAccountOnATM();
// we open the scan here because we will use input from the keyboard multiple times

	Scanner sc = new Scanner(System.in);

	int pinFromKeyboard;

	public void start() throws IOException {
		accounts.initiateAccounts();
		System.out.println("Welcome ! ");
		System.out.println("Please enter your PIN");
		checkPIN();
	}

	public void checkPIN() {

		while (sc.hasNext()) {
			int i = sc.nextInt();
			if (accounts.getBankAccount().containsKey(i)) {
// here we assign the object bank account created earlier to the account to which the pin from the keyboard matches
				pinFromKeyboard = i;
				optionsSwitchStatement();

				System.out.println("Welcome ! ");
			}

			else {
				System.out.println("Your PIN is invalid. Please try again");
			}

		}

	}

	public void optionsSwitchStatement() {
		System.out.println("Please select what would you like to do?");
		System.out.println("1. Verify current available amount ");
		System.out.println("2. Deposit amount");
		System.out.println("3. Withdraw");
		System.out.println("4. Change PIN");

		int optionFromKeyboard = sc.nextInt();
		Owner or = accounts.getBankAccount().get(pinFromKeyboard);

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
			break;
		}
		otherOptions();
	}

	public void otherOptions() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("If you wish to get back to the main menu, please press 1");
		System.out.println("If you wish to cancel please press 2 ");
		int optionFromKeyboard = sc1.nextInt();

		switch (optionFromKeyboard) {
		case 1:
			optionsSwitchStatement();
			break;

		case 2:
			stop();
			break;

		default:
			System.out.println("Option is invalid. Canceling this request");
			break;
		}
		sc1.close();
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
