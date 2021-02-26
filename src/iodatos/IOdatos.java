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
import java.util.Scanner;

import agentes.Agente;
import agentes.Agente007;
import agentes.Espionaje;
import agentes.Jefazo;

public class IOdatos {

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

	// me pasan la ruta del fichero piso o armas
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

	public static String[] cargarDatosFicherosTexto(String rutaFichero) {

		String[] vDatos = new String[10];
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
				vDatos[cont] = linea;
				cont++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return vDatos;
	}
	
	//recorremos el vector de agentes y si la posicion es distinta de nulo lo mostramos por pantalla
	public static void verAgentes(Agente[] vAgentes) {
		
		for (Agente a : vAgentes) {
			if (a != null) {
				System.out.println(a);
			}
		}
		
	}

	//encriptamos el vector de agentes en el fichero agentes.dat
	public static void EncriptarAgentes(String rutaFichero, Agente vAgentes[]) {

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
				if (a != null) {
					escribir.writeObject(a);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	//desencriptamos el fichero agentes.dat y guardamos lo desencriptado en agentes.txt
	public static Agente[] DesencriptarAgentes(String rutaFichero) {

		Agente[] vector = new Agente[10];
		int cont = 0;

		File f = new File(rutaFichero);

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		File Agentes = new File("Agentes.dat");

		try (FileInputStream fi = new FileInputStream(Agentes); ObjectInputStream leer = new ObjectInputStream(fi)) {

			while (true) {
				vector[cont] = (Agente) leer.readObject();
				cont++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Has terminado de leer el fichero.");
		} catch (ClassNotFoundException e) {
			System.out.println("Has terminado de leer el fichero.");
		}
		
		//Una vez desencriptado borramos el fichero encriptado
		File borrarAgentes = new File("Agentes.dat");
		borrarAgentes.delete();

		return vector;
	}

	//encriptamos los ficheros armas y pisos
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

			String vArmas[] = cargarDatosFicherosTexto("Armas.txt");
			String vPisos[] = cargarDatosFicherosTexto("Pisos.txt");

			for (String s : vArmas) {
				if (s != null) {
					escribir.writeUTF(s);
				}
			}

			for (String sa : vPisos) {
				if (sa != null) {
					escribir1.writeUTF(sa);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//A la hora de encriptar borramos los ficheros sin encriptar
		File borrarArmas = new File("Armas.txt");
		borrarArmas.delete();
		File borrarPisos = new File("Pisos.txt");
		borrarPisos.delete();

	}

	//desencriptamos los ficheros armas y pisos
	public static void DesencriptarPisoArma() {

		String[] vPisos = new String[10];
		String[] vArmas = new String[10];
		int cont = 0, cont1 = 0;

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
		
		File Armas = new File("Armas.dat");
		File Pisos = new File("Pisos.dat");

		try (FileReader fr = new FileReader(Armas);
				Scanner leer = new Scanner(fr);
				FileReader fr1 = new FileReader(Pisos);
				Scanner leer1 = new Scanner(fr1);) {

			while (leer.hasNext()) {
				String linea = leer.nextLine();
				vArmas[cont] = linea;
				cont++;
			}

			while (leer.hasNext()) {
				String linea1 = leer.nextLine();
				vPisos[cont1] = linea1;
				cont1++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try (FileOutputStream fo = new FileOutputStream(f);
				DataOutputStream escribir = new DataOutputStream(fo);
				FileOutputStream fx = new FileOutputStream(fp);
				DataOutputStream escribir1 = new DataOutputStream(fx);) {

			for (String s : vArmas) {
				if (s != null) {
					escribir.writeUTF(s);
				}
			}

			for (String sa : vPisos) {
				if (sa != null) {
					escribir.writeUTF(sa);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//Una vez desencriptado borramos el fichero encriptado
		File borrarArmas = new File("Armas.dat");
		borrarArmas.delete();
		File borrarPisos = new File("Pisos.dat");
		borrarPisos.delete();

	}

	//filtramos los agentes por el salario introducido
	public static void salario(Agente[] vAgentes) {

		Scanner leer = new Scanner(System.in);
		int filtrado = 0;

		System.out.println("Busca agentes por su salario");
		System.out.println("Se mostraran los agentes que su salario sea mayor de:");
		System.out.println("Escribe un numero");
		filtrado = leer.nextInt();

		for (int i = 0; i < vAgentes.length; i++) {
			if ((vAgentes[i] != null) && (filtrado < vAgentes[i].getSalario())) {
				System.out.println(vAgentes[i].getNombre() + " " + vAgentes[i].getSalario());
				System.out.println();

			}
		}

	}

	public static void anadirAgente(Agente[] vAgentes) {

		Scanner leer = new Scanner(System.in);
		
		String nombre = null, direccion = null, tipoAgente = null;
		int edad = 0, tiempo_mandato = 0, contadorMuertes = 0;
		double salario = 0;
		
		//Pedimos el tipo de agente para hacer una cosa u otra.
		System.out.println("Dime el tipo de agente que deseas guardar (Jefazo, 007 o Espionaje)");
		tipoAgente = leer.nextLine();
		
		//Continuamos pidiendo los datos comunes de todos los agentes.
		System.out.println("Dime el nombre del agente.");
		nombre = leer.nextLine();
		System.out.println("Dime la direccion del agente.");
		direccion = leer.nextLine();
		System.out.println("Dime la edad del agente.");
		edad = leer.nextInt();
		System.out.println("Dime el salario del agente.");
		salario = leer.nextDouble();
		
		//Ahora dependiendo del tipo de agente que nos han pasado haremos unas cosas distintas.
		if (tipoAgente.equalsIgnoreCase("jefazo")) {
			System.out.println("Dime el tiempo de mandato del jefazo.");
			tiempo_mandato = leer.nextInt();
			
			//Comprobamos cual es la primera posicion vacia en el vector y guardamos un nuevo agente en el.
			for (int i = 0; i < vAgentes.length; i++) {
				if (vAgentes[i] == null) {
					vAgentes[i] = new Jefazo(nombre, edad, direccion, salario, tiempo_mandato);
					break;
				}
			}
		}else if (tipoAgente.equalsIgnoreCase("007")) {
			System.out.println("Dime el número de bajas que tiene este Agente007.");
			contadorMuertes = leer.nextInt();
			
			//Comprobamos cual es la primera posicion vacia en el vector y guardamos un nuevo agente en el.
			for (int i = 0; i < vAgentes.length; i++) {
				if (vAgentes[i] == null) {
					vAgentes[i] = new Agente007(nombre, edad, direccion, salario, contadorMuertes);
					break;
				}
			}
		}else {
			//Como el tipo no es ni jefazo ni 007 solo queda 1 tipo de agente.
			for (int i = 0; i < vAgentes.length; i++) {
				if (vAgentes[i] == null) {
					vAgentes[i] = new Espionaje(nombre, edad, direccion, salario);
					break;
				}
			}
		}
	
	}
	
	//Metodo que borra todos los datos una vez salgamos de la aplicacion
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
}
