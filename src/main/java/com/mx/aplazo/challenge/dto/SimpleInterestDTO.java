package com.mx.aplazo.challenge.dto;

public class SimpleInterestDTO {

	private double amount;
	private Integer terms;
	private double rate;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Integer getTerms() {
		return terms;
	}
	public void setTerms(Integer terms) {
		this.terms = terms;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		return "SimpleInterestDTO [amount=" + amount + ", terms=" + terms + ", rate=" + rate + "]";
	}
	
	
	
	
}
