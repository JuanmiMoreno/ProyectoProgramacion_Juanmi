package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.Provincia;
import enums.TipoApero;
import utils.UtilsDB;

public class Apero extends Maquinaria {
	private TipoApero tipo;

	public Apero(String marca, String modelo, short añoAdquisicion, TipoApero tipo, Empresa empresa) throws SQLException {
		super(marca, modelo, añoAdquisicion, empresa);
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into apero values('" + marca + "','" + modelo + "','" + añoAdquisicion
				+ "','" + tipo + "','"+empresa.getNombre()+ "')") > 0){
			this.tipo = tipo;
		} else {
			UtilsDB.desconectarBD();
			throw new SQLException("No se ha podido insertar el usuario");
		}

		UtilsDB.desconectarBD();

	}

	public Apero() {
		
	}
	
	public TipoApero getTipo() {
		return tipo;
	}

	public void setTipo(TipoApero tipo) {
		this.tipo = tipo;
	}

	public  static ArrayList<Apero> getTodos()  {
		Statement smt = UtilsDB.conectarBD();
		ArrayList<Apero> ret = new ArrayList<Apero>();

		try {
			ResultSet cursor = smt.executeQuery("select * from Apero  ");
			while (cursor.next()) {
				Apero actual = new Apero();

				actual.setMarca(cursor.getString("nombreApero")); 
				actual.setModelo(cursor.getString("modeloApero"));
				actual.setAñoAdquisicion(cursor.getShort("añoAdquisicion"));
				actual.tipo = TipoApero.valueOf(cursor.getString("tipoapero"));
				ret.add(actual);
			}
		} catch (SQLException e) {
			return null;
		}
		
		UtilsDB.desconectarBD();
		return ret;
	}
	
	public boolean eliminar() {

		Statement smt = UtilsDB.conectarBD();
		boolean ret;
		try {
			ret = smt.executeUpdate("delete from Apero where nombreApero='" + this.getMarca() + "'") > 0;
			
			this.setMarca(null);;
			this.setModelo(null);
			this.setAñoAdquisicion((short) 0);
			this.empresa= null;
			this.tipo = null;
			
			
		} catch (SQLException e) {
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}
}
