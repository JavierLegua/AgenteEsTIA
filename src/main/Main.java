package main;

import java.util.ArrayList;

import agentes.Agente;
import agentes.Agente007;
import agentes.Espionaje;
import agentes.Jefazo;
import iodatos.IOdatos;
/**
 * 
 * @author Javier Legua y Oscar Magallon
 * @version v1.0 1/03/2021
 * Descripción --> Esta clase ejecuta el do-while con el menu y las distintas opciones.
 *
 */
public class Main {

	public static void main(String[] args) {

//Creamos el vector de agentes y guardamos unos cuantos agentes.
		ArrayList<Agente> vAgentes = IOdatos.leerAgente();//(String) vAgentes.add(new Espionaje("Javier", 58, "calle", 154564));

//Iniciamos la aplicacion	
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
				IOdatos.anadirPiso("Recursos/Pisos.txt");
				break;
			case 4:
				IOdatos.anadirArma("Recursos/Armas.txt");
				break;
			case 5:
				IOdatos.anadirAgente(vAgentes);
				IOdatos.EncriptarAgentes("Recursos/Agentes.dat", vAgentes);
				break;
			case 6:
				IOdatos.EncriptarArmasPisos();
				IOdatos.EncriptarAgentes("Recursos/Agentes.dat", vAgentes);
				IOdatos.EncriptarTodo();
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
