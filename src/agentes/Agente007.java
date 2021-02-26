package agentes;

import java.io.Serializable;

public final class Agente007 extends Agente implements Serializable{

	protected int numBajas;
	protected String[] vArmas;

	

	public Agente007(String nombre, int edad, String direccion, double salario, int numBajas) {
		super(nombre, edad, direccion, salario);
		this.numBajas = numBajas;
		this.vArmas = iodatos.IOdatos.cargarDatosFicherosTexto("Armas.txt");
	}

	public int getNumBajas() {
		return numBajas;
	}

	public void setNumBajas(int numBajas) {
		this.numBajas = numBajas;
	}

	public String[] getvArmas() {
		return vArmas;
	}

	public void setvArmas(String[] vArmas) {
		this.vArmas = vArmas;
	}

	@Override
	public String toString() {
		String armas= "";
		for (String x : vArmas) {
			if (x != null) {
				armas += x + "\n";
			}
		}
		return  "Agente007 \nNúmero de bajas-" + numBajas + " \nArmas en posesión- \n" + armas + "\n"
				+"*************";
	}

}
