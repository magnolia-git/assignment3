package com.meritamerica.assignment3;

	public class CDOffering {

		private int term;
		private double interestRate;
	
		public CDOffering()	{
		
		}
		public CDOffering(int term, double interestRate) {
			this.term = term;
			this.interestRate = interestRate;
		}
	

		public int getTerm() {return term;}

		public double getInterestRate() {return interestRate;}
		
		public static CDOffering readFromString(String cdOfferingDataString) {
			
		}
		
		public String writeToString() {
			
		}
}