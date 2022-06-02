package superClases;

import java.sql.SQLException;
import java.sql.Statement;

import exceptions.nombreInvalidoExceptions;
import utils.UtilsDB;

public abstract  class EntidadConNombre {
	
	public String nombre;

	public EntidadConNombre(String nombre) throws nombreInvalidoExceptions, SQLException {
		this.nombre = nombre;
	}
	
	public EntidadConNombre()  {
		
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws nombreInvalidoExceptions, SQLException {
		if(!this.nombreValido(nombre)) {
			throw new nombreInvalidoExceptions("El  nombre no puede estar vacio");
		}
		Statement smt = UtilsDB.conectarBD();
		smt.executeUpdate("update usuario set nombre='" + nombre + "' where nombre='" + this.nombre + "'");
		UtilsDB.desconectarBD();
		this.nombre = nombre;
	}
	
	private boolean nombreValido( String nombre) {
		return !nombre.isBlank();
	}
	
	

}
