package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que el año
 * introducido sea valido, sino es valido mostra un mensaje de error
 * 
 * @author Juanmi
 *
 */
public class NumeroInvalidoExceptions extends Exception {

	public NumeroInvalidoExceptions(String msg) {
		super(msg);
	}

}
