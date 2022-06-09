package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exceptions.TelefonoInvalidoExceptions;
import exceptions.cifInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConNombre;
import utils.UtilsDB;

public class Proveedor extends EntidadConNombre {
	private String telefono;
	ArrayList<Producto> productos;
	
	
	public Proveedor(String nombre, String telefono, ArrayList<Producto> productos) throws nombreInvalidoExceptions, SQLException {
		super(nombre);
		this.telefono = telefono;
		this.productos = productos;
	}


	public Proveedor(String nombre, String telefono) throws SQLException, TelefonoInvalidoExceptions,  nombreInvalidoExceptions {
		if(!this.telefonoValido (telefono)) {
			throw new TelefonoInvalidoExceptions("La longuitud del Telefono debe ser de 9 digitos");
		}
		
		
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into proveedor values('" + this.getNombre() + "','" + telefono+ "')") > 0){
			this.nombre = nombre;
			this.telefono = telefono;
		} else {
			UtilsDB.desconectarBD();
				throw new SQLException("No se ha podido insertar el proveedor");
		}

		UtilsDB.desconectarBD();
	}

	private boolean telefonoValido (String telefono) {
		return telefono.length() ==9;
	}

	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	
	
	
}
