// Laboratorio Nro 3 - Ejercico03 - Lab03
// Autor: Mamani Anahua Victor Narciso
// Colaboro:
// Tiempo:
public class Soldier01{ //CREAMOS LA CLASE SOLDIER PARA PODER USAR ARREGLO DE OBJETOS EN LA ACTIVDAD 04 DONDE SE NOS PIDE EL NOMBRE Y LA VIDA DEL SOLDADO  

    private String name;

    // Metodos mutadores
    public void setName(String n){
        name = n;
    }

    // Metodos accesores
    public String getName(){
        return name;
    }

    // Completar con otros métodos necesarios
    public String toString(){ //CREAMOS ESTE METODO PARA IMPRIMIR LOS DATOS DEl OBJETO
        String join = "\nNombre: " + getName();
        return join;
    }
}
