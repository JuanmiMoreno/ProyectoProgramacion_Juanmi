package pantallas;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Actividad;
import clases.Empresa;
import clases.Usuario;
import exceptions.Contrase�aVaciaExceptions;
import exceptions.nombreInvalidoExceptions;

public class Ventana extends JFrame{
	private JPanel pantallaActual;
	public Usuario usuarioLogado;
	public Empresa empresaLogada;
	public Actividad actividadLogada;
	
	public Ventana(String usuario, String contrase�a) throws SQLException, Contrase�aVaciaExceptions, nombreInvalidoExceptions {
		
		
		
	
		
		this.setSize(700,500);  
		this.setLocationRelativeTo(null); 
		
		this.setIconImage(new ImageIcon("./imagenes/logo.png").getImage());
		this.setTitle("Agro Manager");

		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
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
