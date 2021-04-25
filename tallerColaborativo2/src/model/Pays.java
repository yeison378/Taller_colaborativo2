package model;

import java.time.LocalDate;
	/**
	 * Esta clase encapsula las características y comportamiento de la clase 'Credit' y 'Client'
	 * @version 1.0
	 * @author Grupo A
	 *
	 */
public class Pays {
	private short numberPay;
	private double valuePay;
	private LocalDate datePay;
	
	/**
	 * Constructor para 'Pagos'
	 * @param numberPay Define la clave para el pago
	 * @param valuePay Define el valor del pago
	 * @param datePay Define la fecha en que se realiza el pago
	 */
	public Pays(short numberPay, double valuePay, LocalDate datePay) {
		this.numberPay = numberPay;
		this.valuePay = valuePay;
		this.datePay = datePay;
	}
	
	/**
	 * Metodo get para la clave del pago
	 * @return El numberPay de un pago
	 */
	public short getNumberPay() {
		return numberPay;
	}
	
	/**
	 * Metodo set para la clave del pago
	 * @param numberPay Define el valor que tendra numberPay 
	 */
	public void setNumberPay(short numberPay) {
		this.numberPay = numberPay;
	}
	
	/**
	 * Metodo get para el valor del pago
	 * @return El valuePay del pago
	 */
	public double getValuePay() {
		return valuePay;
	}
	
	/**
	 * Metodo set para valuePay
	 * @param valuePay Define el valor que tendra el pago
	 */
	public void setValuePay(double valuePay) {
		this.valuePay = valuePay;
	}
	
	/**
	 * Metodo get para la fecha del pago
	 * @return La datePay del pago
	 */
	public LocalDate getDatePay() {
		return datePay;
	}
	
	/**
	 * Metodo set para la fecha del pago
	 * @param datePay Define la fecha del pago
	 */
	public void setDatePay(LocalDate datePay) {
		this.datePay = datePay;
	}

}
