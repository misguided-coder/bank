package com.example;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PayrollServiceTest {

	PayrollService payrollService = null; 

	@Before
	public void init() {
		payrollService = new PayrollService();
	}
	
	@After
	public void clean() {
		payrollService = null;
	}
	

	@Test
	public void hraShouldBeFortyPercentOfSalary() {
		assertEquals(4000.00, payrollService.hra(10000.00),2);
	}

	
}