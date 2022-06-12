package clases;

import java.sql.SQLException;

import enums.TipoProducto;
import exceptions.NombreInvalidoExceptions;
import superClases.EntidadConDinero;

/**
 * Clase que extiende de entidad con dinero esta clase crea un producto
 * 
 * @author Juanmi No he tenido tiempo a poder utilizarla pero la dejo para no
 *         borrarla ni modificar el diagrama
 */
public class Producto extends EntidadConDinero {
	private TipoProducto tipo;
	private Actividad nombreActividad;

	/**
	 * Constructor que crea un producto
	 * 
	 * @param nombre          recibido por el super, es el nombre del producto
	 * @param dinero          recibido por el super, es el precio del producto
	 * @param tipo            es el tipo de producto que es
	 * @param nombreActividad nombre de la actividad en el que se utiliza el
	 *                        producto
	 * @throws NombreInvalidoExceptions error que salta cuando el nombre esta vacio
	 * @throws SQLException             error que salta cuando hay unn problema de
	 *                                  base de datos
	 */
	public Producto(String nombre, int dinero, TipoProducto tipo, Actividad nombreActividad)
			throws NombreInvalidoExceptions, SQLException {
		super(nombre, dinero);
		this.tipo = tipo;
		this.nombreActividad = nombreActividad;
	}

	/**
	 * Getter de tipo de producto
	 * 
	 * @return devuelve el tipo de producto
	 */
	public TipoProducto getTipo() {
		return tipo;
	}

	/**
	 * Setter de tipo de producto
	 * 
	 * @param tipo nuevo tipo de producto
	 */
	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}

	/**
	 * Getter del nombre de la actividad
	 * 
	 * @return devuelve el nombre de la actividad
	 */
	public Actividad getNombreActividad() {
		return nombreActividad;
	}

	/**
	 * Setter de nombre de la actividad
	 * 
	 * @param nombreActividad nuevo nombre de la actividad
	 */
	public void setNombreActividad(Actividad nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

}
