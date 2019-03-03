package Functional1;

import java.util.Random;

public class Checkingmethods {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();
		int random = rand.nextInt(10) + 1;

		sb.append("1");
		sb.append(Character.forDigit(random, 10));
		System.out.println(sb);

	}

}
