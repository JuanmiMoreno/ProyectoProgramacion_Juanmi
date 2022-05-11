package clases;

public abstract class Maquinaria {
	private String marca;
	private String modelo;
	private short a�oAdquisicion;
	
	
	public Maquinaria(String marca, String modelo, short a�oAdquisicion) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.a�oAdquisicion = a�oAdquisicion;
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

	public void setA�oAdquisicion(short a�oAdquisicion) {
		this.a�oAdquisicion = a�oAdquisicion;
	}
	
	
	
	
}
