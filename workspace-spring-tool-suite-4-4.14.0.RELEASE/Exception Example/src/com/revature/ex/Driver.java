package com.revature.ex;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		try {
			
			int[] partyPokemon= {1,2,3,4,5,6};
			System.out.println(partyPokemon[8]);
		}
		
		//This is the exception that we want to catch
		//In this case we catch an exception and assign it to variable e
		catch(Exception e) {
			System.out.println("a party can only have 6 pokemon");
		}
		//the finally statment executes a line of code after the try/catch
		//block no matter what the result of the try/catch 
		 finally {
			 System.out.println("the finally statement has run succesfully");			
				}
		
		//this is our new scanner called userObj for getting user input
				Scanner userObj = new Scanner(System.in);
		//this prompts the user for an input
				System.out.println("How many pokemon are in your party?");
				
				
				//this line takes the next integer that the user inputs and assigns
				//that value to the party variable
				int party = userObj.nextInt();
				
				//we are passing the party variable as our parameter for the 
				//checkpartsize method
				MyException.checkPartySize(party);
				String myInput = "5";
				try {
				System.out.println("Who is your favorite Pokemon?");
				 myInput = userObj.nextLine();
				
				} catch(Exception e) {
				 System.out.println("the data entered is invalid please"
				 		+ "put a number");
				}
				
				System.out.println("My favorite pokemon is"+ myInput);
				
				
				userObj.close();
		 }
		
	}


