package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que la
 * contraseña sea valida, sino es valida mostra un mensaje de error
 * 
 * @author Juanmi
 *
 */
public class ContraseñaIncorrectaException extends Exception {

	public ContraseñaIncorrectaException(String msg) {
		super(msg);

	}

}
