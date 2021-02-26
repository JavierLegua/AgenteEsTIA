package agentes;

import java.io.Serializable;

public final class Jefazo extends Agente implements Serializable{

	protected int anosMandato;

	public Jefazo(String nombre, int edad, String direccion, double salario, int anosMandato) {
		super(nombre, edad, direccion, salario);
		this.anosMandato = anosMandato;
	}



	public int getAnosMandato() {
		return anosMandato;
	}



	public void setAnosMandato(int anosMandato) {
		this.anosMandato = anosMandato;
	}



	@Override
	public String toString() {
		
		return "****************\n"
				+"Jefazo" + "\n"
				+"-Nombre: " + nombre + "\n"
				+"-Edad: " + edad + "\n"
				+"-Dirección: " + direccion + "\n"
				+"-Salario: " + salario + "\n"
				+"-Años de mandato: " + anosMandato + "\n"
				+"****************";
	}
	
}
