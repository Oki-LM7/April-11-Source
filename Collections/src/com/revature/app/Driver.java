package com.revature.app;

import com.revature.generic.MyGenericClass;
import com.revature.iterator.IteratorExamples;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          
		
		//ListExample le = new ListExample();
		
		//le.show();
		
		//QueueExamples.show();
		
		//SetExamples.show();
		
		//MapExamples.show();
		
		//IteratorExamples.show();
		
		MyGenericClass<Object> objectGeneric = new MyGenericClass<Object>(
				new Object());
		
		objectGeneric.showPayload();
		
		MyGenericClass<String> stringGeneric = new MyGenericClass<String>(
				"Hello");
		
		stringGeneric.showPayload();
	}

}
