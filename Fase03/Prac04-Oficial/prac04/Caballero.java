class Caballero extends Soldado {
    boolean montado = true;

    Caballero() {
        this.ataque = 13;
        this.defensa = 7;
        this.lvVida = (int) (Math.random() * 3 + 10);
        this.vida = lvVida;
    }

    public void usarLanza() {

    }

    public void usarEspada() {

    }

    public void desmontar() {

    }

    public void montar() {

    }

    public int envestir() {
        if (montado)
            return ataque * 3;
        return ataque * 2;
    }
}