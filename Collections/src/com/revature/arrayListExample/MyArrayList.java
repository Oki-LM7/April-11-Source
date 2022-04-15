package com.revature.arrayListExample;

import java.lang.reflect.Array;

public class MyArrayList<T> {
	
	
   Object[] myArrayList = new Object[10] ;
   
   // to add things
   int numOfItems = 0;
   

   
   //add to the front
   void add(T elementToAdd) {
	   
	   //check if full
	   checkFullAndCopy();
	   
	   //add item to front
	   myArrayList[numOfItems]= elementToAdd;
	   
	   //increase number of items counter
	   numOfItems++;
   }
   
      public T get(int arrayIndex) {
    	  
    	  // check if index is inside the array
    	  if(arrayIndex > myArrayList.length) {
    		  
    		  //return the last element if the index is to big
    		  return (T) myArrayList[myArrayList.length-1];
    	  }
	   
    	  //if the index is not too big then return the right element
	   return (T) myArrayList[arrayIndex];
   }
   
   void checkFullAndCopy() {
	   
	   //see if numOfItems is equal to arrays size
	   
	   if(numOfItems == myArrayList.length) {
		   
		   //increase by one if you have meet the full capacity
		   Object[] increased = new Object[myArrayList.length+1];
		   
		   // copy everything into the new array
		   for (int i = 0; i < myArrayList.length; i++) {     
	            increased[i] = myArrayList[i];     
	        } 
		   
		   //set old array to new array
		   
		   myArrayList = increased;
		 
				   
		    
		   
	   }else
	   {
		 //do nothing since its not full yet
		   System.out.print("not full ");
		   
	   }
   }
	   void printArrayList() {
		   
		   for(Object element : myArrayList) {
			   System.out.println(element.toString());
		   }
	   }
	   
	   void printElement(int arrayIndex) {
		   
		   //get element
		  T element = get(arrayIndex);
		  
		  System.out.println(element);
	   }
	   
       
   

}
