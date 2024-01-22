public class CaballeroFranco extends Soldado{
    private int numspears;
    private int longspears;
    private int evolve = 0;
    public CaballeroFranco(){
    }
    public CaballeroFranco(String name , int attacklevel, int defenselevel, int lifelevel, int speed, String attitude ,boolean lives, int row, String column,int numspears, int longspears){
        super(name, attacklevel, defenselevel, lifelevel, speed, attitude, lives, row, column);
        this.numspears = numspears;
        this.longspears = longspears;
    }
    public void throwSpears(){
        if(numspears == 0){
            System.out.println("Ya no quedan lanzas");
        }else{
            numspears--;
        }
    }
    public void evolveSoldier(){
        if(evolve < 4){
            evolve++;
            numspears += evolve;
            numspears += evolve;
            System.out.println("Caballero Franco evolucionó a nivel " + evolve);
        }else{
            System.out.println("Caballero Franco ya está en su nivel máximo de evolución.");
        }
    }
    public int getnumSpears(){
        return numspears;
    }
    public int getlongSpears(){
        return longspears;
    }
    public void setnumSpears(int n){
        this.numspears = n;
    }
}
