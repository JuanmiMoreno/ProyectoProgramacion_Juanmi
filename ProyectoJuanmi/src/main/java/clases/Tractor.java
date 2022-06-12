package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exceptions.A�oInvalidoExceptions;
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
	 * @param a�oAdquisicion recibido por el super, es el a�o en el que se compro el
	 *                       tractor
	 * @param empresa        recibida por el super, es la empresa a la que pertence
	 *                       el tractro
	 * @throws SQLException          error de base de datos salta cuando hay un
	 *                               error de base de datos
	 * @throws A�oInvalidoExceptions error de a�o invalido, salta cuando el a�o en
	 *                               el que se compro es inferior a 1920 y superior
	 *                               a 2022
	 * @throws MarcaInvalidoExceptions error que sata cuando la marca del tractro contiene numeros
	 */
	public Tractor(String marca, String modelo, short a�oAdquisicion, Empresa empresa)
			throws SQLException, A�oInvalidoExceptions, MarcaInvalidoExceptions {
		super(marca, modelo, a�oAdquisicion, empresa);
		if (!this.a�oValido(a�oAdquisicion)) {
			throw new A�oInvalidoExceptions("El  no puede ser inferior a 1920 ni superior a 2022");
		}
		if(!this.marcaValida(marca)) {
			throw new MarcaInvalidoExceptions("La marca no puede contener numeros");
		}

		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into tractor values('" + marca + "','" + modelo + "','" + a�oAdquisicion
				+ "','" + empresa.getNombre() + "')") > 0) {
			this.setMarca(marca);
			this.setModelo(modelo);
			this.setA�oAdquisicion(a�oAdquisicion);
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
				actual.setA�oAdquisicion(cursor.getShort("a�oAdquisicion"));
				ret.add(actual);
			}
		} catch (SQLException | A�oInvalidoExceptions | MarcaInvalidoExceptions e) {
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
			this.setA�oAdquisicion((short) 0);

		} catch (SQLException | A�oInvalidoExceptions | MarcaInvalidoExceptions e) {
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}

}
