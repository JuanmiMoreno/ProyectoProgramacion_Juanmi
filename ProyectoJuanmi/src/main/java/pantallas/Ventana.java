package pantallas;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Actividad;
import clases.Empresa;
import clases.Usuario;

public class Ventana extends JFrame{
	private JPanel pantallaActual;
	public Usuario usuarioLogado;
	public Empresa empresaLogada;
	public Actividad actividadLogada;
	
	public Ventana() {

		this.setSize(700,500);  //TAMA�O VENTANA
		this.setLocationRelativeTo(null); //PONE EN LA MITAD DE LA PANTALLA
		
		this.setIconImage(new ImageIcon("./imagenes/logo.png").getImage());
		this.setTitle("Agro Manager");
		//LA VENTANA SE PONER POR ENCIMA Y NO ME PUEDE MOVER
			//this.setAlwaysOnTop(true);
			//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			//this.setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //CUANDO CIERRA VENTANA SE APAGA EL PROGRAMA
		this.pantallaActual  = new PantallaInicioPrograma(this);
		this.setContentPane(pantallaActual);
		this.setResizable(false);
		this.setVisible(true);
	
	}
	
	public void cambiarPantallas(String nombrePantalla) {
		this.pantallaActual.setVisible(false);
		this.pantallaActual = null;
		switch(nombrePantalla) {
		
			case "principal":
				this.pantallaActual = new PantallaPrincipal(this);
				break;
			
			case "login":
				this.pantallaActual = new PantallaLogin(this);
				break;
				
			case"registro":
				this.pantallaActual = new PantallaRegistro(this);
				break;
				
			case "empresa":
				this.pantallaActual = new PantallaEmpresa(this);
				break;
				
			case "actividad":
				this.pantallaActual = new PantallaActividad(this);
				break;
				
			case "campos":
				this.pantallaActual = new PantallaCampo(this);
				break;
				
			case "personal":
				this.pantallaActual = new PantallaTrabajador(this);
				break;
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
		}
}
