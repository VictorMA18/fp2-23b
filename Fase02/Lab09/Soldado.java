// Laboratorio Nro 9  - Ejercicio Soldado
// Autor: Mamani Anahua Victor Narciso
// Colaboro:
// Tiempo:
import java.util.*;
public class Soldado { //CREAMOS LA CLASE SOLDODADO PARA PODER USAR UN ARREGLO BIDIMENSIONAL DONDE NECESITAMOS LA VIDA , EL NOMBRE DEL SOLDADO Y TAMBIEN SU POSICION COMO LA FILA Y LA COLUMNA   

    private String name;
    private int health;
    private int row;
    private String column;
    private int attacklevel;
    private int defenselevel;
    private int lifelevel;
    private int lifeactual;
    private int speed;
    private String attitude;
    private boolean lives;

    Random rdm = new Random();

    //Añadiendo metodo que nos permita que un arreglo tenga datos nulos si este esta vacio
    public Soldado(){
        this.name = "";
        this.health = 0;
        this.row = 0;
        this.column  = "";
        this.attacklevel = 0;
        this.defenselevel = 0;
        this.lifelevel = 0;
        this.lifeactual = 0;
        this.speed = 0;
        this.attitude = "";
        this.lives = false;
    }

    //Constructor
    public Soldado(String name, int health, int row, String column){
        this.name = name;
        this.health = health;
        this.lifeactual = health;
        this.row = row;
        this.column = column;
        this.lives = true;
        
        //YA QUE ESTOS DATOS SERIAN ALEATORIOS YA QUE SE ESTARIA CREANDO EL SOLDADO TENDRIAMOS DATOS QUE SERIAN COMO ATTACKLEVEL DEFENSELEVEL EL CUAL TENDRIAN QUE SER ALEATORIOS    
        this.attacklevel = rdm.nextInt(5) + 1;
        this.defenselevel = rdm.nextInt(5) + 1;

    }
    
    //Constructor para los diferentes niveles como de vidad defensa ataque velocidad

    // Metodos mutadores
    public void setName(String n){
        name = n;
    }
    public void setHealth(int p){
        health = p;
    }
    public void setRow(int b){
        row = b;
    }
    public void setColumn(String c){
        column = c; 
    }

    // Metodos accesores
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;

    }
    public int getRow(){
        return row;
    }
    public String getColumn(){
        return column;
    }

    // Completar con otros métodos necesarios
    public String toString(){ //CREAMOS ESTE METODO PARA IMPRIMIR LOS DATOS DEl OBJETO
        String join = "\nNombre: " + getName() + "\nVida: " + getHealth() + "\nFila: " + getRow() + "\nColumna: " + getColumn(); //Agregamos un espaciador para poder separar
        return join;
    }
}
