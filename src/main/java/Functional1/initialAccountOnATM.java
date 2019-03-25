package Functional1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class initialAccountOnATM {

	static File file = new File("atmData.txt");
	static Path path = Paths.get("atmData.txt");

	// we create a static map where where put the PIN as an integer and the Owner
	private static Map<Integer, Owner> bankAccount = new HashMap<>();

	// account number generator, we create the account number
	AccountNumber_Generator acc1 = new AccountNumber_Generator();

	// we need to create a file where we put the account no and pins for each owner

	// this needs to be initialized once

	final String accNo1 = acc1.generateAccount();
	final String accNo2 = acc1.generateAccount();
	final String accNo3 = acc1.generateAccount();
	final String accNo4 = acc1.generateAccount();
	final String accNo5 = acc1.generateAccount();

	// pin generator, we create the pin
	PIN pinGenerator = new PIN();
	int pin1 = pinGenerator.generatePIN();
	int pin2 = pinGenerator.generatePIN();
	int pin3 = pinGenerator.generatePIN();
	int pin4 = pinGenerator.generatePIN();
	int pin5 = pinGenerator.generatePIN();

	public void initiateAccounts() throws IOException {
		// here we initiate the account after we open the ATM

		bankAccount.put(pin1, new Owner("Ana-Maria", "Tudor", accNo1, 0));
		bankAccount.put(pin2, new Owner("Vladimir", "Putin", accNo2, 0));
		bankAccount.put(pin3, new Owner("Barack", "Obama", accNo3, 0));
		bankAccount.put(pin4, new Owner("Petre", "Ispirescu", accNo4, 0));
		bankAccount.put(pin5, new Owner("Florin", "Salam", accNo5, 0));

		// adding all info into a file
		FileWriter writer = new FileWriter(file);
		writer.write(mapToString(bankAccount));
		writer.close();

	}

	// to string for the map
	public static <K, V> String mapToString(Map<K, V> map) {
		return map.entrySet().stream().map(entry -> "PIN : " + entry.getKey() + " - > " + entry.getValue())
				.collect(Collectors.joining("\n ", "{", "}"));
	}

//getter for bank account
	public Map<Integer, Owner> getBankAccount() {
		return bankAccount;
	}

// setter for bank account 
	public void setBankAccount(Map<Integer, Owner> bankAccount) {
		initialAccountOnATM.bankAccount = bankAccount;
	}
}
