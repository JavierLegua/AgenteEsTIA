package iodatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IOdatos {
	
	public static int pintarMenu () {
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
				num=leer.nextInt();
			} catch (Exception e) {
				System.out.println("Escribe un numero!");
				leer = new Scanner(System.in);
				num=0;
			}
			
			
			
			}while(num<1 || num>8);
			
		return num;
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
			
			try (FileReader fr = new FileReader(f);
				Scanner leer = new Scanner(fr);){
				
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
	
		
}


