//  Laboratorio Nro 1 - Ejercicio3
//  Autor: Mamani Anahua Victor Narciso
//  Colaboro:
//  Tiempo: 
import java.util.*;
	public class Videojuego {
		public static void main(String args[]){
			//1. DECLARAMOS NUESTRO ARREGLO Y TAMBIEN LO INSTANCIAMOS
			Scanner sc = new Scanner(System.in);
			String[] names = new String[5];
			//2. LLENAMOS CADA ELEMENTO DEL ARREGLO
			for(int i = 0; i < 5; i++){
				names[i] = sc.nextLine();
			}	
			//3. MOSTRAMOS EL CONTENIDO DE CADA ELEMENTO DEL ARREGLO
			for(int x = 0; x < 5 ; x++){
				System.out.println("El nombre del soldado numero " + (x + 1) + " es: " + names[x]);
			}
		}
	}