package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que el
 * email sea valido, sino es valido mostra un mensaje de error
 * 
 * @author Juanmi
 *
 */
public class EmailInvalidoExceptions extends Exception {

	public EmailInvalidoExceptions(String msg) {
		super(msg);
	}

}
