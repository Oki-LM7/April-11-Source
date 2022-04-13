package com.revature.app;

public class Animal {
	
	
	String color;
	int amountOfLegs;
	String  sound;
	String coat;
	
	//method to be overided
	void makeNoise() {
		System.out.println("hi");
	}
	
	
	//method to be overlaoded
	     void Fetch(/*different parameters*/){
	    	  
	    	 //something
	    	 System.out.println("animal brought back nothing");
	      }


		@Override
		public String toString() {
			return "Animal [color= " + color + ", amountOfLegs= " + amountOfLegs + ", sound= " + sound + ", coat= " + coat
					+ "]";
		}
	     
	     
	

}
