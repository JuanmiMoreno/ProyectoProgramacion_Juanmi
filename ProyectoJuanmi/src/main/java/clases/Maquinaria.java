package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import exceptions.AñoInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;
import utils.UtilsDB;

public abstract class Maquinaria {
	private String marca;
	private String modelo;
	private short añoAdquisicion;
	protected static Empresa empresa;
	
	
	public Maquinaria(String marca, String modelo, short añoAdquisicion, Empresa empresa) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.añoAdquisicion = añoAdquisicion;
		this.empresa = empresa;
		
	}

	public Maquinaria() {
		
	} 
	
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public short getAñoAdquisicion() {
		return añoAdquisicion;
	}

	public void setAñoAdquisicion(short añoAdquisicion) throws AñoInvalidoExceptions {
		if(!this.añoValido(añoAdquisicion)) {
			throw new AñoInvalidoExceptions("El  no puede ser inferior a 1920 ni superior a 2022");
		}
		
		this.añoAdquisicion = añoAdquisicion;
	}
	
	private boolean añoValido( short año) {
		return año> 1920 && año< 2022;
	}

	
}
