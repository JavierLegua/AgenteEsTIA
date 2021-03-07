package iodatos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import agentes.Agente;
import agentes.Agente007;
import agentes.Espionaje;
import agentes.Jefazo;

/**
 * @author:Oscar Magallon y Javier Legua

 * @version: 1.0

 */
public class IOdatos {
	
	
	 /**
	  * 
	  * @return numero escojido
	  * Descripcion ->	Metodo que pinta el menu en pantalla con las opciones.
	 	Comprueba que el numero sea valido.
	  * 
	  */
	 

	public static int pintarMenu() {

		int num = 0;

		do {
			Scanner leer = new Scanner(System.in);

			System.out.println("--Menu de la Agencia--");
			System.out.println();
			System.out.println("Presiona 1 para ver la información de todos los agentes");
			System.out.println("Presiona 2 para ver la información de todos los agentes que ganen mas de una cantidad");
			System.out.println("Presiona 3 para dar de alta un nuevo piso");
			System.out.println("Presiona 4 para dar de alta una nueva arma");
			System.out.println("Presiona 5 para dar de alta un nuevo agente");
			System.out.println("Presiona 6 para encriptar toda la información");
			System.out.println("Presiona 7 para desencriptar toda la información");
			System.out.println("Presiona 8 para salir");
			System.out.println();
			System.out.println("Escribe un numero");
			try {
				num = leer.nextInt();
			} catch (Exception e) {
				System.out.println("Escribe un numero!");
				leer = new Scanner(System.in);
				num = 0;
			}

		} while (num < 1 || num > 8);

		return num;
	}

	/**
	 * 
	 * @param rutaFichero recibe la ruta del fichero
	 * 	Descripción-> crea el fichero si no esta lo crea.
	 	comprueba el nombre de la ruta y apunta el arma escrita en el fichero
	 */
	public static void anadirArma(String rutaFichero) {

		File f = new File(rutaFichero);

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (FileWriter esc = new FileWriter(f, true); PrintWriter escribir = new PrintWriter(esc);) {
			Scanner leer = new Scanner(System.in);

			if (rutaFichero.equalsIgnoreCase("Armas.txt")) {
				System.out.println("Que arma quieres anadir");
				String arma = leer.next();
				escribir.println(arma);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	/**
	 * 
	 * @param rutaFichero recibe la ruta del fichero
	 * Descripcion -> crea el fichero si no esta lo crea.
	 	comprueba el nombre de la ruta y apunta el arma escrita en el fichero
	 */
	public static void anadirPiso(String rutaFichero) {

		File f = new File(rutaFichero);

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (FileWriter esc = new FileWriter(f, true); PrintWriter escribir = new PrintWriter(esc);) {
			Scanner leer = new Scanner(System.in);

			if (rutaFichero.equalsIgnoreCase("Pisos.txt")) {
				System.out.println("Dime la direccion del piso.");
				String piso = leer.next();
				escribir.println(piso);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	/**
	 * 
	 * @param rutaFichero recibe la ruta del fichero
	 * @return devuelve un vector con los datos cargados
	 */
	public static ArrayList<String> cargarDatosFicherosTexto(String rutaFichero) {

		ArrayList<String> vDatos = new ArrayList();
		int cont = 0;

		File f = new File(rutaFichero);

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (FileReader fr = new FileReader(f); Scanner leer = new Scanner(fr);) {

			while (leer.hasNext()) {
				String linea = leer.nextLine();
				vDatos.add(linea);
				cont++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return vDatos;
	}
/**
 * 
 * @param vAgentes recibimos el vector de agentes
 * Descripcion -> recorremos el vector de agentes y si la posicion no esta vacia
	  	mostramos todo por pantalla
 */

	
	public static void verAgentes(ArrayList<Agente> vAgentes) {

		for (Agente a : vAgentes) {
			if (a != null) {
				System.out.println(a);
			}
		}

	}
	/**
	 * 
	 * @param rutaFichero recibe la ruta del fichero
	 * @param vAgentes recibe el vector de agentes
	 *  recorre el vector de agente y encripta los datos en un fichero .dat 
	 */


	public static void EncriptarAgentes(String rutaFichero, ArrayList<Agente> vAgentes) {

		File f = new File(rutaFichero);

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (FileOutputStream fi = new FileOutputStream(f); ObjectOutputStream escribir = new ObjectOutputStream(fi)) {

			for (Agente a : vAgentes) {
					escribir.writeObject(a);
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	
	/*
	 	Creamos los ficheros .dat de armas y pisos
	 	cojemos la informacion de los fichero .txt 
	 	y los cargamos en enciptado en el archivo .dat
	 	
	 */
	public static void EncriptarArmasPisos() {

		File f = new File("Armas.dat");

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		File fp = new File("Pisos.dat");

		if (!fp.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		try (FileOutputStream fo = new FileOutputStream(f);
				DataOutputStream escribir = new DataOutputStream(fo);
				FileOutputStream fr = new FileOutputStream(fp);
				DataOutputStream escribir1 = new DataOutputStream(fr)) {

			ArrayList<String>vArmas = cargarDatosFicherosTexto("Armas.txt");
			ArrayList<String>vPisos = cargarDatosFicherosTexto("Pisos.txt");

			for (String s : vArmas) {
			
					escribir.writeUTF(s);
				
			}

			for (String sa : vPisos) {
					escribir1.writeUTF(sa);
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// A la hora de encriptar borramos los ficheros sin encriptar
		File borrarArmas = new File("Armas.txt");
		borrarArmas.delete();
		File borrarPisos = new File("Pisos.txt");
		borrarPisos.delete();

	}

	/*
 	Creamos los ficheros .txt de armas y pisos
 	cojemos la informacion de los fichero.dat
 	y los cargamos en un fichero txt.
 	
 */
	public static void DesencriptarPisoArma() {


		File f = new File("Armas.txt");

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		File fp = new File("Pisos.txt");

		if (!fp.exists()) {
			try {
				fp.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		File armas = new File("Armas.dat");
		File pisos = new File("Pisos.dat");

		try (FileInputStream fr = new FileInputStream(armas);
			DataInputStream leer = new DataInputStream(fr);
				FileWriter ff = new FileWriter(f);
				PrintWriter escribir = new PrintWriter(ff)) {

			while(true) {
				String linea = leer.readUTF();
				escribir.println(linea);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println();
		}
		
		try (FileInputStream fr1 = new FileInputStream(pisos);
				DataInputStream leer1 = new DataInputStream(fr1);
					FileWriter ff1 = new FileWriter(fp);
					PrintWriter escribir1 = new PrintWriter(ff1)) {

				while(true) {
					String linea1 = leer1.readUTF();
					escribir1.println(linea1);
				}

				

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				System.out.println("Fichero leido.");
			}

		

		// Una vez desencriptado borramos el fichero encriptado
		armas.delete();
		pisos.delete();

	}

	/**
	 * 
	 * @param vAgentes recibe el parametro 
	 * descripcion-> Demuestra por pantalla los agentes que ganen mas de un numero
	 */
	public static void salario(ArrayList<Agente> vAgentes) {

		Scanner leer = new Scanner(System.in);
		int filtrado = 0;

		System.out.println("Busca agentes por su salario");
		System.out.println("Se mostraran los agentes que su salario sea mayor de:");
		System.out.println("Escribe un numero");
		filtrado = leer.nextInt();

		for (int i = 0; i < vAgentes.size(); i++) {
			if ((filtrado < vAgentes.get(i).getSalario())) {
				System.out.println(vAgentes.get(i).getNombre() + " " + vAgentes.get(i).getSalario());
				System.out.println();

			}
		}

	}
	
	public static ArrayList<Agente> leerAgente() {
		ArrayList<Agente> vAgentes = new ArrayList<Agente>();
		File f = new File ("Agentes.dat");
		
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (FileInputStream fi = new FileInputStream(f); ObjectInputStream leer = new ObjectInputStream(fi);) {

			while(true) {
				vAgentes.add((Agente) leer.readObject());
			}
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Fin de lectura de agentes.dat");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vAgentes;
	}
	/**
	 * 
	 * @param vAgentes recibe el vector de agenetes
	 * descripcion -> Pregunta por el tipo de agente añadir,
	 * pregunta sus caracteristicas depende del agente
	 * y carga la informacion en la primera posicion libre del vector
	 * @return 
	 */

	@Test
	
	public static void anadirAgente(ArrayList<Agente> vAgentes) {

		Scanner leer = new Scanner(System.in);

		String nombre = null, direccion = null, tipoAgente = null;
		int edad = 0, tiempo_mandato = 0, contadorMuertes = 0;
		double salario = 0;

		// Pedimos el tipo de agente para hacer una cosa u otra.
		System.out.println("Dime el tipo de agente que deseas guardar (Jefazo, 007 o Espionaje)");
		tipoAgente = leer.nextLine();

		// Continuamos pidiendo los datos comunes de todos los agentes.
		System.out.println("Dime el nombre del agente.");
		nombre = leer.nextLine();
		System.out.println("Dime la direccion del agente.");
		direccion = leer.nextLine();
		System.out.println("Dime la edad del agente.");
		edad = leer.nextInt();
		System.out.println("Dime el salario del agente.");
		salario = leer.nextDouble();
		//1
		
		// Ahora dependiendo del tipo de agente que nos han pasado haremos unas cosas
		// distintas.
		if (tipoAgente.equalsIgnoreCase("jefazo")) //2
			{
			System.out.println("Dime el tiempo de mandato del jefazo.");
			tiempo_mandato = leer.nextInt();
			
			// Comprobamos cual es la primera posicion vacia en el vector y guardamos un
			// nuevo agente en el.
			
				vAgentes.add(new Jefazo(nombre, edad, direccion, salario, tiempo_mandato));
				
				//3
			
			
		} else if (tipoAgente.equalsIgnoreCase("007")) {//4
			System.out.println("Dime el número de bajas que tiene este Agente007.");
			contadorMuertes = leer.nextInt();

			// Comprobamos cual es la primera posicion vacia en el vector y guardamos un
			// nuevo agente en el.
				
			vAgentes.add(new Agente007(nombre, edad, direccion, salario, contadorMuertes));	
			//5
				}
			
		 else {
			// Como el tipo no es ni jefazo ni 007 solo queda 1 tipo de agente.
					vAgentes.add(new Espionaje(nombre, edad, direccion, salario));
					//6
			}
		}
	//7

	// Metodo que borra todos los datos una vez salgamos de la aplicacion
	
	public static void borrarTodo() {

		File borrarArmas = new File("Armas.txt");
		borrarArmas.delete();

		File borrarArmasEncriptadas = new File("Armas.dat");
		borrarArmasEncriptadas.delete();

		File borrarPisos = new File("Pisos.txt");
		borrarPisos.delete();

		File borrarPisosEncriptados = new File("Pisos.dat");
		borrarPisosEncriptados.delete();

		File borrarAgentes = new File("Agentes.txt");
		borrarAgentes.delete();

		File borrarAgentesEncriptados = new File("Agentes.dat");
		borrarAgentesEncriptados.delete();
	}

	public static void EncriptarTodo() {
		ArrayList<String> vArmas = cargarDatosFicherosTexto("Armas.dat");
		ArrayList<String> vPisos = cargarDatosFicherosTexto("Pisos.dat");
		ArrayList<Agente> vAgentes ; 
		
	}
}
