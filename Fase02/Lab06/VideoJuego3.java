// Laboratorio Nro 6  - Ejercicio Videojuego3
// Autor: Mamani Anahua Victor Narciso
// Colaboro:
// Tiempo:
import java.util.*;
class VideoJuego3{
    public static ArrayList<ArrayList<Soldado>> fillregisterSoldiers(int num){
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
        System.out.println("");
        for(int i = 0; i < numbersoldiers; i++){ //LLENAMOS CASILLAS CON CADA SOLDADO CREADO ALEATORIAMENTE
            System.out.print("Registrando al " + (i + 1) + " soldado del Ejercito " + num + "");
            String name = "Soldado" + i + "X" + num;
            //System.out.println(name); PRUEBA QUE SE HIZO PARA VER LOS NOMBRES
            int health = rdm.nextInt(5) + 1;
            int row = rdm.nextInt(10) + 1;
            String column = String.valueOf((char)(rdm.nextInt(10) + 65)); //REUTILIZAMOS CODIGO DEL ANTERIOR ARCHIVO VIDEOJUEGO2.JAVA YA QUE TENDRIAN LA MISMA FUNCIONALIDAD
            if(army.get(row - 1).get((int)column.charAt(0) - 65) == null){
                army.get(row - 1).set((int)column.charAt(0) - 65, new Soldado(name, health, row, column));
                System.out.println(army.get(row - 1).get((int)column.charAt(0) - 65).toString());
                System.out.println("---------------------------------");
            }else{
                i -= 1; //NOS AYUDARIA CON LOS SOLDADOS QUE SE REPITEN EN EL MISMO CASILLERO CON TAL QUE NO DEBERIA CONTAR 
            }
        }
        System.out.println("*********************************");
        return army;
    }
    public static void main(String args[]){
        ArrayList<ArrayList<Soldado>> army1 = fillregisterSoldiers(1);
        ArrayList<ArrayList<Soldado>> army2 = fillregisterSoldiers(2);
    }
}