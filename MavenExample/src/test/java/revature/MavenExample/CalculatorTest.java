package revature.MavenExample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.calculator.Calculator;

public class CalculatorTest {
	
	Calculator cal = new Calculator();
	
	@Test
	public void addTest() {
		
		double x = cal.calculator("4+4");
		assertEquals(x,8.0);
	}
	
	@Test
	public void subTractTest() {
	double 	x = cal.calculator("  6- 4");
	  assertEquals(x,2.0);
	}
	
	@Test
	public void multiplyTest() {
		double 	x = cal.calculator("  2* 4");
		assertEquals(x,8.0);
	}
	
	@Test
	public void divideTest() {
		double 	x = cal.calculator("  8/ 4");
		assertEquals(x,2);
	}

}
