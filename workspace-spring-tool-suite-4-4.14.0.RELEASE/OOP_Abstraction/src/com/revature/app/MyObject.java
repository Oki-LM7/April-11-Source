package com.revature.app;


/*
 * When a class implements an interface, it promises to implement 
 * meaning that it promises to write a body for every abstract 
 * method in the implemented interface
 * 
 * When a class extends an abstract class, it promises to also
 * implement any abstract methods, and inherits all implemented 
 * methods and variables
 * 
 * While you can only extend one class (including abstract and
 * concrete classes), you can implement unlimited interfaces!
 * 
 * You do this if you are trying to tell future developers how 
 * to use your class.
 * 
 * This is creating a parent child/relationship
 */


public class MyObject extends MyAbstractClass 
implements MyInterface {

	//this method comes from MyInterface
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		
	}
     
	//this method implements MyAbstractClass
	@Override
	public void implementMe() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
