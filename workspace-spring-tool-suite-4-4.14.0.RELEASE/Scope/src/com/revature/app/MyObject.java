package com.revature.app;

public class MyObject {
	
	//static fields belong to the class and not any instance
	//so any change to a static field is reflected by all instances of 
	//the class
	//This is the CLASS scope
	 static String name = "My Object ";
	
	//Any non-static field will carry data only for each individual instance
	//This is known as a member field and is in the INSTANCE scope, as each
	// instance has its own copy
	public int number;
	
	// static methods can't access instance variables
	public void printName() {
		
		System.out.println(name + ": " + number);
	}
	
	public void growNumber() {
		//Any variables declared at the top level of a method are in METHOD
		//scope. So they belong to each unique invocation of the method
		//parameters are in the METHOD scope too
		int multiplier = 2;
		
		if(multiplier > 1) {
			
			//This variable is inBLOCK scope, and cannot be used outside
			//of this if block
			int y = multiplier*2;
			
			number+=y;
		}
	}
	
	//In order to use the below, args must first be set up with data
	public void testVarArgs(String...args) {
		
		for(String s: args) {
			System.out.println(s);
		}
	}
	
	//In contrast, var args allow us to  pass the data in 
	//directly as parameters
	public void testArray(String[]args) {
		
		for(String s: args) {
			System.out.println(s);
		}
	}

}
