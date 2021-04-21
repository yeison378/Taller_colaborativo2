package model;

import java.time.LocalDate;

public class Runner {

	public static void main(String[] args) {
		LocalDate hoy = LocalDate.now();
		Management obj = new Management();
		obj.addClient(new Client("12142", "Saleh", "jasmin", hoy, "3225989662", "jasmin@saleh.com"));

		System.out.println(obj.getClients().get(0));

		obj.addCredit(obj.getClients().get(0),
				new Credit(obj.getClients().get(0), "hoy", (double) 2000000, (short) 4, (float) 1));


		System.out.println(obj.getClients());
		System.out.println("terminado");
	}

}
