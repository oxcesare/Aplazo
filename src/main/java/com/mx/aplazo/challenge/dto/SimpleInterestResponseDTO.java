package com.mx.aplazo.challenge.dto;

public class SimpleInterestResponseDTO {

	private Integer payment_number;
	private double amount;
	private String payment_date;

	public Integer getPayment_number() {
		return payment_number;
	}

	public void setPayment_number(Integer payment_number) {
		this.payment_number = payment_number;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	@Override
	public String toString() {
		return "SimpleInterestResponseDTO [payment_number=" + payment_number + ", amount=" + amount + ", payment_date="
				+ payment_date + "]";
	}

}
