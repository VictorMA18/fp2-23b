import java.util.*;
public class Ejercicio02_lab03 {
    public static void main(String args[]){ //EN ESTE EJERCICIO USAMOS ARREGLO DE OBJETOS CON LA CALSE SOLDIER DONDE INGRESAMOS UN NOMBRE Y VIDA PARA CADA SOLDADO Y DESPUES IMPRIMIMOS SUS DATOS CON LA AYUDA DE LA ESTRUCTURA FOR 
        Scanner sc = new Scanner(System.in);
        Soldier[] soldiers = new Soldier[5];
        for(int i = 0; i < soldiers.length; i++){
            System.out.println("Soldado " + (i + 1) + " : ");
            System.out.print("Ingrese su nombre: ");
            String name = sc.next();
            System.out.print("Ingrese su vida: ");
            int heatlh = sc.nextInt();
            soldiers[i] = new Soldier();
            soldiers[i].setName(name);
            soldiers[i].setHealth(heatlh);
        }
        for(int i = 0; i < soldiers.length;i++){
            System.out.print("\nLos datos del soldado " + (i + 1) + " : ");
            System.out.println(soldiers[i].toString());
            System.out.println("*************************************");
        }
    }        
}
