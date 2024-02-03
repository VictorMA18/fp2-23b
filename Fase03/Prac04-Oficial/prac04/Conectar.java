import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar{
	private static Conectar singleton = null;
	public static synchronized Conectar getInstance(){
		if (singleton == null)
			singleton = new Conectar();
		return singleton;
	}
	private static Conectar instancia;
	Connection conectar = null;
	public Connection conexion(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conectar = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fp2_23b","root","");
			WriteLog.writeFile("Conexion SQL Exitosa");
		} catch (Exception e){
			System.out.println(e);
		}
		return conectar;
	}
}