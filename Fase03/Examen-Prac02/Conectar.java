package p2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conectar {
    Connection conectar = null;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/fp2_23b", "root", "");
            System.out.println("Conexion aceptada");
            String sql = "SELECT vets.first_name, vets.last_name, specialties.name " +
                    "FROM vets " +
                    "JOIN vet_specialties ON vets.id = vet_specialties.vet_id " +
                    "JOIN specialties ON vet_specialties.specialty_id = specialties.id " +
                    "LIMIT 3";

	        PreparedStatement statement = conectar.prepareStatement(sql);
	        ResultSet resultSet = statement.executeQuery();
	
	        System.out.println("Nombres y Especialidades de los primeros 3 Veterinarios:");
	        while (resultSet.next()) {
	            String firstName = resultSet.getString("first_name");
	            String lastName = resultSet.getString("last_name");
	            String specialty = resultSet.getString("name");
	
	            System.out.println("Nombre: " + firstName + " " + lastName + ", Especialidad: " + specialty);
	        }
	
	        resultSet.close();
	        statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return conectar;
    }
}