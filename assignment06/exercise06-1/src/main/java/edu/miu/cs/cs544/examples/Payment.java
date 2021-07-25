package edu.miu.cs.cs544.examples;

import java.time.LocalDate;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@NoArgsConstructor @Getter @Setter 
@ToString
public class Payment {
	private LocalDate payDate;
	private double amount;
	
	public Payment(LocalDate payDate, double amount) {
		this.payDate = payDate;
		this.amount = amount;
	}
}
