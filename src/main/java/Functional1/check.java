package Functional1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();
		int random = rand.nextInt(10) + 1;

		sb.append("1");
		sb.append(Character.forDigit(random, 10));
		System.out.println(sb);

		AccountNumber_Generator acc1 = new AccountNumber_Generator();

		String accNo1 = acc1.generateAccount();
		String accNo2 = acc1.generateAccount();
		String accNo3 = acc1.generateAccount();
		String accNo4 = acc1.generateAccount();
		String accNo5 = acc1.generateAccount();

		PIN pinGenerator = new PIN();
		int pin1 = pinGenerator.generatePIN();
		int pin2 = pinGenerator.generatePIN();
		int pin3 = pinGenerator.generatePIN();
		int pin4 = pinGenerator.generatePIN();
		int pin5 = pinGenerator.generatePIN();

		Map<Integer, Owner> bankAccount = new HashMap<Integer, Owner>();
		bankAccount.put(pin1, new Owner("Ana-Maria", "Tudor", accNo1, 0));
		bankAccount.put(pin2, new Owner("Vladimir", "Putin", accNo2, 0));
		bankAccount.put(pin3, new Owner("Barack", "Obama", accNo3, 0));
		bankAccount.put(pin4, new Owner("Petre", "Ispirescu", accNo4, 0));
		bankAccount.put(pin5, new Owner("Florin", "Salam", accNo5, 0));

		System.out.println(bankAccount.get(pin1));

	}

}
