package clases;

import java.sql.SQLException;
import java.sql.Statement;

import utils.UtilsDB;

public class Tractor extends Maquinaria {

	public Tractor(String marca, String modelo, short a�oAdquisicion) throws SQLException {
		super(marca, modelo, a�oAdquisicion);
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate(
				"insert into tractor values('" + marca + "','" + modelo + "','" + a�oAdquisicion + "')") > 0) {
			this.setMarca(marca);
			this.setModelo(modelo);
			this.setA�oAdquisicion(a�oAdquisicion);
		} else {
			UtilsDB.desconectarBD();
			throw new SQLException("No se ha podido insertar el usuario");
		}

		UtilsDB.desconectarBD();
	}

}

