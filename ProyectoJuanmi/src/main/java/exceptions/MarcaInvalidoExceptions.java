package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que la
 * marca de las maquinarias sea valida, sino es valida mostra un mensaje de
 * error
 * 
 * @author Juanmi
 *
 */
public class MarcaInvalidoExceptions extends Exception {

	public MarcaInvalidoExceptions(String msg) {
		super(msg);
	}

}
