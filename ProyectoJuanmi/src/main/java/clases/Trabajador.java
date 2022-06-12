package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.Provincia;
import enums.TipoPlantacion;
import exceptions.ContraseñaVaciaExceptions;
import exceptions.DniInvalidoExceptions;
import exceptions.NumeroInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConDinero;
import utils.UtilsDB;

/**
 * DAO que instancia un trabajador representa a las personas que trabajan en la
 * empresa hereda de entidad con dinero En el se hace todo los movimientos con
 * la base de datos
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
	 * @throws DniInvalidoExceptions    error que salta cuando el dni no tiene 9
	 *                                  digitos
	 * @throws NumeroInvalidoExceptions error que salta cuando se introduce un
	 *                                  sueldo negativo o igual a 0
	 */
	public Trabajador(String nombre, int dinero, String apellido, String dni, Empresa empresa)
			throws nombreInvalidoExceptions, SQLException, DniInvalidoExceptions, NumeroInvalidoExceptions {
		super(nombre, dinero);
		if (!this.dniValido(dni)) {
			throw new DniInvalidoExceptions("El dni debe tener 9 digitos y no puede ser un numero negativo");
		}

		if (!this.numeroValido(dinero)) {
			throw new NumeroInvalidoExceptions("El sueldo del trabajador no puede ser negativo ni 0");
		}

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
	 * @throws SQLException error de base de datos
	 */
	public void setApellido(String apellido) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		if (smt.executeUpdate(
				"update trabajador set apellido='" +apellido + "' where nombreTrabajador='" + this.nombre + "'") > 0) {
			this.apellido = apellido;
		}
		UtilsDB.desconectarBD();

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
	 * @throws SQLException error de base de datos
	 */
	public void setDni(String dni) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		if (smt.executeUpdate(
				"update trabajador set dni='" +dni + "' where nombreTrabajador='" + this.nombre + "'") > 0) {
			this.dni = dni;
		}
		UtilsDB.desconectarBD();

	}

	/**
	 * Funcion estatica que crea un arraylist de todos los trabajadores de una
	 * empresa
	 * 
	 * @param empresa empresa a los que pertenece los trabajadores
	 * 
	 * @return devuvle un arraylist de todos los trabajadores
	 */
	public static ArrayList<Trabajador> getTodos(Empresa empresa) {
		Statement smt = UtilsDB.conectarBD();
		ArrayList<Trabajador> ret = new ArrayList<Trabajador>();

		try {
			ResultSet cursor = smt
					.executeQuery("select * from trabajador where nombreEmpresa='" + empresa.nombre + "'");
			while (cursor.next()) {
				Trabajador actual = new Trabajador();

				actual.nombre = cursor.getString("nombreTrabajador");
				actual.apellido = cursor.getString("apellido");
				actual.dni = cursor.getString("dni");
				actual.dinero = cursor.getInt("sueldo");
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

	/**
	 * Funcion privada que comprueba que la longuitud del dni sea 9 digitos y no
	 * negativos
	 * 
	 * @param dni
	 * @return
	 */
	private boolean dniValido(String dni) {
		return dni.length() == 9 && !dni.contains("-");
	}

	@Override
	public String toString() {
		return "Nombre: " + this.getNombre() + " Apellido: " + this.apellido + " Dni: " + this.dni + " Sueldo: "
				+ this.dinero;
	}

	/**
	 * Funcion privada que comprueba que el sueldo de los trabajadores no sean
	 * negativos ni 0
	 * 
	 * @param sueldo es el sueldo de los trabajadores de la empresa
	 * @return true si el sueldo es mayor que cero sino false
	 */
	private boolean numeroValido(int sueldo) {
		return sueldo > 0;
	}
}
