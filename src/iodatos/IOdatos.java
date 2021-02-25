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

public class IOdatos {

	public static int pintarMenu() {
		Scanner leer = new Scanner(System.in);
		int num = 0;
		do {
			System.out.println("Menu Del Proyecto");
			System.out.println("Presiona 1 para ver la información de todos los agentes");
			System.out.println("Presiona 2 para ver la información de todos los agentes que ganen mas de una cantidad");
			System.out.println("Presiona 3 para dar de alta un nuevo piso");
			System.out.println("Presiona 4 para dar de alta una nueva arma");
			System.out.println("Presiona 5 para dar de alta un nuevo agente");
			System.out.println("Presiona 6 para encriptar toda la información");
			System.out.println("Presiona 7 para desencriptar toda la información");
			System.out.println("Presiona 8 para salir");
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
	public static void anadirPisoArma() {
		Scanner leer = new Scanner(System.in);
		
		System.out.println("Escribe el nombre del fichero a usar. (.dat encriptar y .txt para añadir");
		String armaPiso = leer.next();
		File f = new File(armaPiso);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try (FileWriter esc = new FileWriter(f, true); PrintWriter escribir = new PrintWriter(esc);) {
			if (armaPiso.equalsIgnoreCase("armas.txt")||armaPiso.equalsIgnoreCase("armas.dat")) {
				System.out.println("Que arma quieres añadir");
				String arma = leer.next();
				escribir.println(arma);
			} else {
				System.out.println("Que piso quieres a�adir?");
				String piso = leer.next();
				escribir.println(piso);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static String[] cargarDatosFicherosTexto(String rutaFichero) {
		String[] vector = new String[10];

		File f = new File(rutaFichero);

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (FileReader fr = new FileReader(f); Scanner leer = new Scanner(fr);) {

			int cont = 0;
			while (leer.hasNext()) {
				String linea = leer.nextLine();
				vector[cont] = linea;
				cont++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return vector;
	}

	public static void EncriptarInfo(String rutaFichero, Agente vAgentes[]) {

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

	public static Agente[] DesencriptarInfo(String rutaFichero) {

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

		try (FileInputStream fi = new FileInputStream(f); ObjectInputStream leer = new ObjectInputStream(fi)) {

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

		return vector;
	}

	public static void EncriptarArmasPisos(String rutaFichero) {

		File f = new File(rutaFichero);

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		try (FileOutputStream fo = new FileOutputStream(f); DataOutputStream escribir = new DataOutputStream(fo)) {

			String vDatos[] = cargarDatosFicherosTexto(rutaFichero);

			for (String s : vDatos) {
				if (s != null) {
					escribir.writeUTF(s);
				}
			}
			f.delete();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public static String[] DesencriptarPisoArma(String rutaFichero) {

		String[] vector = new String[10];
		int cont = 0;

		File f = new File(rutaFichero);

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		try (FileInputStream fi = new FileInputStream(f); DataInputStream leer = new DataInputStream(fi)) {

			while (true) {
				vector[cont] = leer.readUTF();
				cont++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return vector;
	}

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

			}
		}

	}
}
