package com.revature.app;

public class Snake extends Animal {

	int length;
	
	
	//overidded
		void makeNoise() {
			System.out.println("hiss hiss");
		}
		
		//overloaded
		//method to be overlaoded
	    void Fetch(int numberOfTimes){
	   	  
	    	//something else
	    	System.out.println("snake fetched " + numberOfTimes + " times");
	     }
	
	    
	    void length() {
	    	System.out.println(length);
	    }

		@Override
		public String toString() {
			return "Snake [length= " + length + ", color= " + color + ", amountOfLegs= " + amountOfLegs + ", sound="
					+ sound + ", coat= " + coat + "]";
		}
	    
	  
	    
}
