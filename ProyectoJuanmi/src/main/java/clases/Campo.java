package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.Provincia;
import enums.TipoPlantacion;
import exceptions.NumeroInvalidoExceptions;
import exceptions.NombreInvalidoExceptions;
import superClases.EntidadConUbicacion;
import utils.UtilsDB;

/**
 * DAO que instancia un campo hereda de entidad con ubicacion. En el se hace
 * todo los movimientos con la base de datos
 * 
 * @author Juanmi
 *
 */
public class Campo extends EntidadConUbicacion {
	/** superficie del campo **/
	private float superficie;
	/** tipo de plantacion que hay en el campo es un enum **/
	private TipoPlantacion plantacion;
	/** Empresa a la que pertence el campo **/
	private Empresa empresa;

	/**
	 * Constructor que crea un campo y lo inserta en la base de datos sin puede
	 * insertarlo saltara un error
	 * 
	 * @param nombre     recibido por el super, es el nombre del campo
	 * @param provincia  recibido por el super , es la provincia donde se encuentra
	 *                   el campo
	 * @param superficie es la superficie del campo se mide en hA
	 * @param plantacion es el tipo de plantacion que hay plantada (enum)
	 * @param empresa    empresa a la que pertenece el campo
	 * @throws NombreInvalidoExceptions error que salta cuando el nombre esta vacio
	 * @throws SQLException             error de base de datos
	 * @throws NumeroInvalidoExceptions error que salta cuando le inserta una
	 *                                  superficie negativa o igual a 0
	 */
	public Campo(String nombre, Provincia provincia, float superficie, TipoPlantacion plantacion, Empresa empresa)
			throws NombreInvalidoExceptions, SQLException, NumeroInvalidoExceptions {
		super(nombre, provincia);

		if (!this.numeroValido(superficie)) {
			throw new NumeroInvalidoExceptions("La superficie de los campos no puede ser negativa ni 0");
		}

		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into campo values('" + nombre + "','" + provincia + "'," + superficie
				+ ",'" + plantacion + "','" + empresa.getNombre() + "')") > 0) {

			this.superficie = superficie;
			this.plantacion = plantacion;
			this.empresa = empresa;
		} else {
			UtilsDB.desconectarBD();
			throw new SQLException("No se ha podido insertar el campo");
		}

		UtilsDB.desconectarBD();

	}

	/**
	 * Constructor vacio para utilizarlo en el metodo get todos
	 */
	private Campo() {

	}

	/**
	 * Getter de superficie del campo
	 * 
	 * @return devuelve la superficie
	 */
	public float getSuperficie() {
		return superficie;
	}

	/**
	 * Setter de la superficie
	 * 
	 * @param superficie nueva superficie
	 * @throws SQLException error de base de datos
	 */
	public void setSuperficie(float superficie) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		if (smt.executeUpdate(
				"update campo set superficie='" + superficie + "' where nombreCampo='" + this.nombre + "'") > 0) {
			this.superficie = superficie;
		}
		UtilsDB.desconectarBD();

	}

	/**
	 * Getter del tipo de plantacion
	 * 
	 * @return devuelve el tipo de plantacion
	 */
	public TipoPlantacion getPlantacion() {
		return plantacion;
	}

	/**
	 * Setter en DAO de plantacion
	 * 
	 * @param plantacion nueva plantacion
	 * @throws SQLException error de base de datos
	 */
	public void setPlantacion(TipoPlantacion plantacion) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		if (smt.executeUpdate(
				"update campo set plantacion='" + plantacion + "' where nombreCampo='" + this.nombre + "'") > 0) {
			this.plantacion = plantacion;
		}
		UtilsDB.desconectarBD();

	}

	/**
	 * Getter de empresa
	 * 
	 * @return devuelve la empresa a la que pertence el campo
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * Setter de empresa
	 * 
	 * @param empresa nueva empresa
	 * @throws SQLException error de base de datos
	 */
	public void setEmpresa(Empresa empresa) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		if (smt.executeUpdate(
				"update campo set nombreEmpresa='" + empresa + "' where nombreCampo='" + this.nombre + "'") > 0) {
			this.empresa = empresa;
		}
		UtilsDB.desconectarBD();

	}

	/**
	 * Funcion estatica que crea un array list e inserta todos los campos que
	 * pertenecen a una empresa
	 * 
	 * @param empresa empresa a la que pertence el campo
	 * @return devuelve un array list de todos los campos
	 */
	public static ArrayList<Campo> getTodos(Empresa empresa) {
		Statement smt = UtilsDB.conectarBD();
		ArrayList<Campo> ret = new ArrayList<Campo>();

		try {
			ResultSet cursor = smt.executeQuery("select * from campo where nombreEmpresa='" + empresa.nombre + "'");
			while (cursor.next()) {
				Campo actual = new Campo();

				actual.nombre = cursor.getString("nombreCampo");
				actual.plantacion = TipoPlantacion.valueOf(cursor.getString("plantacion"));
				actual.superficie = cursor.getFloat("superficie");
				actual.provincia = Provincia.valueOf(cursor.getString("provincia"));
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
	 * Funcion para eliminar un campo segun su nombre
	 * 
	 * @return devuelve nul todas sus variables internas y la borra de la base de
	 *         datos
	 */
	public boolean eliminar() {

		Statement smt = UtilsDB.conectarBD();
		boolean ret;
		try {
			ret = smt.executeUpdate("delete from campo where nombreCampo='" + this.nombre + "'") > 0;

			this.nombre = null;
			this.plantacion = null;
			this.empresa = null;
			this.superficie = 0;
			this.provincia = null;

		} catch (SQLException e) {
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}

	/**
	 * Funcion privada que comprueba que la superfecie de los campos no sean
	 * negativos ni 0
	 * 
	 * @param superficie es la superficie de los campos es decir lo que miden en hA
	 * @return devuelve true si la superficie es un numero postivo y false si no lo
	 *         es
	 */
	private boolean numeroValido(float superficie) {
		return superficie > 0;
	}
}
