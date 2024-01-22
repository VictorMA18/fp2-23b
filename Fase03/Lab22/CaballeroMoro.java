public class CaballeroMoro extends Soldado{
    private int flechas;
    private int longflechas;
    private int evolve = 0;
    public CaballeroMoro(){
    }
    public CaballeroMoro(String name , int attacklevel, int defenselevel, int lifelevel, int speed, String attitude ,boolean lives, int row, String column, int flechas, int longflechas){
        super(name, attacklevel, defenselevel, lifelevel, speed, attitude, lives, row, column);
        this.flechas = flechas;
        this.longflechas = longflechas;
    }
    public void disparar(){
        if(this.flechas == 0){
            System.out.println("El arquero ya no tiene flechas para poder disparar");
        }else{
            this.flechas = flechas - 1;
            this.atacar();
        }
    }
    public void evolveSoldier(){
        if(evolve < 4){
            evolve++;
            flechas += evolve;
            longflechas += evolve;
            System.out.println("Espadachín Conquistador evolucionó a nivel " + evolve);
        }else{
            System.out.println("Espadachín Conquistador ya está en su nivel máximo de evolución.");
        }
    }
    public void setFlechas(int n){
        this.flechas = n;
    }
    public int getFlechas(){
        return flechas;
    }
    public int getLongFlechas(){
        return longflechas;
    }
}
