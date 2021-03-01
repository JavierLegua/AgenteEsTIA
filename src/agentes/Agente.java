package agentes;

import java.io.Serializable;
/**
 * 
 * @author Javier Legua y Oscar Magallon
 * @version v1.0 1/03/2021
 * Descripción --> Esta clase es la clase padre de los agentes en la cual estan todos los campos
 * en comun con sus constructores y getters-setters.
 *
 */
public class Agente implements Serializable {

	protected String nombre;
	protected int edad;
	protected String direccion;
	protected double salario;
/**
 * 
 * @param nombre
 * @param edad
 * @param direccion
 * @param salario
 */
	public Agente(String nombre, int edad, String direccion, double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.salario = salario;
	}
/**
 * 
 * @return nombre del agente
 */
	public String getNombre() {
		return nombre;
	}
/**
 * 
 * @param nombre del agente
 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/**
 * 
 * @return edad del agente
 */
	public int getEdad() {
		return edad;
	}
/**
 * 
 * @param edad del agente
 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
/**
 * 
 * @return direccion del agente
 */
	public String getDireccion() {
		return direccion;
	}
/**
 * 
 * @param direccion del agente
 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
/**
 * 
 * @return salario del agente
 */
	public double getSalario() {
		return salario;
	}
/**
 * 
 * @param salario del agente
 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Agente [nombre=" + nombre + ", edad=" + edad + ", direccion=" + direccion + ", salario=" + salario
				+ "]";
	}

}
