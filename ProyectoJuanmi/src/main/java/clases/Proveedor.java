package clases;

import java.sql.SQLException;
import java.util.ArrayList;

import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConNombre;

public class Proveedor extends EntidadConNombre {
	private byte telefono;
	ArrayList<Producto> productos;
	
	
	public Proveedor(String nombre, byte telefono, ArrayList<Producto> productos) throws nombreInvalidoExceptions, SQLException {
		super(nombre);
		this.telefono = telefono;
		this.productos = productos;
	}


	public byte getTelefono() {
		return telefono;
	}

	public void setTelefono(byte telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	
	
	
}
