public class EspadachinReal extends Soldado{
    private int numknifes;
    private int longknife;
    private int evolve = 0;
    public EspadachinReal(){
    }
    public EspadachinReal(String name , int attacklevel, int defenselevel, int lifelevel, int speed, String attitude ,boolean lives, int row, String column, int numknifes, int longknife){
        super(name, attacklevel, defenselevel, lifelevel, speed, attitude, lives, row, column);
        this.numknifes = numknifes;
        this.longknife = longknife;
    }
    public int getnumKnifes(){
        return numknifes;
    }
    public int getlongKnifes(){
        return longknife;
    }
    public void throwKnifes(){
        if(numknifes == 0){
            System.out.println("Ya no quedan cuchillos");
        }else{
            numknifes--;
        }
    }
    public void evolveSoldier(){
        if(evolve < 4){
            evolve++;
            numknifes += evolve;
            longknife += evolve;
            System.out.println("Espadachín Real evolucionó a nivel " + evolve);
        }else{
            System.out.println("Espadachín Real ya está en su nivel máximo de evolución.");
        }
    }
    public void setnumKnifes(int n){
        this.numknifes = n;
    }
}