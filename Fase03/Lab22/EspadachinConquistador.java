public class EspadachinConquistador extends Soldado{
    private int numaxes;
    private int longaxes;
    private int evolve;
    public EspadachinConquistador(){
    }
    public EspadachinConquistador(String name , int attacklevel, int defenselevel, int lifelevel, int speed, String attitude ,boolean lives, int row, String column, int numaxes, int longaxes){
        super(name, attacklevel, defenselevel, lifelevel, speed, attitude, lives, row, column);
        this.numaxes = numaxes;
        this.longaxes = longaxes;
    }
    public void throwAxes(){
        if(numaxes == 0){
            System.out.println("No es posible que el espadachin lance hachas");
        } else {
            numaxes--;
        }
    }
    public void evolveSoldier(){
        if(evolve < 4){
            evolve++;
            numaxes += evolve;
            longaxes += evolve;
            System.out.println("Espadachín Conquistador evolucionó a nivel " + evolve);
        }else{
            System.out.println("Espadachín Conquistador ya está en su nivel máximo de evolución.");
        }
    }
    public void setnumAxes(int n){
        this.numaxes = n;
    }
    public int getnumAxes(){
        return numaxes;
    }
    public int getlongAxes(){
        return longaxes;
    }
}
