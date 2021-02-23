package agentes;

public final class Espionaje extends Agente {

	protected String[] vPisos;

	public Espionaje(String nombre, int edad, String direccion, double salario) {
		super(nombre, edad, direccion, salario);
		this.vPisos = iodatos.IOdatos.cargar;
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
		return "Espionaje [pisos=" + piso + "]";
	}

}
