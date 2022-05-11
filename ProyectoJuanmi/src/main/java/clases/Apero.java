package clases;

import enums.tipoApero;

public class Apero extends Maquinaria{
	private tipoApero tipo;

	public Apero(String marca, String modelo, short añoAdquisicion, tipoApero tipo) {
		super(marca, modelo, añoAdquisicion);
		this.tipo = tipo;
	}

	public tipoApero getTipo() {
		return tipo;
	}

	public void setTipo(tipoApero tipo) {
		this.tipo = tipo;
	}

	
	
	
	
	
}
