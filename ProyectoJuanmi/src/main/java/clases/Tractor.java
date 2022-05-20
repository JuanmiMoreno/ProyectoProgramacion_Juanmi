package clases;

import java.sql.SQLException;
import java.sql.Statement;

import utils.UtilsDB;

public class Tractor extends Maquinaria {

	public Tractor(String marca, String modelo, short añoAdquisicion) throws SQLException {
		super(marca, modelo, añoAdquisicion);
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate(
				"insert into tractor values('" + marca + "','" + modelo + "','" + añoAdquisicion + "')") > 0) {
			this.setMarca(marca);
			this.setModelo(modelo);
			this.setAñoAdquisicion(añoAdquisicion);
		} else {
			UtilsDB.desconectarBD();
			throw new SQLException("No se ha podido insertar el usuario");
		}

		UtilsDB.desconectarBD();
	}

}

