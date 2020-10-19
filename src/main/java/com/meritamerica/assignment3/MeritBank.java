package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MeritBank {

	private static AccountHolder[] accountHolders;
	private static CDOffering[] cdOfferings;
	static long masterAccountNumber = 000000000;

	public static void addAccountHolder(AccountHolder accountHolder) {
		AccountHolder[] newArray = new AccountHolder[1];
		newArray[0] = accountHolder;
		accountHolders = newArray;
	}

	public static AccountHolder[] getAccountHolders() {
		return accountHolders;
	}

	public static CDOffering[] getCDOfferings() {

		return cdOfferings;
	}

	public static CDOffering getBestCDOffering(double depositAmount) {
		CDOffering offering = new CDOffering();

		return offering;
	}

	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		CDOffering offering = new CDOffering();

		return offering;
	}

	public static void clearCDOfferings() {
		if (getCDOfferings() != null) {
			for (int i = 0; i < cdOfferings.length; i++) {
				cdOfferings[i] = new CDOffering();
			}
		}
	}

	public static void setCDOfferings(CDOffering[] offerings) {
		cdOfferings = new CDOffering[5];
		cdOfferings[0] = new CDOffering(1, 1.8 / 100);
		cdOfferings[1] = new CDOffering(2, 1.9 / 100);
		cdOfferings[2] = new CDOffering(3, 2.0 / 100);
		cdOfferings[3] = new CDOffering(5, 2.5 / 100);
		cdOfferings[4] = new CDOffering(10, 2.2 / 100);
	}

	static long getNextAccountNumber() {
		return masterAccountNumber;
	}

	public static double totalBalances() {
		double totalBalance = 0;

		return totalBalance;
	}
	
	public static boolean readFromFile(String fileName) {

		try {
			File input = new File(fileName);
			FileReader fileScan = new FileReader(fileName);
			BufferedReader bufferRead = new BufferedReader(fileScan);
			masterAccountNumber = Long.valueOf(bufferRead.readLine());		// Sets the masterAccountNumber to 11
			
			// Reads the line with the number of CDOfferings...
			CDOffering[] newOfferings = new CDOffering[Integer.valueOf(bufferRead.readLine())];
//			MeritBank.cdOfferings = new CDOffering[newOfferings.length];
			
			for (int i = 0; i < newOfferings.length; i++) {
				// Assigns 
				newOfferings[i] = CDOffering.readFromString(bufferRead.readLine());
			}
			MeritBank.cdOfferings = newOfferings;
			
			
			
			AccountHolder[] newAccountHolders = new AccountHolder[Integer.valueOf(bufferRead.readLine())];
			for (int i = 0; i < newAccountHolders.length; i++) {

				newAccountHolders[i] = AccountHolder.readFromString(bufferRead.readLine());

				CheckingAccount[] newCheckingAccounts = new CheckingAccount[Integer.valueOf(bufferRead.readLine())];
				for (int j = 0; j < newCheckingAccounts.length; j++) {
					newCheckingAccounts[j] = CheckingAccount.readFromString(bufferRead.readLine());
				}
				
				
				SavingsAccount[] newSavingsAccounts = new SavingsAccount[Integer.valueOf(bufferRead.readLine())];
				for (int j = 0; j < newSavingsAccounts.length; j++) {
					newSavingsAccounts[j] = SavingsAccount.readFromString(bufferRead.readLine());
				}
				
				CDAccount[] newCDAccounts = new CDAccount[Integer.valueOf(bufferRead.readLine())];
				for (int j = 0; j < newCDAccounts.length; j++) {
					newCDAccounts[j] = CDAccount.readFromString(bufferRead.readLine());
				}
			}
			MeritBank.accountHolders = newAccountHolders;
			

		} catch (FileNotFoundException ex) {
			System.out.println("Error: File not found!");
			return false;
		} catch (IOException ex) {
			System.out.println("Error: Input / output error!");
			return false;
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean writeToFile(String fileName) {
		return true;
	}
	
	public static AccountHolder[] sortAccountHolders() {
		AccountHolder[] sortedArray;
		sortedArray = MeritBank.accountHolders;
		Arrays.sort(sortedArray);
		return sortedArray;
	}
	
	public static void setNextAccountNumber(long nextAccountNumber) {
		nextAccountNumber = getNextAccountNumber() + 1;
	}

}
