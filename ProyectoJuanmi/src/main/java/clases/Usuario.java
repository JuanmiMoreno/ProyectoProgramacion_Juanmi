package clases;

import java.sql.SQLException;
import java.sql.Statement;

import exceptions.Contrase�aVaciaExceptions;
import exceptions.emailInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConUbicacion;
import utils.UtilsDB;

public class Usuario extends EntidadConUbicacion {

	private String contrase�a;
	private String email;

	public Usuario(String nombre, String provincia, String contrase�a, String email) throws SQLException, Contrase�aVaciaExceptions, emailInvalidoExceptions, nombreInvalidoExceptions {
		super(nombre, provincia);
		if(!this.contrase�aValido(contrase�a)) {
			throw new Contrase�aVaciaExceptions("La contrae�a no puede estar vacia");
		}
		if(!this.emailValido(email)) {
			throw new emailInvalidoExceptions("El email debe contener @");
		}
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into usuario values('" + nombre + "','" + contrase�a + "','" + email
				+ "'," + provincia + "')") > 0) {
			this.contrase�a = contrase�a;
			this.email = email;
		} else {
			UtilsDB.desconectarBD();
				throw new SQLException("No se ha podido insertar el usuario");
		}

		UtilsDB.desconectarBD();

	}
	
	
	
	private boolean contrase�aValido( String pass) {
		return !pass.isBlank();
	}
	private boolean emailValido (String email) {
		return email.contains("@");
	}

	private boolean nombreValido( String nombre) {
		return !nombre.isBlank();
	}
	
	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) throws SQLException, Contrase�aVaciaExceptions {
		if(!this.contrase�aValido(contrase�a)) {
			throw new Contrase�aVaciaExceptions("La contrae�a no puede estar vacia");
		}
		Statement smt = UtilsDB.conectarBD();
		smt.executeUpdate(
				"update usuario set contrasena='" + contrase�a + "' where nombre='" + super.getNombre() + "'");
		UtilsDB.desconectarBD();
		this.contrase�a = contrase�a;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws SQLException, emailInvalidoExceptions {
		if(!this.emailValido(email)) {
			throw new emailInvalidoExceptions("El email debe contener @");
		}
		Statement smt = UtilsDB.conectarBD();
		smt.executeUpdate("update usuario set email='" + email + "' where nombre='" + super.getNombre() + "'");
		UtilsDB.desconectarBD();
		this.email = email;
	}

}
