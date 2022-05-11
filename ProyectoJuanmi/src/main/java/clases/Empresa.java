package clases;

import java.util.ArrayList;

import superClases.EntidadConDinero;

public class Empresa extends EntidadConDinero {
	private String cif;
	private ArrayList<Campo> campos;
	private ArrayList<Maquinaria> maquinarias;
	private ArrayList<Trabajador> trabajadores;
	private ArrayList<Proveedor> proveedores;
	
	
	
	public Empresa(String nombre, float dinero, String cif, ArrayList<Campo> campos, ArrayList<Maquinaria> maquinarias,
			ArrayList<Trabajador> trabajadores, ArrayList<Proveedor> proveedores) {
		super(nombre, dinero);
		this.cif = cif;
		this.campos = campos;
		this.maquinarias = maquinarias;
		this.trabajadores = trabajadores;
		this.proveedores = proveedores;
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
	
	
	
}
