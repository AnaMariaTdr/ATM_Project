package Functional1;

import java.util.Random;

public class PIN {

	private int PIN;

	public void setPIN(int pIN) {
		PIN = pIN;
	}

	public int getPIN() {
		return PIN;
	}

	public int generatePIN() {
		// pin number should be 4 digits
		// use same writing as in AccountNumber_Generator

		StringBuilder sb = new StringBuilder();
		Random rand = new Random();

		sb.append(Integer.toString((rand.nextInt(9) + 1)));
		sb.append(Integer.toString((rand.nextInt(9) + 1)));
		sb.append(Integer.toString((rand.nextInt(9) + 1)));
		sb.append(Integer.toString((rand.nextInt(9) + 1)));

		// checking our new auto generated PIN

		validatorPIN validator = new validatorPIN();
		@SuppressWarnings("unused")
		boolean check = validator.checkPIN(sb.toString());
		if (check = true) {
			// if the generated pin is ok, we change the string to an int and set the PIN
			setPIN(Integer.parseInt(sb.toString()));

		}
		return getPIN();
	}

	public void changePIN(int newPIN) {
		String PIN = Integer.toString(newPIN);
		validatorPIN validator = new validatorPIN();
// we check the new PIN with out validator 
		@SuppressWarnings("unused")
		boolean check = validator.checkPIN(PIN);
		if (check = true) {
// if validator checks ok(true), we change the PIN 
			setPIN(newPIN);

		} else
			System.out.println("Please enter another PIN");

	}

	@Override
	public String toString() {
		return "PIN [PIN=" + PIN + "]";
	}
	
	
}
