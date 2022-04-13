package com.revature.app;

public interface MyInterface {

	 //interfaces may have variables
	//All variables are final in an interface
	//meaning that the variables cannot be changed during runtime
	public  int i =0;
	
	 
	 //interfaces may only have "abstract methods", 
	 // meaning that methods should have not body
	 public void doSomething();
	 
	 
	 // ...Unless we use the default keyword
	 
	 public default void doMoreThings() {
		 System.out.println("Do more things!");
	 }
}
