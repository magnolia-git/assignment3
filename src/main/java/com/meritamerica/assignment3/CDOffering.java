package com.meritamerica.assignment3;

import java.util.ArrayList;
import java.util.Arrays;

public class CDOffering {

		private static int term;
		private static double interestRate;
	
		public CDOffering()	{
		
		}
		public CDOffering(int term, double interestRate) {
			CDOffering.term = term;
			CDOffering.interestRate = interestRate;
		}
	

		public static int getTerm() {return term;}

		public static double getInterestRate() {return interestRate;}
		
		public static CDOffering readFromString(String cdOfferingDataString) {
			CDOffering cdOff;
			ArrayList<String> aL = new ArrayList<>(Arrays.asList(cdOfferingDataString.split(",")));
			cdOff = new CDOffering(Integer.parseInt(aL.get(0)), Double.parseDouble(aL.get(1)));
			return cdOff;
		}
		
		public String writeToString() {
			return term + "," + interestRate;
		}
}