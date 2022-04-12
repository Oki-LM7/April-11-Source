package com.revature.app;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		int[] listOfNumbers = new int[10];
		//Arrays are fixed length; if you need a bigger size you
		//need to make a new array
		
		//The below sets the first element of listOfNumbers to 15
		listOfNumbers[0] = 15 ; 
		
		// Arrays are zero-indexed, or start at 0 and go up.
		// The first element has an index of 0
		
		
		/*
		 * 
		 * for(counter starts at 0; counter meets some condition;
		 * increase counter{do something for ever loop}
		 */
		
		// Sets a value for every element in lisOfNumbers
		
		
		for(int iteration = 0; iteration< listOfNumbers.length; 
				++iteration) {
			listOfNumbers[iteration] = iteration;
			
		}
		
		for(int element : listOfNumbers) {
			Driver.doubleValueAndPrint(element, element);
		}
			
		
		//this method multiplies the given value by 2 and then prints it
	}
		public static void doubleValueAndPrint(/*This is an integer
		parameter*/ int value, int multiplier) {
			
			System.out.println(value*multiplier);
			
		}
		
		//If 
		
		public static void doubleValueAndPrint(/*This is an integer
				parameter*/ int value) {
			
			System.out.println(value*2);
					
				}
		
		
	

		 
	}


