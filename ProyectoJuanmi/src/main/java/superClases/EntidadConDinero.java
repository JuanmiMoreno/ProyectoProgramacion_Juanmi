package superClases;

import java.sql.SQLException;

import exceptions.nombreInvalidoExceptions;

public abstract class EntidadConDinero extends EntidadConNombre {
	private float dinero;

	public EntidadConDinero(String nombre, float dinero) throws nombreInvalidoExceptions, SQLException {
		super(nombre);
		this.dinero = dinero;
	}


	
	public float getDinero() {
		return dinero;
	}

	public void setDinero(float dinero) {
		this.dinero = dinero;
	}
	
	
}
