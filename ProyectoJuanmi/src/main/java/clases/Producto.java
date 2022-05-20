package clases;

import java.sql.SQLException;

import enums.tipoProducto;
import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConDinero;

public class Producto extends EntidadConDinero {
	private tipoProducto tipo;
	private  Actividad nombreActividad;
	
	
	public Producto(String nombre, float dinero, tipoProducto tipo, Actividad nombreActividad)
			throws nombreInvalidoExceptions, SQLException {
		super(nombre, dinero);
		this.tipo = tipo;
		this.nombreActividad = nombreActividad;
	}


	public tipoProducto getTipo() {
		return tipo;
	}


	public void setTipo(tipoProducto tipo) {
		this.tipo = tipo;
	}


	public Actividad getNombreActividad() {
		return nombreActividad;
	}


	public void setNombreActividad(Actividad nombreActividad) {
		this.nombreActividad = nombreActividad;
	} 

	
	
	
}
