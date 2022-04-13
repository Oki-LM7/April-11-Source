package com.revature.app;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		Animal animal = new Animal();
		
		Dog dog = new Dog();
		Bird bird = new Bird();
		Kangeroo roo = new Kangeroo();
		Snake snake = new Snake();
		
		//coat attributes
		dog.coat = "furr";
		bird.coat = "feathers";
		roo.coat = "furr";
		snake.coat = "scales";
		
		//leg attributes
		dog.amountOfLegs = 4;
		bird.amountOfLegs = 2;
		roo.amountOfLegs = 2;
		snake.amountOfLegs = 0;
		
		//color attributes
		dog.color = "brown";
		bird.color = "blue";
		roo.color = "brown";
		snake.color = "green";
		
		//sound attributes
		dog.sound = "bark";
		bird.sound = "tweet";
		roo.sound = "hop";
		snake.sound = "hiss";
		
		//animal unique attributes
		dog.breed = "beagle";
		bird.flightHeight = 9;
		roo.kickIntensity = 8;
		snake.length = 7;
		
		//Print Animals
		
		System.out.println(dog);
		System.out.println(bird);
		System.out.println(roo);
		System.out.println(snake);
		
		
		
		//overrided methods
		
		animal.makeNoise();
		dog.makeNoise();
		bird.makeNoise();
		roo.makeNoise();
		snake.makeNoise();
		
		
		
		//overloaded methods
		animal.Fetch();
		dog.Fetch(5);
		bird.Fetch(4);
		roo.Fetch(8);
		snake.Fetch(0);
		
	}

}
