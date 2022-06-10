package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que el
 * nombre sea valido, sino es valido mostra un mensaje de error
 * 
 * @author Juanmi
 *
 */
public class nombreInvalidoExceptions extends Exception {

	public nombreInvalidoExceptions(String msg) {
		super(msg);
	}
}
