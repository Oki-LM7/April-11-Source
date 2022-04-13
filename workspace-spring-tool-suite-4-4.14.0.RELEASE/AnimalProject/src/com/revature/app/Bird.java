package com.revature.app;

public class Bird extends Animal {
	
	//will be feathers
	int flightHeight;

	//overidded
		void makeNoise() {
			System.out.println("tweet tweet");
		}
		
		//overloaded
		//method to be overlaoded
	    void Fetch(int numberOfTimes){
	   	  
	    	//something else
	    	System.out.println("bird fetched " + numberOfTimes + " times");
	     }
	    
	    void flightHeight() {
	    	System.out.println(flightHeight);
	    }

		@Override
		public String toString() {
			return "Bird [flightHeight = " + flightHeight + ", color = " + color + ", amountOfLegs = " + amountOfLegs
					+ ", sound = " + sound + ", coat = " + coat + "]";
		}
	    
	   
	
}
