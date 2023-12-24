class Cilindro extends Circulo {
    protected double altura;
    public Cilindro (double x , double y , double radio , double altura){ //Creamos este constructor el cual nos va a establecer las coordenadas que necesitamos como su centro , radio y la longitud de este cilindro
        super(x, y, radio); //llamamos al constructor del cual heredamos esta clase que es Circulo lo cual nos ayudara en nuestra clase Cilindro para tener un centro y un radio definido
        this.altura = altura; //asignamos la altura 
    }
    public double superficie(){
        double superficiecilindro = ((2 * (this.radio)) * (this.altura + this.radio)); 
        return superficiecilindro;
    }
    public String toString(){ //Cree este metodo el cual me ayuda a de
        return ("El centro del cilindro es : " + "(" + this.x + " , " + this.y + ")" + " , su radio es : " + this.radio + " y su altura es: " + this.altura);
    }
}
class Ejercicio2 {
    public static void main(String[] args) {
        Cilindro cilindro = new Cilindro(2, 4, 5, 10);
        double superficiecilindro = cilindro.superficie();
        System.out.println(cilindro.toString());
        System.out.println("La superficie de este cilindro es : " + superficiecilindro);
    }
}
