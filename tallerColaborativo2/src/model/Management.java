package model;

//import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Iterator;

public class Management {
	private ArrayList<Client> clients;
	private ArrayList<Credit> credits;

	public Management() {
		clients = new ArrayList<>();
		credits = new ArrayList<>();
	}

	public Client findClient(String idClient) {
		ArrayList<Client> sorted = (ArrayList<Client>) clients.clone();
		Collections.sort(sorted, (client1, client2) -> client1.getIdClient().compareTo(client2.getIdClient()));
		Client client = new Client(idClient, null, null, null, null, null);
		int pos = Collections.binarySearch(sorted, client, Comparator.comparing(Client::getIdClient));
		return pos >= 0 ? sorted.get(pos) : null;
	}

	public void addClient(Client client) {
		if (!clients.contains(client)) {
			clients.add(client);
		}
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public Credit findCredit(String number) {
		ArrayList<Credit> sorted = (ArrayList<Credit>) credits.clone();
		Collections.sort(sorted, (credit1, credit2) -> credit1.getNumber().compareTo(credit2.getNumber()));
		Credit credit = new Credit(null, number, 0, (short) 0, 0f);
		int pos = Collections.binarySearch(sorted, credit, Comparator.comparing(Credit::getNumber));
		return pos >= 0 ? sorted.get(pos) : null;
	}

	public void addCredit(Client client, Credit credit) {
		if (!credits.contains(credit)) {
			credits.add(credit);
			client.addCredit(credit);
		}
	}

	public double doPay(Credit credit, double value) {
		credit.doPay(new Pays((short) 0, value, null));
		return credit.getResidue();
	}

	public ArrayList<Credit> getCredits() {
		return (ArrayList<Credit>) credits.clone();
	}

	public ArrayList<Credit> getCredits(Client client) {
		return client.getCredits();
	}
	
	
	public double sumPays(Credit credit) {
		double auxSumCredits = 0;
		for (int i = 0; i < credit.getPays().size(); i++) {
			auxSumCredits += credit.getPays().get(i).getValuePay();
		}
		return auxSumCredits;
	}
	
	public double sumCredits(Client client) {
		double auxSumCredits = 0;
		for (int i = 0; i < client.getCredits().size(); i++) {
			auxSumCredits += client.getCredits().get(i).getValue();
		}
		return auxSumCredits;
	}
}
