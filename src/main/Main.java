package main;

import agentes.Agente;
import agentes.Agente007;
import agentes.Espionaje;
import agentes.Jefazo;
import iodatos.IOdatos;

public class Main {

	public static void main(String[] args) {
		
		Agente[] vAgentes = new Agente[10];
		vAgentes[0] = new Jefazo("pepe", 58, "calle", 5000, 15);
		vAgentes[1] = new Espionaje("juan", 36, "calle1", 15000);
		vAgentes[2] = new Agente007("pascual", 57, "calle2", 2500, 150);
		
		//int opc = IOdatos.pintarMenu();

		/*
		 for (Agente a : vAgentes) {
			if (a != null) {
				System.out.println(a);
			}
		}
		*/
		
		
	}

}
