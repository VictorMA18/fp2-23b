// Laboratorio Nro 5  - Ejercicio Videojuego2
// Autor: Mamani Anahua Victor Narciso
// Colaboro:
// Tiempo:
import java.util.*;
class VideoJuego2 {
  public static void viewboard(Soldado[][] army){
       System.out.println("Mostrando tabla de posicion ... --");
       System.out.println("_________________________________________________________________________________");
       for(int i = 0; i < army.length; i++ ){
              for(int j = 0; j < army[i].length; j++){
                     if(army[i][j] != null){
                            System.out.print("|   " + "X" + "   ");//ARREGLANDO PARA QUE SE PUEDA IMPRIMIR DE BUENA FORMA
                     }else{
                            System.out.print("|\t");
                     }
              }
              System.out.println("|");
              System.out.println("|_______|_______|_______|_______|_______|_______|_______|_______|_______|_______|");
       }
  }
  public static Soldado[][] fillarray(int number){
       Random rdm = new Random();
       Soldado[][] army= new Soldado[10][10];
       System.out.println("Registrando soldados .......");
       for(int i = 0; i < number; i++){
              String name = "Soldado" + (i); //CORREGIMOS EN EL NOMBRE YA QUE ESTE COMNEZABA DESDE EL 0
              int health = rdm.nextInt(5) + 1;
              int row = rdm.nextInt(10) + 1;
              String column = String.valueOf((char)(rdm.nextInt(10) + 65));  
              if(army[row - 1][(int)column.charAt(0) - 65] == null){
                     System.out.print("*********************************");
                     army[row - 1][(int)column.charAt(0) - 65] = new Soldado(name, health, row, column);
                     System.out.println(army[row - 1][(int)column.charAt(0) - 65].toString());
              }else{
                     i -= 1;
              }
       }
       return army;
  }
  public static void longerLife(Soldado[][] army){
       int mayor = 0;
       Soldado soldier = null;
       for(int i = 0; i < army.length; i++){
              for(int j = 0; j < army[i].length; j++){
                     if(army[i][j] != null){
                            if(mayor < army[i][j].getHealth()){
                                   mayor = army[i][j].getHealth();
                                   soldier = army[i][j];
                            }
                     }
              }
       }
       System.out.println("");
       System.out.print("El primer soldado con mayor vida es: ");
       System.out.println(soldier.toString());
       System.out.println("*********************************");
  }
  public static void averageLife(Soldado[][] army){
       int sum = 0;
       int cont = 0;
       for(int i = 0; i < army.length; i++){
              for(int j = 0; j < army.length; j++){
                     if(army[i][j] != null){
                            sum += army[i][j].getHealth();
                            cont++;
                     }
              }
       }
       double avg = sum / (cont * 1.0);
       System.out.println("El promedio de vida del ejercito es : " + avg);
  }
  public static void main (String args[]){
       Random rdm = new Random();
       System.out.println("Cuantos soldados? ");
       int numsoldiers = rdm.nextInt(10) + 1;
       System.out.println(numsoldiers);
       Soldado[][] army = fillarray(numsoldiers);
       viewboard(army);
       longerLife(army);
       averageLife(army);
  }
}
