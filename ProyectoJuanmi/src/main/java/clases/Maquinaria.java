package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import exceptions.A�oInvalidoExceptions;
import exceptions.MarcaInvalidoExceptions;
import exceptions.NombreInvalidoExceptions;
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
	/** a�o en el que se ha comprado la maquinaria **/
	private short a�oAdquisicion;
	/** empresa a la que pertenece la maquinaria **/
	protected Empresa empresa;

	/**
	 * Constructor que crea una maquinaria pero nunca se va a usar solo sirve de
	 * herencia para tractor y apero
	 * 
	 * @param marca          es la marca de la herramienta
	 * @param modelo         es el modelo de la herramienta
	 * @param a�oAdquisicion es el a�o en el que se compro la herramienta
	 * @param empresa        empresa a la que pertenece la maquinaria
	 * @throws A�oInvalidoExceptions
	 */
	public Maquinaria(String marca, String modelo, short a�oAdquisicion, Empresa empresa) throws A�oInvalidoExceptions {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.setA�oAdquisicion(a�oAdquisicion);
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
	 * @throws MarcaInvalidoExceptions error que salta cuando la marca de las
	 *                                 maquinarias contienen nombre
	 */
	public void setMarca(String marca) throws MarcaInvalidoExceptions {
		if (!this.marcaValida(marca)) {
			throw new MarcaInvalidoExceptions(
					"TRACTOR : La marca no puede contener numeros\nAPEROS: El apero que es no puede contener numero");
		}

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
	 * Getter a�o adquisicion de la maquinaria es decir el a�o que se compro
	 * 
	 * @return devuelve el a�o en el que se compro
	 */
	public short getA�oAdquisicion() {
		return a�oAdquisicion;
	}

	/**
	 * Setter del a�o en el que se compro la maquinaria
	 * 
	 * @param a�oAdquisicion nuevo a�o en el que se compro
	 * @throws A�oInvalidoExceptions error de a�o invalido que salta cuando el a�o
	 *                               es inferior a 1920 o superiror a 2022
	 */
	public void setA�oAdquisicion(short a�oAdquisicion) throws A�oInvalidoExceptions {
		if (!this.a�oValido(a�oAdquisicion)) {
			throw new A�oInvalidoExceptions("El  no puede ser inferior a 1920 ni superior a 2022");
		}

		this.a�oAdquisicion = a�oAdquisicion;
	}

	/**
	 * Funcion protected que comprueba la validez de a�o de adquisicion
	 * 
	 * @param a�o nuevo a�o
	 * @return devuelve true si el a�o esta entre 1920 y 2022 y sino devuelve false
	 */
	protected boolean a�oValido(short a�o) {
		return a�o > 1920 && a�o <= 2022;
	}

	/**
	 * Funcion protecte que compruba que la marca de las herramientas no tengan
	 * numeros
	 * 
	 * @param marca
	 * @return
	 */
	protected boolean marcaValida(String marca) {
		return !marca.contains("0") && !marca.contains("1") && !marca.contains("2") && !marca.contains("3")
				&& !marca.contains("4") && !marca.contains("5") && !marca.contains("6") && !marca.contains("7")
				&& !marca.contains("8") && !marca.contains("9");
	}

}
