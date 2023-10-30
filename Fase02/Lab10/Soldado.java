// Laboratorio Nro 10 - Ejercicio Soldado
// Autor: Mamani Anahua Victor Narciso
// Colaboro:
// Tiempo:
import java.util.*;
public class Soldado { //CREAMOS LA CLASE SOLDODADO PARA PODER USAR UN ARREGLO BIDIMENSIONAL DONDE NECESITAMOS LA VIDA , EL NOMBRE DEL SOLDADO Y TAMBIEN SU POSICION COMO LA FILA Y LA COLUMNA   

    private String name;
    private int lifeactual;
    private int row;
    private String column;
    private int attacklevel;
    private int defenselevel;
    private int lifelevel;
    private int speed;
    private String attitude;
    private boolean lives;

    Random rdm = new Random();

    //Añadiendo metodo que nos permita que un arreglo tenga datos nulos si este esta vacio
    public Soldado(){
        this.name = "";
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
        this.lifeactual = health;
        this.lifelevel = health;
        this.lifeactual = health;
        this.row = row;
        this.column = column;
        this.lives = true;
        
        //YA QUE ESTOS DATOS SERIAN ALEATORIOS YA QUE SE ESTARIA CREANDO EL SOLDADO TENDRIAMOS DATOS QUE SERIAN COMO ATTACKLEVEL DEFENSELEVEL EL CUAL TENDRIAN QUE SER ALEATORIOS    
        this.attacklevel = rdm.nextInt(5) + 1;
        this.defenselevel = rdm.nextInt(5) + 1;

    }
    
    //Constructor para los diferentes niveles como de vidad defensa ataque velocidad
    public Soldado(String name , int attacklevel, int defenselevel, int lifelevel, int speed, boolean lives, int row, String column) {
        this.name = name;
        this.attacklevel = attacklevel;
        this.defenselevel = defenselevel;
        this.lifelevel = lifelevel;
        this.speed = speed;
        this.lives = lives;
        this.row = row;
        this.column = column;
    }

    //Metodos necesarios como avanzar defender huir al seratacado al retroceder
    public void advance(){
        this.speed = getSpeed() + 1;
        System.out.println("El soldado " + this.name + "avanzo");
    }
    public void defense(){
        this.speed = 0;
        this.attitude = "DEFENSIVA";
        System.out.println("El soldado " + this.name + "esta defendiendo");
    }
    public void flee(){
        this.speed = getSpeed() + 2;
        this.attitude = "HUYE";
        System.out.println("El soldado " + this.name + "esta huyendo");
    }
    public void back(){
        System.out.println("El soldado " + this.name + "esta retrocediendo");
        if(this.speed == 0){
            this.speed = rdm.nextInt(5) - 5;
        }else{
            if(this.speed > 0){
                this.speed = 0;
                this.attitude = "DEFENSIVA";
            }
        }
    }
    public void attack(Soldado soldier){
        if(this.getLifeActual() > soldier.getLifeActual()){
            int life = this.getLifeActual() - soldier.getLifeActual();
            this.setLifeActual(life);
            this.setLifeLevel(life);
            soldier.lives = false;
            System.out.println(this.name + " asesino al soldado " + soldier.name);
        }else if(soldier.getLifeActual() > this.getLifeActual()){
            int life = soldier.getLifeActual() - this.getLifeActual();
            this.lives = false;
            soldier.setLifeActual(life);
            soldier.setLifeLevel(life);
            System.out.println(soldier.name + " asesino al soldado " + this.name);
        }else{
            this.lives = false;
            soldier.lives = false;
            System.out.println("los 2 soldados se asesinaron");
        }
    }
    public void morir(){
        this.lives = false;
        this.attitude = "SOLDADO MUERTO";
    }

    // Metodos mutadores
    public void setName(String n){
        name = n;
    }
    public void setLifeActual(int p){
        lifeactual = p;
    }
    public void setRow(int b){
        row = b;
    }
    public void setColumn(String c){
        column = c; 
    }
    public void setAttackLevel(int attacklevel) {
        this.attacklevel = attacklevel;
    }
    public void setDefenseLevel(int defenselevel) {
        this.defenselevel = defenselevel;
    }
    public void setLifeLevel(int lifelevel){
        this.lifelevel = lifelevel;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }
    public void setLives(boolean lives) {
        this.lives = lives;
    }

    // Metodos accesores
    public String getName(){
        return name;
    }
    public int getLifeActual(){
        return lifeactual;
    }
    public int getRow(){
        return row;
    }
    public String getColumn(){
        return column;
    }
    public int getAttackLevel() {
        return attacklevel;
    }
    public int getDefenseLevel() {
        return defenselevel;
    }
    public int getLifeLevel(){
        return lifelevel;
    }
    public int getSpeed() {
        return speed;
    }
    public String getAttitude() {
        return attitude;
    }
    public boolean getLives() {
        return lives;
    }

    // Completar con otros métodos necesarios
    public String toString(){ //CREAMOS ESTE METODO PARA IMPRIMIR LOS DATOS DEl OBJETO
        String join = "\nNombre: " + getName() + "\nVida: " + getLifeActual() + "\nFila: " + getRow() + "\nColumna: " + getColumn() + "\nNivel de ataque: " + getAttackLevel() + "\nNivel de Defensa: " + getDefenseLevel() + "\nNivel de vida: " + getLifeLevel() + "\nVelocidad: " + getSpeed() + "\nActitud: " + getAttitude() + "\nEstado: " + getLives(); //Agregamos un espaciador para poder separar
        return join;
    }
    
}
