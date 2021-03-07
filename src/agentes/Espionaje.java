package agentes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Javier Legua y Oscar Magallon
 * @version v1.0 1/03/2021 descripcion --> clase del agente de espionaje con sus
 *          datos
 */
public final class Espionaje extends Agente implements Serializable {

	protected ArrayList<String> vPisos;

	/**
	 * 
	 * @param nombre
	 * @param edad
	 * @param direccion
	 * @param salario
	 */
	public Espionaje(String nombre, int edad, String direccion, double salario) {
		super(nombre, edad, direccion, salario);
		this.vPisos = iodatos.IOdatos.cargarDatosFicherosTexto("Pisos.txt");
	}

	/**
	 * 
	 * @return pisos de seguridad que tiene
	 */
	public ArrayList<String> getvPisos() {
		return vPisos;
	}

	/**
	 * 
	 * @param vPisos de seguridad
	 */

	public void setvPisos(ArrayList<String> vPisos) {
		this.vPisos = vPisos;
	}

	@Override
	public String toString() {
		String piso = "";
		for (String x : vPisos) {
			if (x != null) {
				piso += x;
			}
		}

		return "Agente Espionaje " + piso + "\n" + nombre + "\n" + "Edad-" + edad + "\n" + direccion + "\n" + "Salario-"
				+ salario + "\n" + "*************";
	}

}
