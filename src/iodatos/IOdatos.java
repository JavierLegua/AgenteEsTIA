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
	public static String[] anadirPisoArma() {

		String[] vDatos = new String[10];
		Scanner leer = new Scanner(System.in);
		
		System.out.println("Escribe el nombre del fichero a usar. (.txt");
		String armaPiso = leer.next();
		File f = new File(armaPiso);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try (FileWriter esc = new FileWriter(f, true); PrintWriter escribir = new PrintWriter(esc);) {
			if (armaPiso.equalsIgnoreCase("armas.txt")) {
				System.out.println("Que arma quieres añadir");
				String arma = leer.next();
				escribir.println(arma);
			} else {
				System.out.println("Que piso quieres añadir?");
				String piso = leer.next();
				escribir.println(piso);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return vDatos;
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

		File armas = new File("Armas.txt");
		armas.delete();
		File pisos = new File("Pisos.txt");
		pisos.delete();

	}

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

		try (FileReader fr = new FileReader(f);
				Scanner leer = new Scanner(fr);
				FileReader fz = new FileReader(fp);
				Scanner leer1 = new Scanner(fz);) {

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

		File fd = new File("Armas.dat");
		fd.delete();
		File fw = new File("Pisos.dat");
		fw.delete();

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
