package clases;

import enums.tipoProducto;
import superClases.EntidadConDinero;

public class Producto extends EntidadConDinero {
	private tipoProducto tipo;

	public Producto(String nombre, float dinero, tipoProducto tipo) {
		super(nombre, dinero);
		this.tipo = tipo;
	}

	
	
	public tipoProducto getTipo() {
		return tipo;
	}
	
	public void setTipo(tipoProducto tipo) {
		this.tipo = tipo;
	}
	
	
}
