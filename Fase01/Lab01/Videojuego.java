//  Laboratorio Nro 1 - Ejercicio4
//  Autor: Mamani Anahua Victor Narciso
//  Colaboro:
//  Tiempo: 
import java.util.*;
class Videojuego {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //DECLARAMOS NUESTROS ARREGLOS
        String[] name = new String[5];
        int[] health = new int[5];
        //CREAMOS UN CICLO PARA LA INFORMACION DE LOS 5 SOLDADOS
        for(int i = 0; i < 5; i++){
            System.out.println("Ingresen sus nombres: ");
            name[i] = sc.next();
            System.out.println("Ingresen sus vidas:");
            health[i] = sc.nextInt();
        }
        //CREAMOS UN CICLO PARA DESPUES MOSTRARLOS
        for(int x = 0; x < 5; x++){
            System.out.println("El nombre del soldado " + (x + 1) + " es: " + name[x]);
            System.out.println("La vida del soldado " + (x + 1) + " es: " + health[x]);
        }
    }
}