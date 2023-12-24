class Punto{
    protected double x;
    protected double y;
    public Punto(double x, double y){ //Creamos un constructor para asiganar valores a los atributos de la clase Punto el cual nos podra asignar puntos como para un centro de nuestra figura o de un punti cualquiera
        this.x = x;
        this.y = y;
    }
    public double distancia(Punto fin){ //Metodo que nos permite ver la distancia entre puntos o hallar la distancia de un centro de nuestra figura hacia un punto 
        double distanciax = this.x - fin.x;
        double distanciay = this.y - fin.y;
        double distanciaresultante = (distanciax * distanciax) + (distanciay * distanciay);
        return Math.sqrt(distanciaresultante);
    }
    public String toString(){ //Cree este metodo para que nos puedra mostrar los puntos que estamos calculando
        return "(" + this.x + " , " + this.y + ")";
    }
}
class Circulo extends Punto{
    protected double radio;
    public Circulo(double x, double y, double radio){ //Creamos este constructor el cual nos va a establecer las coordenadas que necesitamos como su centro y asignamos el valor del radio de este
        super(x,y); //Llamamos al constructor de la clase Punto ,la cual seria nuestro centro del circulo de lo cual heredamos de la clase Punto 
        this.radio = radio; 
    }
    public String toString(){ //Cree este metodo para que nos puedra mostrar las propiedades de este como su centro y su radio
        return ("El centro del circulo es : " + "(" + this.x + " , " + this.y + ")" + " y su radio es : " + this.radio);
    }
}
class Ejercicio1{
    public static void main(String[] args) {
        Punto puntoinicial = new Punto(0, 0);
        Punto puntofinal = new Punto(3, 4);
        double distanciaentrepuntos = puntoinicial.distancia(puntofinal);
        System.out.println("El punto inicial: " + puntoinicial.toString() + " y el punto final: " + puntofinal.toString());
        System.out.println("La distancia entre estos es: " + distanciaentrepuntos);
        Circulo circulo = new Circulo(2, 1, 5);
        System.out.println(circulo.toString());
    }
}