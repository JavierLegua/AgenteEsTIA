package agentes;

import java.io.Serializable;

/**
 * 
 * @author Javier Legua y Oscar Magallon
 * @version v1.0 1/03/2021 
 * Descripcion --> Clase jefazo con sus atributos
 */
public final class Jefazo extends Agente implements Serializable {

	protected int anosMandato;
/**
 * 
 * @param nombre
 * @param edad
 * @param direccion
 * @param salario
 * @param anosMandato
 */
	public Jefazo(String nombre, int edad, String direccion, double salario, int anosMandato) {
		super(nombre, edad, direccion, salario);
		this.anosMandato = anosMandato;
	}
/**
 * 
 * @return años de mandato del jefe
 */
	public int getAnosMandato() {
		return anosMandato;
	}
/**
 * 
 * @param anosMandato del jefe
 */
	public void setAnosMandato(int anosMandato) {
		this.anosMandato = anosMandato;
	}

	@Override
	public String toString() {

		return "****************\n" + "Jefazo" + "\n" + "-Nombre: " + nombre + "\n" + "-Edad: " + edad + "\n"
				+ "-Dirección: " + direccion + "\n" + "-Salario: " + salario + "\n" + "-Años de mandato: " + anosMandato
				+ "\n" + "****************";
	}

}
