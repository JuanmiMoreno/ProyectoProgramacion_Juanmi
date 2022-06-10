package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que el
 * usuario exista, sino existe mostra un mensaje de error
 * 
 * @author Juanmi
 *
 */
public class UsuarioNoExisteException extends Exception {

	public UsuarioNoExisteException(String msg) {
		super(msg);
	}

}
