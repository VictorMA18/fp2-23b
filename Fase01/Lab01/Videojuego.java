//  Laboratorio Nro 1 - Ejercicio1
//  Autor: Mamani Anahua Victor Narciso
//  Colaboro:
//  Tiempo: 
import java.util.*;
	public class Ejercicio1{
		public static void main(String args[]){
			//1. DECLARAMOS LAS VARIABLES
			Scanner sc = new Scanner(System.in);
			String name;
			//2. LE PEDIMOS A LOS 5 USUARIOS ESCRIBIR SUS NOMBRES
			for(int i = 0; i < 5; i++){
				System.out.println("Ingrese su nombre: ");
				name = sc.nextLine();
				System.out.println("El nombre del soldado " + (i + 1) + " es: " + name);
			}
		}
	}