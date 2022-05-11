package clases;

import superClases.EntidadConUbicacion;

public class Usuario extends EntidadConUbicacion {

	private String contrase�a;
	private String email;
	
	
	
	public Usuario(String nombre, String provincia, String contrase�a, String email) {
		super(nombre, provincia);
		this.contrase�a = contrase�a;
		this.email = email;
	}



	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
