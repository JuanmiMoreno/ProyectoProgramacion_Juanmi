package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que la
 * contrase�a sea valida, sino es valida mostra un mensaje de error
 * 
 * @author Juanmi
 *
 */
public class Contrase�aVaciaExceptions extends Exception {

	public Contrase�aVaciaExceptions(String msg) {
		super(msg);
	}
}
