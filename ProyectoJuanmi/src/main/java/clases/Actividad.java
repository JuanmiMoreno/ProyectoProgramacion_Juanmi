package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConNombre;
import utils.UtilsDB;

public class Actividad extends EntidadConNombre {
	private Byte duracion;
	private Campo campo;
	private Trabajador trabajador;
	private ArrayList<Maquinaria> maquinarias;
	private String descripcion;
	private Producto producto;
	private Empresa empresa;
	
	
	
	public Actividad(String nombre, Byte duracion, Campo campo, Trabajador trabajador,
			ArrayList<Maquinaria> maquinarias, String descripcion, Producto producto, Empresa empresa)
			throws nombreInvalidoExceptions, SQLException {
		super(nombre);
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into usuario values('" + nombre + "','" + duracion + "','" + descripcion
				+ "'," + empresa.getNombre() + "')") > 0) {
			this.duracion = duracion;
			this.campo = campo;
			this.trabajador = trabajador;
			this.maquinarias = maquinarias;
			this.descripcion = descripcion;
			this.producto = producto;
			this.empresa = empresa;
		} else {
			UtilsDB.desconectarBD();
				throw new SQLException("No se ha podido insertar el usuario");
		}

		UtilsDB.desconectarBD();

	}
	}
	
	



	


