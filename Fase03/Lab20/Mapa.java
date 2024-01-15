import java.util.*;

public class Mapa {
    Scanner sc = new Scanner(System.in);
    Random rdm = new Random();
    private String territory;
    private ArrayList<ArrayList<Soldado>> board;
    private ArrayList<ArrayList<Soldado>> army1;
    private ArrayList<ArrayList<Soldado>> army2;
    private static String[] typessoldiers = {"lancero" , "espadachin" , "caballero", "arquero"};
    private String[] typesterritory = {"bosque", "campo abierto", "montaña", "desierto", "playa"};
    private String[] kingdoms = {"Inglaterra", "Francia", "Sacro", "Castilla", "Aragon", "Moros"};
    public Mapa(){
        this.board = fillboard();
    }
    public void iniciarJuego() {
        do {
            menuBatalla();
            int resbattle = sc.nextInt();
            if(resbattle == 1){
                String kingdom1 = kingdoms[rdm.nextInt(6)];
                String kingdom2 = kingdoms[rdm.nextInt(6)];
                this.army1 = fillarray(kingdom1, 1);
                this.army2 = fillarray(kingdom2, 2);
                territory = typesterritory[rdm.nextInt(5)];
                System.out.println("\n*********************************");
                System.out.println("El tipo de territorio es: " + territory);
                System.out.println("\n*********************************");
                bonificacion(army1, territory, kingdom1);
                bonificacion(army2, territory, kingdom2);
                viewSoldiers(kingdom1, 1, army1);
                viewSoldiers(kingdom2, 2, army2);
                viewBoard(army1, army2);
                longerLife(army1, kingdom1);
                longerLife(army2, kingdom2);
            }else{
                if(resbattle == 2){
                    break;
                }else{
                    break;
                }
            }
        } while (true);
    }
    public static ArrayList<ArrayList<Soldado>> fillboard(){
        ArrayList<ArrayList<Soldado>> army = new ArrayList<ArrayList<Soldado>>();
        for(int i = 0; i < 10; i++){ //ITERACION
            army.add(new ArrayList<Soldado>()); //LLENAMOS NUESTROS ARRAYLIST BIDIMENSIONAL CON CADA FILA PARA QUE CUMPLAN CON ESTRUCTURA DEL TABLERO
            for(int j = 0; j < 10 ; j++){//ITERACION
                army.get(i).add(null); // LLENAMOS CADA FILA DEL ARRAYLIST CON UN OBJETO SOLDADO CON TAL QUE ESTE SEA NULL PARA QUE SEPA QUE ESTE TIENE UNA CASILLA PERO NO HAY NADIE TODAVIA SE PUEDE LLENAR 
            }
        }
        return army;
    }
    public static ArrayList<ArrayList<Soldado>> fillarray(String armyespe, int num){
        Random rdm = new Random();
        ArrayList<ArrayList<Soldado>> army = new ArrayList<ArrayList<Soldado>>();
        int numbersoldiers = rdm.nextInt(10) + 1; //NUMERO DE SOLDADOS ALEATORIOS ENTRE 1 A 10 SOLDADOS 
        for(int i = 0; i < 10; i++){ //ITERACION
            army.add(new ArrayList<Soldado>()); //LLENAMOS NUESTROS ARRAYLIST BIDIMENSIONAL CON CADA FILA PARA QUE CUMPLAN CON ESTRUCTURA DEL TABLERO
            for(int j = 0; j < 10 ; j++){//ITERACION
                army.get(i).add(null); // LLENAMOS CADA FILA DEL ARRAYLIST CON UN OBJETO SOLDADO CON TAL QUE ESTE SEA NULL PARA QUE SEPA QUE ESTE TIENE UNA CASILLA PERO NO HAY NADIE TODAVIA SE PUEDE LLENAR 
            }
        }
        System.out.println("El Ejercito " + armyespe + " tiene " + numbersoldiers + " soldados : " ); 
        System.out.println("");
        for(int i = 0; i < numbersoldiers; i++){ //LLENAMOS CASILLAS CON CADA SOLDADO CREADO ALEATORIAMENTE
            Soldado soldado = getRandomSoldado();
            String name = "Soldado" + i + "X" + num;
            //System.out.println(name); PRUEBA QUE SE HIZO PARA VER LOS NOMBRES
            int health = rdm.nextInt(5) + 1;
            int row = rdm.nextInt(10) + 1;
            int speed = rdm.nextInt(5) + 1;
            String column = String.valueOf((char)(rdm.nextInt(10) + 65)); //REUTILIZAMOS CODIGO DEL ANTERIOR ARCHIVO VIDEOJUEGO2.JAVA YA QUE TENDRIAN LA MISMA FUNCIONALIDAD
            //System.out.println(army.get(row - 1).get((int)column.charAt(0) - 65)); PRUEBA QUE SE HIZO PARA COMPROBAR SI EL OBJETO SE ESTABA DANDO O NO CAPAZ NI EXISTIA  
            int lifelevel, defenselevel = 0;
            int attacklevel = 0;
            if (soldado instanceof Espadachin) {
                name = "Espadachin" + i + "X" + num; 
                lifelevel = rdm.nextInt(3) + 8; 
                attacklevel = 10;
                defenselevel = 8;
                soldado.setName(name);                  
                soldado.setAttackLevel(attacklevel);
                soldado.setDefenseLevel(defenselevel);                    
                soldado.setLifeLevel(lifelevel);
                soldado.setRow(row);
                soldado.setColumn(column);
                if(army.get(row - 1).get((int)column.charAt(0) - 65) == null){
                    System.out.println("Registrando al " + (i + 1) + " soldado del Ejercito " + armyespe + "");
                    army.get(row - 1).set((int)column.charAt(0) - 65, new Espadachin(name, attacklevel, defenselevel, lifelevel, speed, "Espadachin", true, row, column, attacklevel));
                    army.get(row - 1).get((int)column.charAt(0) - 65).setSpeed(speed);
                    System.out.println(army.get(row - 1).get((int)column.charAt(0) - 65).toString());
                    System.out.println("---------------------------------");
                }else{
                    i -= 1; //NOS AYUDARIA CON LOS SOLDADOS QUE SE REPITEN EN EL MISMO CASILLERO CON TAL QUE NO DEBERIA CONTAR 
                }
            } else if (soldado instanceof Arquero) {
                name = "Arquero" + i + "X" + num; 
            	attacklevel = 7;
            	defenselevel = 3;
                lifelevel = rdm.nextInt(3) + 3; 
                soldado.setName(name);                  
                soldado.setAttackLevel(attacklevel);
                soldado.setDefenseLevel(defenselevel);                    
                soldado.setLifeLevel(lifelevel);
                soldado.setRow(row);
                soldado.setColumn(column);
                if(army.get(row - 1).get((int)column.charAt(0) - 65) == null){
                    System.out.println("Registrando al " + (i + 1) + " soldado del Ejercito " + armyespe + "");
                    army.get(row - 1).set((int)column.charAt(0) - 65, new Arquero(name, attacklevel, defenselevel, lifelevel, speed, "Arquero", true, row, column, attacklevel));
                    army.get(row - 1).get((int)column.charAt(0) - 65).setSpeed(speed);
                    System.out.println(army.get(row - 1).get((int)column.charAt(0) - 65).toString());
                    System.out.println("---------------------------------");
                }else{
                    i -= 1; //NOS AYUDARIA CON LOS SOLDADOS QUE SE REPITEN EN EL MISMO CASILLERO CON TAL QUE NO DEBERIA CONTAR 
                }
            } else if (soldado instanceof Caballero) {
                name = "Caballero" + i + "X" + num; 
            	attacklevel = 13;
            	defenselevel = 7;
                lifelevel = rdm.nextInt(3) + 10; 
                soldado.setName(name);                  
                soldado.setAttackLevel(attacklevel);
                soldado.setDefenseLevel(defenselevel);                    
                soldado.setLifeLevel(lifelevel);
                soldado.setRow(row);
                soldado.setColumn(column);
                if(army.get(row - 1).get((int)column.charAt(0) - 65) == null){
                    System.out.println("Registrando al " + (i + 1) + " soldado del Ejercito " + armyespe + "");
                    army.get(row - 1).set((int)column.charAt(0) - 65, new Caballero(name, attacklevel, defenselevel, lifelevel, speed, "Caballero", true, row, column, false));
                    army.get(row - 1).get((int)column.charAt(0) - 65).setSpeed(speed);
                    System.out.println(army.get(row - 1).get((int)column.charAt(0) - 65).toString());
                    System.out.println("---------------------------------");
                }else{
                    i -= 1; //NOS AYUDARIA CON LOS SOLDADOS QUE SE REPITEN EN EL MISMO CASILLERO CON TAL QUE NO DEBERIA CONTAR 
                }
            } else if (soldado instanceof Lancero) {
                name = "Lancero" + i + "X" + num; 
            	attacklevel = 5;
            	defenselevel = 10;
            	lifelevel = rdm.nextInt(3) + 5;
                soldado.setName(name);                  
                soldado.setAttackLevel(attacklevel);
                soldado.setDefenseLevel(defenselevel);                    
                soldado.setLifeLevel(lifelevel);
                soldado.setRow(row);
                soldado.setColumn(column);
                if(army.get(row - 1).get((int)column.charAt(0) - 65) == null){
                    System.out.println("Registrando al " + (i + 1) + " soldado del Ejercito " + armyespe + "");
                    army.get(row - 1).set((int)column.charAt(0) - 65, new Lancero(name, attacklevel, defenselevel, lifelevel, speed, "Lancero", true, row, column, attacklevel));
                    army.get(row - 1).get((int)column.charAt(0) - 65).setSpeed(speed);
                    System.out.println(army.get(row - 1).get((int)column.charAt(0) - 65).toString());
                    System.out.println("---------------------------------");
                }else{
                    i -= 1; //NOS AYUDARIA CON LOS SOLDADOS QUE SE REPITEN EN EL MISMO CASILLERO CON TAL QUE NO DEBERIA CONTAR 
                }
            }
        }
        System.out.println("*********************************");
        return army;
    }
    public static void menuBatalla(){
        System.out.println("-------------------------------------------");
        System.out.println("--                 MENU                  --"); 
        System.out.println("-------------------------------------------");
        System.out.println(" SELECCIONE UN NUMERO PARA PODER EMPEZAR O TERMINAR");
        System.out.println(" 1 : JUGAR");
        System.out.println(" 2 : NO JUGAR");
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
                                System.out.print("|  1" + obtenerInicial(army1.get(i).get(j)) + "1  ");
                            }else if(army2.get(i).get(j).getLifeActual() > army1.get(i).get(j).getLifeActual()){
                                army2.get(i).get(j).setLifeActual(army2.get(i).get(j).getLifeActual() - army1.get(i).get(j).getLifeActual());
                                army1.get(i).set(j, null);;
                                System.out.print("|  2" + obtenerInicial(army2.get(i).get(j)) + "2  ");
                            }else{
                                army2.get(i).set(j, null);
                                army1.get(i).set(j, null);
                                System.out.print("|   " + "" + "   ");
                            }
                        }else if(army1.get(i).get(j) != null){
                            System.out.print("|  1" + obtenerInicial(army1.get(i).get(j)) + "1  ");
                        }else if(army2.get(i).get(j) != null){
                            System.out.print("|  2" + obtenerInicial(army2.get(i).get(j)) + "2  ");
                        }else{
                            System.out.print("|   " + " " + "   ");
                        }
                }
                System.out.println("|");
                System.out.println("\t|_______|_______|_______|_______|_______|_______|_______|_______|_______|_______|");
        }
        System.out.println("\n*********************************");
    }
    public static Soldado getRandomSoldado() {
        Random rdm = new Random();
        int tipoSoldado = rdm.nextInt(4);
        switch (tipoSoldado) {
            case 0:
                return new Espadachin();
            case 1:
                return new Arquero();
            case 2:
                return new Lancero();
            case 3:
                return new Caballero();
            default:
                return new Espadachin();
        }
    }
    public static String obtenerInicial(Soldado soldado) {
        if (soldado instanceof Espadachin) {
            return "E";
        } else if (soldado instanceof Arquero) {
            return "A";
        } else if (soldado instanceof Caballero) {
            return "C";
        } else if (soldado instanceof Lancero) {
            return "L";
        } else {
            return "S";
        }
    }
    public void bonificacion(ArrayList<ArrayList<Soldado>> army, String territory , String kingdom) {
        for(int i = 0; i < 10; i++){ //ITERACION
            for(int j = 0; j < 10 ; j++){//ITERACION
                if(army.get(i).get(j) != null){
                    if(kingdom.equals("Inglaterra") && territory.equals("bosque")){
                        army.get(i).get(j).setLifeLevel(army.get(i).get(j).getLifeLevel() + 1);
                    }else if(kingdom.equals("Francia") && territory.equals("campo abierto")){
                        army.get(i).get(j).setLifeLevel(army.get(i).get(j).getLifeLevel() + 1);
                    }else if((kingdom.equals("Castilla") || kingdom.equals("Aragon")) && territory.equals("montaña")){
                        army.get(i).get(j).setLifeLevel(army.get(i).get(j).getLifeLevel() + 1);
                    }else if(kingdom.equals("Moros") && territory.equals("desierto")){
                        army.get(i).get(j).setLifeLevel(army.get(i).get(j).getLifeLevel() + 1);
                    }else if(kingdom.equals("Sacro") && (territory.equals("desierto") || territory.equals("playa") || territory.equals("campo abierto"))){
                        army.get(i).get(j).setLifeLevel(army.get(i).get(j).getLifeLevel() + 1);
                    }
                }
            }
        }
    } 
    public static void viewSoldiers(String armyespe, int num, ArrayList<ArrayList<Soldado>> army){
        int numbersoldiers = 0;
        System.out.println("El Ejercito " + armyespe + " del " + num + " ejercito sus soldados son :");
        for(int i = 0; i < 10; i++){ //ITERACION
            for(int j = 0; j < 10 ; j++){//ITERACION
                if(army.get(i).get(j) != null){
                    System.out.println("\n*********************************");
                    System.out.println("El " + (numbersoldiers + 1) + " soldado es: ");
                    System.out.println(army.get(i).get(j).toString());
                    numbersoldiers++;
                }
            }
        }
    }
    public static void longerLife(ArrayList<ArrayList<Soldado>> army, String kingdom){
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
        System.out.println("El soldado con mayor vida del Ejercito " + kingdom + " es: ");
        System.out.println(soldier.toString());//IMPRIMIMOS SUS DATOS PARA PODER VER DE QUE SOLDADO SE TRATA 
        System.out.println("*********************************");
    }
}
