package clases;

import java.sql.SQLException;
import java.util.ArrayList;

import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConDinero;

public class Empresa extends EntidadConDinero {
	private String cif;
	private ArrayList<Campo> campos;
	private ArrayList<Maquinaria> maquinarias;
	private ArrayList<Trabajador> trabajadores;
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Actividad> actividades;
	
	
	
	public Empresa(String nombre, float dinero, String cif, ArrayList<Campo> campos, ArrayList<Maquinaria> maquinarias,
			ArrayList<Trabajador> trabajadores, ArrayList<Proveedor> proveedores, ArrayList<Actividad> actividades)
			throws nombreInvalidoExceptions, SQLException {
		super(nombre, dinero);
		this.cif = cif;
		this.campos = campos;
		this.maquinarias = maquinarias;
		this.trabajadores = trabajadores;
		this.proveedores = proveedores;
		this.actividades = actividades;
	}
	
	
	
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public ArrayList<Campo> getCampos() {
		return campos;
	}
	public void setCampos(ArrayList<Campo> campos) {
		this.campos = campos;
	}
	public ArrayList<Maquinaria> getMaquinarias() {
		return maquinarias;
	}
	public void setMaquinarias(ArrayList<Maquinaria> maquinarias) {
		this.maquinarias = maquinarias;
	}
	public ArrayList<Trabajador> getTrabajadores() {
		return trabajadores;
	}
	public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}
	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}
	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	public ArrayList<Actividad> getActividades() {
		return actividades;
	}
	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	

	
	
}
