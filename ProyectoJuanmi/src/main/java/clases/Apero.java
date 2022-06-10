package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.Provincia;
import enums.TipoApero;
import exceptions.AñoInvalidoExceptions;
import utils.UtilsDB;

/**
 * Clase que instancia un apero es la herramienta con la que los tractores
 * trabajan para realizar las actividades
 * 
 * @author Juanmi
 *
 */
public class Apero extends Maquinaria {
	/** El tipo de apero que puede ser arrastrado o suspendido **/
	private TipoApero tipo;

	/**
	 * Constructor de apero que inserta apero en la base de datos
	 * 
	 * @param marca          recibido por el super hace referencia a la marca del
	 *                       apero
	 * @param modelo         recibido por el super hace referencia al modelo del
	 *                       apero
	 * @param añoAdquisicion recibido por el super hace referencia al año en el que
	 *                       se compro el apero
	 * @param tipo           enum que puede elegir entre suspendido o arrastrado
	 * @param empresa        recibida por el super hace referencia a la empresa que
	 *                       pertence el apero
	 * @throws SQLException          error de la base de datos
	 * @throws AñoInvalidoExceptions error creado para que el año de adquisicion no
	 *                               pueda ser inferior a 1920 ni superior a 2022
	 *                               (año actual)
	 */
	public Apero(String marca, String modelo, short añoAdquisicion, TipoApero tipo, Empresa empresa)
			throws SQLException, AñoInvalidoExceptions {
		super(marca, modelo, añoAdquisicion, empresa);
		if (!this.añoValido(añoAdquisicion)) {
			throw new AñoInvalidoExceptions("El  no puede ser inferior a 1920 ni superior a 2022");
		}
		
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into apero values('" + marca + "','" + modelo + "','" + añoAdquisicion
				+ "','" + tipo + "','" + empresa.getNombre() + "')") > 0) {
			this.setAñoAdquisicion(añoAdquisicion);
			this.setMarca(marca);
			this.setModelo(modelo);
			this.tipo = tipo;
		} else {
			UtilsDB.desconectarBD();
			throw new SQLException("No se ha podido insertar el usuario");
		}

		UtilsDB.desconectarBD();

	}

	/**
	 * Constructor privado vacido para poder trabajar con la funcion get todos
	 */
	private Apero() {

	}

	/**
	 * Getter del tipo de apero
	 * 
	 * @return devuelve el tipo de apero
	 */
	public TipoApero getTipo() {
		return tipo;
	}

	/**
	 * Setter del tipo de apero
	 * 
	 * @param tipo nuevo tiò de apero
	 */
	public void setTipo(TipoApero tipo) {
		this.tipo = tipo;
	}

	/**
	 * Funcion que crea un array list de apero en el que se inserta todos los apero
	 * de la empresa que estan en la base de datos
	 * @param empresa empresa a los que pertenece los aperos
	 * @return devuelve un array list de todos los aperos que pertencen a la empresa
	 */
	public static ArrayList<Apero> getTodos(Empresa empresa) {
		Statement smt = UtilsDB.conectarBD();
		ArrayList<Apero> ret = new ArrayList<Apero>();

		try {
			ResultSet cursor = smt.executeQuery("select * from Apero where nombreEmpresa='" + empresa.nombre + "'" );
			while (cursor.next()) {
				Apero actual = new Apero();

				actual.setMarca(cursor.getString("nombreApero"));
				actual.setModelo(cursor.getString("modeloApero"));
				actual.setAñoAdquisicion(cursor.getShort("añoAdquisicion"));
				actual.tipo = TipoApero.valueOf(cursor.getString("tipoapero"));
				ret.add(actual);
			}
		} catch (SQLException | AñoInvalidoExceptions e) {
			return null;
		}

		UtilsDB.desconectarBD();
		return ret;
	}

	/**
	 * Funcion que elimina de la base de datos y pone todo sus variables a null
	 * segun el marca del apero
	 * 
	 * @return el apero eliminado de la base de datos y en java todas sus variables
	 *         a null
	 */
	public boolean eliminar() {

		Statement smt = UtilsDB.conectarBD();
		boolean ret;
		try {
			ret = smt.executeUpdate("delete from Apero where nombreApero='" + this.getMarca() + "'") > 0;

			this.setMarca(null);
			;
			this.setModelo(null);
			this.setAñoAdquisicion((short) 0);
			this.empresa = null;
			this.tipo = null;

		} catch (SQLException | AñoInvalidoExceptions e) {
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}
}
