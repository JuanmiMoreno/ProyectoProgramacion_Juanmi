package clases;

import java.sql.SQLException;

import enums.tipoPlantacion;
import exceptions.nombreInvalidoExceptions;
import superClases.EntidadConUbicacion;

public class Campo extends EntidadConUbicacion {
	private float superficie;
	private tipoPlantacion plantacion;
	
	
	public Campo(String nombre, String provincia, float superficie, tipoPlantacion plantacion) throws nombreInvalidoExceptions, SQLException {
		super(nombre, provincia);
		this.superficie = superficie;
		this.plantacion = plantacion;
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
	
	
	
	

	
}
