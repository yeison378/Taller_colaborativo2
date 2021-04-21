package model;

import java.time.LocalDate;

public class TemporalMain {

	public static void main(String[] args) {
		Management obj = new Management();
		LocalDate hoy = LocalDate.now();
		obj.addClient(new Client("jasmin", "saleh", "jasmin", hoy, "3225989662", "andre@gmail.com"));
		obj.getClients();
		System.out.println(obj.getClients());

	}

}
