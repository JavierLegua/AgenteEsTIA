package agentes;

public final class Agente007 extends Agente {

	protected int numBajas;
	protected String[] vArmas;

	public Agente007(String nombre, int edad, String direccion, double salario, int numBajas, int numArmas) {
		super(nombre, edad, direccion, salario);
		this.numBajas = numBajas;
		this.vArmas = iodatos.IOdatos.cargar;
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
		return "Agente007 [numBajas=" + numBajas + ", Armas: " + armas + "]";
	}

}
