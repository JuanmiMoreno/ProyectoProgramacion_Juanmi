package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que el cif
 * sea valido, sino es valido mostra un mensaje de error
 * 
 * @author Juanmi
 *
 */
public class cifInvalidoExceptions extends Exception {

	public cifInvalidoExceptions(String msg) {
		super(msg);
	}

}
