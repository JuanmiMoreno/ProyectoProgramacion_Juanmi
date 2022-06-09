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

public class Trabajador extends EntidadConDinero {
	private String apellido;
	private String dni;
	private Empresa empresa;
	
	public Trabajador() {
		
	}
	
	public Trabajador(String nombre, int dinero, String apellido, String dni, Empresa empresa) throws nombreInvalidoExceptions, SQLException {
		super(nombre, dinero);
		
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into trabajador values('" + this.getNombre() + "','" + apellido+ "','" +dni + "','" + this.getDinero()   
        + "','"+empresa.getNombre()+"')") > 0) {
			this.apellido = apellido;
			this.dni = dni;
			this.empresa = empresa;
		} else {
			UtilsDB.desconectarBD();
				throw new SQLException("No se ha podido el trabajador");
		}

		UtilsDB.desconectarBD();
		
		
	}



	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public  static ArrayList<Trabajador> getTodos() {
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
