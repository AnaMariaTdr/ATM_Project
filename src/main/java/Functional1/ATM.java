package Functional1;

import java.io.IOException;

public class ATM {
	public static void main(String[] args) throws IOException {

		ATM_Menu atm = new ATM_Menu();
		System.out.println(
				"Before starting the application, please check the file named atmDATA.txt for 'private' PIN numbers");
		atm.start();
	}
}
