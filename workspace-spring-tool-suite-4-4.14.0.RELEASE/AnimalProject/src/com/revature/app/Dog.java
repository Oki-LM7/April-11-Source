package com.revature.app;

public class Dog extends Animal {
	
	String breed;

	//overidded
	void makeNoise() {
		System.out.println("bark bark");
	}
	
	//overloaded
	//method to be overlaoded
    void Fetch(int numberOfTimes){
   	  
    	//something else
    	System.out.println("dog fetched " + numberOfTimes + " times");
     }
    
    void breed() {
    	System.out.println(breed);
    }

	@Override
	public String toString() {
		return "Dog [breed = " + breed + ", color = " + color + ", amountOfLegs = " + amountOfLegs + ", sound = " + sound
				+ ", coat = " + coat + "]";
	}
    
   
}
