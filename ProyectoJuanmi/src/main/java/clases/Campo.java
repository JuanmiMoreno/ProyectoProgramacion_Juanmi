package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.Provincia;
import enums.tipoPlantacion;
import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConUbicacion;
import utils.UtilsDB;

public class Campo extends EntidadConUbicacion {
	private float superficie;
	private tipoPlantacion plantacion;
	private Empresa empresa;
	
	
	public Campo(String nombre, Provincia provincia, float superficie, tipoPlantacion plantacion, Empresa empresa)
			throws nombreInvalidoExceptions, SQLException {
		super(nombre, provincia);
		
		Statement queryInsertar = UtilsDB.conectarBD();
		if (queryInsertar.executeUpdate("insert into campo values('" + this.getNombre() + "','" + provincia+ "'," + superficie+ ",'" + plantacion
        + "','"+empresa.getNombre()+ "')") > 0){
			
			this.superficie = superficie;
			this.plantacion = plantacion;
			this.empresa = empresa;
		} else {
			UtilsDB.desconectarBD();
				throw new SQLException("No se ha podido insertar el campo");
		}

		UtilsDB.desconectarBD();

	}
		
	


	public Campo() {
	
	}




	public float getSuperficie() {
		return superficie;
	}


	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}


	public tipoPlantacion getPlantacion() {
		return plantacion;
	}


	public void setPlantacion(tipoPlantacion plantacion) {
		this.plantacion = plantacion;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public  static ArrayList<Campo> getTodos() {
		Statement smt = UtilsDB.conectarBD();
		ArrayList<Campo> ret = new ArrayList<Campo>();

		try {
			ResultSet cursor = smt.executeQuery("select * from campo ");
			while (cursor.next()) {
				Campo actual = new Campo();

				actual.nombre = cursor.getString("nombreCampo");
				actual.plantacion = tipoPlantacion.valueOf("plantacion");
				actual.superficie = cursor.getFloat("superficie");
				actual.provincia = Provincia.valueOf("provincia");
				ret.add(actual);
			}
		} catch (SQLException e) {
			
			e.getMessage();
			return null;
		}
		
		UtilsDB.desconectarBD();
		return ret;
	}
	
	

	
	
	
	

	
}
