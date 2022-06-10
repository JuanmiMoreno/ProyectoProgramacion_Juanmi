package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exceptions.TelefonoInvalidoExceptions;
import exceptions.cifInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConNombre;
import utils.UtilsDB;

/**
 * Clase que instancia un proveedor, que se ocupa de venderle productos a la
 * empresa, hereda de entidad con nombre
 * 
 * @author Juanmi
 *
 */
public class Proveedor extends EntidadConNombre {
	/** el telefono con el que se podra contactar con el proveedor **/
	private String telefono;
	/** Lista de todos los productos del proveedor **/
	private ArrayList<Producto> productos;

	/**
	 * Contructor que crea un proveedor
	 * 
	 * @param nombre    recibido desde el super, es el nombre del proveedor
	 * @param telefono  telefono del proveedor
	 * @param productos lista de productos del proveedor
	 * @throws nombreInvalidoExceptions error que salta cuando el nombre se queda en
	 *                                  blanco
	 * @throws SQLException             error que salta cuando hay un error de base
	 *                                  de datos
	 */
	public Proveedor(String nombre, String telefono, ArrayList<Producto> productos)
			throws nombreInvalidoExceptions, SQLException {
		super(nombre);
		this.telefono = telefono;
		this.productos = productos;
	}

	/**
	 * Constructor que crea un proveedor y lo inserta en la base de datos
	 * 
	 * @param nombre   recibido por el super, es el nombre del proveedor
	 * @param telefono telefono del proveedor
	 * @throws SQLException               error que salta cuando hay un error de
	 *                                    base de datos
	 * @throws TelefonoInvalidoExceptions error que salta cuando la longuitud del
	 *                                    telefono es diferente de 9 digitos
	 * @throws nombreInvalidoExceptions   error que salta cuando el nombre se queda
	 *                                    en blanco
	 */
	public Proveedor(String nombre, String telefono)
			throws SQLException, TelefonoInvalidoExceptions, nombreInvalidoExceptions {
		if (!this.telefonoValido(telefono)) {
			throw new TelefonoInvalidoExceptions("La longuitud del Telefono debe ser de 9 digitos");
		}

		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar
				.executeUpdate("insert into proveedor values('" + this.getNombre() + "','" + telefono + "')") > 0) {
			this.nombre = nombre;
			this.telefono = telefono;
		} else {
			UtilsDB.desconectarBD();
			throw new SQLException("No se ha podido insertar el proveedor");
		}

		UtilsDB.desconectarBD();
	}

	/**
	 * Funcion privada que comprueba la longuitud del telefono
	 * 
	 * @param telefono el telefono a comprobar
	 * @return devuelve true si la longuitud es 9 y false si es distinta
	 */
	private boolean telefonoValido(String telefono) {
		return telefono.length() == 9;
	}

	/**
	 * Getter de telefono de proveedor
	 * 
	 * @return devuelve el telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Setter del telefono de proveedores
	 * 
	 * @param telefono nuevo telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Getter de arraylist de productos que tiene los proveedores
	 * 
	 * @return devuelve la lista de los productos
	 */
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	/**
	 * Setter de arraylist de productos que tiene los proveedores
	 * 
	 * @param productos nueva lista de productos
	 */
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

}
