package com.revature.inheritance;

// I am the child class
public class Dog extends Pet {

	String color;
	String hairLength;
	
	
	//this method overrides our sleep method 
	//in the parent Pet class
	public void sleep() {
		System.out.println("I am trying to sleep");
	}
	
	//this method is overloading the parents treats method
	
	public void treats(String treats, String food) {
		System.out.println("my pet likes " + treats + " and " + food);
	}
}
