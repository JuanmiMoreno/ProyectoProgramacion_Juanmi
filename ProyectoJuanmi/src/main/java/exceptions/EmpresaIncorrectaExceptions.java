package exceptions;

/**
 * Excepcion creada que extiende de Exception esta excepcion controla que el
 * nombre de la empresa sea valido, sino es valido mostra un mensaje de error
 * 
 * @author Juanmi
 *
 */
public class EmpresaIncorrectaExceptions extends Exception {

	public EmpresaIncorrectaExceptions(String msg) {
		super(msg);
	}

}
