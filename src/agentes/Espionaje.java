package agentes;

import java.io.Serializable;
import java.util.Arrays;

public final class Espionaje extends Agente implements Serializable {

	protected String[] vPisos;

	public Espionaje(String nombre, int edad, String direccion, double salario) {
		super(nombre, edad, direccion, salario);
		this.vPisos = iodatos.IOdatos.cargarDatosFicherosTexto("Pisos.txt");;
	}

	public String[] getvPisos() {
		return vPisos;
	}

	public void setvPisos(String[] vPisos) {
		this.vPisos = vPisos;
	}

	@Override
	public String toString() {
		String piso = "";
		for (String x : vPisos) {
			if (x != null) {
				x += vPisos;
			}
		}
		
		return "Espionaje " + piso +  nombre + " edad=" + edad + direccion + " salario=" + salario;
	}

	
	

}
