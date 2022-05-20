package clases;

import java.sql.SQLException;
import java.sql.Statement;

import enums.tipoApero;
import utils.UtilsDB;

public class Apero extends Maquinaria {
	private tipoApero tipo;

	public Apero(String marca, String modelo, short añoAdquisicion, tipoApero tipo) throws SQLException {
		super(marca, modelo, añoAdquisicion);
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into apero values('" + marca + "','" + modelo + "','" + añoAdquisicion
				+ "'," + tipo + "')") > 0) {
			this.tipo = tipo;
		} else {
			UtilsDB.desconectarBD();
			throw new SQLException("No se ha podido insertar el usuario");
		}

		UtilsDB.desconectarBD();

	}

	public tipoApero getTipo() {
		return tipo;
	}

	public void setTipo(tipoApero tipo) {
		this.tipo = tipo;
	}

}
