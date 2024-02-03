import java.awt.Color;

class Jugador {
    String nombre;
    Color color;

    Jugador(String nombre, Color color) {
        this.nombre = nombre;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public Color getColor() {
        return color;
    }
}
