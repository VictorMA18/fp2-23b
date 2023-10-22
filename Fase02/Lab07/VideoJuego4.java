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
        System.out.println("*********************************");
        return army;
    }
    public static void viewBoard(ArrayList<ArrayList<Soldado>> army1, Soldado[][] army2){//EN ESTE METODO NOS AYUDAMOS DEL ANTERIOR ARCHIVO YA QUE TENDRIAMOS UNA BASE PARA PODER CREARLO
        System.out.println("\nMostrando tabla de posicion ... --");
        System.out.println("Leyenda: Ejercito1 --> X | Ejercito2 --> Y"); //RECONOCIMIENTO PARA LOS EJERCITOS Y POSICION DE SUS SOLDADOS
        System.out.println("\n \t   A\t   B\t   C\t   D\t   E\t   F\t   G\t   H\t   I\t   J"); // RECONOCIMIENTO PARA CADA UBICACION DE CADA SOLDADO EN EL TABLERO POR PARTE DE LAS COLUMNAS
        System.out.println("\t_________________________________________________________________________________");
        for(int i = 0; i < army1.size(); i++ ){
            System.out.print((i + 1) + "\t"); // RECONOCIMIENTO PARA CADA UBICACION DE CADA SOLDADO EN EL TABLERO POR PARTE DE LAS FILAS
                for(int j = 0; j < army1.get(i).size(); j++){
                        if(army1.get(i).get(j) != null){
                            System.out.print("|   " + "X" + "   "); //VERIFICANDOLA POSICIONES DE CADA SOLDADO DE CADA EJERCITO CON SU RESPECTIVO INDICADOR PARA PODER UBICARLOS
                        }else if(army2[i][j] != null){
                            System.out.print("|   " + "Y" + "   ");
	                        }else{
                            System.out.print("|       ");
                        }
                }
                System.out.println("|");
                System.out.println("\t|_______|_______|_______|_______|_______|_______|_______|_______|_______|_______|");
        }
        System.out.println("\n*********************************");
    }
    public static void arrayListLongerLife(ArrayList<ArrayList<Soldado>> army, int num){
        System.out.println("El soldado con mayor vida del Ejercito " + num + " es: "); //METODO CREADO PARA PODER PERMITIRNOS A CONOCER EL SOLDADO CON MAYOR VIDA DE CADA EJERCITO 
        int mayor = 0;
        Soldado soldier = null;
        for(int i = 0; i < army.size(); i++){
            for(int j = 0; j < army.get(i).size(); j++){
                if(army.get(i).get(j) != null){ //COMPROBACION QUE HACEMOS PARA PODER DECIR QUE EL CASILLERO DONDE ESTAMOS ES UN SOLDADO QUE EXISTE
                    if(army.get(i).get(j).getHealth() > mayor){ //COMPARAMOS PUNTOS DE VIDA DE CADA SOLDADO PARA VER QUIEN ES EL MAYOR 
                        mayor = army.get(i).get(j).getHealth();
                        soldier = army.get(i).get(j);
                    }
                }
            }
        }
        System.out.println(soldier.toString());//IMPRIMIMOS SUS DATOS PARA PODER VER DE QUE SOLDADO SE TRATA 
        System.out.println("*********************************");
    }
    public static void arrayLongerLife(Soldado[][] army, int num){
        int mayor = 0;
        Soldado soldier = null; //METODO CREADO QUE NOS VA AYUDAR A DECIRNOS SOBRE LA INFORMACION DEL SOLDADO CON MAYOR VIDAD DEL EJERCITO2 EL CUAL TENDREMOS QUE ITERAR
        for(int i = 0; i < army.length; i++){
               for(int j = 0; j < army[i].length; j++){//ITERAMOS SOBRE CADA SOLDADO EL CUAL COMPARAÑOS CON SI ESTE ES EL MAYOR EN CUESTION DE VIDA VAMOS PASANDO POR CADA SOLDADO
                      if(army[i][j] != null){
                             if(mayor < army[i][j].getHealth()){
                                    mayor = army[i][j].getHealth();
                                    soldier = army[i][j];//ACTUALIZAMOS A ESTE SOLDADO CON EL QUE TIENE MAS VIDA DESPUES LO IMPRIMIMOS PARA VER DE QUE SOLDADO SE TRATA 
                             }
                      }
               }
        }
        System.out.println("");
        System.out.println("El soldado con mayor vida del Ejercito " + num + " es: ");
        System.out.println(soldier.toString());
        System.out.println("*********************************");
    }
    public static void main(String args[]){
        ArrayList<ArrayList<Soldado>> army1 = arrayListFillRegister(1);
        Soldado[][] army2 = arrayfillregister(2);
        viewBoard(army1, army2);
        arrayListLongerLife(army1, 1);
        arrayLongerLife(army2, 2);
    }
}