package revature.MavenExample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	MyClass mc = new MyClass();
	//@Test annotation marks a method as a test method to run the test runner
	//a test runner is a program that runs test methods and reports the results
	
	//Tests if the new My Class mc Object is null
    @Test
	public void firstTest() {
		
    	//checks for empty or null references
    	assertNotNull(mc);
	}
    
    @Test
    public void addTest() {
    	
    	int x = mc.add(5,8); //should = 13
    	
    	//asserting that the variable x is equal to 13
    	assertEquals(x,13);
    	
    	
    	assertNotEquals(x,0);
    	
    	//returns a boolean value
    	assertTrue(x==13);
    }
    
    @AfterEach
    public void afterEach() {
    	System.out.println("I am after each");
    }
    
    @BeforeEach
    public void beforeEach() {
    	System.out.println("I am before each");
    }
    
    @AfterAll
    public static void afterAll() {
    	   
    	 System.out.println("I am after all");
    	    
    }
    
    @BeforeAll
    public static void before() {
    	System.out.println("I am before all");
    }
    
 
}
