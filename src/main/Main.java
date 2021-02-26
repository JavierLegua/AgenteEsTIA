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

//Iniciamos la aplicación.		
		int opc = 0;
		boolean salir = false;

		System.out.println("Bienvenidos al menu de gestion de empleados.");
		System.out.println();

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
				IOdatos.anadirPiso("Pisos.txt");
				break;
			case 4:
				IOdatos.anadirArma("Armas.txt");
				break;
			case 5:
				IOdatos.anadirAgente(vAgentes);
				break;
			case 6:
				IOdatos.EncriptarArmasPisos();
				IOdatos.EncriptarAgentes("Agentes.dat", vAgentes);
				break;
			case 7:
				IOdatos.DesencriptarPisoArma();
				break;
			case 8:
				IOdatos.borrarTodo();
				salir = true;
				break;

			}
		} while (salir != true);

		System.out.println("--No queda constancia de nada--");

	}

}
