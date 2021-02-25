package agentes;

import java.io.Serializable;

public final class Jefazo extends Agente implements Serializable{

	protected int AñosMandato;

	public Jefazo(String nombre, int edad, String direccion, double salario, int añosMandato) {
		super(nombre, edad, direccion, salario);
		AñosMandato = añosMandato;
	}

	public int getAñosMandato() {
		return AñosMandato;
	}

	public void setAñosMandato(int añosMandato) {
		AñosMandato = añosMandato;
	}

	@Override
	public String toString() {
		
		return "****************\n"
				+"Jefazo" + "\n"
				+"-Nombre: " + nombre + "\n"
				+"-Edad: " + edad + "\n"
				+"-Dirección: " + direccion + "\n"
				+"-Salario: " + salario + "\n"
				+"-Años de mandato: " + AñosMandato + "\n"
				+"****************";
	}
	
}
