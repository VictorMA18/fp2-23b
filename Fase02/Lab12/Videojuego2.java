// Laboratorio Nro 12 - Ejercicio Videojuego1
// Autor: Mamani Anahua Victor Narciso
// Colaboro:
// Tiempo:
import java.util.*;
class Videojuego2 {
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
    public static void longerLife(ArrayList<ArrayList<Soldado>> army, int num){
        int mayor = 0;//METODO CREADO PARA PODER PERMITIRNOS A CONOCER EL SOLDADO CON MAYOR VIDA DE CADA EJERCITO 
        Soldado soldier = null;
        for(int i = 0; i < army.size(); i++){
            for(int j = 0; j < army.get(i).size(); j++){
                if(army.get(i).get(j) != null){ //COMPROBACION QUE HACEMOS PARA PODER DECIR QUE EL CASILLERO DONDE ESTAMOS ES UN SOLDADO QUE EXISTE
                    if(army.get(i).get(j).getLifeActual() > mayor){ //COMPARAMOS PUNTOS DE VIDA DE CADA SOLDADO PARA VER QUIEN ES EL MAYOR 
                        mayor = army.get(i).get(j).getLifeActual();
                        soldier = army.get(i).get(j);
                    }
                }
            }
        }
        System.out.println("El soldado con mayor vida del Ejercito " + num + " es: ");
        System.out.println(soldier.toString());//IMPRIMIMOS SUS DATOS PARA PODER VER DE QUE SOLDADO SE TRATA 
        System.out.println("*********************************");
    }
    public static double averageLife(ArrayList<ArrayList<Soldado>> army , int num){
        int sum = 0;
        int count = 0;
        System.out.println("El promedio de puntos de vida del Ejercito " + num + " es: ");
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){ //ITERACION LA CUAL NOS AYUDA A PASAR POR TODOS LOS SOLDADOS DE CADA EJERCITO
                if(army.get(i).get(j) != null){ 
                    sum += army.get(i).get(j).getLifeActual();
                    count++;
                }
            }
        }
        if(sum != 0){
            double avg = sum / (count * 1.0);
            System.out.println(avg); // DAMOS A CONOCER EL PROMEDIO DE VIDA DE CADA EJERCITO 
            System.out.println("*********************************");
            return avg;
        }else{
            double avg = 0;
            System.out.println(avg); // DAMOS A CONOCER EL PROMEDIO DE VIDA DE CADA EJERCITO 
            System.out.println("*********************************");
            return avg;
        }
    }
    public static void rankingBurbujaLife(ArrayList<ArrayList<Soldado>> army , int num){
        System.out.println("\nEl Ejercito " + num + " ordenando por metodo burbuja: ");
        int count = 0;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){ //ITERACION LA CUAL NOS AYUDA A PASAR POR TODOS LOS SOLDADOS DE CADA EJERCITO
                if(army.get(i).get(j) != null){ 
                   count++;
                }
            }
        }
        System.out.println("------------------------------------------");
        System.out.println("Mostrando Ranking del Ejercito " + num + " ..... ////// --->");
        Soldado[] soldados = new Soldado[count];
        int x = 0;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){ //ITERACION LA CUAL NOS AYUDA A PASAR POR TODOS LOS SOLDADOS AL ARRAY SOLDADO PARA PODER USAR EL USO DEL METODO DE ORDENACION BURBUJA
                if(army.get(i).get(j) != null){ 
                    if(count - count + x == count){
                        break;
                    }else{
                        soldados[count - count + x] = army.get(i).get(j);
                    }
                    x++;   
                }
            }
        }
        int n = soldados.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (soldados[j].getLifeActual() < soldados[j + 1].getLifeActual()) {
                    // Intercambiar elementos si están en el orden incorrecto
                    Soldado temp = soldados[j];
                    soldados[j] = soldados[j + 1];
                    soldados[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i < soldados.length; i++){
            System.out.print("\n" + "Puesto " + (i + 1));
            System.out.println(soldados[i].toString());
            System.out.println("------------------");
        }
        System.out.println("*********************************");
    }
    public static void rankingInsercionLife(ArrayList<ArrayList<Soldado>> army , int num){
        System.out.println("\nEl Ejercito " + num + " ordenando por metodo insercion: ");
        int count = 0;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){ //ITERACION LA CUAL NOS AYUDA A PASAR POR TODOS LOS SOLDADOS DE CADA EJERCITO
                if(army.get(i).get(j) != null){ 
                   count++;
                }
            }
        }
        System.out.println("------------------------------------------");
        System.out.println("Mostrando Ranking del Ejercito " + num + " ..... ////// --->");
        Soldado[] soldados = new Soldado[count];
        int x = 0;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){ //ITERACION LA CUAL NOS AYUDA A PASAR POR TODOS LOS SOLDADOS AL ARRAY SOLDADO PARA PODER USAR EL USO DEL METODO DE ORDENACION INSERCION
                if(army.get(i).get(j) != null){ 
                    if(count - count + x == count){
                        break;
                    }else{
                        soldados[count - count + x] = army.get(i).get(j); //LA MISMA LOGICA QUE EL ANTERIOR METODO SOLO QUE EN ESTE LO USARIAMOS DE MANERA DIFERENTE YA QUE ESTE SERIA DE FORMA DE INSERCION
                    }
                    x++;   
                }
            }
        }
        int n = soldados.length;
        for (int i = 1; i < n; i++) {
            Soldado actual = soldados[i];
            int j = i - 1;
            while (j >= 0 && soldados[j].getLifeActual() < actual.getLifeActual()) { //ORDENAMOS EL EJERCITO RESPECTIVAMENTE MEDIANTE EL METODO QUE NOS OFRECE INSERCION EL CUAL ES ESTE CODIGO
                soldados[j + 1] = soldados[j];
                j--;
            }
            soldados[j + 1] = actual;
        }
        for(int i = 0; i < soldados.length; i++){
            System.out.print("\n" + "Puesto " + (i + 1));
            System.out.println(soldados[i].toString()); //PUBLICAMOS RESULTADOS
            System.out.println("------------------");
        }
        System.out.println("*********************************");
    }
    public static void optionsPlayer(){
        System.out.println(" TIENE QUE SELECCIONAR UNA OPCION");
        System.out.println(" 1 : MOVER SOLDADO");
        System.out.println(" 2 : SALTAR TURNO");
    }
    public static void optionsbattle(ArrayList<ArrayList<Soldado>> army1 , ArrayList<ArrayList<Soldado>> army2){
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------------------");
        System.out.println("--          OPCIONES DE BATALLA          --"); 
        System.out.println("-------------------------------------------");
        System.out.println(" SELECCIONE UN NUMERO PARA PODER EMPEZAR O TERMINAR");
        System.out.println(" 1 : JUEGO RAPIDO");
        System.out.println(" 2 : JUEGO PERSONALIZADO");
        int optbattle = sc.nextInt();
        if(optbattle == 1){
            battle(army1, army2);
        }else{
            battlePersonalized(army1, army2);
        }
    }
    public static void battle(ArrayList<ArrayList<Soldado>> army1 , ArrayList<ArrayList<Soldado>> army2){
        Scanner sc = new Scanner(System.in);
        Soldado soldier = null;
        int numberoption = 0;
        int playeroption = 0;
        int numbersoldiers = 0;
        System.out.println("-------------------------------------------");
        System.out.println("--             MENU PRINCIPAL            --"); 
        System.out.println("-------------------------------------------");
        System.out.println(" SELECCIONE UN NUMERO PARA PODER EMPEZAR O TERMINAR");
        System.out.println(" 1 : JUGAR");
        System.out.println(" 2 : NO JUGAR");
        numberoption = sc.nextInt();
        viewBoard(army1, army2);
        do { //CREAMOS UN DO WHILE EL CUAL NOS VA PODER PERMITIR INTERACTUAR CON LOS JUGADORES PARA EL EMPEZAR EL JUEGO EL CUAL TENDRA QUE HACER VUELTAS INFINITAS PARA PODER INTERACTUAR CON LOS JUGADORES
            numbersoldiers = 0;
            if(numberoption == 1){
                System.out.println(" EMPIEZA EL JUGADOR CON EL BANDO --X-- ");
                for(int i = 0; i < 10; i++){  //ITERACION CREADA PARA PODER SABER QUE SI ESTE BANDO DEL EJERCITO TIENE SOLDADOS PARA PODER JUGAR EL CUAL VAMOS A TENER QUE CONTAR
                    for(int j = 0; j < 10; j++){
                        if(army1.get(i).get(j) != null){
                            numbersoldiers++;
                        }
                    }
                }
                if(numbersoldiers == 0){
                    System.out.println("(FELICITACIONES!!!!!!) TENEMOS UN GANADOR EL EJERCITO --Y--");
                    break;
                }
                optionsPlayer(); //METODO CREADO PARA PODER DARLE OPCIONES AL JUGADOR QUE JUGADA REALIZAR O RETIRARSE DEL JUEGO
                playeroption = sc.nextInt();
                if(playeroption == 1){
                    int row , rowafter = 0;
                    String column , columnafter = "";
                    System.out.println("\n-Seleccione el soldado: ");
                    System.out.print("Fila: ");
                    row = sc.nextInt() - 1;
                    System.out.print("Columna: ");
                    column = sc.next();
                    int columnnumber = (int)column.charAt(0) - 65; 
                    System.out.println("\n-Ingrese la casilla a mover");
                    System.out.print("Fila: ");
                    rowafter = sc.nextInt() - 1;
                    System.out.print("Columna: ");
                    columnafter = sc.next();
                    int columnafternumber = (int)columnafter.charAt(0) - 65;  
                    while (row >= 10 || columnnumber >= 10 || rowafter >= 10 || columnafternumber >= 10) {
                        System.out.println("POSICIONES INCORRECTAS");
                        System.out.println("\n-Seleccione el soldado: ");
                        System.out.print("Fila: ");
                        row = sc.nextInt() - 1;
                        System.out.print("Columna: ");
                        column = sc.next();
                        columnnumber = (int)column.charAt(0) - 65; 
                        System.out.println("\n-Ingrese la casilla a mover");
                        System.out.print("Fila: ");
                        rowafter = sc.nextInt() - 1;
                        System.out.print("Columna: ");
                        columnafter = sc.next();
                        columnafternumber = (int)columnafter.charAt(0) - 65;  
                    }
                    if(army1.get(rowafter).get(columnafternumber) == null && army2.get(rowafter).get(columnafternumber) == null){
                        soldier = army1.get(row).get(columnnumber);
                        army1.get(row).set(columnnumber, null);
                        army1.get(rowafter).set(columnafternumber,soldier);
                        viewBoard(army1, army2);
                    }else {
                        while (army1.get(rowafter).get(columnafternumber) != null ){
                            System.out.println("\n-JUGADA NO VALIDA");
                            System.out.println("\n-INGRESE NUEVOS DATOS");
                            System.out.println("\n-Seleccione el soldado: ");
                            System.out.print("Fila: ");
                            row = sc.nextInt() - 1;
                            System.out.print("Columna: ");
                            column = sc.next();
                            columnnumber = (int)column.charAt(0) - 65; 

                            System.out.println("\n-Ingrese la casilla a mover");    
                            System.out.print("Fila: ");
                            rowafter = sc.nextInt() - 1;
                            System.out.print("Columna: ");
                            columnafter = sc.next();
                            columnafternumber = (int)columnafter.charAt(0) - 65; 
                        }
                        if(army1.get(rowafter).get(columnafternumber) == null && army2.get(rowafter).get(columnafternumber) == null){
                            soldier = army1.get(row).get(columnnumber);
                            army1.get(row).set(columnnumber, null);
                            army1.get(rowafter).set(columnafternumber,soldier);
                        }else if(army2.get(rowafter).get(columnafternumber) != null){
                            int health1 = army1.get(row).get(columnnumber).getLifeActual();
                            int health2 = army2.get(rowafter).get(columnafternumber).getLifeActual();
                            if(health2 > health1){
                                double sumhealth = (health2 + health1);
                                System.out.println("\n \t Resultado de la Batalla");
                                System.out.println("El soldado del bando Y es el ganador ya que su probabilidad de ganar la batalla es --> " +  String.format( "%.1f" , ((health2/sumhealth) * 1000 ) / 10)  + "% y la probabilidad del soldado del bando X es ---> " +  String.format( "%.1f" , ((health1/sumhealth) * 1000) / 10) + "%" );
                                army1.get(row).set(columnnumber, null);
                                army2.get(rowafter).get(columnafternumber).setLifeActual(health2 + 1);
                            }else if(health1 > health2){
                                double sumhealth = (health2 + health1) * 1.0;
                                System.out.println("\n \t Resultado de la Batalla");
                                System.out.println("El soldado del bando X es el ganador ya que su probabilidad de ganar la batalla es --> " +  String.format( "%.1f" , ((health1/sumhealth) * 1000 ) / 10)  + "% y la probabilidad del soldado del bando Y es ---> " + String.format( "%.1f" , ((health2/sumhealth) * 1000) / 10) + "%" );
                                army2.get(rowafter).set(columnafternumber, null); //ELIMINAMOS AL SOLDADO DEL OTRO BANDO DE ESA CASILLA
                                army1.get(row).get(columnnumber).setLifeActual(health1 + 1); //CAMBIAMOS LA VIDA ANTES DE MANDARLO CON EL OBJETO SOLDADO QUE HICIMOS
                                soldier = army1.get(row).get(columnnumber);
                                army1.get(row).set(columnnumber, null); //ELIMINAMOS AL SOLDADO DE LA CASILLA DE DONDE ESTABA
                                army1.get(rowafter).set(columnafternumber, soldier); //PONEMOS AL SOLDADO EN LA NUEVA CASILLA
                            }else{
                                System.out.println("\n \t Resultado de la Batalla");
                                System.out.println("Los 2 soldados murieron por la batalla de la cuadrilla");
                                army1.get(row).set(columnnumber, null);
                                army2.get(rowafter).set(columnafternumber, null);
                            }
                        }
                        viewBoard(army1, army2);
                    }
                }
                numbersoldiers = 0;
                System.out.println(" EMPIEZA EL JUGADOR CON EL BANDO --Y-- ");
                for(int i = 0; i < 10; i++){  //ITERACION CREADA PARA PODER SABER QUE SI ESTE BANDO DEL EJERCITO TIENE SOLDADOS PARA PODER JUGAR EL CUAL VAMOS A TENER QUE CONTAR
                    for(int j = 0; j < 10; j++){
                        if(army2.get(i).get(j) != null){
                            numbersoldiers++;
                        }
                    }
                }
                if(numbersoldiers == 0){
                    System.out.println("(FELICITACIONES!!!!!!) TENEMOS UN GANADOR EL EJERCITO --X--");
                    break;
                }
                optionsPlayer();
                playeroption = sc.nextInt();
                if(playeroption == 1){
                    int row , rowafter = 0;
                    String column , columnafter = "";
                    System.out.println("\n-Seleccione el soldado: ");
                    System.out.print("Fila: ");
                    row = sc.nextInt() - 1;
                    System.out.print("Columna: ");
                    column = sc.next();
                    int columnnumber = (int)column.charAt(0) - 65;  
                    System.out.println("\n-Ingrese la casilla a mover");
                    System.out.print("Fila: ");
                    rowafter = sc.nextInt() - 1;
                    System.out.print("Columna: ");
                    columnafter = sc.next();
                    int columnafternumber = (int)columnafter.charAt(0) - 65; 
                    while (row >= 10 || columnnumber >= 10 || rowafter >= 10 || columnafternumber >= 10) {
                        System.out.println("POSICIONES INCORRECTAS");
                        System.out.println("\n-Seleccione el soldado: ");
                        System.out.print("Fila: ");
                        row = sc.nextInt() - 1;
                        System.out.print("Columna: ");
                        column = sc.next();
                        columnnumber = (int)column.charAt(0) - 65; 
                        System.out.println("\n-Ingrese la casilla a mover");
                        System.out.print("Fila: ");
                        rowafter = sc.nextInt() - 1;
                        System.out.print("Columna: ");
                        columnafter = sc.next();
                        columnafternumber = (int)columnafter.charAt(0) - 65;  
                    }
                    if(army1.get(rowafter).get(columnafternumber) == null && army2.get(rowafter).get(columnafternumber) == null){
                        soldier = army2.get(row).get(columnnumber);
                        army2.get(row).set(columnnumber, null);
                        army2.get(rowafter).set(columnafternumber,soldier);
                        viewBoard(army1, army2);
                    }else {
                        while (army2.get(rowafter).get(columnafternumber) != null || row >= 10 || columnnumber >= 10 || rowafter >= 10 || columnafternumber >= 10){
                            System.out.println("\n-JUGADA NO VALIDA");
                            System.out.println("\n-INGRESE NUEVOS DATOS");
                            System.out.println("\n-Seleccione el soldado: ");
                            System.out.print("Fila: ");
                            row = sc.nextInt() - 1;
                            System.out.print("Columna: ");
                            column = sc.next();
                            columnnumber = (int)column.charAt(0) - 65; 

                            System.out.println("\n-Ingrese la casilla a mover");    
                            System.out.print("Fila: ");
                            rowafter = sc.nextInt() - 1;
                            System.out.print("Columna: ");
                            columnafter = sc.next();
                            columnafternumber = (int)columnafter.charAt(0) - 65; 
                        }
                        if(army1.get(rowafter).get(columnafternumber) == null ){
                            soldier = army2.get(row).get(columnnumber);
                            army2.get(row).set(columnnumber, null);
                            army2.get(rowafter).set(columnafternumber,soldier);
                        }else if(army1.get(rowafter).get(columnafternumber) != null){
                            int health1 = army2.get(row).get(columnnumber).getLifeActual();
                            int health2 = army1.get(rowafter).get(columnafternumber).getLifeActual();
                            if(health2 > health1){
                                double sumhealth = (health2 + health1) * 1.0;
                                System.out.println("\n \t Resultado de la Batalla");
                                System.out.println("El soldado del bando X es el ganador ya que su probabilidad de ganar la batalla es --> " +  String.format( "%.1f" , ((health2/sumhealth) * 1000 ) / 10)  + "% y la probabilidad del soldado del bando Y es ---> " + String.format( "%.1f" , ((health1/sumhealth) * 1000) / 10) + "%" );
                                army2.get(row).set(columnnumber, null);
                                army1.get(rowafter).get(columnafternumber).setLifeActual(health2 + 1);
                            }else if(health1 > health2){
                                double sumhealth = (health2 + health1) * 1.0; 
                                System.out.println("\n \t Resultado de la Batalla");
                                System.out.println("El soldado del bando Y es el ganador ya que su probabilidad de ganar la batalla es --> " +  String.format( "%.1f" , ((health1/sumhealth) * 1000 ) / 10)  + "% y la probabilidad del soldado del bando X es ---> " + String.format( "%.1f" , ((health2/sumhealth) * 1000) / 10) + "%" );
                                army1.get(rowafter).set(columnafternumber, null); //ELIMINAMOS AL SOLDADO DEL OTRO BANDO DE ESA CASILLA
                                army2.get(row).get(columnnumber).setLifeActual(health1 + 1); //CAMBIAMOS LA VIDA ANTES DE MANDARLO CON EL OBJETO SOLDADO QUE HICIMOS
                                soldier = army2.get(row).get(columnnumber);
                                army2.get(row).set(columnnumber, null); //ELIMINAMOS AL SOLDADO DE LA CASILLA DE DONDE ESTABA
                                army2.get(rowafter).set(columnafternumber, soldier); //PONEMOS AL SOLDADO EN LA NUEVA CASILLA
                            }else{
                                System.out.println("\n \t Resultado de la Batalla");
                                System.out.println("Los 2 soldados murieron por la batalla de la cuadrilla");
                                army2.get(row).set(columnnumber, null);
                                army1.get(rowafter).set(columnafternumber, null);
                            }
                        }
                        viewBoard(army1, army2);
                    }
                }
            }else{
                break;   
            }
        } while (true);
    }
    public static void battlePersonalized(ArrayList<ArrayList<Soldado>> army1 , ArrayList<ArrayList<Soldado>> army2){
        Scanner sc = new Scanner(System.in);
        System.out.println("Gestionar Ejercito \n[1] Ejercito 1\n[2] Ejercito 2");
        int optarmy = sc.nextInt();
        do {
            System.out.println("Escoja una de estas opciones para el ejercito 1");
            System.out.println("[1] Crear Soldado"+
                                "\n[2] Eliminar Soldado" + 
                                "\n[3] Clonar Soldado"+
                                "\n[4] Modificar Soldado"+
                                "\n[5] Comparar Soldados"+
                                "\n[6] Intercambiar Soldados"+
                                "\n[7] Ver soldado"+
                                "\n[8] Ver ejercito"+
                                "\n[9] Sumar Niveles"+
                                "\n[10] Jugar" +
                                "\n[11] Volver");
            int optPersonalized = sc.nextInt();
            switch (optPersonalized) {
                case 1:
                    createdSoldier(army1);
                    viewBoard(army1, army2);
                    break;
                case 2:
                    deleteSoldier(army1);                    
                    viewBoard(army1, army2);
                    break;
                case 3:
                    cloneSoldier(army1);
                    viewBoard(army1, army2);
                    break;
                case 4:
                    changeSoldier(army1);
                    viewBoard(army1, army2);
                    break;
                case 5:
                    compareSoldier(army1);
                    viewBoard(army1, army2);
                default:
                    break;
            }
        } while (optarmy == 1);
    }
    public static void createdSoldier(ArrayList<ArrayList<Soldado>> army){
        Scanner sc = new Scanner(System.in);
        int numbersoldiers = 0;
        for(int i = 0; i < 10; i++){  //ITERACION CREADA PARA PODER SABER QUE SI ESTE BANDO DEL EJERCITO TIENE SOLDADOS PARA PODER JUGAR SI TIENE 10 ESTA OPCION ESTA CANCELADA
            for(int j = 0; j < 10; j++){
                if(army.get(i).get(j) != null){
                    numbersoldiers++;
                }
            }
        }
        if(numbersoldiers == 10){
            System.out.println("*********************************");
            System.out.println("USTED NO PUEDE CREAR MAS SOLDADOS EL MAXIMO ES 10 SOLDADOS POR EJERCITO");
        }else{
            System.out.println("*********************************");
            System.out.println("El nombre del soldado:");
            String name = sc.next();
            System.out.println("La vida del soldado es de 1 a 5:");
            int health = sc.nextInt();
            System.out.println("Escriba la fila donde va a estar el soldado:");
            int row = sc.nextInt() - 1;
            System.out.println("Escriba la columna donde va a estar el soldado:");
            String column = sc.next();
            Soldado soldier =  new Soldado(name, health, numbersoldiers, column);
            army.get(row).set((int)column.charAt(0) - 65, soldier);
        }
    }
    public static void deleteSoldier(ArrayList<ArrayList<Soldado>> army ){
        Scanner sc = new Scanner(System.in);
        int numbersoldiers = 0;
        for(int i = 0; i < 10; i++){  //ITERACION CREADA PARA PODER SABER QUE SI ESTE BANDO DEL EJERCITO TIENE SOLDADOS PARA PODER JUGAR SI TIENE 10 ESTA OPCION ESTA CANCELADA
            for(int j = 0; j < 10; j++){
                if(army.get(i).get(j) != null){
                    numbersoldiers++;
                }
            }
        }
        if(numbersoldiers == 1){
            System.out.println("*********************************");
            System.out.println("USTED NO PUEDE ELIMINAR MAS SOLDADOS YA QUE ELIMINARIA A SU EJERCITO");    
        }else{
            System.out.println("*********************************");
            System.out.println("Escriba la fila donde esta el soldado el cual eliminara:");
            int row = sc.nextInt() - 1;
            System.out.println("Escriba la columna donde esta el soldado el cual eliminara:");
            String column = sc.next();
            army.get(row).set((int)column.charAt(0) - 65, null);
        }
    }
    public static void cloneSoldier(ArrayList<ArrayList<Soldado>> army){
        Scanner sc = new Scanner(System.in);
        int numbersoldiers = 0;
        for(int i = 0; i < 10; i++){  //ITERACION CREADA PARA PODER SABER QUE SI ESTE BANDO DEL EJERCITO TIENE SOLDADOS PARA PODER JUGAR SI TIENE 10 ESTA OPCION ESTA CANCELADA
            for(int j = 0; j < 10; j++){
                if(army.get(i).get(j) != null){
                    numbersoldiers++;
                }
            }
        }
        if(numbersoldiers == 10){
            System.out.println("*********************************");
            System.out.println("USTED NO PUEDE CLONAR MAS SOLDADOS EL MAXIMO ES 10 SOLDADOS POR EJERCITO");
        }else{
            System.out.println("*********************************");
            System.out.println("Escriba la fila donde esta el soldado que quiere clonar:");
            int row = sc.nextInt() - 1;
            System.out.println("Escriba la columna donde esta el soldado que quiere clonar:");
            String column = sc.next();
            Soldado soldado = army.get(row).get((char)column.charAt(0) - 65);
            System.out.println("Escriba la fila donde va a estar el soldado que quiere clonar:");
            int rowafter = sc.nextInt() - 1;
            System.out.println("Escriba la columna donde va a estar el soldado que quiere clonar:");
            String columnafter = sc.next();
            army.get(rowafter).set((char)columnafter.charAt(0) - 65, soldado);
        }
    }
    public static void changeSoldier(ArrayList<ArrayList<Soldado>> army){
        System.out.println("*********************************");
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba la fila donde esta el soldado el cual modificara:");
        int row = sc.nextInt() - 1;
        System.out.println("Escriba la columna donde esta el soldado el cual modificara:");
        String column = sc.next();
        System.out.println("*********************************");
        System.out.println("QUE DESEA MODIFICAR");
        System.out.println("[1] Nivel de ataque"+
                            "\n[2] Nivel de defensa" + 
                            "\n[3] Nivel de vida Actual");
        int optchangesoldier = sc.nextInt();
        System.out.println("*********************************");
        switch (optchangesoldier) {
            case 1:
                System.out.println(army.get(row).get((int)column.charAt(0) - 65).toString());
                System.out.println("*********************************");
                System.out.println("Cual es el nivel de fuerza que le pondra del 1 al 5 ");
                int attacklevel = sc.nextInt();
                army.get(row).get((int)column.charAt(0) - 65).setAttackLevel(attacklevel);
                System.out.println("*********************************");
                System.out.println(army.get(row).get((int)column.charAt(0) - 65).toString());
                break;
            case 2:
                System.out.println(army.get(row).get((int)column.charAt(0) - 65).toString());
                System.out.println("*********************************");
                System.out.println("Cual es el nivel de defensa que le pondra del 1 al 5 ");
                int defenselevel = sc.nextInt();
                army.get(row).get((int)column.charAt(0) - 65).setDefenseLevel(defenselevel);
                System.out.println("*********************************");
                System.out.println(army.get(row).get((int)column.charAt(0) - 65).toString());
                break;
            case 3:
                System.out.println(army.get(row).get((int)column.charAt(0) - 65).toString());
                System.out.println("*********************************");
                System.out.println("Cual es el nivel de vida actual que le pondra del 1 al 5 ");
                int lifeactuallevel = sc.nextInt();
                army.get(row).get((int)column.charAt(0) - 65).setLifeActual(lifeactuallevel);
                System.out.println("*********************************");
                System.out.println(army.get(row).get((int)column.charAt(0) - 65).toString());
                break;
            default:
                break;
        }
    }
    public static void compareSoldier(ArrayList<ArrayList<Soldado>> army){
        System.out.println("*********************************");
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba la fila donde esta el primer soldado que va comparar:");
        int row = sc.nextInt() - 1;
        System.out.println("Escriba la columna donde esta el primer soldado que va comparar:");
        String column = sc.next();
        System.out.println("EL PRIMER SOLDADO ES:");
        Soldado soldier1 = army.get(row).get((int)column.charAt(0) - 65);
        System.out.println(army.get(row).get((int)column.charAt(0) - 65).toString());
        System.out.println("\nEscriba la fila donde esta el segundo soldado que va comparar:");
        int row2 = sc.nextInt() - 1;
        System.out.println("Escriba la columna donde esta el segundo soldado que va comparar:");
        String column2 = sc.next();
        System.out.println("EL SEGUNDO SOLDADO ES:");
        Soldado soldier2 = army.get(row2).get((int)column2.charAt(0) - 65);
        System.out.println(army.get(row2).get((int)column2.charAt(0) - 65).toString());
        if(soldier1.getName().equals(soldier2.getName()) && soldier1.getAttackLevel() == soldier2.getAttackLevel() && soldier1.getDefenseLevel() == soldier2.getDefenseLevel() && soldier1.getLifeActual() == soldier2.getLifeActual() && soldier1.getLives() == soldier2.getLives()){
            System.out.println("\nLOS SOLDADOS SON IGUALES EN EL ASPECTO DE NOMBRE , NIVEL DE ATAQUE , NIVEL DE DEFENSA , NIVEL DE VIDA ACTUAL Y ESTADO");
        }else{
            System.out.println("NO SON IGUALES EN EL ASPECTO DE NOMBRE , NIVEL DE ATAQUE , NIVEL DE DEFENSA , NIVEL DE VIDA ACTUAL Y ESTADO");
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Soldado>> army1 = fillRegister(1);
        ArrayList<ArrayList<Soldado>> army2 = fillRegister(2);
        viewBoard(army1, army2);
        //longerLife(army1, 1);
        //longerLife(army2, 2);
        //double avg1 = averageLife(army1, 1);
        //double avg2 = averageLife(army2, 2);
        //rankingBurbujaLife(army1, 1);
        //rankingBurbujaLife(army2, 2);
        //rankingInsercionLife(army1, 1);
        //rankingInsercionLife(army2, 2);
        optionsbattle(army1, army2);
        //battle(army1, army2);
        //battlePersonalized(army1 , army2);
    }
}

