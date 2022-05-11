package superClases;

public abstract class EntidadConUbicacion extends EntidadConNombre {
	
	private String provincia;

	public EntidadConUbicacion(String nombre, String provincia) {
		super(nombre);
		this.provincia = provincia;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	

}
