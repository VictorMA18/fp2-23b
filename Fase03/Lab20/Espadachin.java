public class Espadachin extends Soldado{
    private int swordlth;
    public Espadachin(String name , int attacklevel, int defenselevel, int lifelevel, int speed, String attitude ,boolean lives, int row, String column, int swordlth){
        super(name, attacklevel, defenselevel, lifelevel, speed, attitude, lives, row, column);
        this.swordlth = swordlth;
    }
    public void muroEscudo(){
        System.out.println("Usted uso la habilidad muro de Escudos");
    }
    public int getSwordlth(){
        return swordlth;
    }
    public void setSwordlth(int n){
        this.swordlth = n;
    }
}
