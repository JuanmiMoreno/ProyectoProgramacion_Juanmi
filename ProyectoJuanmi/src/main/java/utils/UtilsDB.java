package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que crea la conexion con la base de datos
 * 
 * @author Juanmi
 *
 */
public class UtilsDB {
	/** nombre y host de la conexion **/
	private static final String cadenaConexion = "jdbc:mysql://127.0.0.1:3306/proyectoProgramacion";
	/** usuario de workbench **/
	private static final String usuarioBD = "root";
	/** contrasela de workbench **/
	private static final String contrasenaBD = "losprados12";
	/** es la conexion que se crea con workbench **/
	private static Connection conexion;

	/**
	 * Funcion estatica para conectar con la base de datos de workbench
	 * 
	 * @return si todo ha ido bien devuelve la conexion y si ha fallado devuelve
	 *         null
	 */
	public static Statement conectarBD() {
		try {
			if (conexion == null) {
				conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, contrasenaBD);
			}
			return conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		
			return null;
		}
	}

	/**
	 * Funcion estatica para desconectar de la base de datos de workbench En ella se
	 * comprueba si la conexion es distinta de null y si lo es se desconecta y se
	 * iguala a null
	 */
	public static void desconectarBD() {
		if (conexion != null) {
			try {
				conexion.close();
				conexion = null;
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
		}
	}
}
