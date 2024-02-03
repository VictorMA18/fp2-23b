public class Arquero extends Soldado {
    int flechas;

    Arquero() {
        this.ataque = 7;
        this.defensa = 3;
        this.lvVida = (int) (Math.random() * 3 + 3);
        this.vida = lvVida;
    }

    public int disparar() {
        if (flechas <= 0)
            return 0;
        flechas--;
        return ataque;
    }
}
