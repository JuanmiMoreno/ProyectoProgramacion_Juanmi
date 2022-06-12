package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exceptions.NumeroInvalidoExceptions;
import exceptions.NombreInvalidoExceptions;
import superClases.EntidadConNombre;
import utils.UtilsDB;

/**
 * DAO que instancia a una actividad que representa la actividades que tiene la
 * empresa. En el se hace todo los movimientos con la base de datos
 * 
 * @author Juanmi
 *
 */
public class Actividad extends EntidadConNombre {
	/** Duracion hace referencia a la duracion de la actividad en dias **/
	private Byte duracion;
	/**
	 * campo hace referencia al nombre del campo en el que se realiza la activiad
	 **/
	private String campo;
	/** trabjador hace referencia al trabajador que realiza la accion **/
	private Trabajador trabajador;
	/**
	 * ArrayList maquinaria hace referencia a todas las maquinarias que realizan la
	 * actividad
	 **/
	private ArrayList<Maquinaria> maquinarias;
	/**
	 * Descripcioin es la descripcion de la actividad, en la que se explica toda la
	 * actividad
	 **/
	private String descripcion;
	/** Producto que se utilizaria o no en la realizacion de la actividad **/
	private Producto producto;
	/**
	 * empresa en la que se realiza la actividad, el nombre de la empresa es la
	 * clave foranea en la base de datos
	 **/
	private Empresa empresa;
	/**
	 * modelo del tractor es la clave forane del tracotr utiilizado en la actividad
	 **/
	private String modeloTractor;
	/** modelo del apero es la clave forane del apero utilizado en la actividad **/
	private String modeloApero;

	/**
	 * Constructor privado de actividad para poder realizar la funcion get todos y
	 * sacar los datos de la base de datos No tiene ninguna variable ni inicializa
	 * nada
	 */
	private Actividad() {

	}

	/**
	 * Constructor de actividdad que inserta la actividadd en la base de datos si es
	 * posible
	 * 
	 * @param nombre        de la actividad
	 * @param duracion      de la actividad
	 * @param campo         en el que se realiza la actividad
	 * @param descripcion   de la actividdad
	 * @param modeloTractor tractor que realiza la actividad (clave forane)
	 * @param modeloApero   apero que realiza la actividad(clave foranea)
	 * @param empresa       empresa que realiza las actividades (clave forane)
	 * @throws NombreInvalidoExceptions excepcions creada para que el nombre de la
	 *                                  actividad no se deje en blanco
	 * @throws SQLException             exception de base de datos
	 * @throws NumeroInvalidoExceptions error que salta cuando la duracion de la
	 *                                  actividad es negativa o 0
	 */
	public Actividad(String nombre, Byte duracion, String campo, String descripcion, String modeloTractor,
			String modeloApero, Empresa empresa)
			throws NombreInvalidoExceptions, SQLException, NumeroInvalidoExceptions {
		super(nombre);
		if (!this.numeroValido(duracion)) {
			throw new NumeroInvalidoExceptions("La duracion de la actividad no puede ser negativa ni 0");
		}
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into actividad values('" + this.getNombre() + "','" + duracion + "','"
				+ descripcion + "','" + empresa.getNombre() + "','" + campo + "','" + modeloTractor + "','"
				+ modeloApero + "')") > 0) {
			this.duracion = duracion;
			this.campo = campo;
			this.trabajador = trabajador;
			this.maquinarias = maquinarias;
			this.descripcion = descripcion;
			this.producto = producto;
			this.empresa = empresa;
			this.modeloTractor = modeloTractor;
			this.modeloApero = modeloApero;
		} else {
			UtilsDB.desconectarBD();
			throw new SQLException("No se ha podido insertar la actividad");
		}

		UtilsDB.desconectarBD();

	}

	/**
	 * Getter de la duracion de la actividad
	 * 
	 * @return devuelve la duracion de la actividad
	 */
	public Byte getDuracion() {
		return duracion;
	}

	/**
	 * Setter en DAO de la duracion de la actividad
	 * 
	 * @param duracion devuelve la nueva duracion de la actividad
	 * @throws SQLException error que salta cuando hay un fallo de base de datos
	 */
	public void setDuracion(Byte duracion) throws SQLException {

		Statement smt = UtilsDB.conectarBD();
		if (smt.executeUpdate(
				"update actividad set duracion='" + duracion + "' where nombreActividad='" + this.nombre + "'") > 0) {
			this.duracion = duracion;
		}
		UtilsDB.desconectarBD();
	}

	/**
	 * Getter del nombre del campo donde se realiza la actividad
	 * 
	 * @return devuelve el nombre del campo
	 */
	public String getCampo() {
		return campo;
	}

	/**
	 * Setter en DAO del nombre del campo donde se realiza la actividad
	 * 
	 * @param campo campo es el nuevo nombre del campo
	 * @throws SQLException
	 */
	public void setCampo(String campo) throws SQLException {

		Statement smt = UtilsDB.conectarBD();
		if (smt.executeUpdate(
				"update actividad set nombreCampo='" + campo + "' where nombreActividad='" + this.nombre + "'") > 0) {
			this.campo = campo;
		}
		UtilsDB.desconectarBD();
	}

	/**
	 * Getter del trabajador que realiza la actividad
	 * 
	 * @return trabajador, devuelve el trabajador que realiza la accion
	 */
	public Trabajador getTrabajador() {
		return trabajador;
	}

	/**
	 * Getter del modelo del tractor que realiza la accion
	 * 
	 * @return el modelo del tractor
	 */
	public String getModeloTractor() {
		return modeloTractor;
	}

	/**
	 * Setter en DAO del modelo del tractor que realiza la accion
	 * 
	 * @param modeloTractor nuevo modelo del tractor
	 * @throws SQLException error de base de datos
	 */
	public void setModeloTractor(String modeloTractor) throws SQLException {

		Statement smt = UtilsDB.conectarBD();
		if (smt.executeUpdate("update actividad set modeloTractor='" + modeloTractor + "' where nombreActividad='"
				+ this.nombre + "'") > 0) {
			this.modeloTractor = modeloTractor;
		}
		UtilsDB.desconectarBD();

	}

	/**
	 * Getter del modelo de apero que realiza la accion
	 * 
	 * @return devuelve el modelo del apero que realiza la accion
	 */
	public String getModeloApero() {
		return modeloApero;
	}

	/**
	 * Setter en DAO del modelo de apero que realiza la accion
	 * 
	 * @param modeloApero nuevo modelo de apero
	 * @throws SQLException error de base de datos
	 */
	public void setModeloApero(String modeloApero) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		if (smt.executeUpdate("update actividad set modeloApero='" + modeloApero + "' where nombreActividad='"
				+ this.nombre + "'") > 0) {
			this.modeloApero = modeloApero;
		}
		UtilsDB.desconectarBD();

	}

	/**
	 * Setter del trabajador que realiza la accion
	 * 
	 * @param trabajador nuevo trabajador que realiza la accion
	 */
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	/**
	 * getter de arraylist de maquinarias
	 * 
	 * @return devuelve todas las maquinarias que realiza una actividad
	 */
	public ArrayList<Maquinaria> getMaquinarias() {
		return maquinarias;
	}

	/**
	 * setter maquinaria que realizan la actividad
	 * 
	 * @param maquinarias nuevas maquinarias
	 */
	public void setMaquinarias(ArrayList<Maquinaria> maquinarias) {
		this.maquinarias = maquinarias;
	}

	/**
	 * Getter de la descripcion de la actividada
	 * 
	 * @return devuelve la nueva descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Setter descripcion de la actividad
	 * 
	 * @param descripcion nueva descripcion de la actividad
	 * @throws SQLException error de base de datos
	 */
	public void setDescripcion(String descripcion) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		if (smt.executeUpdate("update actividad set descripcion='" + descripcion + "' where nombreActividad='"
				+ this.nombre + "'") > 0) {
			this.descripcion = descripcion;
		}
		UtilsDB.desconectarBD();

	}

	/**
	 * Getter de los productos que realizan la actividad
	 * 
	 * @return devuelve los productos utilizados
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * Setter de los productos que realizan la actividad
	 * 
	 * @param producto nuevo producto
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * Getter de la empresa en la que se realiza la actividad
	 * 
	 * @return devuelve la empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * Setter en DAO de la empresa que realiza la actividad
	 * 
	 * @param empresa nueva empresa
	 * @throws SQLException error base de datos
	 */
	public void setEmpresa(Empresa empresa) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		if (smt.executeUpdate("update actividad set nombreEmpresa='" + empresa.nombre + "' where nombreActividad='"
				+ this.nombre + "'") > 0) {
			this.empresa = empresa;
		}
		UtilsDB.desconectarBD();
	}

	/**
	 * Funcion que añade en un array list todas las actividades de una empresa que
	 * haya en la base de datos
	 * 
	 * @param empresa empresa a los que pertenece las actividades
	 * @return devuelve el array list de actividades
	 */
	public static ArrayList<Actividad> getTodos(Empresa empresa) {
		Statement smt = UtilsDB.conectarBD();
		ArrayList<Actividad> ret = new ArrayList<Actividad>();

		try {
			ResultSet cursor = smt.executeQuery("select * from actividad where nombreEmpresa='" + empresa.nombre + "'");
			while (cursor.next()) {
				Actividad actual = new Actividad();

				actual.nombre = cursor.getString("nombreActividad");
				actual.descripcion = cursor.getString("descripcion");
				actual.campo = cursor.getString("nombreCampo");
				actual.duracion = cursor.getByte("duracion");
				actual.modeloTractor = cursor.getString("modeloTractor");
				actual.modeloApero = cursor.getString("modeloApero");

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
	 * Funcion que elimina una actividad segun el nombre
	 * 
	 * @return devuelve null en todas las variable de la actividad eliminada
	 */
	public boolean eliminar() {

		Statement smt = UtilsDB.conectarBD();
		boolean ret;
		try {
			ret = smt.executeUpdate("delete from actividad where nombreActividad='" + this.nombre + "'") > 0;

			this.nombre = null;
			this.campo = null;
			this.empresa = null;
			this.descripcion = null;
			this.duracion = 0;
			this.maquinarias = null;

		} catch (SQLException e) {
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}

	/**
	 * Funcion privada que comprueba que los dias de duracion de la actividad no
	 * sean negativos ni 0
	 * 
	 * @param duracion son los dias de duracion de la actividad
	 * @return devuelve true si la duracion es un numero postivo y false si no lo es
	 */
	private boolean numeroValido(byte duracion) {
		return duracion > 0;
	}
}
