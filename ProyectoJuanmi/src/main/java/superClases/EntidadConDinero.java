package superClases;

import java.sql.SQLException;

import exceptions.NombreInvalidoExceptions;

/**
 * Clase abstractra que no instancia nada que hereda de entidad con nombre tiene
 * de variable interna el dinero
 * 
 * @author Juanmi
 *
 */
public abstract class EntidadConDinero extends EntidadConNombre {
	/** dinero que tienen **/
	protected int dinero;

	/**
	 * Constructor que crea una entidad con dinero
	 * 
	 * @param nombre recibido por argumento
	 * @param dinero dinero que tienen
	 * @throws NombreInvalidoExceptions error que salta cuando el nombre esta vacio
	 * @throws SQLException             error de base de datos
	 */
	public EntidadConDinero(String nombre, int dinero) throws NombreInvalidoExceptions, SQLException {
		super(nombre);
		this.dinero = dinero;
	}

	/**
	 * Constructor vacio que solo recibe nombre
	 * 
	 * @param nombre recibido por argumentos, es el nombre
	 * @throws NombreInvalidoExceptions error que salta cuando el nombre esta vacio
	 * @throws SQLException             error de base de datos
	 */
	public EntidadConDinero(String nombre) throws NombreInvalidoExceptions, SQLException {
		super(nombre);
	}

	/**
	 * Constructor vacio para poder trabajar en las clases que se heredan
	 */
	public EntidadConDinero() {

	}

	/**
	 * Getter de dinero
	 * 
	 * @return devuelve el dinero
	 */
	public int getDinero() {
		return dinero;
	}

	/**
	 * Setter de dinero
	 * 
	 * @param dinero nuevo dinero
	 */
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

}
