package com.revature.inheritance;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		//creates an instance of the class DOg and we name it a 
		//beagle
		Dog beagle = new Dog();
		
		beagle.color = "brown";
		beagle.size = "small";
		beagle.hairLength = "short";
		beagle.sound = "bark bark";
		
		System.out.println("the beagle is " +
		beagle.color + " and " + beagle.size);
		
		Cat tabby = new Cat();
		
		tabby.color = "brown";
		tabby.favoriteFood = "tuna";
		tabby.size = "small";
		tabby.sound = "meow meow";
		
		System.out.println("the cat is " + tabby.size);
		
		beagle.sleep();
		tabby.sleep();
		
		//this calls our overloaded method
		beagle.treats("beggin strips", "kibble");
		
		//this calls the method that is not overloaded from the
		//parent
		beagle.treats("bacon");
	}

}
