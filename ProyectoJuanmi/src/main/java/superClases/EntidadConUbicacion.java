package superClases;

import java.sql.SQLException;

import enums.Provincia;
import exceptions.nombreInvalidoExceptions;

public abstract class EntidadConUbicacion extends EntidadConNombre {
	
	private Provincia provincia;

	public EntidadConUbicacion(String nombre, Provincia provincia) throws nombreInvalidoExceptions, SQLException {
		super(nombre);
		this.provincia = provincia;
	}

	public EntidadConUbicacion(String nombre) throws nombreInvalidoExceptions, SQLException {
		super(nombre);
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	

}
