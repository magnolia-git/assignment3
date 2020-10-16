package com.meritamerica.assignment3;

//import com.meritamerica.assignment1.BankAccount;

	public class CheckingAccount extends BankAccount {
	
		private double interestRate = 0.0001;
	
		public CheckingAccount() {
			super();
		}
	
		public CheckingAccount(double openingBalance) {
			super(openingBalance);
		}
	
		public CheckingAccount(double openingBalance, double interestRate) {
			super(openingBalance, interestRate);
		}
	
		public CheckingAccount(long accountNumber, double openingBalance, double interestRate) {
			super(accountNumber, openingBalance, interestRate);
		}
		
		public CheckingAccount(long accountNumber, double openingBalance, double interestRate, java.util.Date accountOpenedOn) {
			super(accountNumber, openingBalance, interestRate, accountOpenedOn);
		}
		
		public static CheckingAccount readFromString(String accountData) throws ParseException {
			
		}
}