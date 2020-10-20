package com.meritamerica.assignment3;
import java.text.ParseException;

public class MeritAmericaBankApp {
	public static void main(String[] args) throws ParseException {
		try {
			MeritBank.readFromFile("src/test/testMeritBank_good.txt");
			MeritBank.writeToFile("test.txt");
			System.out.println("Hello Merit America!");
			AccountHolder accountHolder = new AccountHolder(
		        	"Sadiq",
		        	"",
		        	"Manji",
		        	"123456789");
			System.out.println(accountHolder.getFirstName());
			System.out.println(accountHolder.getMiddleName());
			System.out.println(accountHolder.getLastName());
			System.out.println(accountHolder.getSSN());
			System.out.println(accountHolder.getNumberOfCDAccounts());
			System.out.println(accountHolder.getNumberOfCheckingAccounts());
			System.out.println(accountHolder.getNumberOfSavingsAccounts());
			System.out.println(accountHolder.getCombinedBalance());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}	
/*	public static CDOffering[] initialCDOfferings() {
		CDOffering[] cdOfferings = new CDOffering[5];
		cdOfferings[0] = new CDOffering(1, 1.8 / 100);
		cdOfferings[1] = new CDOffering(2, 1.9 / 100);
		cdOfferings[2] = new CDOffering(3, 2.0 / 100);
		cdOfferings[3] = new CDOffering(5, 2.5 / 100);
		cdOfferings[4] = new CDOffering(10, 2.2 / 100);

		return cdOfferings;
	}
	
}*/