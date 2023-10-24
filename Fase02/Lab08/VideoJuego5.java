// Laboratorio Nro 8  - Ejercicio VideoJuego5
// Autor: Mamani Anahua Victor Narciso
// Colaboro:
// Tiempo:
import java.util.*;
class VideoJuego5{
    public static HashMap<String, Soldado> mapHashFillRegister(int num){
        Random rdm =new Random();
        HashMap<String, Soldado> army1 = new HashMap<String, Soldado>();
        ArrayList<ArrayList<Soldado>> army = new ArrayList<ArrayList<Soldado>>(); //NOS AYUDARIAMOS DE UN ARRAYLIST PARA PODER AYUDARNOS CON EL USO DE HASHMAPS PARA PODER REGISTAR A SOLDADOS EN LA QUE NINGUNO DE ESTOS SE REPITA 
        int numsoldiers = rdm.nextInt(10) + 1; //NUMERO DE SOLDADOS QUE SE VAN A CREAR DE 1 AL 10 
        for(int i = 0; i < 10; i++){
            army.add(new ArrayList<Soldado>()); //LLENAMOS NUESTROS ARRAYLIST BIDIMENSIONAL CON CADA FILA PARA QUE CUMPLAN CON ESTRUCTURA DEL TABLERO
            for(int j = 0; j < 10 ; j++){
                army.get(i).add(null); // LLENAMOS CADA FILA DEL ARRAYLIST CON UN OBJETO SOLDADO CON TAL QUE ESTE SEA NULL PARA QUE SEPA QUE ESTE TIENE UNA CASILLA PERO NO HAY NADIE TODAVIA SE PUEDE LLENAR 
                army1.put("Soldado" + i +"X" + j, null);
            }
        }
        System.out.println("El Ejercito " + num + " tiene " + numsoldiers + " soldados : " ); 
        System.out.println("*********************************");
        for(int i = 0; i < numsoldiers; i++){ //ITERACION PARA PODER DARLES LOS DATOS A CADA SOLDADO CREADO 
            String name = "Soldado" + i + "X" + num;
            int health = rdm.nextInt(5) + 1;
            int row = rdm.nextInt(10) + 1;
            String column = String.valueOf((char)(rdm.nextInt(10) + 65)); //REUTILIZAMOS CODIGO DEL ANTERIOR ARCHIVO VIDEOJUEGO4.JAVA YA QUE TENDRIAN LA MISMA FUNCIONALIDAD
            if(army.get(row - 1).get((int)column.charAt(0) - 65) == null){ 
                System.out.println("Registrando al " + (i + 1) + " soldado del Ejercito " + num + "");
                System.out.print("------------------");
                army.get(row - 1).set((int)column.charAt(0) - 65, new Soldado(name, health, row, column));
                army1.put("Soldado" + (row - 1) + "X" + ((int)(column.charAt(0)) - 65), new Soldado(name, health, row, column)); //INTEGRAMOS AL HASHMAP AL SOLDADO CON SU RESPECTIVO NOMBRE Y VALOR 
                System.out.println(army1.get("Soldado" + (row - 1) + "X" + ((int)(column.charAt(0)) - 65)).toString()); //PUBLICAMOS AL SOLDADO CREADO POR ORDEN DE CREACION
            }else{
                i -= 1; //NOS AYUDARIA CON LOS SOLDADOS QUE SE REPITEN EN EL MISMO CASILLERO CON TAL QUE NO DEBERIA CONTAR 
            }
        }
        return army1;
    }
    public static void viewBoard(HashMap<String, Soldado> army1, HashMap<String, Soldado> army2){ //EN ESTE METODO DEMOSTRAREMOS LA TABLA REUTILIZAREMOS CODIGOS DE ANTERIORES LABORATORIOS PARA PODER HACER LA BASE DE ESTE TABLERO
        System.out.println("\nMostrando tabla de posicion ... --");
        System.out.println("Leyenda: Ejercito1 --> X | Ejercito2 --> Y"); //RECONOCIMIENTO PARA LOS EJERCITOS Y POSICION DE SUS SOLDADOS
        System.out.println("\n \t   A\t   B\t   C\t   D\t   E\t   F\t   G\t   H\t   I\t   J"); // RECONOCIMIENTO PARA CADA UBICACION DE CADA SOLDADO EN EL TABLERO POR PARTE DE LAS COLUMNAS
        System.out.println("\t_________________________________________________________________________________");
        for(int i = 0; i < 10; i++ ){
            System.out.print((i + 1) + "\t"); // RECONOCIMIENTO PARA CADA UBICACION DE CADA SOLDADO EN EL TABLERO POR PARTE DE LAS FILAS
                for(int j = 0; j < 10; j++){
                        if(army1.get("Soldado" + i + "X" + j) != null && army2.get("Soldado" + i + "X" + j) != null){ //CREAMOS UN IF PARA QUE ESTE NOS AYUDE A SABER QUIEN DE ESTOS SOLDADOS SE OCUPARA DEL CASILLERO EL CUAL DONDE ESTAN PELEANDO
                            if(army1.get("Soldado" + i + "X" + j).getHealth() > army2.get("Soldado" + i + "X" + j).getHealth()){
                                army1.get("Soldado" + i + "X" + j).setHealth(army1.get("Soldado" + i + "X" + j).getHealth() - army2.get("Soldado" + i + "X" + j).getHealth());
                                army2.remove("Soldado" + i + "X" + j);
                                System.out.print("|   " + "X" + "   ");
                            }else if(army2.get("Soldado" + i + "X" + j) != null && army1.get("Soldado" + i + "X" + j) != null){
                                army2.get("Soldado" + i + "X" + j).setHealth(army2.get("Soldado" + i + "X" + j).getHealth() - army1.get("Soldado" + i + "X" + j).getHealth());
                                army1.remove("Soldado" + i + "X" + j);
                                System.out.print("|   " + "Y" + "   ");
                            }else{
                                army2.remove("Soldado" + i + "X" + j);
                                army1.remove("Soldado" + i + "X" + j);
                                System.out.print("|   " + " " + "   ");
                            }
                        }else if(army1.get("Soldado" + i + "X" + j) != null){
                            System.out.print("|   " + "X" + "   ");
                        }else if(army2.get("Soldado" + i + "X" + j) != null){
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
    public static void longerLife(HashMap<String, Soldado> army , int num){
        int mayor = 0;
        Soldado soldier = null;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){ //ITERACION LA CUAL NOS AYUDA A PASAR POR TODOS LOS SOLDADOS DE CADA EJERCITO
                if(army.get("Soldado" + i + "X" + j) != null){ //VERIFICAMOS QUE EL SOLDADO EL CUAL ESTAMOS VERIFICANOD NO SEA UNO NULO
                    if(army.get("Soldado" + i + "X" + j).getHealth() > mayor){
                        mayor = army.get("Soldado" + i + "X" + j).getHealth(); //DETECTAMOS EL MAYOR EL CUAL VAMOS COMPRANDO CON LOS DEMAS SOLDADOS PARA TENER SOLO AL SOLDADO EL CUAL TENGA LA MAYOR VIDA
                        soldier = army.get("Soldado" + i + "X" + j); //SOLDIER CONTENDRA A ESTE SOLDADO EL CUAL DESPUES SE IMPRIMIRA SUS DATOS PARA VER DE QUE SOLDADO SE TRATA
                    }
                }
            }
        }
        System.out.println("");
        System.out.println("El soldado con mayor vida del Ejercito " + num + " es: ");
        System.out.println(soldier.toString());
        System.out.println("*********************************");
    }
    public static void main (String args []){
        HashMap<String, Soldado> army1 = mapHashFillRegister(1);
        HashMap<String, Soldado> army2 = mapHashFillRegister(2);
        viewBoard(army1, army2);
        longerLife(army1, 1);
        longerLife(army2, 2);
    }
}
