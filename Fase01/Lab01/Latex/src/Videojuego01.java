//  Laboratorio Nro 1 - Ejercicio5
//  Autor: Mamani Anahua Victor Narciso
//  Colaboro:
//  Tiempo:   
import java.util.*;
public class Videojuego01{
    public static void main(String args[]){
        //DECLARAMOS Y INSTACIAMOS NUESTROS ARREGLOS
        Random random = new Random();
        String[] Army1 = new String[random.nextInt(5) + 1];
        String[] Army2 = new String[random.nextInt(5) + 1]; 
        //LLENAMOS CADA ARREGLO CON LO PEDIDO
        for(int x = 0; x < Army1.length; x++){
            Army1[x] = "Soldado" + x;
        }
        for(int y = 0; y < Army2.length; y++){
            Army2[y] = "Soldado" + y;
        }
        //MOSTRAMOS LOS DATOS DE LOS SOLDADOS DE AMBOS EJERCITOS
        System.out.println("LOS SOLDADOS DEL EJERCITO 1 SON: ");
        for(int z = 0; z < Army1.length; z++){
            System.out.println(Army1[z]);
        }
        System.out.println("LOS SOLDADOS DEL EJERCITO 2 SON: ");
        for(int i = 0; i < Army2.length; i++){
            System.out.println(Army2[i]);
        }
        //MOSTRAMOS EL GANADOR DE LA BATALLA
        System.out.println("EL RESULTADO DE LA BATALLA ES :");
        if(Army1.length > Army2.length){
            System.out.println("EL EJERCITO 1 ES EL GANADOR");
        }else{
            if(Army1.length < Army2.length){
                System.out.println("EL EJERCITO 2 ES EL GANADOR");
            }else{
                System.out.println("EMPATE");
            }
        }
    }
}