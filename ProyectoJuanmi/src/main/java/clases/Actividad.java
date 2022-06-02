package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConNombre;
import utils.UtilsDB;

public class Actividad extends EntidadConNombre {
	private Byte duracion;
	private Campo campo;
	private Trabajador trabajador;
	private ArrayList<Maquinaria> maquinarias;
	private String descripcion;
	private Producto producto;
	private Empresa empresa;
	
	
	public Actividad() {
		
	}
	
	public Actividad(String nombre, Byte duracion, Campo campo, Trabajador trabajador,
			ArrayList<Maquinaria> maquinarias, String descripcion, Producto producto, Empresa empresa)
			throws nombreInvalidoExceptions, SQLException {
		super(nombre);
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into usuario values('" + nombre + "','" + duracion + "','" + descripcion
				+ "'," + empresa.getNombre() + "')") > 0) {
			this.duracion = duracion;
			this.campo = campo;
			this.trabajador = trabajador;
			this.maquinarias = maquinarias;
			this.descripcion = descripcion;
			this.producto = producto;
			this.empresa = empresa;
		} else {
			UtilsDB.desconectarBD();
				throw new SQLException("No se ha podido insertar el usuario");
		}

		UtilsDB.desconectarBD();

	}



	public Byte getDuracion() {
		return duracion;
	}



	public void setDuracion(Byte duracion) {
		this.duracion = duracion;
	}



	public Campo getCampo() {
		return campo;
	}



	public void setCampo(Campo campo) {
		this.campo = campo;
	}



	public Trabajador getTrabajador() {
		return trabajador;
	}



	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}



	public ArrayList<Maquinaria> getMaquinarias() {
		return maquinarias;
	}



	public void setMaquinarias(ArrayList<Maquinaria> maquinarias) {
		this.maquinarias = maquinarias;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Producto getProducto() {
		return producto;
	}



	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	public Empresa getEmpresa() {
		return empresa;
	}



	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public  static ArrayList<Actividad> getTodos() {
		Statement smt = UtilsDB.conectarBD();
		ArrayList<Actividad> ret = new ArrayList<Actividad>();

		try {
			ResultSet cursor = smt.executeQuery("select * from actividad ");
			while (cursor.next()) {
				Actividad actual = new Actividad();

				actual.nombre = cursor.getString("nombreActividad");
				actual.descripcion = cursor.getString("descripcion");
				//actual.campo = cursor.getString();
				actual.duracion = cursor.getByte("duracion");
				
				ret.add(actual);
			}
		} catch (SQLException e) {
			
			e.getMessage();
			return null;
		}
		
		UtilsDB.desconectarBD();
		return ret;
	}
	
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
	
	



	


