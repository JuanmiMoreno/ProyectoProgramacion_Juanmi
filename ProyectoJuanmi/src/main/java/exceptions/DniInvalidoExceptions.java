package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que la
 * longuitud del dni sea valida, sino es valida mostra un mensaje de error
 * 
 * @author Juanmi
 *
 */
public class DniInvalidoExceptions extends Exception {

	public DniInvalidoExceptions(String msg) {
		super(msg);
	}
}
