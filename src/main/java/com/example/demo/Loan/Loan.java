package com.example.demo.Loan;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Loan {
	Integer tenure;
	BigDecimal ticketSize;

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public BigDecimal getTicketSize() {
		return ticketSize;
	}

	public void setTicketSize(BigDecimal ticketSize) {
		this.ticketSize = ticketSize;
	}

}
