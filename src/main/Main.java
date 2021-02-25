package main;

import agentes.Agente;
import agentes.Agente007;
import agentes.Espionaje;
import agentes.Jefazo;
import iodatos.IOdatos;

public class Main {

	public static void main(String[] args) {

//Creamos el vector de agentes y guardamos unos cuantos agentes.
		Agente[] vAgentes = new Agente[10];
		vAgentes[0] = new Jefazo("pepe", 58, "calle", 5000, 15);
		vAgentes[1] = new Espionaje("juan", 36, "calle1", 15000);
		vAgentes[2] = new Agente007("pascual", 57, "calle2", 2500, 150);

//Iniciamos la aplicación.		
		int opc = 0;
		boolean salir = false;
		
		do {
			opc = IOdatos.pintarMenu();
			
			switch (opc) {
			case 1:
				IOdatos.verAgentes(vAgentes);
				break;
			case 2:
				IOdatos.salario(vAgentes);
				break;
			case 3:
				IOdatos.añadirPiso("Pisos.txt");
				break;
			case 4:
				IOdatos.añadirArma("Armas.txt");
				break;
			case 5:
				IOdatos.añadirAgente(vAgentes);
				break;
			case 6:
				IOdatos.EncriptarArmasPisos();
				IOdatos.EncriptarAgentes("Agentes.dat", vAgentes);
				break;
			case 7:
				IOdatos.DesencriptarAgentes("Agentes.txt");
				IOdatos.DesencriptarPisoArma();
				break;
			case 8:
				salir = true;
				break;

			}
		} while (salir != true);
		
		System.out.println("--No queda constancia de nada--");

	}

}
