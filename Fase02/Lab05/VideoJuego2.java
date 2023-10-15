// Laboratorio Nro 5  - Ejercicio Videojuego2
// Autor: Mamani Anahua Victor Narciso
// Colaboro:
// Tiempo:
import java.util.*;
class VideoJuego2 {
  public static void viewboard(Soldado[][] army){
       System.out.println("Mostrando tabla de posicion ... --");
       System.out.println("_____________________________________________________");
       for(int i = 0; i < army.length; i++ ){
              for(int j = 0; j < army[i].length; j++){
                     if(army[i][j].getHealth() == 0){
                            System.out.print("|  " + "X" + "  ");
                     }else{
                            System.out.print("|\t");
                     }
              }
              System.out.println("");
              System.out.println("|_______|_______|_______|_______|_______|_______|_______|_______|_______|_______|");
       }
  }
  public static void main (String args[]){
       Random rdm = new Random();
       System.out.println("Cuantos soldados? ");
       int numsoldiers = rdm.nextInt(10) + 1;
       Soldado[][] army = new Soldado[10][10];
       viewboard(army);
  }
}
