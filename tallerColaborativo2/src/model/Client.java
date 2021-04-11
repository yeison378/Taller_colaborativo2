package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Client {
	private String idClient;
	private String lastName;
	private String name;
	private LocalDate dateUp;
	private String phone;
	private String email;
	private ArrayList<Credit> credits;

	public Client(String idClient, String lastName, String name, LocalDate dateUp, String phone, String email) {
		this.idClient = idClient;
		this.lastName = lastName;
		this.name = name;
		this.dateUp = dateUp;
		this.phone = phone;
		this.email = email;
		
		credits = new ArrayList<>();
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateUp() {
		return dateUp;
	}

	public void setDateUp(LocalDate dateUp) {
		this.dateUp = dateUp;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//TODO PROBAAAAAR
	public void addCredit(Credit credit) {
		credits.add(credit);
	}

	public ArrayList<Credit> getCredits() {
		return (ArrayList<Credit>) credits.clone();
	}

	// TODO PROBAAAR
	public double sumCredits() {
		double auxSumCredits = 0; 
		for (int i = 0; i < credits.size(); i++) {
			auxSumCredits += credits.get(i).getValue();
		}
		return auxSumCredits;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", lastName=" + lastName + ", name=" + name + ", dateUp=" + dateUp
				+ ", phone=" + phone + ", email=" + email + ", credits=" + credits + "]";
	}

}
