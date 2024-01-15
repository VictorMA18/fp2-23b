import java.util.*;

public class Mapa {
    Scanner sc = new Scanner(System.in);
    private String territory;
    private ArrayList<ArrayList<Soldado>> board;
    private ArrayList<ArrayList<Soldado>> army1;
    private ArrayList<ArrayList<Soldado>> army2;
    private String[] typesterritory = {"bosque", "campo abierto", "montaña", "desierto", "playa"};
    private String[] kingdoms = {"Inglaterra", "Francia", "Sacro", "Castilla", "Aragon", "Moros"};
    public Mapa(){
        this.board = fillboard();
        this.army1 = fillarray(1);
        this.army2 = fillarray(2);
    }
    public void iniciarJuego() {
        do {
            menuBatalla();
            int resbattle = sc.nextInt();
            if(resbattle == 1){
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
    public static ArrayList<ArrayList<Soldado>> fillarray(int num){
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
    public static void menuBatalla(){
        System.out.println("-------------------------------------------");
        System.out.println("--                 MENU                  --"); 
        System.out.println("-------------------------------------------");
        System.out.println(" SELECCIONE UN NUMERO PARA PODER EMPEZAR O TERMINAR");
        System.out.println(" 1 : JUGAR");
        System.out.println(" 2 : NO JUGAR");
    }
}
