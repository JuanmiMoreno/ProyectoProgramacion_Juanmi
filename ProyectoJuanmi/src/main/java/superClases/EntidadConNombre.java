package superClases;

import java.sql.SQLException;
import java.sql.Statement;

import exceptions.nombreInvalidoExceptions;
import utils.UtilsDB;

/**
 * Clase abastrac que no instancia nada y es la clase madre no hereda de nadie
 * 
 * @author Juanmi
 *
 */
public abstract class EntidadConNombre {
	/** es el nombre **/
	private String nombre;

	/**
	 * Constructor que crea una entidad con nombre
	 * 
	 * @param nombre es el nombre
	 * @throws nombreInvalidoExceptions error que salta cuando el nombre esta vacio
	 * @throws SQLException             error de base de datos
	 */
	public EntidadConNombre(String nombre) throws nombreInvalidoExceptions, SQLException {
		this.setNombre(nombre);
		;
	}

	/**
	 * Constructor vacio para poder trabajar en las clases que heredan
	 */
	public EntidadConNombre() {

	}

	/**
	 * Getter de nombre
	 * 
	 * @return devuelve el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter de nombre que comprueba si el nombre esta vacio o no
	 * 
	 * @param nombre ees el nombre
	 * @throws nombreInvalidoExceptions error que salta cuando el nombre esta vacio
	 * @throws SQLException             error de base de daros
	 */
	public void setNombre(String nombre) throws nombreInvalidoExceptions, SQLException {
		if (!this.nombreValido(nombre)) {
			throw new nombreInvalidoExceptions("El  nombre no puede estar vacio");
		}
		this.nombre = nombre;
	}

	/**
	 * Funcion privada que comrpueba si el nombre es valido
	 * 
	 * @param nombre es el nombre a comprobar
	 * @return devuelve true si el nombre no esta vacio y false si el nombre esta
	 *         vacio
	 */
	private boolean nombreValido(String nombre) {
		return !nombre.isBlank();
	}

}
