package com.meritamerica.assignment3;

import java.lang.Math;
import java.sql.Date;
import java.text.ParseException;

	public class SavingsAccount extends BankAccount {
	
		private double interestRate = 0.01;
	
		public SavingsAccount() {
			super();
		}
		
		public SavingsAccount(double openingBalance) {
			super(openingBalance);
		}
	
		public SavingsAccount(double openingBalance, double interestRate) {
			super(openingBalance, interestRate);
		}
	
		public SavingsAccount(long accountNumber, double openingBalance, double interestRate) {
			super(accountNumber, openingBalance, interestRate);
		}
	
		public SavingsAccount(long accountNumber, double openingBalance, double interestRate, java.util.Date accountOpenedOn) {
			super(accountNumber, openingBalance, interestRate, accountOpenedOn);
		}
		
		public static SavingsAccount readFromString(String accountData) throws ParseException {
			return null;
		}
}