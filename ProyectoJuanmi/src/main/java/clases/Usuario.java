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

/**
 * Clase que instancia un usuario que representa al dueño de la empresa herada
 * de entidad con uicacion
 * 
 * @author Juanmi
 *
 */
public class Usuario extends EntidadConUbicacion {
	/** contraseña con la que hara login el usuario **/
	private String contraseña;
	/** Email con el que se registrara el email **/
	private String email;

	/**
	 * Contructor que crea un usuario y lo inserta en la base de datos, como un
	 * registro
	 * 
	 * @param nombre     recibido por el super, es el nombre del usuario
	 * @param provincia  recibido por el super, es la provincia donde vive el
	 *                   usuario
	 * @param contraseña es la contraseña del usuario para hacer login
	 * @param email      es el email de usuario
	 * @throws SQLException              error de base de datos que salta cuando hay
	 *                                   fallos en la base de datos
	 * @throws ContraseñaVaciaExceptions error que salta cuando la contraseña la
	 *                                   dejas vacia
	 * @throws emailInvalidoExceptions   error que salta cuando el email no
	 *                                   contiene @
	 * @throws nombreInvalidoExceptions  error que salta cuando el nombre se queda
	 *                                   vacio
	 */
	public Usuario(String nombre, Provincia provincia, String contraseña, String email)
			throws SQLException, ContraseñaVaciaExceptions, emailInvalidoExceptions, nombreInvalidoExceptions {
		super(nombre, provincia);
		if (!this.contraseñaValido(contraseña)) {
			throw new ContraseñaVaciaExceptions("La contraeña no puede estar vacia");
		}
		if (!this.emailValido(email)) {
			throw new emailInvalidoExceptions("El email debe contener @");
		}

		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into usuario values('" + this.getNombre() + "','" + contraseña + "','"
				+ email + "','" + provincia + "')") > 0) {
			this.contraseña = contraseña;
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
	 * @param nombre     el nombre que debería existir ya en la BD
	 * @param contraseña es la contraseña para hacer login
	 * @throws SQLException                  error de base de datos
	 * @throws ContraseñaIncorrectaException error que salta cuando la contraseña no
	 *                                       es la correcta correspondiente al
	 *                                       usuario
	 * @throws UsuarioNoExisteException      error que existe cuando se introduce un
	 *                                       nombre de usuario que no existe
	 * @throws nombreInvalidoExceptions      error que salta cuando el nombre se
	 *                                       queda en blanco
	 */
	public Usuario(String nombre, String contraseña)
			throws SQLException, ContraseñaIncorrectaException, UsuarioNoExisteException, nombreInvalidoExceptions {
		super(nombre);
		Statement smt = UtilsDB.conectarBD();
		ResultSet cursor = smt.executeQuery("select * from usuario where nombreUsuario='" + nombre + "'");

		if (cursor.next()) {
			this.contraseña = cursor.getString("contraseña");
			if (!this.contraseña.equals(contraseña)) {
				UtilsDB.desconectarBD();
				throw new ContraseñaIncorrectaException("La contraseña no es correcta");
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
	 * Funcion privada que comprueba si la contraseña es valida
	 * 
	 * @param pass la contraseña para comprobar
	 * @return true si la contraseña no esta vacia y false si la contraseña esta
	 *         vacia
	 */
	private boolean contraseñaValido(String pass) {
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
	 * Getter de contraseña
	 * 
	 * @return devuelve la contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * Setter de la contraseña
	 * 
	 * @param contraseña nueva contraseña
	 * @throws SQLException              error de base de datos
	 * @throws ContraseñaVaciaExceptions error que salta cuando la contraseña esta
	 *                                   vacia
	 */
	public void setContraseña(String contraseña) throws SQLException, ContraseñaVaciaExceptions {
		if (!this.contraseñaValido(contraseña)) {
			throw new ContraseñaVaciaExceptions("La contraeña no puede estar vacia");
		}
		Statement smt = UtilsDB.conectarBD();
		smt.executeUpdate("update usuario set contrasena='" + contraseña + "' where nombre='" + this.getNombre() + "'");
		UtilsDB.desconectarBD();
		this.contraseña = contraseña;
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
