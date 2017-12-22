package com.example;

public class PayrollService {

	public double hra(double salary) {
		return salary * .40;
	}

	public double da(double salary) {
		return salary * .10;
	}

	public double ta(double salary) {
		return salary * .20;
	}

}