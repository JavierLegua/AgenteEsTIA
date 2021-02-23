package agentes;

public final class Agente007 extends Agente {

	protected int numBajas;
	protected int numArmas;
	
	public Agente007(String nombre, int edad, String direccion, double salario, int numBajas, int numArmas) {
		super(nombre, edad, direccion, salario);
		this.numBajas = numBajas;
		this.numArmas = numArmas;
	}

	public int getNumBajas() {
		return numBajas;
	}

	public void setNumBajas(int numBajas) {
		this.numBajas = numBajas;
	}

	public int getNumArmas() {
		return numArmas;
	}

	public void setNumArmas(int numArmas) {
		this.numArmas = numArmas;
	}

	@Override
	public String toString() {
		return "Agente007 [numBajas=" + numBajas + ", numArmas=" + numArmas + "]";
	}
	
	
	
}
