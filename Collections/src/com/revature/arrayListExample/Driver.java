package com.revature.arrayListExample;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		MyArrayList<String> arrayList = new MyArrayList<String>();
		
		//add methods
		System.out.println("add methods: ");
		arrayList.add("element one");
		arrayList.add("element two");
		arrayList.add("element three");
		arrayList.add("element four");
		arrayList.add("element five");
		arrayList.add("element six");
		arrayList.add("element seven");
		arrayList.add("element eight");
		arrayList.add("element nine");
		arrayList.add("element ten");
		arrayList.add("element one");
		arrayList.add("element eleven");
		
		//print
		arrayList.printArrayList();
		
		
		System.out.println(" ");
		System.out.println(" ");
		//get methods
		System.out.println("get methods: ");
		arrayList.printElement(7);
		
		
	}

}
