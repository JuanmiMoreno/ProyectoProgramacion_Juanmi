package clases;

import java.sql.SQLException;
import java.sql.Statement;

import enums.TipoApero;
import utils.UtilsDB;

public class Apero extends Maquinaria {
	private TipoApero tipo;

	public Apero(String marca, String modelo, short añoAdquisicion, TipoApero tipo) throws SQLException {
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

	public TipoApero getTipo() {
		return tipo;
	}

	public void setTipo(TipoApero tipo) {
		this.tipo = tipo;
	}

}
