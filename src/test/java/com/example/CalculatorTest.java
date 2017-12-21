package com.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	Calculator calculator = null; 

	@Before
	public void init() {
		calculator = new Calculator();
		//System.out.println("Inside init()");
	}
	
	@After
	public void clean() {
		calculator = null;
		//System.out.println("Inside clean()");
	}
	

	@Test
	public void subtractingTwentyAndFiveShouldProduceFifteen() {
		//Calculator calculator = new Calculator();
		int rs = calculator.diff(20, 5);
		Assert.assertEquals(15, rs);
	}

	@Test
	public void subtractingTwentyAndNegativeFiveShouldProduceTwintyFive() {
		//Calculator calculator = new Calculator();
		int rs = calculator.diff(20, -5);
		Assert.assertEquals(25, rs);
	}

	@Test
	public void addingTwentyAndFiveShouldProduceTwentyFive() {
		//Calculator calculator = new Calculator();
		int rs = calculator.sum(20, 5);
		Assert.assertEquals(25, rs);
	}

	@Test
	public void addingTwentyAndNegativeFiveShouldProduceFifteen() {
		//Calculator calculator = new Calculator();
		int rs = calculator.sum(20, -5);
		Assert.assertEquals(15, rs);
	}

}