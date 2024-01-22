public class EspadachinTeutonico extends Soldado{
    private int numjavelin;
    private int longjavelin;
    private int evolve;
    public EspadachinTeutonico(){
    }
    public EspadachinTeutonico(String name , int attacklevel, int defenselevel, int lifelevel, int speed, String attitude ,boolean lives, int row, String column, int numjavelin, int longjavelin){
        super(name, attacklevel, defenselevel, lifelevel, speed, attitude, lives, row, column);
        this.numjavelin = numjavelin;
        this.longjavelin = longjavelin;
    }
    public void throwJavelin(){
        if(numjavelin == 0){
            System.out.println("No es posible que el espadachin lance jabalinas");
        } else {
            numjavelin--;
        }
    }
    public void modoTortuga(){
        System.out.println("Usted uso la habilidad modo Tortuga, Defensa Especial");
    }
    public void evolveSoldier(){
        if(evolve < 4){
            evolve++;
            numjavelin += evolve;
            longjavelin += evolve;
            System.out.println("Espadachín Teutonico evolucionó a nivel " + evolve);
        }else{
            System.out.println("Espadachín Teutonico ya está en su nivel máximo de evolución.");
        }
    }
    public void setnumJavelin(int n){
        this.numjavelin = n;
    }
    public int getnumJavelin(){
        return numjavelin;
    }
    public int getlongJavelin(){
        return longjavelin;
    }
}