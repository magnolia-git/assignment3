package com.meritamerica.assignment3;

import java.lang.Math;
import java.sql.Date;
import java.text.ParseException;

	public class SavingsAccount extends BankAccount {
		
		public SavingsAccount(double openingBalance) {
			super(openingBalance);
		}

		public double getInterestRate() {return 0.01;}
		
		public static SavingsAccount readFromString(String accountData) throws ParseException {
			return null;
		}
}