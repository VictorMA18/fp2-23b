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
        System.out.print("*********************************");
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
    public static void arrayListAverageLife(ArrayList<ArrayList<Soldado>> army, int num){
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
    public static void arrayAverageLife(Soldado[][] army, int num){
        int sum = 0;
        int cont = 0;
        for(int i = 0; i < army.length; i++){
               for(int j = 0; j < army.length; j++){
                      if(army[i][j] != null){
                             sum += army[i][j].getHealth(); //SUMAMOS LA VIDA DE LOS SOLDADOS DEL EJERCITO 2 
                             cont++;//CONTADOR PARA VER CUANTOS SOLDADOS EXISTEN EN ESTE EJERCITO PARA DESPUES PODER DIVIDIRLO CON SU SUMA
                      }
               }
        }
        double avg = sum / (cont * 1.0);
        System.out.println("El promedio de puntos de vida del Ejercito " + num + " es: " + "\n" + avg);
        System.out.println("*********************************"); // AGREGANDOLO PARA HACER EL SIGUIENTE METODO Y SEPARARLOS
   }
   public static void arrayListRankingBurbujaLife(ArrayList<ArrayList<Soldado>> army, int num){
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
        System.out.println("Mostrando Ranking del Ejercito " + num + " ..... ////// --->"); //MOSTRADOR DE RANKING DE LOS SOLDADOS
        for(int i = 0; i < fillList.size(); i++){
            System.out.print("\n" + "Puesto " + (i + 1));
            System.out.println(fillList.get(i).toString());
            System.out.println("------------------");
        }
        System.out.println("*********************************");
   }
    public static void arrayRankingBurbujaLife(Soldado[][] army, int num){
        int numsoldiers = 0;
        int count = 0;
        Soldado soldier = null;
        for(int i = 0; i < army.length; i++){ //CREAMOS UN CONTADOR PARA SABER EL NUMERO DE SOLDADOS DE ESTE EJERCITO Y DESPUES CREAR UN ARREGLO EL CUAL PODEAMOS DARLE ESTE TAMAÑO Y LO PODAMOS USAR PARA EL METODO BURBUJA
            for(int j = 0; j < army[i].length; j++){
                    if(army[i][j] != null){
                        numsoldiers++;
                    }
            }
        }
        Soldado[] soldiers = new Soldado[numsoldiers];
        for(int i = 0; i < army.length; i++){ //CREAMOS ARREGLO PARA QUE LOS SOLDADOS SE TRASLADEN DE UN ARREGLO BIDIMENSIONAL A UNO UNIDIMENSIONAL PARA APLICAR EL METODO BURBUJA
            for(int j = 0; j < army[i].length; j++){
                    if(army[i][j] != null){
                        soldiers[count] = army[i][j];
                        count++;
                    }
            }
        }
        System.out.println("Ordenando a los soldados del Ejercito " + num + " por el metodo burbuja: ");//APLICAMOS EL METODO BURBUJA CON LOS PUNTOS DE VIDA
        for(int i = 0; i < numsoldiers - 1; i++){
            for(int j = 0; j < numsoldiers - i - 1; j++){
                    if(soldiers[j].getHealth() < soldiers[j + 1].getHealth()){
                            soldier = soldiers[j];
                            soldiers[j] = soldiers[j + 1];
                            soldiers[j + 1] = soldier;
                    }
            }      
        }
        System.out.println("------------------------------------------");
        System.out.println("Mostrando Ranking del Ejercito " + num + " ..... ////// --->"); //DAMOS A CONOCER EL RANKING DE ESTE EJERCITO  EL CUAL LO PUBLICAMOS MEDIANTE PUESTOS 
        for(int i = 0; i < soldiers.length; i++){
            System.out.print("\n" + "Puesto " + (i + 1));
            System.out.println(soldiers[i].toString()); //PUBLICAMOS INFORMACION DE CADA SOLDADO
            System.out.println("------------------");
        }
        System.out.println("*********************************");
    }
    public static void arrayListRankingInsercionLife(ArrayList<ArrayList<Soldado>> army, int num){
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
    public static void arrayRankingInsercionLife(Soldado[][] army, int num){
        int numsoldiers = 0;
        int count = 0;
        for(int i = 0; i < army.length; i++){ //CREAMOS UN CONTADOR PARA SABER EL NUMERO DE SOLDADOS DE ESTE EJERCITO Y DESPUES CREAR UN ARREGLO EL CUAL PODEAMOS DARLE ESTE TAMAÑO Y LO PODAMOS USAR PARA EL METODO BURBUJA
            for(int j = 0; j < army[i].length; j++){
                    if(army[i][j] != null){
                        numsoldiers++;
                    }
            }
        }
        Soldado[] soldiers = new Soldado[numsoldiers];
        for(int i = 0; i < army.length; i++){ //CREAMOS ARREGLO PARA QUE LOS SOLDADOS SE TRASLADEN DE UN ARREGLO BIDIMENSIONAL A UNO DIMENSIONAL PARA APLICAR EL METODO INSERCION
               for(int j = 0; j < army[i].length; j++){
                      if(army[i][j] != null){
                             soldiers[count] = army[i][j];
                             count++;
                      }
               }
        }
        System.out.println("Ordenando a los soldados del Ejercito " + num + " por el insercion: ");  //APLICAMOS EL METODO INSERCION CON LOS PUNTOS DE VIDA
        for(int i = 1; i < soldiers.length; i++){
               Soldado temp = soldiers[i];
               int j = i - 1;
               while(j >= 0 && (temp.getHealth() > soldiers[j].getHealth())){
                   soldiers[j + 1] = soldiers[j];
                   j--;
               }
               soldiers[j + 1] = temp;
        }
        System.out.println("------------------------------------------");
        System.out.println("Mostrando Ranking del Ejercito " + num + ".....");
        for(int i = 0; i < soldiers.length; i++){
               System.out.print("\n" + "Puesto " + (i + 1));
               System.out.println(soldiers[i].toString());
               System.out.println("------------------");
        }
        System.out.println("*********************************");
   }
    public static void resultBattle(ArrayList<ArrayList<Soldado>> army1, Soldado[][] army2, int num, int num2){
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
        for(int i = 0; i < army2.length; i++){
            for(int j = 0 ; j < army2[i].length; j++){
                if(army2[i][j] != null){
                    sumarmy2 += army2[i][j].getHealth(); //SUMA DE PUNTOS DEL EJERCITO 2
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
        ArrayList<ArrayList<Soldado>> army1 = arrayListFillRegister(1);
        Soldado[][] army2 = arrayfillregister(2);
        viewBoard(army1, army2);
        arrayListLongerLife(army1, 1);
        arrayLongerLife(army2, 2);
        arrayListAverageLife(army1, 1);
        arrayAverageLife(army2, 2);
        arrayListRankingBurbujaLife(army1, 1);
        arrayRankingBurbujaLife(army2, 2);
        arrayListRankingInsercionLife(army1, 1);
        arrayRankingInsercionLife(army2, 2);
        resultBattle(army1, army2 , 1 , 2);
    }
}