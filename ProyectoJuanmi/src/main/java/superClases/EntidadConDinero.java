package superClases;

import java.sql.SQLException;

import exceptions.nombreInvalidoExceptions;

public abstract class EntidadConDinero extends EntidadConNombre {
	private int dinero;

	public EntidadConDinero(String nombre, int dinero) throws nombreInvalidoExceptions, SQLException {
		super(nombre);
		this.dinero = dinero;
	}


	
	public EntidadConDinero(String nombre) throws nombreInvalidoExceptions, SQLException {
		super(nombre);
	}

	public EntidadConDinero() {
		
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	
	
}
