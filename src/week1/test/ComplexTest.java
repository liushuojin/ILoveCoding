package week1.test;

import  org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import week1.Complex;

public class ComplexTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		Complex c1 = Complex.valueOf(1, 2);
		Assert.assertEquals("1+2i", c1.toString());
		
		Complex c2 = Complex.valueOf(2, 3);
		Assert.assertEquals("2+3i", c2.toString());
		
		Complex r1 = c1.add(c2);
		Assert.assertEquals("3+5i", r1.toString());
		Assert.assertNotSame(r1, c1);
		Assert.assertNotSame(r1, c2);
		
		
		Complex r2 = c2.subtract(c1);
		Assert.assertEquals("1+1i", r2.toString());
		Assert.assertNotSame(r2, c1);
		Assert.assertNotSame(r2, c2);
	}

}
