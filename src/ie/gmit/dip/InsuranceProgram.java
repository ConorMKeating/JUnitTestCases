package ie.gmit.dip;

import java.util.Scanner;

public class InsuranceProgram {

	private int basicInsurance = 500;
	private int ageSurcharge = 100; // under 25 years
	private int[] accSurcharge = { 0, 50, 125, 225, 375, 575 }; // array of surcharge values for accidents
	private int age;
	private int accidents;
	private String greeting;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		InsuranceProgram ip = new InsuranceProgram();

		System.out.print("Enter your age: ");
		ip.age = input.nextInt();
		ip.ageSurcharge(ip.age);

		System.out.print("\nHow many accidents did you have? ");
		ip.accidents = input.nextInt();
		ip.numOfAccidents(ip.accidents);

		input.close();
	}

	// this method decides whether a surcharge is added based on age
	public void ageSurcharge(int age) {
		if (this.age >= 25) {
			System.out.println("No additional surcharge");
		}

		if (this.age < 25) {
			System.out.println("Additional age surcharge " + ageSurcharge);
		}
	}

	// this method calculates premium added for each number of accidents
	public int numOfAccidents(int accidents) {

		if (this.age >= 25)
			this.ageSurcharge = 0;

		switch (accidents) {
		case 0:
			this.basicInsurance += accSurcharge[accidents];
			System.out.println("No accident surcharge");
			System.out.println("Total amount to pay: " + (this.basicInsurance + this.ageSurcharge));
			return this.basicInsurance;
		case 1:
			this.basicInsurance += accSurcharge[accidents];
			System.out.println("Additional surcharge for 1 accident: " + 50 + " \nTotal amount to pay: "
					+ (this.basicInsurance + this.ageSurcharge)); // Pay 550 or 650
			return this.basicInsurance;
		case 2:
			this.basicInsurance += accSurcharge[accidents];
			System.out.println("Additional surcharge for 2 accidents: " + 125 + " \nTotal amount to pay: "
					+ (this.basicInsurance + this.ageSurcharge)); // Pay 625 or 725
			return this.basicInsurance;
		case 3:
			this.basicInsurance += accSurcharge[accidents];
			System.out.println("Additional surcharge for 3 accidents: " + 225 + " \nTotal amount to pay: "
					+ (this.basicInsurance + this.ageSurcharge)); // Pay 725 or 825
			return this.basicInsurance;
		case 4:
			this.basicInsurance += accSurcharge[accidents];
			System.out.println("Additional surcharge for 4 accidents: " + 375 + " \nTotal amount to pay: "
					+ (this.basicInsurance + this.ageSurcharge)); // Pay 875 or 975
			return this.basicInsurance;
		case 5:
			this.basicInsurance += accSurcharge[accidents];
			System.out.println("Additional surcharge for 5 accidents: " + 575 + " \nTotal amount to pay: "
					+ (this.basicInsurance + this.ageSurcharge)); // Pay 1075 or 1175
			return this.basicInsurance;
		default:
			System.out.println("No insurance for greater than 5 accidents.");
			return -1;
		}

	}

	// getters and setters generated for private variables accessed in tests

	public int getAgeSurcharge() {
		return ageSurcharge;
	}

	public int[] getAccSurcharge() {
		return accSurcharge;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGreeting() {
		return greeting;
	}

}