package p2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
   public static void main(String[] args){
	   System.out.println("Sin Singleton");
	   Conectar conn1 = new Conectar();
	   System.out.println("El hashcode de conn es : " + conn1.hashCode());
	   conn1.conexion();
       Conectar conn2 = new Conectar();
       System.out.println("El hashcode de conn es : " + conn2.hashCode());
       conn2.conexion();
       Conectar conn3 = new Conectar();
       System.out.println("El hashcode de conn es : " + conn3.hashCode());
       conn3.conexion();
       System.out.println("Usando Singleton");
	   Conectar conn4 = Conectar.getInstance();
	   System.out.println("El hashcode de conn es : " + conn4.hashCode());
	   conn4.conexion();
       Conectar conn5 = Conectar.getInstance();
       System.out.println("El hashcode de conn es : " + conn5.hashCode());
       conn5.conexion();
       Conectar conn6 = Conectar.getInstance();
       System.out.println("El hashcode de conn es : " + conn6.hashCode());
       conn6.conexion();
   }
}
