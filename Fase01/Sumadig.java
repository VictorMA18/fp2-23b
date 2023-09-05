import java.util.*;
class Sumadig {
    public static int smdig(int n){
        if(n <= 9){
            return n;
        } 
        return n % 10 + smdig(n / 10);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(smdig(n));
    }
}
