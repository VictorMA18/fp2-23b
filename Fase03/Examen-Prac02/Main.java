package p2;

public class Main {	
   public static void main(String[] args){
	   Conectar conn = new Conectar();
	   conn.conexion();
	   System.out.println("HashCode del objeto Conectar: " + conn.hashCode());
   }
}