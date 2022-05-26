package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exceptions.ContraseñaIncorrectaException;
import exceptions.EmpresaIncorrectaExceptions;
import exceptions.UsuarioNoExisteException;
import exceptions.cifInvalidoExceptions;
import exceptions.emailInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConDinero;
import utils.UtilsDB;

public class Empresa extends EntidadConDinero {
	private String cif;
	private ArrayList<Campo> campos;
	private ArrayList<Maquinaria> maquinarias;
	private ArrayList<Trabajador> trabajadores;
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Actividad> actividades;
	private Usuario usuario;
	
	
	
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
	
	public Empresa(String nombre, float dinero, String cif, Usuario usuario)
			throws nombreInvalidoExceptions, SQLException, cifInvalidoExceptions {
		super(nombre, dinero);
		String nombreEmpresa = nombre;
		float presupuesto = dinero;
		String nombreUsuario = usuario.getNombre();
		if(!this.cifValido(cif)) {
			throw new cifInvalidoExceptions("La longuitud del CIF debe ser de 9 digitos, 8 numeos y 1 letra");
		}
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into empresa values('" + nombreEmpresa + "','" + cif+ "','" + presupuesto + "','" + nombreUsuario
        + "')") > 0) {
			this.cif=cif;
		} else {
			UtilsDB.desconectarBD();
				throw new SQLException("No se ha podido insertar la empresa");
		}

		UtilsDB.desconectarBD();
		
		
	}
		
	private boolean cifValido (String email) {
		return email.length() ==9;
	}
	
	
	public Empresa(String nombre, Usuario usuario) throws nombreInvalidoExceptions, SQLException, EmpresaIncorrectaExceptions {
		super(nombre);
		String nombreUsuario = usuario.getNombre();
		Statement smt=UtilsDB.conectarBD();
		ResultSet cursor=smt.executeQuery("select * from empresa where nombreEmpresa='"+
		nombre+"' and nombreUsuario='"+nombreUsuario+"'");
		
		if(cursor.next()) {
			this.nombre=cursor.getString("nombreEmpresa");
			if(!this.nombre.equals(nombre)) {
				UtilsDB.desconectarBD();
				throw new EmpresaIncorrectaExceptions("El nombre de la empresa no existe");
			}
			nombre = cursor.getString("nombreEmpresa");
			
		}else {
			UtilsDB.desconectarBD();
			throw new EmpresaIncorrectaExceptions("El nombre de la empresa no existe");
		}
		UtilsDB.desconectarBD();
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
