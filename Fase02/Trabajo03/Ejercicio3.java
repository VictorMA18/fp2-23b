interface Barco {
    void zarpar();
}
interface Avion{
    void planear();
}
class Hidroavion implements Barco, Avion{ //Creamos las interfaces como una herdacion multiple la cual Hidroavion tiene esta condicion donde este puede aplicar metodos de las interfaces creadas
    public void zarpar(){ //Metodo de la interfaz Barco
        System.out.println("El Hidroavion esta implementando el metodo zarpar de la interfaz Barco");
    } 
    public void planear() {
        System.out.println("El Hidroavion esta implementando el metodo planear de la interfaz Avion");
    } 
}
class Ejercicio3 {
    public static void main(String[] args) {
        Hidroavion hidroavion = new Hidroavion();
        hidroavion.zarpar();
        hidroavion.planear();//Comprobando la heredacion multiple por interfaces la cual creamos a un objeto hidroavion que usara metodos de las interfaces de la cual se hereda
        Barco barco = hidroavion; //La referencia de tipo Barco para hacer referencia a una instancia de Hidroavion.
        Avion avion = hidroavion; //La referencia de tipo Avion para hacer referencia a una instancia de Hidroavion.
        barco.zarpar();
        avion.planear();
    }
}
