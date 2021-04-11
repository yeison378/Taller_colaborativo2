package model;

import java.time.LocalDate;

public class Pays {
	private short numberPay;
	private double valuePay;
	private LocalDate datePay;

	public Pays(short numberPay, double valuePay, LocalDate datePay) {
		this.numberPay = numberPay;
		this.valuePay = valuePay;
		this.datePay = datePay;
	}

	public short getNumberPay() {
		return numberPay;
	}

	public void setNumberPay(short numberPay) {
		this.numberPay = numberPay;
	}

	public double getValuePay() {
		return valuePay;
	}

	public void setValuePay(double valuePay) {
		this.valuePay = valuePay;
	}

	public LocalDate getDatePay() {
		return datePay;
	}

	public void setDatePay(LocalDate datePay) {
		this.datePay = datePay;
	}

}
