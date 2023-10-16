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
    public static void viewBoard(ArrayList<ArrayList<Soldado>> army1, ArrayList<ArrayList<Soldado>> army2){ //EN ESTE METODO NOS AYUDAMOS DEL ANTERIOR ARCHIVO YA QUE TENDRIAMOS UNA BASE PARA PODER CREARLO
        System.out.println("Mostrando tabla de posicion ... --");
        System.out.println("Leyenda: Ejercito1 --> X | Ejercito2 --> Y"); //RECONOCIMIENTO PARA LOS EJERCITOS Y POSICION DE SUS SOLDADOS
        System.out.println("\n \t   A\t   B\t   C\t   D\t   E\t   F\t   G\t   H\t   I\t   J"); // RECONOCIMIENTO PARA CADA UBICACION DE CADA SOLDADO EN EL TABLERO POR PARTE DE LAS COLUMNAS
        System.out.println("\t_________________________________________________________________________________");
        for(int i = 0; i < army1.size(); i++ ){
            System.out.print((i + 1) + "\t"); // RECONOCIMIENTO PARA CADA UBICACION DE CADA SOLDADO EN EL TABLERO POR PARTE DE LAS FILAS
                for(int j = 0; j < army1.get(i).size(); j++){
                        if(army1.get(i).get(j) != null){
                            System.out.print("|   " + "X" + "   "); //VERIFICANDOLA POSICIONES DE CADA SOLDADO DE CADA EJERCITO CON SU RESPECTIVO INDICADOR PARA PODER UBICARLOS
                        }else if(army2.get(i).get(j) != null){
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
    public static void longerLife(ArrayList<ArrayList<Soldado>> army, int num){
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
    public static void averageLife(ArrayList<ArrayList<Soldado>> army, int num){
        int sum = 0;
        int count = 0;
        System.out.println("El promedio de puntos de vida del Ejercito " + num + " es: "); //METODO CREADO QUE NOS PERMITE DAR A CONOCER EL PROMEDIO DE VIDA DE CADA EJERCITO
        for(int i = 0; i < army.size(); i++){
            for(int j = 0; j < army.get(i).size(); j++){
                if(army.get(i).get(j) != null){ //VERIFICAMOS QUE EL SOLDADO DE CADA CASILLA SEA NO NULO 
                    sum += army.get(i).get(j).getHealth(); //JUNTAMOS LOS VALORES DE VIDA DE CADA SOLDADO DE CADA EJERCITO 
                    count++; //CONTAMOS CANTIDAD DE SOLDADOS DE CADA EJERCITO PARA DESPUES PODER DIVIDIRLO CON LA SUMA DE VIDA DE CADA EJERCITO
                }
            }
        }
        double avg = sum / (count * 1.0);
        System.out.println(avg); // DAMOS A CONOCER EL PROMEDIO DE VIDA DE CADA EJERCITO 
        System.out.println("*********************************");
    }
    public static void rankingBurbujaHealth(ArrayList<ArrayList<Soldado>> army, int num){
        ArrayList<Soldado> fillList = new ArrayList<Soldado>(); //CREAMOS ESTE ARRAYLIST PARA PODER GUARDAR A LOS SOLDADOS EN UN SOLO ARRAYLIST EL CUAL SEA EFECTIVO EL METODO BURBUJA 
        Soldado soldier = null; //SOLDADO CREADO PARA PODER CONTENER EL INTERCAMBIO ENTRE SOLDADOS EN EL METODO BURBUJA
        for(int i = 0; i < army.size(); i++){ //CREAMOS ESTAS SENTENCIAS PARA PODER VERIFICAR EL NUMERO DE SOLDADOS PARA DESPUES PONER EL RANKING DE PUESTOS DE CADA UNO DE ESTOS SOLDADOS
               for(int j = 0; j < army.get(i).size(); j++){
                      if(army.get(i).get(j) != null){
                            fillList.add(army.get(i).get(j));
                      }
               }
        }
        System.out.println("Ordenando a los soldados del Ejercito " + num + " por el metodo burbuja: "); //APLICAMOS EL METODO BURBUJA CON LOS PUNTOS DE VIDA
        for(int i = 0; i < fillList.size() - 1; i++){
            for(int j = 0; j < fillList.size() - i - 1; j++){
                   if(fillList.get(j).getHealth() < fillList.get(j + 1).getHealth()){
                        soldier = fillList.get(j); //INTERCAMBIO
                        fillList.set(j , fillList.get(j + 1));
                        fillList.set(j + 1, soldier);
                   }
            }      
        }
        System.out.println("------------------------------------------");
        System.out.println("Mostrando Ranking del Ejercito " + num + "....."); //MOSTRADOR DE RANKING DE LOS SOLDADOS
        for(int i = 0; i < fillList.size(); i++){
               System.out.print("\n" + "Puesto " + (i + 1));
               System.out.println(fillList.get(i).toString());
               System.out.println("------------------");
        }
        System.out.println("*********************************");
    }
    public static void rankingInsercionHealth(ArrayList<ArrayList<Soldado>> army, int num){
        ArrayList<Soldado> fillList = new ArrayList<Soldado>(); //CREAMOS ESTE ARRAYLIST PARA PODER GUARDAR A LOS SOLDADOS EN UN SOLO ARRAYLIST EL CUAL SEA EFECTIVO EL METODO INSERCION 
        for(int i = 0; i < army.size(); i++){ //CREAMOS ESTAS SENTENCIAS PARA PODER VERIFICAR EL NUMERO DE SOLDADOS Y TAMBIEN AÑADIRLO EN EL ARRAYLIST CREADO PARA DESPUES PONER EL RANKING DE PUESTOS DE CADA UNO DE ESTOS SOLDADOS
               for(int j = 0; j < army.get(i).size(); j++){
                      if(army.get(i).get(j) != null){
                            fillList.add(army.get(i).get(j));
                      }
               }
        }
        System.out.println("Ordenando a los soldados del Ejercito " + num + " por el insercion: "); //APLICAMOS EL METODO INSERCION CON LOS PUNTOS DE VIDA
        for(int i = 1; i < fillList.size(); i++){
            Soldado soldier = fillList.get(i);
            int j = i - 1;
            while(j >= 0 && (soldier.getHealth() > fillList.get(j).getHealth())){ //APLICAMOS EL METODO INSERCION
                fillList.set(j + 1, fillList.get(j));
                j--;
            }
            fillList.set(j + 1, soldier);
        }
        System.out.println("Mostrando Ranking del Ejercito " + num + "....."); //MOSTRADOR DE RANKING DE LOS SOLDADOS
        for(int i = 0; i < fillList.size(); i++){
               System.out.print("\n" + "Puesto " + (i + 1));
               System.out.println(fillList.get(i).toString()); //DAMOS A CONOCER SUS DATOS Y EL PUESTO EN EL RANKING
               System.out.println("------------------");
        }
        System.out.println("*********************************");
    }
    public static void resultBattle(ArrayList<ArrayList<Soldado>> army1, ArrayList<ArrayList<Soldado>> army2, int num, int num2){
        int sumarmy1 = 0;
        int sumarmy2 = 0;
        System.out.println("El resultado de esta Batalla se decidio por el nivel de fuerza de cada ejercito por lo que el resultado es: ...");
        for(int i = 0; i < army1.size(); i++){ //METODO CREADO QUE NOS PERMITE DAR CON UN GANADOR ESTO GRACIAS AL NIVEL DE PUNTOS DE VIDA O FUERZA DE CADA EJERCITO EL CUAL VAMOS SUMANDO DE CADA EJERCITO PARA DESPUES COMPARARLOS Y DECIDIR EL RESULTADO DE ESTA BATALLA
            for(int j = 0 ; j < army1.get(i).size(); j++){
                if(army1.get(i).get(j) != null){
                    sumarmy1 += army1.get(i).get(j).getHealth(); //SUMA DE PUNTOS DEL EJERCITO 1
                }
            }
        }
        for(int i = 0; i < army2.size(); i++){
            for(int j = 0 ; j < army2.get(i).size(); j++){
                if(army2.get(i).get(j) != null){
                    sumarmy2 += army2.get(i).get(j).getHealth(); //SUMA DE PUNTOS DEL EJERCITO 2
                }
            }
        }
        if(sumarmy1 > sumarmy2){ //PUBLICACION DE LOS RESULTADOS
            System.out.println("El Ejercito " + num + " es el GANADOR con " + sumarmy1 + " puntos");
        }else if(sumarmy2 > sumarmy1){
            System.out.println("El Ejercito " + num2 + " es el GANADOR con " + sumarmy2 + " puntos");
        }else{
            System.out.println("EMPATE con " + sumarmy1 + " puntos");
        }
    }
    public static void main(String args[]){
        ArrayList<ArrayList<Soldado>> army1 = fillregisterSoldiers(1);
        ArrayList<ArrayList<Soldado>> army2 = fillregisterSoldiers(2);
        viewBoard(army1, army2);
        longerLife(army1, 1);
        longerLife(army2, 2);
        averageLife(army1, 1);
        averageLife(army2, 2);
        rankingBurbujaHealth(army1 , 1);
        rankingBurbujaHealth(army2 , 2);    
        rankingInsercionHealth(army1, 1);
        rankingInsercionHealth(army2, 2);
        resultBattle(army1, army2, 1, 2);
    }
}