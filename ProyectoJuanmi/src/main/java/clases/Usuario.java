package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import enums.Provincia;
import exceptions.ContraseñaIncorrectaException;
import exceptions.ContraseñaVaciaExceptions;
import exceptions.UsuarioNoExisteException;
import exceptions.emailInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConUbicacion;
import utils.UtilsDB;

public class Usuario extends EntidadConUbicacion {

	private String contraseña;
	private String email;

	public Usuario(String nombre, Provincia provincia, String contraseña, String email) throws SQLException, ContraseñaVaciaExceptions, emailInvalidoExceptions, nombreInvalidoExceptions {
		super(nombre, provincia);
		if(!this.contraseñaValido(contraseña)) {
			throw new ContraseñaVaciaExceptions("La contraeña no puede estar vacia");
		}
		if(!this.emailValido(email)) {
			throw new emailInvalidoExceptions("El email debe contener @");
		}
		
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into usuario values('" + this.getNombre() + "','" + contraseña+ "','" + email + "','" + provincia
        + "')") > 0) {
			this.contraseña = contraseña;
			this.email = email;
		} else {
			UtilsDB.desconectarBD();
				throw new SQLException("No se ha podido insertar el usuario");
		}

		UtilsDB.desconectarBD();

	}
	
	
	public Usuario(String nombre,String contraseña) throws SQLException, ContraseñaIncorrectaException, UsuarioNoExisteException, nombreInvalidoExceptions {
		super(nombre);
		Statement smt=UtilsDB.conectarBD();
		ResultSet cursor=smt.executeQuery("select * from usuario where nombreUsuario='"+
		nombre+"'");
		
		if(cursor.next()) {
			this.contraseña=cursor.getString("contraseña");
			if(!this.contraseña.equals(contraseña)) {
				UtilsDB.desconectarBD();
				throw new ContraseñaIncorrectaException("La contraseña no es correcta");
			}
			nombre = cursor.getString("nombreUsuario");
			this.email = cursor.getString("email");
			

		}else {
			UtilsDB.desconectarBD();
			throw new UsuarioNoExisteException("No existe ese usuario!");
		}
		UtilsDB.desconectarBD();
	}
	
	
	
	private boolean contraseñaValido( String pass) {
		return !pass.isBlank();
	}
	private boolean emailValido (String email) {
		return email.contains("@");
	}

	private boolean nombreValido( String nombre) {
		return !nombre.isBlank();
	}
	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) throws SQLException, ContraseñaVaciaExceptions {
		if(!this.contraseñaValido(contraseña)) {
			throw new ContraseñaVaciaExceptions("La contraeña no puede estar vacia");
		}
		Statement smt = UtilsDB.conectarBD();
		smt.executeUpdate(
				"update usuario set contrasena='" + contraseña + "' where nombre='" + this.getNombre() + "'");
		UtilsDB.desconectarBD();
		this.contraseña = contraseña;
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
