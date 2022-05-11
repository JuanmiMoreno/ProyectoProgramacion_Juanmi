package superClases;

public abstract class EntidadConDinero extends EntidadConNombre {
	private float dinero;

	public EntidadConDinero(String nombre, float dinero) {
		super(nombre);
		this.dinero = dinero;
	}


	
	public float getDinero() {
		return dinero;
	}

	public void setDinero(float dinero) {
		this.dinero = dinero;
	}
	
	
}
