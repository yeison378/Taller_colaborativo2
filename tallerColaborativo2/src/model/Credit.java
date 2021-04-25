package model;

import java.time.LocalDate;
import java.util.ArrayList;

	/**
	* Esta clase define los objetos 'Creditos'
	* @version 1.0
	* @author Grupo A
	*
 	*/
public class Credit {
	private String number;
	private Client client;
	private double value;
	private short term;
	private float rate;
	private double residue;
	private LocalDate dateCredit;
	private ArrayList<Pays> pays;

	/**
	 * Constructor para 'Credit', ademas inicializa un arreglo de 'pagos' para el cliente
	 * Inicializa la fecha de aquisicion del credito
	 * 
	 * @param client Define el cliente a quien pertenece el credito
	 * @param number Define un codigo unico para el credito
	 * @param value Define el valor incial del credito
	 * @param term Define el termino o plazo para pagar el credito
	 * @param rate Define el interes mensual a pagar sobre el saldo del credito
	 */
	public Credit(Client client, String number, double value, short term, float rate) {
		this.client = client;
		this.number = number;
		this.value = value;
		this.term = term;
		this.rate = rate;

		dateCredit.now();
		residue = value;

		pays = new ArrayList<>();
	}
	
	/**
	 * Metodo para obtener el number del credito
	 * @return identificacion unica del credito
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Metodo para asignar el number o id del credito
	 * @param number Define el valor que tendra la identificacion del credito
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Metodo para obtener el value del credito
	 * @return El valor  del credito
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Metodo para asignar el valor del credito
	 * @param value Define el valor que tendra el valor del credito
	 */
	public void setValue(double value) {
		this.value = value;
	}
	
	/**
	 * Metodo para obtener el term del credito
	 * @return El plazo de meses para pagar el credito
	 */
	public short getTerm() {
		return term;
	}
	
	/**
	 * Metodo para asignar el plazo para pagar el credito
	 * @param term Define el plazo de pagar el credito
	 */
	public void setTerm(short term) {
		this.term = term;
	}
	
	/**
	 * Metodo para obtener el rate del credito
	 * @return El interes por pagar del credito
	 */
	public float getRate() {
		return rate;
	}
	
	/**
	 * Metodo para asignar el interes por pagar del credito
	 * @param rate Define el interes por pagar del credito
	 */
	public void setRate(float rate) {
		this.rate = rate;
	}
	
	/**
	 * Metodo para obtener el residue del credito
	 * @return El saldo que hay por pagar del credito
	 */
	public double getResidue() {
		return residue;
	}

	/**
	 * Metodo para asignar el residuo que hay por pagar del credito
	 * @param residue Define el saldo por pagar del credito
	 */
	public void setResidue(double residue) {
		this.residue = residue;
	}
	
	/**
	 * Metodo para obtener la dateCredit del credito
	 * @return La fecha del credito
	 */
	public LocalDate getDateCredit() {
		return dateCredit;
	}
	
	/**
	 * Metodo para asignar la fecha del credito
	 * @param dateCredit Define la fecha del credito
	 */
	public void setDateCredit(LocalDate dateCredit) {
		this.dateCredit = dateCredit;
	}
	
	/**
	 * Metodo que permite hacer un pago a un credito determinado
	 * Agregando un pago al arreglo de pagos y actualizando el valor del residuo o saldo por pagar
	 * @param pay Define el pago de la cuota al credito
	 * @return El saldo actualizado que queda por pagar del credito
	 */
	public double doPay(Pays pay) {
		double valueInterest = (rate * residue) / 100;
		if (pay.getValuePay() <= (residue - valueInterest)) {
			residue = residue - (pay.getValuePay() - valueInterest);
			pays.add(pay);
		}
		return residue;
	}
	
	/**
	 * Metodo get, para obtener los pagos
	 * @return Retorna un Clone del arreglo de los pagos
	 */
	public ArrayList<Pays> getPays() {
		return (ArrayList<Pays>) pays.clone();
	}
	
	/**
	 * Metodo que suma el valor de los pagos realizados a un credito
	 * @return Retorna la sumatoria de los pagos realizados
	 */
	public double sumPays() {
		double auxSumPays = 0;
		for (int i = 0; i < pays.size(); i++) {
			auxSumPays += pays.get(i).getValuePay();
		}
		return auxSumPays;
	}
	
	/**
	 * Metodo que permite ver la información de un credito con determinado formato
	 */
	@Override
	public String toString() {
		return "Credit [client=" + client + ", number=" + number + ", value=" + value + ", term=" + term + ", rate="
				+ rate + ", residue=" + residue + ", dateCredit=" + dateCredit + ", pays=" + pays + "]";
	}

}
