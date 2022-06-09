package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exceptions.A�oInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;
import utils.UtilsDB;

public class Tractor extends Maquinaria {

	public Tractor(String marca, String modelo, short a�oAdquisicion, Empresa empresa) throws SQLException, A�oInvalidoExceptions {
		super(marca, modelo, a�oAdquisicion,empresa );
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate(
				"insert into tractor values('" + marca + "','" + modelo + "','" + a�oAdquisicion + "','"+empresa.getNombre()+ "')") > 0) {
			this.setMarca(marca);
			this.setModelo(modelo);
			this.setA�oAdquisicion(a�oAdquisicion);
		} else {
			UtilsDB.desconectarBD();
			throw new SQLException("No se ha podido insertar el tractor");
		}

		UtilsDB.desconectarBD();
	}

	public Tractor() {
		
	}
	
	public  static ArrayList<Tractor> getTodos()  {
		Statement smt = UtilsDB.conectarBD();
		ArrayList<Tractor> ret = new ArrayList<Tractor>();

		try {
			ResultSet cursor = smt.executeQuery("select * from Tractor ");
			while (cursor.next()) {
				Tractor actual = new Tractor();

				actual.setMarca(cursor.getString("marcaTractor")); 
				actual.setModelo(cursor.getString("modeloTractor"));
				actual.setA�oAdquisicion(cursor.getShort("a�oAdquisicion"));
				ret.add(actual);
			}
		} catch (SQLException | A�oInvalidoExceptions e) {
			return null;
		}
		
		UtilsDB.desconectarBD();
		return ret;
	}
	
	public boolean eliminar() {

		Statement smt = UtilsDB.conectarBD();
		boolean ret;
		try {
			ret = smt.executeUpdate("delete from tractor where modeloTractor='" + this.getModelo() + "'") > 0;
			
			this.getMarca();
			this.setModelo(null);
			this.setA�oAdquisicion((short) 0);
			
			
		} catch (SQLException | A�oInvalidoExceptions e) {
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}
	
	
}

