import java.util.*;
public class Ejercicio03_lab03 {
    public static void battleResult(Soldier01[] army1, Soldier01[] army2){
        if(army1.length < army2.length){
            System.out.println("El ganador de la batalla es el Ejercito 02 con " + (army2.length) + " soldados");
            System.out.println("********************************");
        }else if(army1.length > army2.length){
            System.out.println("El ganador de la batalla es el Ejercito 01 con " + (army1.length) + " soldados");
            System.out.println("********************************");
        }else{
            System.out.println("El resultado de la batalla es un EMPATE");
            System.out.println("********************************");
        }
    }
    public static void showSoldiers(Soldier01[] army){
        for(int i = 0; i < army.length; i++){
            System.out.print("Los datos del Soldado" + (i + 1));
            System.out.println(army[i].toString());
            System.out.println("********************************");
        }
    } 
    public static Soldier01[] fillinName(){
        Random rdm = new Random();
        Soldier01[] army = new Soldier01[rdm.nextInt(5) + 1];
        for(int i = 0; i < army.length; i++){
            army[i] = new Soldier01();
            army[i].setName("Soldado" + (i + 1));
        }
        return army;
    }
    public static void main(String args[]){
        Soldier01[] army1 = fillinName();
        Soldier01[] army2 = fillinName();
        System.out.println("-------------------------------------");
        System.out.println("Los soldados del Ejercito 01: ");
        showSoldiers(army1);
        System.out.println("////////////////////////////////");
        System.out.println("Los soldados del Ejercito 02: ");
        showSoldiers(army2);  
        System.out.println("-------------------------------------");
        battleResult(army1, army2);
    }
}
