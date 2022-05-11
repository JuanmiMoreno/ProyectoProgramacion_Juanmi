package clases;

import java.util.ArrayList;

import superClases.EntidadConNombre;

public class Actividad extends EntidadConNombre {
	private Byte duracion;
	private Campo campo;
	private Trabajador trabajador;
	private ArrayList<Maquinaria> maquinarias;
	private String descripcion;
	private Producto producto;
	
	
	public Actividad(String nombre, Byte duracion, Campo campo, Trabajador trabajador,
			ArrayList<Maquinaria> maquinarias, String descripcion, Producto producto) {
		super(nombre);
		this.duracion = duracion;
		this.campo = campo;
		this.trabajador = trabajador;
		this.maquinarias = maquinarias;
		this.descripcion = descripcion;
		this.producto = producto;
	}


	public Byte getDuracion() {
		return duracion;
	}

	public void setDuracion(Byte duracion) {
		this.duracion = duracion;
	}

	public Campo getCampo() {
		return campo;
	}

	public void setCampo(Campo campo) {
		this.campo = campo;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public ArrayList<Maquinaria> getMaquinarias() {
		return maquinarias;
	}

	public void setMaquinarias(ArrayList<Maquinaria> maquinarias) {
		this.maquinarias = maquinarias;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	

}
