package com.kelsey.dl;

public class PokemonTrainerDAO {

	//created a method using the PokeMon model
	public static PokemonTrainer addTrainer() {
		
		//this line initializes an instance of the PokemonTrainer
		//model class
		
		PokemonTrainer pokemonTrainer = new PokemonTrainer();
		pokemonTrainer.firstName = "Kelsey";
		pokemonTrainer.lastName = "Morrison";
		pokemonTrainer.typeFavorite = "dragon";
		pokemonTrainer.badges = 2;
		
		System.out.println(pokemonTrainer);
		return  pokemonTrainer;
		
	}
}
