package com.revature.otherPackage;

public class OtherClass {

	public void testVisibility() {
		Parent p = new Parent();
		//p.privateInt = 9; // Never visible
		p.protectedInt = 6; //visible because this class shares a package
		//with Parent
		p.defaultInt = 7; //Also visible 
	}
	
}
