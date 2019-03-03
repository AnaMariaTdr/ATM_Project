
package Functional1;

public class Owner {
	private String firstName;
	private String lastName;
	private int PIN;
	private int accountCurrentSold;

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

	public int getPIN() {
		return PIN;
	}

	public void setPIN(int pIN) {
		PIN = pIN;
	}

	@Override
	public String toString() {
		return "Owner [firstName=" + firstName + ", lastName=" + lastName + ", PIN=" + PIN + ", accountCurrentSold="
				+ accountCurrentSold + "]";
	}

	public Owner(String firstName, String lastName, int pIN, int accountCurrentSold) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		PIN = pIN;
		this.accountCurrentSold = accountCurrentSold;
	}
	

	
	
	

}
