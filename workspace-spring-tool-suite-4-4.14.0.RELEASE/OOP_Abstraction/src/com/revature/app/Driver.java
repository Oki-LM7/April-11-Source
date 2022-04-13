package com.revature.app;

import java.util.Arrays;

public class Driver {
	
	/*
	 * Abstraction-Removing the implementation detail from a
	 * problem and focusing on the interaction between systems
	 * 
	 * Classical examples include steering wheel in cars and 
	 * electrical outlets using electric plugs
	 * 
	 * In java, we have two tools for implementing Abstraction
	 * 1.Interface, which describe which elements should be 
	 * implemented but not how.Also a way to communicate between
	 * developers
	 * 
	 * 
	 * 2.Abstract Classes, which define methods to be inherited but 
	 * but cannot be instantiated
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vehicle a = new Vehicle();
		Vehicle b = new Vehicle();
		Vehicle c = new Vehicle();
		
		a.make = "Honda";
		a.model = "Accord";
		a.year = "2000";
		
		b.make = "Hyundai";
		b.model = "Elantra";
		b.year = "2011";
		
		c.make = "Ford";
		c.model = "Ranger";
		c.year = "1997";
		
		Vehicle[] vehicles = new Vehicle[] {a,b,c};
		Arrays.sort(vehicles);
		System.out.println(Arrays.toString(vehicles));
 		
	}

}
