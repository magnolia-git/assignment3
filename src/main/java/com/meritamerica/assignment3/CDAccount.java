package com.meritamerica.assignment3;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

	public class CDAccount extends BankAccount {
	
		private CDOffering offering;
//		private double balance;
	
		public CDAccount(CDOffering offering, double balance) {
			super(balance);
			this.offering = offering;
//			this.balance = balance;
		}
		
		public CDAccount(CDOffering offering, double balance, java.util.Date accountOpenedOn) {
			super(balance);
			
		}
	
		public double getInterestRate() {return offering.getInterestRate();}
	
		public int getTerm() {return offering.getTerm();}
	
		public Date getStartDate() {Date date = new Date();return date;}
	
		public long getAccountNumber() {return getAccountNumber();}
	
		public double futureValue() {return futureValue();}
		
		@Override
		public boolean deposit(double amount) {
			return false;
		}
		
		@Override
		public boolean withdraw(double amount) {
			return false;
		}
		
		public static CDAccount readFromString(String accountData) throws ParseException {
			
		}
		
		@Override
		public String writeToString() {
			
		}
}