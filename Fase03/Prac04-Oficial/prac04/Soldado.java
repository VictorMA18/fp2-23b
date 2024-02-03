public class Soldado {
    int ataque;
    int vida;
    int lvVida;
    int defensa;
    String nombre;
    String reino;
    int tipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLvVida() {
        return lvVida;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setTipo(int t) {
        this.tipo = t;
    }

    public int getTipo() {
        return tipo;
    }

    public void setVida(int v) {
        this.vida = v;
    }
    // Completar con otros métodos necesarios
    public String toString(){ //CREAMOS ESTE METODO PARA IMPRIMIR LOS DATOS DEl OBJETO
        String join = "\nNombre: " + getNombre() + "\nVida: " + getLvVida() + "\nNivel de ataque: " + getAtaque() + "\nNivel de Defensa: " + getDefensa() + "\nNivel de vida: " + getLvVida() + "\nTipo: " + getTipo(); //Agregamos un espaciador para poder separar
        return join;
    }
}
