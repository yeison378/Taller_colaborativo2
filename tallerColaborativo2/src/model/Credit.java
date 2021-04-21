package model;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Iterator;

public class Credit {
	private String number;
	private Client client;
	private double value;
	private short term;
	private float rate;
	private double residue;
	private LocalDate dateCredit;
	private ArrayList<Pays> pays;

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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public short getTerm() {
		return term;
	}

	public void setTerm(short term) {
		this.term = term;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public double getResidue() {
		return residue;
	}

	public void setResidue(double residue) {
		this.residue = residue;
	}

	public LocalDate getDateCredit() {
		return dateCredit;
	}

	public void setDateCredit(LocalDate dateCredit) {
		this.dateCredit = dateCredit;
	}

	public double doPay(Pays pay) {
		double valueInterest = (rate * residue) / 100;
		if (pay.getValuePay() <= (residue - valueInterest)) {
			residue = residue - (pay.getValuePay() - valueInterest);
			pays.add(pay);
		}
		return residue;
	}

	public ArrayList<Pays> getPays() {
		return (ArrayList<Pays>) pays.clone();
	}

	public double sumPays() {
		double auxSumPays = 0;
		for (int i = 0; i < pays.size(); i++) {
			auxSumPays += pays.get(i).getValuePay();
		}
		return auxSumPays;
	}

	@Override
	public String toString() {
		return "Credit [client=" + client + ", number=" + number + ", value=" + value + ", term=" + term + ", rate="
				+ rate + ", residue=" + residue + ", dateCredit=" + dateCredit + ", pays=" + pays + "]";
	}

}
