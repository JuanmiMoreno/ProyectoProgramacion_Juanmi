package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que el
 * telefono sea valido, sino es valido mostra un mensaje de error
 * 
 * @author Juanmi
 *
 */
public class TelefonoInvalidoExceptions extends Exception {

	public TelefonoInvalidoExceptions(String msg) {
		super(msg);

	}

}
