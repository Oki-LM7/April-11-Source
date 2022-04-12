package com.kelsey.dl;

public class PokemonTrainer {

	//these are the attributes for our PokemonTrainer object
	 String firstName;
	  String lastName;
	 int age;
	  String typeFavorite;
	 int badges;
	 
	 //this allows use to print the sting in a human readable format
	@Override
	public String toString() {
		return "PokemonTrainer [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", typeFavorite="
				+ typeFavorite + ", badges=" + badges + "]";
	}
	
	
}
