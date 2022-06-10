package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que la
 * contraseña sea valida, sino es valida mostra un mensaje de error
 * 
 * @author Juanmi
 *
 */
public class ContraseñaVaciaExceptions extends Exception {

	public ContraseñaVaciaExceptions(String msg) {
		super(msg);
	}
}
