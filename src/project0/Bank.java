package project0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	private ArrayList<BankAccount> bankAccounts;
	private final String bankDBFileName = "bankDB.csv";
	
	public Bank(){
		this.bankAccounts = new ArrayList<BankAccount>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(bankDBFileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        scanner.useDelimiter(",");
        while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			BankAccount tempBA = null;
			String[] temp = line.split(",");
			if (temp.length == 4) {
				tempBA = new BankAccount(Integer.parseInt(temp[0]),
										 Integer.parseInt(temp[1]),
										 Double.parseDouble(temp[2]),
										 temp[3]);
			}
			else if (temp.length == 5) {
				tempBA = new BankAccount(Integer.parseInt(temp[0]),
						 				 Integer.parseInt(temp[1]),
						 				 Double.parseDouble(temp[2]),
						 				 Double.parseDouble(temp[3]),
						 				 temp[4],
						 				 true);
			}
			else {
				System.out.println("ERROR");
			}
			this.bankAccounts.add(tempBA);
        }
	}
	
	public BankAccount login() {
		System.out.print("Enter your bank account number: ");
		Scanner sc = new Scanner(System.in);
		BankAccount foundBA = null;
        int bankAccount = Integer.parseInt(sc.nextLine());
        
        for (BankAccount ba : this.bankAccounts) {
        	if (ba.getAccountNum() == bankAccount) {
        		int tries = 0;
        		while (tries < 3 && foundBA == null) {
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
        }
        return foundBA;
	}
}
