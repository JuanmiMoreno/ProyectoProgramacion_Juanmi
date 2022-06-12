package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que el cif
 * sea valido, sino es valido mostra un mensaje de error
 * 
 * @author Juanmi
 *
 */
public class CifInvalidoExceptions extends Exception {

	public CifInvalidoExceptions(String msg) {
		super(msg);
	}

}
