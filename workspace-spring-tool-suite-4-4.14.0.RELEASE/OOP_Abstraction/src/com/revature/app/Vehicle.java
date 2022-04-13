package com.revature.app;

public class Vehicle implements Comparable<Vehicle>{
  
	public String make;
	public String model;
	public String year;
	
	public String toString() {
		
		return year +" " + make + " " + model;
	}

	@Override
	public int compareTo(Vehicle other) {
		// TODO Auto-generated method stub
		return year.compareTo(other.year);
	}
}
