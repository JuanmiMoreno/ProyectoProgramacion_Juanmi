package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.Provincia;
import enums.TipoPlantacion;
import exceptions.nombreInvalidoExceptions;
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
	 * @throws nombreInvalidoExceptions error que salta cuando el nombre esta vacio
	 * @throws SQLException             error de base de datos
	 */
	public Campo(String nombre, Provincia provincia, float superficie, TipoPlantacion plantacion, Empresa empresa)
			throws nombreInvalidoExceptions, SQLException {
		super(nombre, provincia);

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
	 */
	public void setSuperficie(float superficie) {
		this.superficie = superficie;
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
	 * Setter de plantacion
	 * 
	 * @param plantacion nueva plantacion
	 */
	public void setPlantacion(TipoPlantacion plantacion) {
		this.plantacion = plantacion;
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
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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

}
