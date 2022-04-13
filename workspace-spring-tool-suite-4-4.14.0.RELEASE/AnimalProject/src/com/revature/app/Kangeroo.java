package com.revature.app;

public class Kangeroo extends Animal {
	
	// furr
	int kickIntensity;
	
	//overidded
		void makeNoise() {
			System.out.println("hop");
		}
		
		//overloaded
		//method to be overlaoded
	    void Fetch(int numberOfTimes){
	   	  
	    	//something else
	    	System.out.println("kagaroo fetched " + numberOfTimes + " times");
	     }
	    
	    void kickIntensity() {
	    	System.out.println(kickIntensity);
	    }

		@Override
		public String toString() {
			return "Kangeroo [kickIntensity = " + kickIntensity + ", color = " + color + ", amountOfLegs = " + amountOfLegs
					+ ", sound = " + sound + ", coat = " + coat + "]";
		}
	    
	   

}
