package com.meritamerica.assignment3;

//import java.util.Arrays;

//import com.meritamerica.assignment2.CDAccount;
//import com.meritamerica.assignment2.CDOffering;
//import com.meritamerica.assignment2.CheckingAccount;
//import com.meritamerica.assignment2.SavingsAccount;

	public class AccountHolder implements Comparable<AccountHolder> {
		public static final long MAX_ALLOWED = 250000;
		private String firstName;
		private String middleName;
		private String lastName;
		private String ssn;

		private CheckingAccount[] checkingAccounts = new CheckingAccount[0];
		private SavingsAccount[] savingsAccounts = new SavingsAccount[0];
		private CDAccount[] cdAccounts = new CDAccount[0];

	
/*		public AccountHolder() {
			this.firstName = "";
			this.middleName = "";
			this.lastName = "";
			this.ssn = "";

//			this.checkingAccounts = new CheckingAccount[0];
//			this.savingsAccounts = new SavingsAccount[0];
//			this.cdAccounts = new CDAccount[0];
		}*/

		public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
			super();
				this.firstName = firstName;
				this.middleName = middleName;
				this.lastName = lastName;
				this.ssn = ssn;
		}
		
// getters and setters
		
		public String getFirstName() {return this.firstName;}
		public void setFirstName(String firstName) {this.firstName = firstName;}

		public String getMiddleName() {return this.middleName;}
		public void setMiddleName(String middleName) {this.middleName = middleName;}

		public String getLastName() {return this.lastName;}
		public void setLastName(String lastName) {this.lastName = lastName;}

		public String getSSN() {return this.ssn;}
		public void setSsn(String ssn) {this.ssn = ssn;}

		public CheckingAccount[] getCheckingAccounts() {return this.checkingAccounts;}
		public void setCheckingAccount(CheckingAccount[] checkingAccount) {this.checkingAccounts = checkingAccount;}

		public SavingsAccount[] getSavingsAccounts() {return this.savingsAccounts;}
		public void setSavingsAccount(SavingsAccount[] savingsAccount) {this.savingsAccounts = savingsAccount;}
		
// method that calls the SavingsAccount class and creates array of savings accounts
		
		public SavingsAccount addSavingsAccount(double openingBalance) {
			SavingsAccount newname = new SavingsAccount(openingBalance);
			
			if(getCombinedBalance() + openingBalance >= MAX_ALLOWED) {
				System.out.println("You have reached the maximum total balance across all accounts. Cannot create another.");
				return null;
			} else {
				return addSavingsAccount(newname);
			}
		}

		public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
			if(getCombinedBalance() + savingsAccount.getBalance() >= MAX_ALLOWED) {
				System.out.println("You have reached the maximum total balance across all accounts. Cannot create another.");
				return null;
			} else {
				SavingsAccount[] newArray = new SavingsAccount[savingsAccounts.length + 1];
				int i;
				for (i = 0; i < savingsAccounts.length; i++) {
					newArray[i] = savingsAccounts[i];
				}
				newArray[i] = savingsAccount;
				savingsAccounts = newArray;
				return savingsAccount;
			}
		}
		
		public double getSavingsBalance() {
		SavingsAccount[] currentSavingsAccount = getSavingsAccounts();
		double savingsBalance = 0;
		if (currentSavingsAccount != null) {
			for (int i = 0; i < currentSavingsAccount.length; i++) {
				savingsBalance = savingsBalance + currentSavingsAccount[i].getBalance();
			}
		}

		return savingsBalance;
	}
		
// method that calls the CheckingAccount class and creates array of savings accounts
		public CheckingAccount addCheckingAccount(double openingBalance) {
			CheckingAccount newname = new CheckingAccount(openingBalance);
			
			if(getCombinedBalance() + openingBalance >= MAX_ALLOWED) {
				System.out.println("You have reached the maximum total balance across all accounts. Cannot create another.");
				return null;
			} else {
			return addCheckingAccount(newname);
			}
			
		}

		public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
			if(getCombinedBalance() + checkingAccount.getBalance() >= MAX_ALLOWED) {
				System.out.println("You have reached the maximum total balance across all accounts. Cannot create another.");
				return null;
			} else {
				CheckingAccount[] newArray = new CheckingAccount[checkingAccounts.length + 1];
				int i;
				for (i = 0; i < checkingAccounts.length; i++) {
					newArray[i] = checkingAccounts[i];
				}
			
				newArray[i] = checkingAccount;
				checkingAccounts = newArray;
			
				return checkingAccount;
			}
		}

		public double getCheckingBalance() {
		CheckingAccount[] currentCheckingAccount = getCheckingAccounts();
		double savingsBalance = 0;
		if (currentCheckingAccount != null) {
			for (int i = 0; i < currentCheckingAccount.length; i++) {
				savingsBalance = savingsBalance + currentCheckingAccount[i].getBalance();
			}
		}

		return savingsBalance;
	}

	
	

	public CDAccount[] getCDAccounts() {return cdAccounts;}
	

	
	// This first one creates a new CDAccount...
	
	public CDAccount addCDAccount(CDOffering offering, double openingBalance) {
	CDAccount newName = new CDAccount(offering, openingBalance);
	return addCDAccount(newName);
	}
	
	// ... and this second one adds it to the CDAccount array.
	
	public CDAccount addCDAccount(CDAccount cdAccount) {
		CDAccount[] newArray = new CDAccount[cdAccounts.length + 1];
		int i;
		for (i = 0; i < cdAccounts.length; i++) {
			newArray[i] = cdAccounts[i];
		}
		newArray[i] = cdAccount;
		cdAccounts = newArray;
		return cdAccount;
	}



	public double getCDBalance() {

		double sum = 0;

			for (int i = 0; i < cdAccounts.length; i++) {
				System.out.println(cdAccounts[i].getBalance());
				sum = sum + cdAccounts[i].getBalance();

			}
//		}
		return sum;
	}


	public double getCombinedBalance() {

		return getCheckingBalance() + getSavingsBalance() + getCDBalance();
	}

	public int getNumberOfCheckingAccounts() {
		int numberOfCheckingAccounts = 0;

		if (checkingAccounts == null) {
			return numberOfCheckingAccounts;
		} else {
			return checkingAccounts.length;
		}
	}

	public int getNumberOfSavingsAccounts() {
		int numberOfSavingsAccounts = 0;
		if (savingsAccounts == null) {
			return numberOfSavingsAccounts;
		} else {
			return savingsAccounts.length;
		}
	}

	public int getNumberOfCDAccounts() {
		int numberOfCDAccounts = 0;
		if (cdAccounts == null) {
			return numberOfCDAccounts;
		} else {
			return cdAccounts.length;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * returns the state of the object as a string.
	 */
	@Override
	public String toString() {
		return generateStringForToString();
	}

	
	private String generateStringForToString() {
		StringBuilder str = new StringBuilder();

		// append the name
		str.append("Name: " + getFirstName() + " " + getMiddleName() + " " + getLastName() + "\n");

		
		str.append("SSN: " + getSSN() + "\n");

		
		str.append(getCheckingAccounts().toString());

		// append savings account balance
		// append savings account interest rate
		// append the savings account balance in 3 years
		str.append(getSavingsAccounts().toString());

		// return the StringBuilder object as a string.
		return str.toString();
	}

	@Override
	public int compareTo(AccountHolder otherAccountHolder) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String writeToString() {
		return firstName + "," + middleName + "," + lastName + "," + ssn;
	}
	
	public static AccountHolder readFromString(String accountHolderData) throws Exception {
		String[] str = accountHolderData.split(",");
		return new AccountHolder(str[0],str[1], str[2], str[3]);
	}
	
}