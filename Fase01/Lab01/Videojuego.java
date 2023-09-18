//  Laboratorio Nro 1 - Ejercicio2
//  Autor: Mamani Anahua Victor Narciso
//  Colaboro:
//  Tiempo: 
import java.util.*;
	public class Videojuego{
		public static void main(String args[]){
			//1. DECLARAMOS LAS VARIABLES
			Scanner sc = new Scanner(System.in);
			String name;
			int health;
			//2. LE PEDIMOS A LOS 5 USUARIOS ESCRIBIR SUS NOMBRES Y SU NIVEL DE VIDA	
			for(int i = 0; i < 5; i++){
				System.out.println("Ingrese su nombre: ");
				name = sc.nextLine();
				System.out.println("El nombre del soldado " + (i + 1) + " es: " + name);
				for(int x = 0; x < 1; x++){
					System.out.println("Ingrese su nivel de vida: ");
					health = sc.nextInt();
					System.out.println("El nivel de vida del soldado " + (x + 1) + " es: " + health);
				}
			}
		}
	}