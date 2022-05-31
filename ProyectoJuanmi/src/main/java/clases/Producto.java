package clases;

import java.sql.SQLException;

import enums.TipoProducto;
import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConDinero;

public class Producto extends EntidadConDinero {
	private TipoProducto tipo;
	private  Actividad nombreActividad;
	
	
	public Producto(String nombre, float dinero, TipoProducto tipo, Actividad nombreActividad)
			throws nombreInvalidoExceptions, SQLException {
		super(nombre, dinero);
		this.tipo = tipo;
		this.nombreActividad = nombreActividad;
	}


	public TipoProducto getTipo() {
		return tipo;
	}


	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}


	public Actividad getNombreActividad() {
		return nombreActividad;
	}


	public void setNombreActividad(Actividad nombreActividad) {
		this.nombreActividad = nombreActividad;
	} 

	
	
	
}
