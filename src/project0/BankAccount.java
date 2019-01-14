package project0;

public class BankAccount {
	private int accountNum;
	private int pinNum;
	private double savingsBal;
	private double checkingsBal;
	private String accountHolderName;
	private boolean hasCheckings;
	
	public BankAccount(int an, int pn, double sb, String ahn){
		this.accountNum = an;
		this.pinNum = pn;
		this.savingsBal = sb;
		this.accountHolderName = ahn;
		this.hasCheckings = false;
	}
	
	public BankAccount(int an, int pn, double sb, double cb, String ahn, boolean hc){
		this.accountNum = an;
		this.pinNum = pn;
		this.savingsBal = sb;
		this.checkingsBal = cb;
		this.accountHolderName = ahn;
		this.hasCheckings = true;
	}
	
	public int getAccountNum() {
		return this.accountNum;
	}
	
	public String getAccountHolderName() {
		return this.accountHolderName;
	}
	
	public double getSavingsBalance() {
		return this.savingsBal;
	}
	
	public void setSavingsBalance(double savingsBal) {
		if (!this.hasCheckingsAccount()){
			throw new UnsupportedOperationException("Account holder does not have a checking account.");
		}
		this.savingsBal = savingsBal;
	}
	
	public double getCheckingsBalance() {
		if (!this.hasCheckingsAccount()){
			throw new UnsupportedOperationException("Account holder does not have a checking account.");
		}
		return this.checkingsBal;
	}
	
	public void setCheckingsBalance(double checkingsBal) {
		this.checkingsBal = checkingsBal;
	}
	
	public boolean hasCheckingsAccount() {
		return this.hasCheckings;
	}
	
	public boolean hasCorrectPin(int enteredPinNum) {
		return (this.pinNum == enteredPinNum);
	}
	
	public String printCSV() {
		String csv = this.accountNum + ',' +
					 this.pinNum + ',' +
					 this.savingsBal + ',' +
					 this.checkingsBal + ',' +
					 this.accountHolderName + ',' +
					 String.valueOf(this.hasCheckings);
		return csv;
	}
}
