package model.application;

import java.util.Locale;
import java.util.Scanner;

import model.AccontExcepition.BusinessException;
import model.entities.Accont;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter accont data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		System.out.print("Initital balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();

		Accont accont = new Accont(number, holder, balance, withdrawLimit);
		System.out.println();
		sc.nextLine();
		
		System.out.print("Enter amount for withdraw: ");
		double withdraw = sc.nextDouble();
		
		try {
			accont.withdraw(withdraw);
			System.out.printf("New balance: %.2f" + accont.getBalance());

		} catch (BusinessException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}

}
