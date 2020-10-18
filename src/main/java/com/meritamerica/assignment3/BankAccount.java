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
		public double interestRate = 0;
		private static double balance;
		private static long accountNumber;
		private static long accountNum = 1000;
		private static java.util.Date accountOpenedOn;

		public BankAccount() {
			accountNum = accountNum + 1;
			BankAccount.accountNumber = accountNum;
		}

		public BankAccount(double openingBalance) {
			BankAccount.balance = openingBalance;
			this.interestRate = this.getInterestRate();
		}

		public BankAccount(double interestRate, double balance) {
			BankAccount.balance = balance;
			this.interestRate = this.getInterestRate();

		}

		public BankAccount(long accountNumber, double interestRate, double balance) {
			BankAccount.accountNumber = accountNumber;
			this.balance = balance;
		}

	// Made accountOpenedOn static and created getters and setters
		public BankAccount(double interestRate, double balance, java.util.Date accountOpenedOn) {
			this.interestRate = interestRate;
			this.balance = balance;
			this.accountOpenedOn = accountOpenedOn;

		}

		public BankAccount(long accountNumber, double interestRate, double balance, java.util.Date accountOpenedOn) {
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
				
			} catch(FileNotFoundException ex11) {
				System.out.println("Error: file not found.");
			} catch (IOException ex1) {
				System.out.println("Error: incorrect input / output!");
			}
		// not sure what to return hear
			return obj;
			
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
					accountData = obj.toString();
				}

		// there is a syntax error: Identifier expected.. will have to get help tomorrow in regards to this
		} catch (FileNotFoundException ex) {
			System.out.println("Error: File not found!");
		} catch (IOException ex) {
			System.out.println("Error: Input / output error!"); 
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
		public String writeToString() {
	
			return this.toString();
		}

		public double futureValue(int years) {

			return balance * (Math.pow(1 + getInterestRate(), years));
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

		BankAccount.balance = getBalance() - amount;
		return true;
		}

		public boolean deposit(double amount) {
			if (amount < 0) {
				System.out.println("You may not deposit a negative amount.");
				return false;
		}

		BankAccount.balance = getBalance() + amount;
			return true;
		}

		public double getInterestRate() {
			System.out.println("Interest rate: " + interestRate);
			return this.interestRate;
		}

		public static double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			BankAccount.balance = balance;
		}

		public long getAccountNumber() {
			return accountNumber;
		}
		
		public String toString() {

			String string = "";
			
			string += ("Checking Account Balance: " + displayInUSD(getBalance()) + "\n" + 
					"Checking Account Interest Rate : " + String.format("%.5f", getInterestRate()) + " \n" +
					"Checking Account Balance in 3 years: " + displayInUSD(futureValue(3)) + "\n");
			
			return string;
		}

	/*
	 * returns the specified decimal formatted in United States Dollar
	 */
	public static String displayInUSD(double decimal) {
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
