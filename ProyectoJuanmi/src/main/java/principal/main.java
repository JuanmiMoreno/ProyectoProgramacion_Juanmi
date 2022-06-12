package principal;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import exceptions.ContraseñaVaciaExceptions;
import exceptions.NombreInvalidoExceptions;
import pantallas.Ventana;

/**
 * Clase que contiene el main del programa con el que funciona todo nuestro
 * proyecto
 * 
 * @author Juanmi
 *
 */
public class Main {
	/**
	 * Funcion que contiene la cracion e inicializacion de una ventana para que que
	 * el resto del proyecto pueda ejecutarse. Tmabien tiene un bluce for que busca
	 * en los argumentos de programa para realizar un autologin
	 * 
	 * @param args argumentos de programa. En los que esta el usuario y la
	 *             contraseña para hacer login
	 */
	public static void main(String[] args) {

		String usuario = null;
		String contrasena = null;

		for (byte i = 0; i < args.length; i++) {

			if (args[i].equals("-usuario")) {
				usuario = args[1 + i];

			}
			if (args[i].equals("-contrasena")) {
				contrasena = args[i + 1];
			}
		}
		try {
			Ventana v = new Ventana(usuario, contrasena);
		} catch (SQLException | ContraseñaVaciaExceptions | NombreInvalidoExceptions e) {

			
		}

	}

}
