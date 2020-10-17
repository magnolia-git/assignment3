package com.meritamerica.assignment3;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

	public class BankAccount {
		private double interestRate;
		private double balance;
		private long accountNumber;
		private static long accountNum = 1000;
	
		public BankAccount() {
			accountNum = accountNum + 1;
			this.accountNumber = accountNum;
		}
	
		public BankAccount(double openingBalance) {this.balance = openingBalance;}
	
		public BankAccount(double interestRate, double balance) {
			super();
			this.interestRate = interestRate;
			this.balance = balance;
		}
	
	
		public BankAccount(long accountNumber, double interestRate, double balance) {
			super();
			this.accountNumber = accountNumber;
			this.interestRate = interestRate;
			this.balance = balance;
		}
		
		public BankAccount(double interestRate, double balance, java.util.Date accountOpenedOn) {
			super();
			
		}
		
		public BankAccount(long accountNumber, double interestRate, double balance, java.util.Date accountOpenedOn) {
			super();
		}
		
		public java.util.Date accountOpenedOn() {
			return null;
		}
		
		public java.util.Date getOpenedOn() {
			return null;
		}
		
		public static BankAccount readFromString(String accountData) throws ParseException {
			return null;
		}
		
		public String writeToString() {
			return null;
		}

		public double futureValue(int years) {
			double balance = getBalance();
			double interestRate = getInterestRate();
		
			return balance * (Math.pow(1 + interestRate, years));
		}
	
		public boolean withdraw(double amount) {
			if(amount < 0) {
				System.out.println("You may not withdraw a negative amount.");
				return false;
		}
			if(amount > getBalance()) {
				System.out.println("There is not enough money in the checking account "
					+ "to make this widrawal");
			return false;
		}
		
			this.balance = getBalance() - amount;
			return true;
		}
	
		public boolean deposit(double amount) {
			if(amount < 0) {
				System.out.println("You may not deposit a negative amount.");
				return false;
		}
		
			this.balance = getBalance() + amount;
			return true;
		}
	
	
		public double getInterestRate() {return interestRate;}
		public void setInterestRate(double interestRate) {this.interestRate = interestRate;}

		public double getBalance() {return balance;}
		public void setBalance(double balance) {this.balance = balance;}
	
		public long getAccountNumber() {return accountNumber;}


	
	
	@Override
	public String toString() {return generateStringForToString();}
	
	/*
	 * returns a string to be used in the toString method
	 */
	public String generateStringForToString() {
		StringBuilder str = new StringBuilder();
		
		str.append("Checking Account Balance: " + displayInUSD(getBalance()) + "\n");
		str.append("Checking Account Interest Rate : " + 
					String.format("%.5f", getInterestRate()) + " \n");
		str.append("Checking Account Balance in 3 years: " + 
					displayInUSD(futureValue(3)) + "\n");
		
		return str.toString();
	}
	
	/*
	 * returns the specified decimal formatted in United States Dollar
	 */
	public String displayInUSD(double decimal) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
		
		return formatter.format(decimal);
	}
	
	
	
}
