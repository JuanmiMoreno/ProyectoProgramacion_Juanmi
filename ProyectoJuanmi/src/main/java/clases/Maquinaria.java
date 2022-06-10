package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import exceptions.AñoInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;
import utils.UtilsDB;

/**
 * Clase abastracta de la que extiende tractor y apero
 * 
 * @author Juanmi
 *
 */
public abstract class Maquinaria {
	/** marca de la maquinaria **/
	private String marca;
	/** modelo de la maquinaria **/
	private String modelo;
	/** año en el que se ha comprado la maquinaria **/
	private short añoAdquisicion;
	/** empresa a la que pertenece la maquinaria **/
	protected Empresa empresa;

	/**
	 * Constructor que crea una maquinaria pero nunca se va a usar solo sirve de
	 * herencia para tractor y apero
	 * 
	 * @param marca          es la marca de la herramienta
	 * @param modelo         es el modelo de la herramienta
	 * @param añoAdquisicion es el año en el que se compro la herramienta
	 * @param empresa        empresa a la que pertenece la maquinaria
	 * @throws AñoInvalidoExceptions
	 */
	public Maquinaria(String marca, String modelo, short añoAdquisicion, Empresa empresa) throws AñoInvalidoExceptions {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.setAñoAdquisicion(añoAdquisicion);
		this.empresa = empresa;

	}

	/**
	 * Constructor protected vacio que utilizamos para poder trabajar con el metodo
	 * get todos
	 */
	protected Maquinaria() {

	}

	/**
	 * Getter de la empresa que contiene todas las herramientas
	 * 
	 * @return devuelve la empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * Setter de la empresa que contiene todas las herramientas
	 * 
	 * @param empresa nueva empresa
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * Getter de la marca de la maquinaria
	 * 
	 * @return devuelve la marca de la maquinaria
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Setter de la marca de la maquinaria
	 * 
	 * @param marca nueva marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Getter de modelo de la maquinaria
	 * 
	 * @return el modelo de la maquinaria
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Setter del modelo de la maquinaria
	 * 
	 * @param modelo neuvo modelo de la maquinaria
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Getter año adquisicion de la maquinaria es decir el año que se compro
	 * 
	 * @return devuelve el año en el que se compro
	 */
	public short getAñoAdquisicion() {
		return añoAdquisicion;
	}

	/**
	 * Setter del año en el que se compro la maquinaria
	 * 
	 * @param añoAdquisicion nuevo año en el que se compro
	 * @throws AñoInvalidoExceptions error de año invalido que salta cuando el año
	 *                               es inferior a 1920 o superiror a 2022
	 */
	public void setAñoAdquisicion(short añoAdquisicion) throws AñoInvalidoExceptions {
		if (!this.añoValido(añoAdquisicion)) {
			throw new AñoInvalidoExceptions("El  no puede ser inferior a 1920 ni superior a 2022");
		}

		this.añoAdquisicion = añoAdquisicion;
	}

	/**
	 * Funcion privada que comprueba la validez de año de adquisicion
	 * 
	 * @param año nuevo año
	 * @return devuelve true si el año esta entre 1920 y 2022 y sino devuelve false
	 */
	private boolean añoValido(short año) {
		return año > 1920 && año <= 2022;
	}

}
