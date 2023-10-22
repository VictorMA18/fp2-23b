// Laboratorio Nro 7  - Ejercicio Soldado
// Autor: Mamani Anahua Victor Narciso
// Colaboro:
// Tiempo:
public class Soldado { //CREAMOS LA CLASE SOLDODADO PARA PODER USAR UN ARREGLO BIDIMENSIONAL DONDE NECESITAMOS LA VIDA , EL NOMBRE DEL SOLDADO Y TAMBIEN SU POSICION COMO LA FILA Y LA COLUMNA   

    private String name;
    private int health;
    private int row;
    private String column;

    //Añadiendo metodo que nos permita que un arreglo tenga datos nulos si este esta vacio
    public Soldado(){
        this.name = "";
        this.health = 0;
        this.row = 0;
        this.column  = "";
    }

    //Constructor
    public Soldado(String name, int health, int row, String column){
      this.name = name;
      this.health = health;
      this.row = row;
      this.column = column;
    }

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
