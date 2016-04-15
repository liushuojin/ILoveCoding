package week1.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import week1.ExpressionCalculator;

public class ExpressionEvaluationTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEvaluate() {
		ExpressionCalculator calculator = new ExpressionCalculator();
		
		
		Assert.assertEquals(7, calculator.evaluate("1+2*3" ), 0.01);
		
		Assert.assertEquals(36, calculator.evaluate("5*6+2*3" ), 0.01);		
		Assert.assertEquals(101.0, calculator.evaluate("(1+(2+3)*(4*5))" ), 0.01);
		
		
	}

}
