import java.util.*;
class VideoJuego4{  
    public static Soldado[][] arrayfillregister(int num){ //METODO CREADO PARA PODER CREAR AL EJERCITO 2 EL CUAL USAREMOS LA ESTRUCTURA DE DATO QUE ES EL ARRAY CON TAL QUE TAMBIEN REGISTRAMOS 
        Random rdm = new Random();
        int numsoldiers = rdm.nextInt(10) + 1;
        System.out.println("La Ejercito " + num + " tiene " + numsoldiers + " soldados:");  
        System.out.println("*********************************");
        Soldado[][] army = new Soldado[10][10];
        for(int i = 0; i < numsoldiers; i++){ //LOS REGISTRAMOS A CADA UNO POR EL ORDEN DE CREACION QUE FUERON CREADOS EL CUAL TAMBIEN COMPLETAMOS SUS DATOS Y LOS PUBLICAMOS POR ORDEN 
            System.out.println("Registrando al " + (i + 1) + " soldado del Ejercito " + num + "");            
            String name = "Soldado" + i + "X" + num;            
            int health = rdm.nextInt(5) + 1;
            int row = rdm.nextInt(10) + 1;
            String column = String.valueOf((char)(rdm.nextInt(10) + 65));  
            if(army[row - 1][(int)column.charAt(0) - 65] == null){ //VERIFICAMOS QUE NO SE REPITAN MISMOS SOLDADOS DE UN EJERCITO EN EL MISMO CUADRADO 
                System.out.print("------------------");
                army[row - 1][(int)column.charAt(0) - 65] = new Soldado(name, health, row, column);
                System.out.println(army[row - 1][(int)column.charAt(0) - 65].toString());
            }else{
                i -= 1;
            }
        }
        return army;
    }
    public static void main(String args[]){
        ArrayList<ArrayList<Soldado>> army1 = null;
        Soldado[][] army2 = arrayfillregister(2);
    }
}