package edu.miu.cs.cs544.examples;

import java.time.LocalDate;

public class Payment {
	private LocalDate payDate;
	private double amount;
	
	public Payment(LocalDate payDate, double amount) {
		this.payDate = payDate;
		this.amount = amount;
	}
	
}
