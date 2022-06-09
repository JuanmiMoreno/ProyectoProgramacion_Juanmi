package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exceptions.AñoInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;
import utils.UtilsDB;

public class Tractor extends Maquinaria {

	public Tractor(String marca, String modelo, short añoAdquisicion, Empresa empresa) throws SQLException, AñoInvalidoExceptions {
		super(marca, modelo, añoAdquisicion,empresa );
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate(
				"insert into tractor values('" + marca + "','" + modelo + "','" + añoAdquisicion + "','"+empresa.getNombre()+ "')") > 0) {
			this.setMarca(marca);
			this.setModelo(modelo);
			this.setAñoAdquisicion(añoAdquisicion);
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
				actual.setAñoAdquisicion(cursor.getShort("añoAdquisicion"));
				ret.add(actual);
			}
		} catch (SQLException | AñoInvalidoExceptions e) {
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
			this.setAñoAdquisicion((short) 0);
			
			
		} catch (SQLException | AñoInvalidoExceptions e) {
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}
	
	
}

