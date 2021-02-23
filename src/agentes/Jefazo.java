package agentes;

public final class Jefazo extends Agente {

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
		//Hay que modificarlo
		return "Jefazo [AñosMandato=" + AñosMandato + "]";
	}
	
	
}
