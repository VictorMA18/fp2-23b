// Laboratorio Nro 9  - Ejercicio Videojuego
// Autor: Mamani Anahua Victor Narciso
// Colaboro:
// Tiempo:
import java.util.*;
class Videojuego { 
    public static ArrayList<ArrayList<Soldado>> fillRegister(int num){
        Random rdm = new Random();
        ArrayList<ArrayList<Soldado>> army = new ArrayList<ArrayList<Soldado>>();
        int numbersoldiers = rdm.nextInt(10) + 1; //NUMERO DE SOLDADOS ALEATORIOS ENTRE 1 A 10 SOLDADOS 
        for(int i = 0; i < 10; i++){ //ITERACION
            army.add(new ArrayList<Soldado>()); //LLENAMOS NUESTROS ARRAYLIST BIDIMENSIONAL CON CADA FILA PARA QUE CUMPLAN CON ESTRUCTURA DEL TABLERO
            for(int j = 0; j < 10 ; j++){//ITERACION
                army.get(i).add(null); // LLENAMOS CADA FILA DEL ARRAYLIST CON UN OBJETO SOLDADO CON TAL QUE ESTE SEA NULL PARA QUE SEPA QUE ESTE TIENE UNA CASILLA PERO NO HAY NADIE TODAVIA SE PUEDE LLENAR 
            }
        }
        System.out.println("El Ejercito " + num + " tiene " + numbersoldiers + " soldados : " ); 
        System.out.println("");
        for(int i = 0; i < numbersoldiers; i++){ //LLENAMOS CASILLAS CON CADA SOLDADO CREADO ALEATORIAMENTE
            String name = "Soldado" + i + "X" + num;
            //System.out.println(name); PRUEBA QUE SE HIZO PARA VER LOS NOMBRES
            int health = rdm.nextInt(5) + 1;
            int row = rdm.nextInt(10) + 1;
            int speed = rdm.nextInt(5) + 1;
            String column = String.valueOf((char)(rdm.nextInt(10) + 65)); //REUTILIZAMOS CODIGO DEL ANTERIOR ARCHIVO VIDEOJUEGO2.JAVA YA QUE TENDRIAN LA MISMA FUNCIONALIDAD
            //System.out.println(army.get(row - 1).get((int)column.charAt(0) - 65)); PRUEBA QUE SE HIZO PARA COMPROBAR SI EL OBJETO SE ESTABA DANDO O NO CAPAZ NI EXISTIA  
            if(army.get(row - 1).get((int)column.charAt(0) - 65) == null){
                System.out.println("Registrando al " + (i + 1) + " soldado del Ejercito " + num + "");
                army.get(row - 1).set((int)column.charAt(0) - 65, new Soldado(name, health, row, column));
                army.get(row - 1).get((int)column.charAt(0) - 65).setSpeed(speed);
                System.out.println(army.get(row - 1).get((int)column.charAt(0) - 65).toString());
                System.out.println("---------------------------------");
            }else{
                i -= 1; //NOS AYUDARIA CON LOS SOLDADOS QUE SE REPITEN EN EL MISMO CASILLERO CON TAL QUE NO DEBERIA CONTAR 
            }
        }
        System.out.println("*********************************");
        return army;
    }
    public static void viewBoard(ArrayList<ArrayList<Soldado>> army1, ArrayList<ArrayList<Soldado>> army2){ //EN ESTE METODO DEMOSTRAREMOS LA TABLA REUTILIZAREMOS CODIGOS DE ANTERIORES LABORATORIOS PARA PODER HACER LA BASE DE ESTE TABLERO
        System.out.println("\nMostrando tabla de posicion ... --");
        System.out.println("Leyenda: Ejercito1 --> X | Ejercito2 --> Y"); //RECONOCIMIENTO PARA LOS EJERCITOS Y POSICION DE SUS SOLDADOS
        System.out.println("\n \t   A\t   B\t   C\t   D\t   E\t   F\t   G\t   H\t   I\t   J"); // RECONOCIMIENTO PARA CADA UBICACION DE CADA SOLDADO EN EL TABLERO POR PARTE DE LAS COLUMNAS
        System.out.println("\t_________________________________________________________________________________");
        for(int i = 0; i < 10; i++ ){
            System.out.print((i + 1) + "\t"); // RECONOCIMIENTO PARA CADA UBICACION DE CADA SOLDADO EN EL TABLERO POR PARTE DE LAS FILAS
                for(int j = 0; j < 10; j++){
                        if(army1.get(i).get(j) != null && army2.get(i).get(j) != null){ //CREAMOS UN IF PARA QUE ESTE NOS AYUDE A SABER QUIEN DE ESTOS SOLDADOS SE OCUPARA DEL CASILLERO EL CUAL DONDE ESTAN PELEANDO
                            if(army1.get(i).get(j).getLifeActual() > army2.get(i).get(j).getLifeActual()){
                                army1.get(i).get(j).setLifeActual(army1.get(i).get(j).getLifeActual() - army2.get(i).get(j).getLifeActual()); //Cambiamos 
                                army2.get(i).set(j, null); 
                                System.out.print("|   " + "X" + "   ");
                            }else if(army2.get(i).get(j).getLifeActual() > army1.get(i).get(j).getLifeActual()){
                                army2.get(i).get(j).setLifeActual(army2.get(i).get(j).getLifeActual() - army1.get(i).get(j).getLifeActual());
                                army1.get(i).set(j, null);;
                                System.out.print("|   " + "Y" + "   ");
                            }else{
                                army2.get(i).set(j, null);
                                army1.get(i).set(j, null);
                                System.out.print("|   " + " " + "   ");
                            }
                        }else if(army1.get(i).get(j) != null){
                            System.out.print("|   " + "X" + "   ");
                        }else if(army2.get(i).get(j) != null){
                            System.out.print("|   " + "Y" + "   ");
                        }else{
                            System.out.print("|   " + " " + "   ");
                        }
                }
                System.out.println("|");
                System.out.println("\t|_______|_______|_______|_______|_______|_______|_______|_______|_______|_______|");
        }
        System.out.println("\n*********************************");
    
    }
    public static void main(String args[]){
        ArrayList<ArrayList<Soldado>> army1 = fillRegister(1);
        ArrayList<ArrayList<Soldado>> army2 = fillRegister(2);
        viewBoard(army1, army2);
    }
}
