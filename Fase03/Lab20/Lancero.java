public class Lancero extends Soldado{
    private int lancelth;
    public Lancero(){
    }
    public Lancero(String name , int attacklevel, int defenselevel, int lifelevel, int speed, String attitude ,boolean lives, int row, String column, int lancelth){
        super(name, attacklevel, defenselevel, lifelevel, speed, attitude, lives, row, column);
        this.lancelth = lancelth;
    }
    public void schiltrom(){
        this.setDefenseLevel(this.getDefenseLevel() + 1);
        System.out.println("El lancero uso el schiltrom su nivel de defensa subio 1 punto");
    }
    public void setLancelth(int n){
        this.lancelth = n;
    }
    public int getLancelth(){
        return lancelth;
    }
}
