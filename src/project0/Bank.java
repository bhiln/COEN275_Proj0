package project0;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	private ArrayList<BankAccount> bankAccounts;
	private final String bankDBFileName = "bankDB.csv";
	
	public BankAccount login() {
		System.out.print("Enter your bank account number: ");
		Scanner sc = new Scanner(System.in);
		BankAccount foundBA = null;
        int bankAccount = Integer.parseInt(sc.nextLine());
        
        for (BankAccount ba : this.bankAccounts) {
        	if (ba.getAccountNum() == bankAccount) {
        		int tries = 0;
        		System.out.print("Enter your pin: ");
        		int pin = Integer.parseInt(sc.nextLine());
        		if (ba.hasCorrectPin(pin)) {
        			System.out.print("Hello " + ba.getAccountHolderName() + "!");
        			foundBA = ba;
        		}
        		else {
        			tries++;
        			if (tries == 3) {
        				System.out.println("Incorrect pin. Goodbye.");
        			}
        			else {
        				System.out.println("Incorrect pin. Please try again...");
        			}
        		}
        	}
        }
        return foundBA;
	}
}
