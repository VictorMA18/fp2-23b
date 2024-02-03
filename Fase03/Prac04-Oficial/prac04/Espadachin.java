public class Espadachin extends Soldado {
    int longEspada;

    Espadachin() {
        this.ataque = 10;
        this.defensa = 8;
        this.lvVida = (int) (Math.random() * 3 + 8);
        this.vida = lvVida;
    }

    public void muroDeEspadas() {

    }
}
