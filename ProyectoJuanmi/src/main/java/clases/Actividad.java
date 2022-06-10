package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConNombre;
import utils.UtilsDB;
/**
 * clase que instancia a una actividad que representa la actividades que tiene la empresa
 * @author Juanmi
 *
 */
public class Actividad extends EntidadConNombre {
	/** Duracion hace referencia a la duracion de la actividad en dias**/
	private Byte duracion;
	/** campo hace referencia al nombre del campo en el que se realiza la activiad**/
	private String campo;
	/** trabjador hace referencia al trabajador que realiza la accion**/
	private Trabajador trabajador;
	/** ArrayList maquinaria hace referencia a todas las maquinarias que realizan la actividad**/
	private ArrayList<Maquinaria> maquinarias;
	/** Descripcioin es la descripcion de la actividad, en la que se explica toda la actividad**/
	private String descripcion;
	/** Producto que se utilizaria o no en la realizacion de la actividad**/
	private Producto producto;
	/** empresa en la que se realiza la actividad, el nombre de la empresa es la clave foranea en la base de datos**/
	private Empresa empresa;
	/** modelo del tractor es la clave forane del tracotr utiilizado en la actividad**/
	private String modeloTractor;
	/** modelo del apero es la clave forane del apero utilizado en la actividad**/
	private String modeloApero;
	
	
	
	/**
	 * Constructor privado de actividad para poder realizar la funcion get todos y sacar los datos de la base de datos
	 * No tiene ninguna variable ni inicializa nada
	 */
	private Actividad() {
		
	}
	
	/**
	 * Constructor de actividdad que inserta la actividadd en la base de datos si es posible
	 * @param nombre de la actividad
	 * @param duracion  de la actividad
	 * @param campo en el que se realiza la actividad
	 * @param descripcion de la actividdad
	 * @param modeloTractor tractor que realiza la actividad (clave forane)
	 * @param modeloApero apero que realiza la actividad(clave foranea)
	 * @param empresa empresa que realiza las actividades (clave forane)
	 * @throws nombreInvalidoExceptions excepcions creada para que el nombre de la actividad no se deje en blanco
	 * @throws SQLException exception de base de datos
	 */
	public Actividad(String nombre, Byte duracion, String campo, String descripcion,  String modeloTractor, String modeloApero,Empresa empresa)
			throws nombreInvalidoExceptions, SQLException {
		super(nombre);
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into actividad values('" + this.getNombre() + "','" +duracion + "','" + descripcion
				+ "','" + empresa.getNombre() + "','"+ campo + "','"+modeloTractor+"','"+modeloApero+ "')") > 0 ){
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
	 *Getter de la duracion de la actividad 
	 * @return devuelve la duracion de la actividad
	 */
	public Byte getDuracion() {
		return duracion;
	}

	
	/**
	 * Setter de la duracion de la actividad
	 * @param duracion devuelve la nueva duracion de la actividad
	 */
	public void setDuracion(Byte duracion) {
		this.duracion = duracion;
	}


	/**
	 *Getter del nombre del campo donde se realiza la actividad 
	 * @return devuelve el nombre del campo
	 */
	public String getCampo() {
		return campo;
	}


	/**
	 * Setter del nombre del campo  donde se realiza la actividad
	 * @param campo campo es el nuevo nombre del campo
	 */
	public void setCampo(String campo) {
		this.campo = campo;
	}


	/**
	 *Getter del trabajador que realiza la actividad
	 * @return trabajador, devuelve el trabajador que realiza la accion
	 */
	public Trabajador getTrabajador() {
		return trabajador;
	}


	/**
	 * Getter del modelo del tractor que realiza la accion
	 * @return el modelo del tractor
	 */
	public String getModeloTractor() {
		return modeloTractor;
	}

	/**
	 * Setter del modelo del tractor que realiza la accion
	 * @param modeloTractor nuevo modelo del tractor
	 */
	public void setModeloTractor(String modeloTractor) {
		this.modeloTractor = modeloTractor;
	}

	/**
	 * Getter del modelo de apero que realiza la accion
	 * @return devuelve el modelo del apero que realiza la accion
	 */
	public String getModeloApero() {
		return modeloApero;
	}
	 
	/**
	 * Setter del modelo de apero que realiza la accion
	 * @param modeloApero nuevo modelo de apero
	 */
	public void setModeloApero(String modeloApero) {
		this.modeloApero = modeloApero;
	}

	/**
	 * Setter del trabajador que realiza la accion
	 * @param trabajador nuevo trabajador que realiza la accion
	 */
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}


	/**
	 * getter de arraylist de maquinarias
	 * @return devuelve todas las maquinarias que realiza una actividad
	 */
	public ArrayList<Maquinaria> getMaquinarias() {
		return maquinarias;
	}


	/**
	 * setter  maquinaria que realizan la actividad
	 * @param maquinarias nuevas maquinarias
	 */
	public void setMaquinarias(ArrayList<Maquinaria> maquinarias) {
		this.maquinarias = maquinarias;
	}


	/**
	 * Getter de la descripcion de la actividada
	 * @return devuelve la nueva descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * Setter descripcion de la actividad
	 * @param descripcion nueva descripcion de la actividad
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	/**
	 * Getter de los productos que realizan la actividad
	 * @return devuelve los productos utilizados
	 */
	public Producto getProducto() {
		return producto;
	}


	/**
	 * Setter de los productos que realizan la actividad
	 * @param producto nuevo producto
	 */ 
	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	/**
	 * Getter de la empresa en la que se realiza la actividad
	 * @return devuelve la empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}


	/**
	 * Setter de la empresa que realiza la actividad
	 * @param empresa nueva empresa
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
	/**
	 * Funcion que añade en un array list todas las actividades de una empresa que haya en la base de datos
	 * @return devuelve el array list de actividades 
	 */
	public  static ArrayList<Actividad> getTodos() {
		Statement smt = UtilsDB.conectarBD();
		ArrayList<Actividad> ret = new ArrayList<Actividad>();

		try {
			ResultSet cursor = smt.executeQuery("select * from actividad ");
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
	
	
	}
	
	



	


