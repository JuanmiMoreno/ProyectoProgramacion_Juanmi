package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import enums.Provincia;
import exceptions.Contrase�aIncorrectaException;
import exceptions.Contrase�aVaciaExceptions;
import exceptions.UsuarioNoExisteException;
import exceptions.emailInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConUbicacion;
import utils.UtilsDB;

/**
 * Clase que instancia un usuario que representa al due�o de la empresa herada
 * de entidad con uicacion
 * 
 * @author Juanmi
 *
 */
public class Usuario extends EntidadConUbicacion {
	/** contrase�a con la que hara login el usuario **/
	private String contrase�a;
	/** Email con el que se registrara el email **/
	private String email;

	/**
	 * Contructor que crea un usuario y lo inserta en la base de datos, como un
	 * registro
	 * 
	 * @param nombre     recibido por el super, es el nombre del usuario
	 * @param provincia  recibido por el super, es la provincia donde vive el
	 *                   usuario
	 * @param contrase�a es la contrase�a del usuario para hacer login
	 * @param email      es el email de usuario
	 * @throws SQLException              error de base de datos que salta cuando hay
	 *                                   fallos en la base de datos
	 * @throws Contrase�aVaciaExceptions error que salta cuando la contrase�a la
	 *                                   dejas vacia
	 * @throws emailInvalidoExceptions   error que salta cuando el email no
	 *                                   contiene @
	 * @throws nombreInvalidoExceptions  error que salta cuando el nombre se queda
	 *                                   vacio
	 */
	public Usuario(String nombre, Provincia provincia, String contrase�a, String email)
			throws SQLException, Contrase�aVaciaExceptions, emailInvalidoExceptions, nombreInvalidoExceptions {
		super(nombre, provincia);
		if (!this.contrase�aValido(contrase�a)) {
			throw new Contrase�aVaciaExceptions("La contrae�a no puede estar vacia");
		}
		if (!this.emailValido(email)) {
			throw new emailInvalidoExceptions("El email debe contener @");
		}

		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into usuario values('" + this.getNombre() + "','" + contrase�a + "','"
				+ email + "','" + provincia + "')") > 0) {
			this.contrase�a = contrase�a;
			this.email = email;
		} else {
			UtilsDB.desconectarBD();
			throw new SQLException("No se ha podido insertar el usuario");
		}

		UtilsDB.desconectarBD();

	}

	/**
	 * * Constructor que a partir de la clave primaria (nombre) Consulta en base de
	 * datos el usuario que ya tenga ese nombre. Si no existe, lanza un
	 * SQLException. Si existe, rellena el resto de variables internas a partir de
	 * los valores que le da el cursor de la consulta
	 * 
	 * @param nombre     el nombre que deber�a existir ya en la BD
	 * @param contrase�a es la contrase�a para hacer login
	 * @throws SQLException                  error de base de datos
	 * @throws Contrase�aIncorrectaException error que salta cuando la contrase�a no
	 *                                       es la correcta correspondiente al
	 *                                       usuario
	 * @throws UsuarioNoExisteException      error que existe cuando se introduce un
	 *                                       nombre de usuario que no existe
	 * @throws nombreInvalidoExceptions      error que salta cuando el nombre se
	 *                                       queda en blanco
	 */
	public Usuario(String nombre, String contrase�a)
			throws SQLException, Contrase�aIncorrectaException, UsuarioNoExisteException, nombreInvalidoExceptions {
		super(nombre);
		Statement smt = UtilsDB.conectarBD();
		ResultSet cursor = smt.executeQuery("select * from usuario where nombreUsuario='" + nombre + "'");

		if (cursor.next()) {
			this.contrase�a = cursor.getString("contrase�a");
			if (!this.contrase�a.equals(contrase�a)) {
				UtilsDB.desconectarBD();
				throw new Contrase�aIncorrectaException("La contrase�a no es correcta");
			}
			nombre = cursor.getString("nombreUsuario");
			this.email = cursor.getString("email");

		} else {
			UtilsDB.desconectarBD();
			throw new UsuarioNoExisteException("No existe ese usuario!");
		}
		UtilsDB.desconectarBD();
	}

	/**
	 * Funcion privada que comprueba si la contrase�a es valida
	 * 
	 * @param pass la contrase�a para comprobar
	 * @return true si la contrase�a no esta vacia y false si la contrase�a esta
	 *         vacia
	 */
	private boolean contrase�aValido(String pass) {
		return !pass.isBlank();
	}

	/**
	 * Funcion privada que comprueba si el email es valido
	 * 
	 * @param email email para comprobar
	 * @return devuelve true si el email contien un @ o false si no la contiene
	 */
	private boolean emailValido(String email) {
		return email.contains("@");
	}

	/**
	 * Funcion privada que comprueba que el nombre no este en blanci
	 * 
	 * @param nombre nombre para comprobar
	 * @return devuelve true si el nombre no esta vacio y false si esta vacio
	 */
	private boolean nombreValido(String nombre) {
		return !nombre.isBlank();
	}

	/**
	 * Getter de contrase�a
	 * 
	 * @return devuelve la contrase�a
	 */
	public String getContrase�a() {
		return contrase�a;
	}

	/**
	 * Setter de la contrase�a
	 * 
	 * @param contrase�a nueva contrase�a
	 * @throws SQLException              error de base de datos
	 * @throws Contrase�aVaciaExceptions error que salta cuando la contrase�a esta
	 *                                   vacia
	 */
	public void setContrase�a(String contrase�a) throws SQLException, Contrase�aVaciaExceptions {
		if (!this.contrase�aValido(contrase�a)) {
			throw new Contrase�aVaciaExceptions("La contrae�a no puede estar vacia");
		}
		Statement smt = UtilsDB.conectarBD();
		smt.executeUpdate("update usuario set contrasena='" + contrase�a + "' where nombre='" + this.getNombre() + "'");
		UtilsDB.desconectarBD();
		this.contrase�a = contrase�a;
	}

	/**
	 * Getter de email
	 * 
	 * @return devuelve el email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter de email
	 * 
	 * @param email nuevo email
	 * @throws SQLException            error base de datos
	 * @throws emailInvalidoExceptions error que salta cuando el email no contiene
	 *                                 un @
	 */
	public void setEmail(String email) throws SQLException, emailInvalidoExceptions {
		if (!this.emailValido(email)) {
			throw new emailInvalidoExceptions("El email debe contener @");
		}
		Statement smt = UtilsDB.conectarBD();
		smt.executeUpdate("update usuario set email='" + email + "' where nombre='" + super.getNombre() + "'");
		UtilsDB.desconectarBD();
		this.email = email;
	}

}
