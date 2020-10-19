package com.meritamerica.assignment3;

import java.io.BufferedReader;
//import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
		private double balance;
		protected static long accountNumber;
		private static java.util.Date accountOpenedOn;
		static private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		public BankAccount() {
			accountNumber++;
		}

		public BankAccount(double openingBalance) {
			accountNumber++;
			this.balance = openingBalance;
			this.interestRate = this.getInterestRate();
		}

		public BankAccount(double interestRate, double balance) {
			accountNumber++;
			this.balance = balance;
			this.interestRate = interestRate;

		}

		public BankAccount(long accountNumber, double interestRate, double balance) {
			accountNumber++;
			BankAccount.accountNumber = accountNumber;
			this.balance = balance;
		}

	// Made accountOpenedOn static and created getters and setters
		public BankAccount(double interestRate, double balance, java.util.Date accountOpenedOn) {
			accountNumber++;
			this.interestRate = interestRate;
			this.balance = balance;
			this.accountOpenedOn = accountOpenedOn;

		}

		public BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn) {
			this.accountNumber = accountNumber++;
			this.interestRate = interestRate;
			this.balance = balance;
			this.accountOpenedOn = accountOpenedOn;
		}

		public BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn,
				int term) {
			this.accountNumber = accountNumber++;
			this.balance = balance;
			this.interestRate = interestRate;
			this.accountOpenedOn = accountOpenedOn;
			// TODO Auto-generated constructor stub
		}

		public java.util.Date accountOpenedOn() {


			return accountOpenedOn;
		}

		public java.util.Date getOpenedOn() {
			
			return accountOpenedOn;
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
/*			BankAccount obj = new BankAccount();
			try {
				File input = new File(accountData);

				FileInputStream fis = new FileInputStream(input);
				ObjectInputStream ois = new ObjectInputStream(fis);
				ois.readObject();
				Vector<BankAccount> bankInput = (Vector<BankAccount>) ois.readObject();
				System.out.println(bankInput);
				ois.close();
				Iterator<BankAccount> iter = bankInput.iterator();
				while(iter.hasNext()) {
					BankAccount b = iter.next() ;
					String fileLine = obj.toString();
					System.out.println(fileLine);
			}

		// there is a syntax error: Identifier expected.. will have to get help tomorrow in regards to this
		} catch (FileNotFoundException ex) {
			System.out.println("Error: File not found!");
		} catch (IOException ex) {
			System.out.println("Error: Input / output error!"); 
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block/			e.printStackTrace();
		}
		return obj;*/
		return null;
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

		balance = getBalance() - amount;
		return true;
		}

		public boolean deposit(double amount) {
			if (amount < 0) {
				System.out.println("You may not deposit a negative amount.");
				return false;
		}

		balance = getBalance() + amount;
			return true;
		}

		public double getInterestRate() {
			return this.interestRate;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			balance = balance;
		}

		public long getAccountNumber() {
			return accountNumber++;
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
