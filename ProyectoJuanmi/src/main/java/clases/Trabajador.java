package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.Provincia;
import enums.TipoPlantacion;
import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConDinero;
import utils.UtilsDB;

/**
 * Clase que instancia un trabajador representa a las personas que trabajan en
 * la empresa hereda de entidad con dinero
 * 
 * @author Juanmi
 *
 */
public class Trabajador extends EntidadConDinero {
	/** apellido del trabajador **/
	private String apellido;
	/** dni del trabajador con el que se identifica **/
	private String dni;
	/** Empresa a la que pertence el trabajador **/
	private Empresa empresa;

	/**
	 * Funcion privada que nos sirve para poder trabajar con el metodo getTodos
	 */
	private Trabajador() {

	}

	/**
	 * Constructor que crea un trabajador y lo inserta en la base de datos
	 * 
	 * @param nombre   recibido por el super, es el nombre del trabajador
	 * @param dinero   recibido por eñ super, es el sueldo del trabjador
	 * @param apellido apeelido del trabjador
	 * @param dni      dni del trabajador es unico
	 * @param empresa  es la empresa a la que pertence el trabajador
	 * @throws nombreInvalidoExceptions error que salta cuando el nombre se queda en
	 *                                  blanco
	 * @throws SQLException             error que salta cuando hay error de base de
	 *                                  datos
	 */
	public Trabajador(String nombre, int dinero, String apellido, String dni, Empresa empresa)
			throws nombreInvalidoExceptions, SQLException {
		super(nombre, dinero);

		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into trabajador values('" + this.getNombre() + "','" + apellido + "','"
				+ dni + "','" + this.getDinero() + "','" + empresa.getNombre() + "')") > 0) {
			this.apellido = apellido;
			this.dni = dni;
			this.empresa = empresa;
		} else {
			UtilsDB.desconectarBD();
			throw new SQLException("No se ha podido el trabajador");
		}

		UtilsDB.desconectarBD();

	}

	/**
	 * Getter de apellido del trabajador
	 * 
	 * @return delvuelve el apellido del trabajador
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Setter de apellidos del trabajador
	 * 
	 * @param apellido nuevo apellido del trabajador
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Getter del dni del trabajador
	 * 
	 * @return devuelve el dni del trabajador
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Setter del dni de trabajador
	 * 
	 * @param dni nuevo dni del trabajador
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Funcion estatica que crea un arraylist de todos los trabajadores de una
	 * empresa
	 * 
	 * @return devuvle un arraylist de todos los trabajadores
	 */
	public static ArrayList<Trabajador> getTodos() {
		Statement smt = UtilsDB.conectarBD();
		ArrayList<Trabajador> ret = new ArrayList<Trabajador>();

		try {
			ResultSet cursor = smt.executeQuery("select * from trabajador ");
			while (cursor.next()) {
				Trabajador actual = new Trabajador();

				actual.nombre = cursor.getString("nombreTrabajador");
				actual.apellido = cursor.getString("apellido");
				actual.dni = cursor.getString("dni");
				ret.add(actual);
			}
		} catch (SQLException e) {

			e.getMessage();
			return null;
		}

		UtilsDB.desconectarBD();
		return ret;
	}

	/**
	 * Funcion privada que elimina un trabajador segun su nombre
	 * 
	 * @return devuelve null en todas las variables y lo borra de la base de datos
	 */
	public boolean eliminar() {

		Statement smt = UtilsDB.conectarBD();
		boolean ret;
		try {
			ret = smt.executeUpdate("delete from trabajador where nombreTrabajador='" + this.nombre + "'") > 0;

			this.nombre = null;
			this.apellido = null;
			this.empresa = null;
			this.dni = null;

		} catch (SQLException e) {
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}

}
