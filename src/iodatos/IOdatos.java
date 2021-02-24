package iodatos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	
	//me pasan la ruta del fichero piso o armas
	public static void anadirPisoArma (String rutaFichero) {
		
		File f = new File(rutaFichero);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try (FileWriter esc = new FileWriter(f,true);
			PrintWriter escribir = new PrintWriter(esc);
				) {
			Scanner leer = new Scanner(System.in);
			if(rutaFichero.equalsIgnoreCase("arma.txt")){
				System.out.println("Que arma quieres añadir");
				String arma = leer.next();
				escribir.println(arma);
			}else {
				System.out.println("Que piso quieres a�adir?");
				String piso = leer.next();
				escribir.println(piso);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
			
		
	

}


