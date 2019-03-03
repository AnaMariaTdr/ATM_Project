package Functional1;

public class validatorDeposit {

	public boolean checkDeposit(int Withdraw) {

		if (Withdraw < 10) {
			System.out.println("Amount deposited should be at least 10 RON");
			return false;
		} else if (Withdraw > 5000) {
			System.out.println("For amounts bigger than 5000, please address the request to our offices");
			return false;
		} else
			return true;
	}

}
