package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que el
 * nombre sea valido, sino es valido mostra un mensaje de error
 * 
 * @author Juanmi
 *
 */
public class NombreInvalidoExceptions extends Exception {

	public NombreInvalidoExceptions(String msg) {
		super(msg);
	}
}
