package superClases;

import java.sql.SQLException;

import enums.Provincia;
import exceptions.NombreInvalidoExceptions;

/**
 * Clase abastract que no instancia nada y hereda de entidad con nombre
 * 
 * @author Juanmi
 *
 */
public abstract class EntidadConUbicacion extends EntidadConNombre {
	/** provincia de la que es **/
	protected Provincia provincia;

	/**
	 * Constructor que crea una entidad con ubucacion que tiene nombre y provincia
	 * 
	 * @param nombre    recibido por argumentos es el nombre
	 * @param provincia es un enum que eliges la provincia
	 * @throws NombreInvalidoExceptions error que salta cuando el nombre esta vacio
	 * @throws SQLException
	 */
	public EntidadConUbicacion(String nombre, Provincia provincia) throws NombreInvalidoExceptions, SQLException {
		super(nombre);
		this.provincia = provincia;
	}

	/**
	 * Constructor de entidad con ubicacion que solo tiene nombre
	 * 
	 * @param nombre recibido por argumentos, es el nombre
	 * @throws NombreInvalidoExceptions error que salta cuando el nombre esta vacio
	 * @throws SQLException             error base de datos
	 */
	public EntidadConUbicacion(String nombre) throws NombreInvalidoExceptions, SQLException {
		super(nombre);
	}

	/**
	 * Constructor vacio que sirve para trabajar con las clases que heredan
	 */
	public EntidadConUbicacion() {

	}

	/**
	 * Getter de provincia
	 * 
	 * @return devuelve la provincia
	 */
	public Provincia getProvincia() {
		return provincia;
	}

	/**
	 * Setter de provincia
	 * 
	 * @param provincia nueva provincia
	 */
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

}
