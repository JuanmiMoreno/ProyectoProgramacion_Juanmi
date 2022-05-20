package clases;

import java.sql.SQLException;

import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConDinero;

public class Trabajador extends EntidadConDinero {
	private String apellido;
	private String dni;

	
	
	public Trabajador(String nombre, float dinero, String apellido, String dni) throws nombreInvalidoExceptions, SQLException {
		super(nombre, dinero);
		this.apellido = apellido;
		this.dni = dni;
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
	
	
}
