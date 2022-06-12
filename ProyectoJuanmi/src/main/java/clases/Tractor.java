package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exceptions.AñoInvalidoExceptions;
import exceptions.MarcaInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;
import utils.UtilsDB;

/**
 * DAO que instancia un tractor que es una herramienta de hecho hereda de
 * herramientas no tiene variables internas En el se hace todo los movimientos
 * con la base de datos
 * 
 * @author Juanmi
 *
 */
public class Tractor extends Maquinaria {

	/**
	 * Constructor que crea un tractor y lo inserta en la base de datos
	 * 
	 * @param marca          recibido por el super, es la marca del tractor
	 * @param modelo         recibido por el super, es el modelo del tractor
	 * @param añoAdquisicion recibido por el super, es el año en el que se compro el
	 *                       tractor
	 * @param empresa        recibida por el super, es la empresa a la que pertence
	 *                       el tractro
	 * @throws SQLException          error de base de datos salta cuando hay un
	 *                               error de base de datos
	 * @throws AñoInvalidoExceptions error de año invalido, salta cuando el año en
	 *                               el que se compro es inferior a 1920 y superior
	 *                               a 2022
	 * @throws MarcaInvalidoExceptions error que sata cuando la marca del tractro contiene numeros
	 */
	public Tractor(String marca, String modelo, short añoAdquisicion, Empresa empresa)
			throws SQLException, AñoInvalidoExceptions, MarcaInvalidoExceptions {
		super(marca, modelo, añoAdquisicion, empresa);
		if (!this.añoValido(añoAdquisicion)) {
			throw new AñoInvalidoExceptions("El  no puede ser inferior a 1920 ni superior a 2022");
		}
		if(!this.marcaValida(marca)) {
			throw new MarcaInvalidoExceptions("La marca no puede contener numeros");
		}

		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into tractor values('" + marca + "','" + modelo + "','" + añoAdquisicion
				+ "','" + empresa.getNombre() + "')") > 0) {
			this.setMarca(marca);
			this.setModelo(modelo);
			this.setAñoAdquisicion(añoAdquisicion);
		} else {
			UtilsDB.desconectarBD();
			throw new SQLException("No se ha podido insertar el tractor");
		}

		UtilsDB.desconectarBD();
	}

	/**
	 * Constructor privado vacio que utlizamos para trabajar con el metodo get todos
	 */
	private Tractor() {

	}

	/**
	 * Funcion estatica que crea un array list de todos los tractores de una empresa
	 * 
	 * @return devuelve una arraylist con todos los tractores
	 */
	public static ArrayList<Tractor> getTodos(Empresa empresa) {
		Statement smt = UtilsDB.conectarBD();
		ArrayList<Tractor> ret = new ArrayList<Tractor>();

		try {
			ResultSet cursor = smt.executeQuery("select * from Tractor where nombreEmpresa='" + empresa.nombre + "'");
			while (cursor.next()) {
				Tractor actual = new Tractor();

				actual.setMarca(cursor.getString("marcaTractor"));
				actual.setModelo(cursor.getString("modeloTractor"));
				actual.setAñoAdquisicion(cursor.getShort("añoAdquisicion"));
				ret.add(actual);
			}
		} catch (SQLException | AñoInvalidoExceptions | MarcaInvalidoExceptions e) {
			return null;
		}

		UtilsDB.desconectarBD();
		return ret;
	}

	/**
	 * Funcion privada que sirve para eliminar un tractor segun su modelo
	 * 
	 * @param empresa empresa a los que pertenece los tractores
	 * 
	 * @return devuelve null todas las variables y lo borra de la base de datos
	 */
	public boolean eliminar() {

		Statement smt = UtilsDB.conectarBD();
		boolean ret;
		try {
			ret = smt.executeUpdate("delete from tractor where modeloTractor='" + this.getModelo() + "'") > 0;

			this.setMarca(null);
			this.setModelo(null);
			this.setAñoAdquisicion((short) 0);

		} catch (SQLException | AñoInvalidoExceptions | MarcaInvalidoExceptions e) {
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}

}
