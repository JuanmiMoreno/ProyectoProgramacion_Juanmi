package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilsDB {

	private static final String cadenaConexion = "jdbc:mysql://127.0.0.1:3306/proyectoProgramacion";
	private static final String usuarioBD = "root";
	private static final String contrasenaBD = "losprados12";
	private static Connection conexion;

	public static Statement conectarBD() {
		try {
			if (conexion == null) {
				conexion = DriverManager.getConnection(
						cadenaConexion, usuarioBD, contrasenaBD);
			}
			return conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("No se ha podido conectar, inténtalo luego");
			return null;
		}
	}

	public static void desconectarBD() {
		if (conexion != null) {
			try {
				conexion.close();
				conexion=null;
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("No se pudo desconectar");
			}
		}
	}
}
