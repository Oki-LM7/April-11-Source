package com.revature.otherPackage;

public class Child  extends Parent{
	
	public void testVisibility() {
		
		//privateInt = 10; Never visible
		protectedInt = 6; //Visible because its a child in the 
		//same package as the parent
		defaultInt = 9; //Visible because its a child in the 
		//same package as the parent
		publicInt = 11; //Always Visible
	}
  
} 
