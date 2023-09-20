/* 
 * Laboratorio Nro 2 - Ahorcado
 * Autor: Mamani Anahua Victor Narciso
 * Colaboro:
 * Tiempo:
*/
import java.util.Scanner;
public class Copia {
    public static void main(String []args){
        String ahor1 = 
        " + - - - + \n"+
        "   |     | \n" +
        "         | \n" +
        "         | \n" +
        "         | \n" +
        "         | \n" +
        "========= ";
        String ahor2 = 
        " + - - - + \n"+
        "   |     | \n" +
        "   O     | \n" +
        "         | \n" +
        "         | \n" +
        "         | \n" +
        "========= ";
        String ahor3 = 
        " + - - - + \n"+
        "   |       | \n" +
        "   O       | \n" +
        "   |       | \n" +
        "           | \n" +
        "           | \n" +
        "========= ";
        String ahor4 = 
        " + - - - + \n"+
        "   |       | \n" +
        "   O       | \n" +
        "  /|       | \n" +
        "           | \n" +
        "           | \n" +
        "========= ";
        String ahor5 = 
        " + - - - + \n"+
        "   |       | \n" +
        "   O       | \n" +
        "  /|\\     | \n" +
        "           | \n" +
        "           | \n" +
        "========= ";
        String ahor6 = 
        " + - - - + \n"+
        "   |       | \n" +
        "   O       | \n" +
        "  /|\\     | \n" +
        "  /        | \n" +
        "           | \n" +
        "========= ";
        String ahor7 = 
        " + - - - + \n"+
        "   |       | \n" +
        "   O       | \n" +
        "  /|\\     | \n" +
        "  / \\     | \n" +
        "           | \n" +
        "========= ";
        String [] figuras = {ahor1, ahor2, ahor3,ahor4,ahor5,ahor6,ahor7};
        int contador = 1;
        String letra;
        String [] palabras = {"programacion", "java", "identacion", "clases",
                                "objetos", "desarrollador", "pruebas"};
        String palSecreta = getPalabraSecreta(palabras);
        String[] fill = new String[palSecreta.length()]; // CREAMOS UN ARRAY DEL TAMAÑO DE CUAL CUALQUIER ELEMENTO DEL ARRAY PALABRAS[]
        System.out.println(figuras[0]);
        mostrarBlancos(palSecreta);
        System.out.println("\n");
        System.out.println(palSecreta); // IMPRIMIMOS LA PALABRA PARA FACILITAR SU COMPLETACION
        while(contador <= 6){
            letra = ingreseLetra();
                if (letraEnPalabraSecreta(letra, palSecreta)){
                    mostrarBlancosActualizados(letra,palSecreta,fill);
                }else{
                    System.out.println(figuras[contador]);
                    if(figuras[contador] == ahor7){
                        System.out.println("Usted a perdido y el numero de intentos es : " + contador); // MENSAJE DE PERDIO Y CUANTOS INTENTOS USO 
                    }
                    contador = contador +1;
                }
        }
    }
    public static String getPalabraSecreta(String [] lasPalabras){
        int ind;
        int indiceMayor = lasPalabras.length -1;
        int indiceMenor = 0;
        ind = (int) (Math.random() * (indiceMayor - indiceMenor + 1) + indiceMenor);
        return lasPalabras[ind];
    }
    public static void mostrarBlancos(String palabra){
        for(int i=0; i< palabra.length(); i++)
            System.out.print("_ " );

    }
    public static String ingreseLetra(){
        String laLetra;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese letra: ");
        laLetra = sc.next();
        while(laLetra.length() != 1){ 
            System.out.println("Ingrese letra: "); //COMPLETAR PARA VALIDAR CARACTERES PERMITIDOS
            laLetra = sc.next();
        }
        return laLetra;
    }
    public static boolean letraEnPalabraSecreta(String letra, String palSecreta){
        //COMPLETAR
        int count = 0;
        for(int x = 0; x < palSecreta.length(); x++){
            if(letra.charAt(0) == palSecreta.charAt(x)){
                count++;    
            }
        }
        return count > 0; // Agregamos el contador para sacar un valor booleano de la letra ingresada
    }
    //MODIFICAMOS UN METODO
    public static void mostrarBlancosActualizados(String letra, String palSecreta, String[] fill){ // Agregamos al dominio un string y un string[] para su funcionamiento del metodo
        //COMPLETAR 
        for(int z = 0; z < palSecreta.length(); z++){
            if(letra.charAt(0) == palSecreta.charAt(z)){
                    fill[z] = letra.substring(0,1);
            }else{
                if(fill[z] == null){
                    fill[z] = "_ ";
                }
            }
        }
        for(int a = 0; a < fill.length; a++){
            if(a == fill.length - 1){
                System.out.print(fill[a] + "\n");
            }else{
                System.out.print(fill[a]);
            }
        }
    }
}
