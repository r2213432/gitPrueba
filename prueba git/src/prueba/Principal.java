package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
			Connection conn = DriverManager.getConnection("baseDeDatos/BasedeDatosPrueba.db");
			
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Programa terminado");

	}

}
