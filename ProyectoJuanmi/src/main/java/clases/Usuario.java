package clases;

import superClases.EntidadConUbicacion;

public class Usuario extends EntidadConUbicacion {

	private String contraseña;
	private String email;
	
	
	
	public Usuario(String nombre, String provincia, String contraseña, String email) {
		super(nombre, provincia);
		this.contraseña = contraseña;
		this.email = email;
	}



	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
