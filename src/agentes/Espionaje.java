package agentes;

public final class Espionaje extends Agente {

	protected int pisos;

	public Espionaje(String nombre, int edad, String direccion, double salario, int pisos) {
		super(nombre, edad, direccion, salario);
		this.pisos = pisos;
	}

	public int getPisos() {
		return pisos;
	}

	public void setPisos(int pisos) {
		this.pisos = pisos;
	}

	@Override
	public String toString() {
		return "Espionaje [pisos=" + pisos + "]";
	}
	
	
	
}
