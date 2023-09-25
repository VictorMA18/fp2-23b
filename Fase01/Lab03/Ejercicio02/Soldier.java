// Laboratorio Nro 3 - Activdad 4 - Practica 1
// Autor: Mamani Anahua Victor Narciso
// Colaboro:
// Tiempo:
public class Soldier { //CREAMOS LA CLASE SOLDIER PARA PODER USAR ARREGLO DE OBJETOS EN LA ACTIVDAD 04 DONDE SE NOS PIDE EL NOMBRE Y LA VIDA DEL SOLDADO  

    private String name;
    private int heatlh;

    // Metodos mutadores
    public void setName(String n){
        name = n;
    }
    public void setHealth(int p){
        heatlh = p;
    }

    // Metodos accesores
    public String getName(){
        return name;
    }
    public int getHealth(){
        return heatlh;

    }
    // Completar con otros métodos necesarios
    public String toString(){ //CREAMOS ESTE METODO PARA IMPRIMIR LOS DATOS DEl OBJETO
        String join = "Nombre: " + getName() + "\nVida: " + getHealth();
        return join;
    }
}
