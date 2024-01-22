public class Arquero extends Soldado{
    private int flechas;
    public Arquero(){
        
    }
    public Arquero(String name , int attacklevel, int defenselevel, int lifelevel, int speed, String attitude ,boolean lives, int row, String column, int flechas){
        super(name, attacklevel, defenselevel, lifelevel, speed, attitude, lives, row, column);
        this.flechas = flechas;
    }
    public void disparar(){
        if(this.flechas == 0){
            System.out.println("El arquero ya no tiene flechas para poder disparar");
        }else{
            this.flechas = flechas - 1;
            this.atacar();
        }
    }
    public void setFlechas(int n){
        this.flechas = n;
    }
    public int getFlechas(){
        return flechas;
    }
}
