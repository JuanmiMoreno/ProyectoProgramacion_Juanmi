package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exceptions.ContraseñaIncorrectaException;
import exceptions.EmpresaIncorrectaExceptions;
import exceptions.UsuarioNoExisteException;
import exceptions.cifInvalidoExceptions;
import exceptions.emailInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConDinero;
import utils.UtilsDB;

/**
 * Clase que instancia una empresa que es la que contiene todos los elementos
 * del proyecto
 * 
 * @author Juanmi
 *
 */
public class Empresa extends EntidadConDinero {
	/** CIF de la empresa debe ser de 9 digitos **/
	private String cif;
	/** arraylist de todos los campos de la empresa **/
	private ArrayList<Campo> campos;
	/** arraylist de todos las maquinarias de la empresa **/
	private ArrayList<Maquinaria> maquinarias;
	/** arraylist de todos los trabajadores de la empresa **/
	private ArrayList<Trabajador> trabajadores;
	/** arraylist de todos los proveedores de la empresa **/
	private ArrayList<Proveedor> proveedores;
	/** arraylist de todos las actividades de la empresa **/
	private ArrayList<Actividad> actividades;
	/** usuario es el dueño de la empresa es la clave foranea **/
	private Usuario usuario;

	/**
	 * Constructor de empresa con todas las variables internas
	 * 
	 * @param nombre       recibido desde el super es el nombre de la empresa
	 * @param dinero       recibido desde el super es el dinero o fondos que tiene
	 *                     la empresa
	 * @param cif          es el cif de la empresa su longuitud debe de ser de 9
	 *                     digitos
	 * @param campos       arraylist de todos los campos
	 * @param maquinarias  arraylist de todas las maquinarias
	 * @param trabajadores arraylist de todos los trabajadores
	 * @param proveedores  arraylist de todos los proveedores
	 * @param actividades  arraylist de todas las actividades
	 * @throws nombreInvalidoExceptions error de nombre invalido salta cuando el
	 *                                  nombre se queda en blanco
	 * @throws SQLException             error sql salta cuando hay un error de base
	 *                                  de datos
	 */
	public Empresa(String nombre, int dinero, String cif, ArrayList<Campo> campos, ArrayList<Maquinaria> maquinarias,
			ArrayList<Trabajador> trabajadores, ArrayList<Proveedor> proveedores, ArrayList<Actividad> actividades)
			throws nombreInvalidoExceptions, SQLException {
		super(nombre, dinero);
		this.cif = cif;
		this.campos = campos;
		this.maquinarias = maquinarias;
		this.trabajadores = trabajadores;
		this.proveedores = proveedores;
		this.actividades = actividades;
	}

	/**
	 * Constructor que crea una empresa y la inserta en la base de datos
	 * 
	 * @param nombre  recibido desde el super es el nombre de la empresa
	 * @param dinero  recibido desde el super es el dinero o fondos que tiene la
	 *                empresa
	 * @param cif     es el cif de la empresa su longuitud debe de ser de 9 digitos
	 * @param usuario usuario es el dueño de la empresa, es la clave foranea
	 * @throws nombreInvalidoExceptions nombre invalido salta cuando el nombre se
	 *                                  queda ene blanco
	 * @throws SQLException             error que salta cuando hay errores de base
	 *                                  de datos
	 * @throws cifInvalidoExceptions    cif invalido error que salta cuando la
	 *                                  longuitud del cif no es 9 digitos
	 */
	public Empresa(String nombre, int dinero, String cif, Usuario usuario)
			throws nombreInvalidoExceptions, SQLException, cifInvalidoExceptions {
		super(nombre, dinero);
		String nombreEmpresa = nombre;
		float presupuesto = dinero;
		String nombreUsuario = usuario.getNombre();
		if (!this.cifValido(cif)) {
			throw new cifInvalidoExceptions("La longuitud del CIF debe ser de 9 digitos, 8 numeos y 1 letra");
		}
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into empresa values('" + this.getNombre() + "','" + cif + "',"
				+ this.getDinero() + ",'" + usuario.getNombre() + "')") > 0) {
			this.cif = cif;
		} else {
			UtilsDB.desconectarBD();
			throw new SQLException("No se ha podido insertar la empresa");
		}

		UtilsDB.desconectarBD();

	}

	/**
	 * Funcion privada que sirve comprobar la longuitud del cif
	 * 
	 * @param cif recibe el cif de la empresa
	 * @return devuelve que la longuitud del cif debe de ser 9 digitos
	 */
	private boolean cifValido(String cif) {
		return cif.length() == 9;
	}

	/**
	 * Contructor que sirve para iniciar el programa con un usuario que ya tiene una
	 * empresa creada
	 * 
	 * @param nombre  recibido desde el super es el nombre de la empresa
	 * @param usuario usuario es el dueño de la empresa, es la clave foranea
	 * @throws nombreInvalidoExceptions    nombre invalido salta cuando el nombre se
	 *                                     queda ene blanco
	 * @throws SQLException                error que salta cuando hay errores de
	 *                                     base de datos
	 * @throws EmpresaIncorrectaExceptions error que salta cuando el nombre de la
	 *                                     empresa no exite
	 */
	public Empresa(String nombre, Usuario usuario)
			throws nombreInvalidoExceptions, SQLException, EmpresaIncorrectaExceptions {
		super(nombre);
		String nombreUsuario = usuario.getNombre();
		Statement smt = UtilsDB.conectarBD();
		ResultSet cursor = smt.executeQuery(
				"select * from empresa where nombreEmpresa='" + nombre + "' and nombreUsuario='" + nombreUsuario + "'");

		if (cursor.next()) {
			this.nombre = cursor.getString("nombreEmpresa");
			if (!this.nombre.equals(nombre)) {
				UtilsDB.desconectarBD();
				throw new EmpresaIncorrectaExceptions("El nombre de la empresa no existe");
			}
			nombre = cursor.getString("nombreEmpresa");

		} else {
			UtilsDB.desconectarBD();
			throw new EmpresaIncorrectaExceptions("El nombre de la empresa no existe");
		}
		UtilsDB.desconectarBD();
	}

	/**
	 * Getter del cif de la empresa
	 * 
	 * @return devuelve el cif de la empresa
	 */
	public String getCif() {
		return cif;
	}

	/**
	 * Setter del cif de la empresa
	 * 
	 * @param cif es el nuevo cif de la empresa
	 */
	public void setCif(String cif) {
		this.cif = cif;
	}

	/**
	 * Getter de campos es un arraylist de todos los campos de la empresa
	 * 
	 * @return todos los campos de la empresa
	 */
	public ArrayList<Campo> getCampos() {
		return campos;
	}

	/**
	 * Setter de campos de la empresa
	 * 
	 * @param campos es un nuevo arraylist de campos
	 */
	public void setCampos(ArrayList<Campo> campos) {
		this.campos = campos;
	}

	/**
	 * Getter de maquinaria es una arraylist de las maquinarias de la empresa
	 * 
	 * @return todas las maquinarias de la empresa
	 */
	public ArrayList<Maquinaria> getMaquinarias() {
		return maquinarias;
	}

	/**
	 * Setter de maquinarias de la empresa
	 * 
	 * @param maquinarias nueva lista de maquinarias
	 */
	public void setMaquinarias(ArrayList<Maquinaria> maquinarias) {
		this.maquinarias = maquinarias;
	}

	/**
	 * Getter de trabjadores es un arraylist de todos los trabjadores de la empresa
	 * 
	 * @return devuelve todos los trabjadores de la empresa
	 */
	public ArrayList<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	/**
	 * Setter de los trabajadores de la empresa
	 * 
	 * @param trabajadores nueva lista de trabajadores
	 */
	public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}

	/**
	 * Getter proveedores es un arraylist de todos los proveedores
	 * 
	 * @return devuelve una lista de proveedores
	 */
	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}

	/**
	 * Setter de proveedores de la empresa
	 * 
	 * @param proveedores una nueva lista de proveedores
	 */
	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	/**
	 * Getter de las actividades de la empresa
	 * 
	 * @return devuelve una lista de actividades
	 */
	public ArrayList<Actividad> getActividades() {
		return actividades;
	}

	/**
	 * Setter de actividades de la empresa
	 * 
	 * @param actividades una nueva lista de actividades
	 */
	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}

}
