package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Principal {

	public static void main(String[] args) {
		// Base de datos
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {
			System.out.println("No se ha podido cargar el driver de base de datos\n"+e);
		}
		//conectar
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/domain/BasedeDatosPrueba.db");
			Statement stmt = conn.createStatement();
			
			int n = 900;
			String seño = "Prueba90";
			String seño1 = "Apellido90";
			float n1 = 10;
			
			
//			String sqlInsert = "insert into Usuario values(? ,? ,? ,?)";
//			PreparedStatement preparestmt = conn.prepareStatement(sqlInsert);
//			preparestmt.setInt(1, n);
//			preparestmt.setString(2, seño);
//			preparestmt.setString(3, seño1);
//			preparestmt.setFloat(4, n1);
//			preparestmt.executeUpdate();
			
			ResultSet rs = stmt.executeQuery("select * from Usuario");
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				System.out.println(id);
				String name = rs.getString("nombre");
				System.out.println(name);
				String apellido = rs.getString("apellido");
				System.out.println(apellido);
				float cartera = rs.getFloat("cartera");
				System.out.println(cartera);
				
			}
			String sqlInsert = "insert into Usuario values(? ,? ,? ,?)";
			PreparedStatement preparestmt = conn.prepareStatement(sqlInsert);
			preparestmt.setInt(1, n);
			preparestmt.setString(2, seño);
			preparestmt.setString(3, seño1);
			preparestmt.setFloat(4, n1);
			preparestmt.executeUpdate();
			
			int filas = stmt .executeUpdate(sqlInsert);
			System.out.println("filas modificadas: "+ filas);
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Programa terminado");

	}

}
