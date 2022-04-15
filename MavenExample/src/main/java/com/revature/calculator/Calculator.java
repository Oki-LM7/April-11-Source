package com.revature.calculator;

import java.util.ArrayList;

public class Calculator {
	
	
	//break String down
	
	static String rightNumber;
	static String opperation;
	static String leftNumber;
	
	// convert String into numbers
	
	static int right;
	static int left;
	
	// To check if its an opperator
	static ArrayList<String> operators = new ArrayList<String>();
	
	//add operators
	public Calculator() {
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
		
	}
	
	public static double calculator(String equation) {
		double answer = 0;
		
		//look for operator
		
				lookForOperator(equation);
				
				//Convert Strings into numbers
				
				convertStrings();
				
				//Do opperations
				answer = doOpperations();
		
		
		return answer;
	}
	
	
		
		
			
	
		
		
	

     static void lookForOperator(String equation) {
    	
     for(int i = 0; i< equation.length(); i++) {
			
			//check if characters are numbers or operators
			
    	
			char possibleOperator = equation.charAt(i);
			if (operators.contains(String.valueOf(possibleOperator)) ) {
				
				 opperation  = String.valueOf(possibleOperator);
				 
				 //right number is everything before the operator
				 rightNumber = equation.substring(0, i);
				 
				 //left number is everything after the operator
				 leftNumber = equation.substring(i+1);
				
				 //end the loop
				 
				 System.out.println("rightNumber: " + rightNumber +  " " + "leftNumber" + leftNumber);
				
				break;
			}
    	
    }
     }
     
     
     static void convertStrings() {
    	 
    	 // remove anything thats not a number
    	 
    	  rightNumber = rightNumber.replaceAll("[^0-9]", "");
    	  leftNumber = leftNumber.replaceAll("[^0-9]", "");
    	  
    	  
    	  // convert String into numbers
    	   right = Integer.parseInt(rightNumber);
    	  
    	   left = Integer.parseInt(leftNumber);
    	  
    	
     }
	
	static double doOpperations() {
		
		switch (opperation) {
		
		case "+" : return right + left;
		case "-" : return right - left;
		case "*" : return right * left;
		default: return right/left;
		}
		
		//if addd do add
		
		// if minus do minus 
	}
	
	
	

}
