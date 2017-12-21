package com.example;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	CalculatorTest.class, 
	ShoppingCartTest.class,
	PayrollServiceTest.class
})
public class AllTests {

}
