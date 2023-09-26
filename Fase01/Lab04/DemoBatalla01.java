// Laboratorio Nro 4 - DemoBatalla01
// Autor: Mamani Anahua Victor Narciso
// Colaboro:
// Tiempo:
import java.util.*;
public class DemoBatalla01{
    public static void main(String [] args){
        Nave [] misNaves = new Nave [3]; // LE PONEMOS AL ARREGLO UN TAMAÑO DE 2 PARA SU POSTERIOR PRUEBA 
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;
    for (int i = 0; i < misNaves.length; i++) {
        System.out.println("Nave " + (i+1) + " : ");
        System.out.print("Nombre: ");
        nomb = sc.next();
        System.out.print("Fila: ");
        fil = sc.nextInt();
        System.out.print("Columna: ");
        col = sc.next();
        System.out.print("Estado: ");
        est = sc.nextBoolean();
        System.out.print("Puntos: ");
        punt = sc.nextInt();
        misNaves[i] = new Nave(); //Se crea un objeto Nave y se asigna su referencia a misNaves
        misNaves[i].setNombre(nomb);
        misNaves[i].setFila(fil);
        misNaves[i].setColumna(col);
        misNaves[i].setEstado(est);
        misNaves[i].setPuntos(punt);
    }
        System.out.println("\nNaves creadas:");
        System.out.println("--------------------------------------");
        mostrarNaves(misNaves);
        System.out.println("--------------------------------------");
        mostrarPorNombre(misNaves);
        System.out.println("--------------------------------------");        
        mostrarPorPuntos(misNaves);
        System.out.println("--------------------------------------");
        System.out.println("Nave con mayor numero de puntos: \n" + mostrarMayorPuntos(misNaves));
        System.out.println("***********************");
        System.out.println("--------------------------------------");
        //leer un nombre
        //mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
        System.out.println("Ingrese el nombre para buscar a la primera nave: ");
        String searchedname = sc.next();
        int pos = busquedaLinealNombre(misNaves, searchedname);
        System.out.println("--------------------------------------");
        System.out.println("Ordenado por la cantidad de puntos del menor al mayor mediante el metodo burbuja: ");
        ordenarPorPuntosBurbuja(misNaves);
        mostrarNaves(misNaves);
        System.out.println("--------------------------------------");
        System.out.println("Ordenado por las iniciales de cada nombre de A a la Z mediante el metodo burbuja: ");
        ordenarPorNombreBurbuja(misNaves);
        mostrarNaves(misNaves);
        System.out.println("--------------------------------------");
        /* 
        //mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
        pos=busquedaBinariaNombre(misNaves,"");
        */
        System.out.println("Ordenado por la cantidad de puntos del menor al mayor mediante el metodo seleccion: ");
        ordenarPorPuntosSeleccion(misNaves);
        mostrarNaves(misNaves);
        System.out.println("--------------------------------------");
        System.out.println("Ordenado por la cantidad de puntos del mayor al menor mediante el metodo insercion: ");
        ordenarPorPuntosInsercion(misNaves);
        mostrarNaves(misNaves);
        System.out.println("--------------------------------------");
        System.out.println("Ordenado por las iniciales de cada nombre de A a la Z mediante el metodo seleccion: ");
        ordenarPorNombreSeleccion(misNaves);
        mostrarNaves(misNaves);
        System.out.println("--------------------------------------");
        /* 
        ordenarPorNombreInsercion(misNaves);
        mostrarNaves(misNaves);
        */
    }
    //Método para mostrar todas las naves
    public static void mostrarNaves(Nave [] flota){ //COMPLETAMOS EL METODO mostrarNaves Y NOS AYUDAMOS DE UN FOR EACH PARA EL MUESTREO DE LOS DATOS DE CADA OBJETO Y TAMBIEN USAMOS EL METODO toString()
        for(Nave ship: flota){
            System.out.println(ship.toString());
            System.out.println("***********************");
        }
    }
    //Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave [] flota){ //COMPLETAMOS EL METODO mostrarPorNombre Y NOS AYUDAMOS DE UN FOR EACH CON TAL QUE SI EL NOMBRE INGRESADO ERA IGUAL AL OBJETO CREADO MOSTRABA LOS DATOS DEL OBJETO Y TAMBIEN USAMOS EL METODO toString()
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre para buscar a las naves: ");
        String name = sc.next();
        System.out.println("***********************");
        for(Nave ship: flota){
            if(ship.getNombre().equals(name)){
                System.out.println(ship.toString());
                System.out.println("***********************");
            }
        }
    }
    //Método para mostrar todas las naves con un número de puntos inferior o igual
    //al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave [] flota){ // Completamos el metodo mostrarPorPuntos donde ingresamos un numero de puntos en esta usamos un for each que pase por todos los elementos donde si su numero de puntos es menor o igual a este numero ingresado se imprimira sus datos
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número puntos para buscar a las naves que son menor o igual a esta: ");
        int point = sc.nextInt();
        System.out.println("***********************");
        for(Nave ship: flota){
            if(ship.getPuntos() <= point){
                System.out.println(ship.toString());
                System.out.println("***********************");
            }
        }
    }
    //Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave [] flota){ //COMPLETAMOS ESTE METODO mostrarMayorPuntos DONDE CREAMOS UN OBJETO DE LA CLASE NAVE QUE ES SHIP EN ESTE PODREMOS GUARDAR LOS DATOS DE LA NAVE CON LA MAYOR CANTIDAD DE PUNTOS Y DESPUES RETONARNLO
        Nave ship = new Nave();
        for(int i = 0; i < flota.length - 1; i++){
            if(flota[i].getPuntos() < flota[i + 1].getPuntos()){
                ship = flota[i + 1];
            }else{
                ship = flota[i];
            }
        }
        return ship;
    }
    //Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaLinealNombre(Nave[] flota, String s){ //METODO CREADO PARA LA BUSQUEDA DE LA PRIMERA NAVE QUE ES IGUAL AL NOMBRE QUE ESCRIBIMOS
        System.out.println("***********************");
        int count = 0;
        for(int i = 0; i < flota.length; i++){
            if(flota[i].getNombre().equals(s)){
                count++;
                if(count > 0){
                    System.out.println(flota[i].toString());
                    break;
                }else{
                    System.out.println("Nave no encontrada");
                }
                return i;
            }
        }
        return -1;
    }
    //Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosBurbuja(Nave[] flota){ //COMPLETAMOS ESTE METODO QUE NOS PERMITE ORDENAR DE MENOR A MAYOR DE LA MANERA DE ORDENAR BURBUJA QUE SERIA CAMBIAR POSCIONES SI TU ELEMENTO DE ADELANTE ES MENOR AL ACTUAL
        for(int i = 0; i < flota.length - 1;i++){
            if(flota[i].getPuntos() > flota[i + 1].getPuntos()){
                Nave temp = flota[i];
                flota[i] = flota[i + 1];
                flota[i + 1] = temp;
            }
        }
    }
    //Método que ordena por nombre de A a Z
    public static void ordenarPorNombreBurbuja(Nave[] flota){ //COMPLETAMOS ESTE METODO QUE NOS PERMITE ORDENAR DE A HASTA Z PARA ESTO COMPARAMOS EL PRIMER CARACTER DE CADA UNA Y SI ESTA ACTUAL ES MAYOR A LA SIGUIENTE ESTA CAMBIARA DE POSICION
        for(int i = 0; i < flota.length - 1;i++){
            if(flota[i].getNombre().charAt(0) > flota[i + 1].getNombre().charAt(0)){
                Nave temp = flota[i];
                flota[i] = flota[i + 1];
                flota[i + 1] = temp;
            }
        }
    }
    //Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaBinariaNombre(Nave[] flota, String s){
        return 0;
    }
    //Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosSeleccion(Nave[] flota){ //METODO COMPLETADO QUE NOS PERMITE CAMBIAR LAS POSICIONES DE CADA ARREGLO DEPENDIENDO DE LO QUE RETORNE EL METODO indProxMin que sera el indice cual debemos cambiar con el actual
        for(int i = 0; i < flota.length - 1; i++){
            int j = indProxMin(flota, i);
            Nave temp = flota[i];
            flota[i] = flota[j];
            flota[j] = temp;
        }
    }
    public static int indProxMin(Nave[] flota, int index){ //METODO CREADO QUE NOS AYUDA A BUSCAR EL INDICE DEL OBJETO Y NOS DICE CUAL ES EL PROXIMO MENOR  APARTIR DEL QUE ESTAMOS Y VA PASANDO POR TODOS LOS ELEMENTOS ASI QUE VA ACTUALIZANDOSE LA VARIABLE MINDEX
        int minindex = index;
        for(int i = index + 1; i < flota.length; i++){
            if(flota[i].getPuntos() < flota[minindex].getPuntos()){
                minindex = i;
            }
        }
        return minindex;
    }
    //Método que ordena por nombre de A a Z
    public static void ordenarPorNombreSeleccion(Nave[] flota){ //METODO COMPLETADO QUE NOS PERMITE CAMBIAR LAS POSICIONES DE CADA ARREGLO DEPENDIENDO DE LO QUE RETORNE EL METODO indProxMin que sera el indice cual debemos cambiar con el actual
        for(int i = 0; i < flota.length - 1; i++){
            int j = indProxMin02(flota, i);
            Nave temp = flota[i];
            flota[i] = flota[j];
            flota[j] = temp;
        }
    }
    public static int indProxMin02(Nave[] flota, int index){ //METODO CREADO QUE NOS AYUDA A BUSCAR EL INDICE DEL OBJETO Y NOS DICE CUAL ES EL PROXIMO MENOR EN TERMINOS DE A HASTA Z APARTIR DEL QUE ESTAMOS Y VA PASANDO POR TODOS LOS ELEMENTOS ASI QUE VA ACTUALIZANDOSE LA VARIABLE MINDEX
        int minindex = index;
        for(int i = index + 1; i < flota.length; i++){
            if(flota[i].getNombre().charAt(0) < flota[minindex].getNombre().charAt(0)){
                minindex = i;
            }
        }
        return minindex;
    }
    //Método que muestra las naves ordenadas por número de puntos de mayor a menor
    public static void ordenarPorPuntosInsercion(Nave[] flota){ //Este metodo ordenarPorPuntosInsercion() consiste en recorrer todo el array comenzando desde el segundo elemento hasta el final. Para cada elemento, se trata de colocarlo en el lugar correcto entre todos los elementos con menor punto anteriores a él y asi por cada uno completando del mayor al menor 
        for(int i = 1; i < flota.length; i++){
            Nave temp = flota[i];
            int j = i - 1;
            while(j >= 0 && (temp.getPuntos() > flota[j].getPuntos())){
                flota[j + 1] = flota[j];
                j--;
            }
            flota[j + 1] = temp;
        }
    }
    //Método que muestra las naves ordenadas por nombre de Z a A
    public static void ordenarPorNombreInsercion(Nave[] flota){
    }
}