package com.revature.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExamples {

	
	static Map <String,String> favoriteCars;
	
	public static void show() {
		
		favoriteCars  = new HashMap<String, String>();
		
		
		
		favoriteCars.put("Jacob", "Doge Dart LTd");
		favoriteCars.put("Brandy", "Punchbug");
		favoriteCars.put("Mohammed", "Range Rover");
		
		String name = "Jacob";
		String faveCar = favoriteCars.get(name);
		
		System.out.println(faveCar);
		
		//We can get a set of all keys in theMap
		Set<String> keys = favoriteCars.keySet();
		
		//Which allows us to iterate through all elements in the map
		for(String s:keys) {
			//Do something to each String in favoriteCars
			 faveCar = favoriteCars.get(s);
			
			System.out.println(faveCar);
		}
	}
}
