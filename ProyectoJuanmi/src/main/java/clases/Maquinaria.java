package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import exceptions.A�oInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;
import utils.UtilsDB;

public abstract class Maquinaria {
	private String marca;
	private String modelo;
	private short a�oAdquisicion;
	protected static Empresa empresa;
	
	
	public Maquinaria(String marca, String modelo, short a�oAdquisicion, Empresa empresa) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.a�oAdquisicion = a�oAdquisicion;
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

	public short getA�oAdquisicion() {
		return a�oAdquisicion;
	}

	public void setA�oAdquisicion(short a�oAdquisicion) throws A�oInvalidoExceptions {
		if(!this.a�oValido(a�oAdquisicion)) {
			throw new A�oInvalidoExceptions("El  no puede ser inferior a 1920 ni superior a 2022");
		}
		
		this.a�oAdquisicion = a�oAdquisicion;
	}
	
	private boolean a�oValido( short a�o) {
		return a�o> 1920 && a�o< 2022;
	}

	
}
