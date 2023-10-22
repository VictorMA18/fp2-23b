// Laboratorio Nro 7  - Ejercicio VideoJuego4
// Autor: Mamani Anahua Victor Narciso
// Colaboro:
// Tiempo:
import java.util.*;
class VideoJuego4{  
    public  static ArrayList<ArrayList<Soldado>> arrayListFillRegister(int num){
        Random rdm = new Random();
        ArrayList<ArrayList<Soldado>> army = new ArrayList<ArrayList<Soldado>>();
        int numbersoldiers = rdm.nextInt(10) + 1;
        for(int i = 0; i < 10; i++){
            army.add(new ArrayList<Soldado>()); //LLENAMOS NUESTROS ARRAYLIST BIDIMENSIONAL CON CADA FILA PARA QUE CUMPLAN CON ESTRUCTURA DEL TABLERO
            for(int j = 0; j < 10 ; j++){
                army.get(i).add(null); // LLENAMOS CADA FILA DEL ARRAYLIST CON UN OBJETO SOLDADO CON TAL QUE ESTE SEA NULL PARA QUE SEPA QUE ESTE TIENE UNA CASILLA PERO NO HAY NADIE TODAVIA SE PUEDE LLENAR 
            }
        }
        System.out.println("El Ejercito " + num + " tiene " + numbersoldiers + " soldados : " ); 
        System.out.println("*********************************");
        for(int i = 0; i < numbersoldiers; i++){ //LLENAMOS CASILLAS CON CADA SOLDADO CREADO ALEATORIAMENTE
            String name = "Soldado" + i + "X" + num;
            int health = rdm.nextInt(5) + 1;
            int row = rdm.nextInt(10) + 1;
            String column = String.valueOf((char)(rdm.nextInt(10) + 65)); //REUTILIZAMOS CODIGO DEL ANTERIOR ARCHIVO VIDEOJUEGO3.JAVA YA QUE TENDRIAN LA MISMA FUNCIONALIDAD
            if(army.get(row - 1).get((int)column.charAt(0) - 65) == null){
                System.out.println("Registrando al " + (i + 1) + " soldado del Ejercito " + num + "");
                System.out.print("------------------");
                army.get(row - 1).set((int)column.charAt(0) - 65, new Soldado(name, health, row, column));
                System.out.println(army.get(row - 1).get((int)column.charAt(0) - 65).toString());
            }else{
                i -= 1; //NOS AYUDARIA CON LOS SOLDADOS QUE SE REPITEN EN EL MISMO CASILLERO CON TAL QUE NO DEBERIA CONTAR 
            }
        }
        System.out.println("*********************************");
        return army;
    }
    public static Soldado[][] arrayfillregister(int num){ //METODO CREADO PARA PODER CREAR AL EJERCITO 2 EL CUAL USAREMOS LA ESTRUCTURA DE DATO QUE ES EL ARRAY CON TAL QUE TAMBIEN REGISTRAMOS 
        Random rdm = new Random();
        int numsoldiers = rdm.nextInt(10) + 1;
        System.out.println("\nEl Ejercito " + num + " tiene " + numsoldiers + " soldados:");  
        System.out.println("*********************************");
        Soldado[][] army = new Soldado[10][10];
        for(int i = 0; i < numsoldiers; i++){ //LOS REGISTRAMOS A CADA UNO POR EL ORDEN DE CREACION QUE FUERON CREADOS EL CUAL TAMBIEN COMPLETAMOS SUS DATOS Y LOS PUBLICAMOS POR ORDEN          
            String name = "Soldado" + i + "X" + num;            
            int health = rdm.nextInt(5) + 1;
            int row = rdm.nextInt(10) + 1;
            String column = String.valueOf((char)(rdm.nextInt(10) + 65));  
            if(army[row - 1][(int)column.charAt(0) - 65] == null){ //VERIFICAMOS QUE NO SE REPITAN MISMOS SOLDADOS DE UN EJERCITO EN EL MISMO CUADRADO 
                System.out.println("Registrando al " + (i + 1) + " soldado del Ejercito " + num + "");   
                System.out.print("------------------");
                army[row - 1][(int)column.charAt(0) - 65] = new Soldado(name, health, row, column);
                System.out.println(army[row - 1][(int)column.charAt(0) - 65].toString());
            }else{
                i -= 1;
            }
        }
        return army;
    }
    public static void main(String args[]){
        ArrayList<ArrayList<Soldado>> army1 = arrayListFillRegister(1);
        Soldado[][] army2 = arrayfillregister(2);
    }
}