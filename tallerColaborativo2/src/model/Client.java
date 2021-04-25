package model;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Esta clase define los objetos 'Clientes'
 * @version 1.0
 * @author Grupo A
 *
 */

public class Client {
	private String idClient;
	private String lastName;
	private String name;
	private LocalDate dateUp;
	private String phone;
	private String email;
	private ArrayList<Credit> credits;
	
	/**
	 * Constructor para 'Client', ademas inicializa un arreglo de 'creditos' para el cliente
	 * @param idClient Define una identificacion unica para cada cliente
	 * @param lastName Define los apellidos de un cliente
	 * @param name Define los nombres de un cliente
	 * @param dateUp Define la fecha de inscripcion del cliente	
	 * @param phone Define el numero de telefono del cliente
	 * @param email Define el correo electronico del cliente
	 * 
	 */
	public Client(String idClient, String lastName, String name, LocalDate dateUp, String phone, String email) {
		this.idClient = idClient;
		this.lastName = lastName;
		this.name = name;
		this.dateUp = dateUp;
		this.phone = phone;
		this.email = email;
		
		credits = new ArrayList<>();
	}
	
	/**
	 * Metodo para obtener el idClient del cliente
	 * @return identificacion unica del cliente
	 */
	public String getIdClient() {
		return idClient;
	}
	
	/**
	 * Metodo para asignar el idClient del cliente
	 * @param idClient Define el valor que tendra la identificacion del cliente
	 */
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	
	/**
	 * Metodo para obtener el lastName del cliente
	 * @return Los apellidos del cliente
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Metodo para asignar el lastName del cliente
	 * @param lastName Define los apellidos del cliente
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Metodo para obtener el name del cliente
	 * @return Los nombres del cliente
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Metodo para asignar el name del cliente
	 * @param name  Define los nombres del cliente
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Metodo para obtener el dateUp del cliente
	 * @return La fecha de inscripcion del cliente
	 */
	public LocalDate getDateUp() {
		return dateUp;
	}
	
	/**
	 * Metodo para asignar la fecha de inscripcion del cliente
	 * @param dateUp  Define la fecha de inscripcion del cliente
	 */
	public void setDateUp(LocalDate dateUp) {
		this.dateUp = dateUp;
	}
	
	/**
	 * Metodo para obtener el dateUp del cliente 
	 * @return El numero de telefono del cliente
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Metodo para asignar el numero de telefono del cliente
	 * @param phone  Define el numero de telefono del cliente
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Metodo para obtener el email del cliente 
	 * @return El correo electronico del cliente
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Metodo para asignar el email del cliente
	 * @param email Define el email del cliente
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que permite agregar un credito al arreglo de creditos del cliente
	 * @param credit Es el objeto Credito el cual va a ser agregado
	 */
	public void addCredit(Credit credit) {
		credits.add(credit);
	}
	
	/**
	 * Metodo que permite obtener una copia de los arreglos de un cliente
	 * @return Clone del listado de creditos
	 */
	public ArrayList<Credit> getCredits() {
		return (ArrayList<Credit>) credits.clone();
	}

	/**
	 * Metodo que suma el valor de todos los creditos de un cliente
	 * @return Acumulado del valor de los creditos
	 */
	public double sumCredits() {
		double auxSumCredits = 0; 
		for (int i = 0; i < credits.size(); i++) {
			auxSumCredits += credits.get(i).getValue();
		}
		return auxSumCredits;
	}
	
	/**
	 * Metodo que permite ver la información de un cliente con determinado formato
	 */
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", lastName=" + lastName + ", name=" + name + ", dateUp=" + dateUp
				+ ", phone=" + phone + ", email=" + email + "]";
	}

}
