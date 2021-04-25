package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
	/**
	 * Esta clase encapsula las características y comportamiento de la clase 'Credit' y 'Client'
	 * @version 1.0
	 * @author Grupo A
	 *
	 */

public class Management {
	private ArrayList<Client> clients;
	private ArrayList<Credit> credits;
	
	/**
	 * Metodo constructor, que inicializa los arreglos de Clientes y Creditos
	 */
	public Management() {
		clients = new ArrayList<>();
		credits = new ArrayList<>();
	}
	
	/**
	 * Metodo que permite por medio del identificador, encontrar un cliente
	 * @param idClient Define la identificacion con la cual se va a realizar la busqueda
	 * @return El estudiante que se busca, si no exiiste retorna null
	 */
	public Client findClient(String idClient) {
		ArrayList<Client> sorted = (ArrayList<Client>) clients.clone();
		Collections.sort(sorted, (client1, client2) -> client1.getIdClient().compareTo(client2.getIdClient()));
		Client client = new Client(idClient, null, null, null, null, null);
		int pos = Collections.binarySearch(sorted, client, Comparator.comparing(Client::getIdClient));
		return pos >= 0 ? sorted.get(pos) : null;
	}
	
	/**
	 * Metodo que permite agregar un cliente al arreglo de clientes
	 * @param client Cliente que sera agregado
	 */
	public void addClient(Client client) {
		if (!clients.contains(client)) {
			clients.add(client);
		}
	}
	
	/**
	 * Metodo que permite obtner el arreglo de clientes
	 * @return Arreglo de clientes
	 */
	public ArrayList<Client> getClients() {
		return clients;
	}
	
	/**
	 * Metodo que permite buscar un credito por medio de su identificacion unica
	 * @param number Define la identificacion con la cual se busca el credito
	 * @return El credito buscado, sino existe retorna null
	 */
	public Credit findCredit(String number) {
		ArrayList<Credit> sorted = (ArrayList<Credit>) credits.clone();
		Collections.sort(sorted, (credit1, credit2) -> credit1.getNumber().compareTo(credit2.getNumber()));
		Credit credit = new Credit(null, number, 0, (short) 0, 0f);
		int pos = Collections.binarySearch(sorted, credit, Comparator.comparing(Credit::getNumber));
		return pos >= 0 ? sorted.get(pos) : null;
	}
	
	/**
	 * Metodo que permite agregar credito al arreglo de creditos
	 * @param client Define el cliente al cual se le agregara un credito
	 * @param credit Define el credito el cual sera agregado al cliente
	 */
	public void addCredit(Client client, Credit credit) {
		if (!credits.contains(credit)) {
			credits.add(credit);
			client.addCredit(credit);
		}
	}
	
	/**
	 * Metodo que permite realizar un pago a un credito
	 * @param credit Define el credito al cual se le realizara el pago
	 * @param value Define el valor del pago 
	 * @return El residuo actualizado, despues de realizar el pago
	 */
	public double doPay(Credit credit, double value) {
		credit.doPay(new Pays((short) 0, value, null));
		return credit.getResidue();
	}
	
	/**
	 * Metodo que permite obtener un clone del arreglo de creditos
	 * @return Clone del arreglo de creditos
	 */
	public ArrayList<Credit> getCredits() {
		return (ArrayList<Credit>) credits.clone();
	}
	
	/**
	 * Metodo que permite obtener los credito de un determinado cliente
	 * @param client Define el cliente al cual se le obtendran los creditos
	 * @return El arreglo de creditos de un determinado cliente
	 */
	public ArrayList<Credit> getCredits(Client client) {
		return client.getCredits();
	}
	
	/**
	 * Metodo que suma el valor de todos los pagos realizados de un credito en especifico
	 * @param credit Define el credito al que se le sumaran los pagos
	 * @return La sumatoria de los pagos realizados a un determinado credito
	 */
	public double sumPays(Credit credit) {
		double auxSumCredits = 0;
		for (int i = 0; i < credit.getPays().size(); i++) {
			auxSumCredits += credit.getPays().get(i).getValuePay();
		}
		return auxSumCredits;
	}
	
	/**
	 * Metodo que suma el valor de todos los creditos realizados de un cliente en especifico
	 * @param client Define el cliente al que se le sumaran los creditos que haya realizado
	 * @return La sumatoria de los creditos realizados de un determinado cliente
	 */
	public double sumCredits(Client client) {
		double auxSumCredits = 0;
		for (int i = 0; i < client.getCredits().size(); i++) {
			auxSumCredits += client.getCredits().get(i).getValue();
		}
		return auxSumCredits;
	}
}
