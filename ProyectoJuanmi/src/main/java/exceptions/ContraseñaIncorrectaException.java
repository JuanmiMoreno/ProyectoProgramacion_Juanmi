package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que la
 * contrase�a sea valida, sino es valida mostra un mensaje de error
 * 
 * @author Juanmi
 *
 */
public class Contrase�aIncorrectaException extends Exception {

	public Contrase�aIncorrectaException(String msg) {
		super(msg);

	}

}
