public class Caballero extends Soldado{
    private boolean montar;
    private String arma;
    public Caballero(){
    }
    public Caballero(String name , int attacklevel, int defenselevel, int lifelevel, int speed, String attitude ,boolean lives, int row, String column,boolean montar){
        super(name, attacklevel, defenselevel, lifelevel, speed, attitude, lives, row, column);
        this.montar = montar;
    }
    public void montar(){
        if(!this.montar){
            this.arma = "Lanza";
            this.embestir();
        }
    }
    public void desmontar(){
        if (this.montar) {
            this.arma = "Espada";
        }
    }
    public void embestir(){
        if(!montar){
            this.atacar();
            this.atacar();
        }else{
            this.atacar();
            this.atacar();
            this.atacar();
        }
    }
    public String getArma(){
        return arma;
    }
}
