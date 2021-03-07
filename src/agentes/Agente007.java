package agentes;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 *@author Javier Legua y Oscar Magallon
 *@version v1.0 1/03/2021 *
 *Descripción --> clase Agente 007 con sus datos
 */
public final class Agente007 extends Agente implements Serializable{

	protected int numBajas;
	protected ArrayList<String> vArmas;
/**
 * 
 * @param nombre del agente 007
 * @param edad del agente 007
 * @param direccion del agente 007
 * @param salario del agente 007
 * @param numBajas de 007
 */
	public Agente007(String nombre, int edad, String direccion, double salario, int numBajas) {
		super(nombre, edad, direccion, salario);
		this.numBajas = numBajas;
		this.vArmas = iodatos.IOdatos.cargarDatosFicherosTexto("Armas.txt");
	}
/**
 * 
 * @return numero de bajas
 */
	public int getNumBajas() {
		return numBajas;
	}
/**
 * 
 * @param numBajas del agente
 */
	public void setNumBajas(int numBajas) {
		this.numBajas = numBajas;
	}
/**
 * 
 * @return numero de armas en posesion
 */
	public ArrayList<String> getvArmas() {
		return vArmas;
	}
/**
 * 
 * @param vArmas del agente
 */
	public void setvArmas(ArrayList<String>vArmas) {
		this.vArmas=vArmas;
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
