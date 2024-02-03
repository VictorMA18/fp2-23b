public class Lancero extends Soldado {
    int longLanza;

    Lancero() {
        this.ataque = 5;
        this.defensa = 10;
        this.lvVida = (int) (Math.random() * 4 + 5);
        this.vida = lvVida;
    }

    public void schilron() {
        this.defensa++;
    }
}
