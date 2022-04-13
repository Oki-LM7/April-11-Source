package com.revature.inheritance;

//I am the parent class
public class Pet {

	//these are attribute of the Pet class
	static String size = "small";
	String sound;
	
	//This method is overridden in the child class
	public void sleep() {
		System.out.println("zzz");
	}
	
	
	//this method will be overloaded
	
	public void treats(String treats) {
		System.out.println("my pet likes " + treats);
	}
}
