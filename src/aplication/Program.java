package aplication;

import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		try {
		System.out.println("Enter account data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Holder: ");
		String holder = sc.next();
		System.out.print("Balance: ");
		Double balance = sc.nextDouble();
		System.out.print("Withdraw Limit: ");
		Double withdrawLimit = sc.nextDouble();
		
		Account account = new Account (number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Enter amout for withdraw: ");
		Double withdraw = sc.nextDouble();
		account.withdraw(withdraw);
		System.out.print("New balance: " + account.getBalance());
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected erro!");
		}
		
		sc.close();
		

	}

}
