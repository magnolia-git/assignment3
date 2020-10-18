package com.meritamerica.assignment3;

//import java.util.Arrays;
import java.util.Random;

public class MeritBank {

	private static AccountHolder[] accountHolders;
	private static CDOffering[] cdOfferings;

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
		long x = 0;

		return x;
	}

	public static double totalBalances() {
		double totalBalance = 0;

		return totalBalance;
	}
	
	public static boolean readFromFile(String fileName) {
		return true;
	}
	
	public static boolean writeToFile(String fileName) {
		return true;
	}
	
	public static AccountHolder[] sortAccountHolders() {
		return null;
	}
	
	public static void setNextAccountNumber(long nextAccountNumber) {
		
	}

}
