package clases;

public abstract class Maquinaria {
	private String marca;
	private String modelo;
	private short añoAdquisicion;
	
	
	public Maquinaria(String marca, String modelo, short añoAdquisicion) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.añoAdquisicion = añoAdquisicion;
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

	public void setAñoAdquisicion(short añoAdquisicion) {
		this.añoAdquisicion = añoAdquisicion;
	}
	
	
	
	
}
