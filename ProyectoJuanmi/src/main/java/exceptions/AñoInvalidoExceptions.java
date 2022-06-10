package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que año
 * sea valido, sino es valido mostra un mensaje de error
 * 
 * @author Juanmi
 *
 */
public class AñoInvalidoExceptions extends Exception {

	public AñoInvalidoExceptions(String msg) {
		super(msg);
	}

}
