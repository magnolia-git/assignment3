package com.meritamerica.assignment3;

//import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java. util. ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

	public class BankAccount {
		private double interestRate;
		private double balance;
		private long accountNumber;
		private static long accountNum = 1000;
		private static java.util.Date accountOpenedOn;

		public BankAccount() {
			accountNum = accountNum + 1;
			this.accountNumber = accountNum;
		}

		public BankAccount(double openingBalance) {
			this.balance = openingBalance;
		}

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

	// Made accountOpenedOn static and created getters and setters
		public BankAccount(double interestRate, double balance, java.util.Date accountOpenedOn) {
			super();
			this.interestRate = interestRate;
			this.balance = balance;
			this.accountOpenedOn = accountOpenedOn;

		}

		public BankAccount(long accountNumber, double interestRate, double balance, java.util.Date accountOpenedOn) {
			super();
			this.accountNumber = accountNumber;
			this.interestRate = interestRate;
			this.balance = balance;
			this.accountOpenedOn = accountOpenedOn;
		}

// Not sure why there is a suppress warning, but the solution will work for both methods 
		public java.util.Date accountOpenedOn() {
			@SuppressWarnings("deprecation")
			Date format = new Date("MM-dd-yyyy");
			return format;
		}

		public java.util.Date getOpenedOn() {
			@SuppressWarnings("deprecation")
			Date format = new Date("MM-dd-yyyy");
			return format;
		}

		
		public static BankAccount writeToFile() throws IOException{
			BankAccount obj = new BankAccount();
			File input = new File("accounts.txt");
			try {
				FileOutputStream fos = new FileOutputStream(input);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(obj);	
				}
				
			} catch(FileNotFoundException ex11) {
				ex11.printStackTrace();
			} catch (IOException ex1) {
				ex11.printStackTrace();
		// not sure what to return hear
			return ;
			
		}
/* This is in the right direction I think, I believe what's missing is the conversion of the String accountData into  
 * an instance of BankAccount 
	*/
		public  static BankAccount readFromString(String accountData) throws ParseException {
			BankAccount obj = new BankAccount();
			File output = new File("accounts.txt");
			try {
				FileInputStream fis = new FileInputStream(output);
				ObjectInputStream ois = new ObjectInputStream(fis);
				ois.readObject();
				Vector<BankAccount> bankInput = (Vector<BankAccount>) ois.readObject();
				System.out.println(bankInput);
				ois.close();
				Iterator<BankAccount> iter = bankInput.iterator();
				while(iter.hasNext()) {
					BankAccount b = iter.next() ;
					accountData = BankAccount.toString();
				}
					
				}
		// there is a syntax error: Identifier expected.. will have to get help tomorrow in regards to this
		} catch (FileNotFoundException ex) {
			ex11.printStackTrace();
		} catch (IOException ex) {
			ex11.printStackTrace(); 
			}
		return accountData;
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
			if (amount < 0) {
				System.out.println("You may not withdraw a negative amount.");
				return false;
			}
			if (amount > getBalance()) {
				System.out.println("There is not enough money in the checking account " + "to make this widrawal");
				return false;
			}

		this.balance = getBalance() - amount;
		return true;
		}

		public boolean deposit(double amount) {
			if (amount < 0) {
				System.out.println("You may not deposit a negative amount.");
				return false;
		}

		this.balance = getBalance() + amount;
			return true;
		}

		public double getInterestRate() {
			return interestRate;
		}

		public void setInterestRate(double interestRate) {
			this.interestRate = interestRate;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public long getAccountNumber() {
			return accountNumber;
		}

		@Override
		public String toString() {
			return generateStringForToString();
		}

	/*
	 * returns a string to be used in the toString method
	 */
		public String generateStringForToString() {
			StringBuilder str = new StringBuilder();

		str.append("Checking Account Balance: " + displayInUSD(getBalance()) + "\n");
		str.append("Checking Account Interest Rate : " + String.format("%.5f", getInterestRate()) + " \n");
		str.append("Checking Account Balance in 3 years: " + displayInUSD(futureValue(3)) + "\n");

		return str.toString();
	}

	/*
	 * returns the specified decimal formatted in United States Dollar
	 */
	public String displayInUSD(double decimal) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

		return formatter.format(decimal);
	}

	public static java.util.Date getAccountOpenedOn() {
		return accountOpenedOn;
	}

	public static void setAccountOpenedOn(java.util.Date accountOpenedOn) {
		BankAccount.accountOpenedOn = accountOpenedOn;
	}

}
