package pantallas;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Usuario;

public class Ventana extends JFrame{
	private HashMap<String, JPanel> pantallas;
	public Usuario usuarioLogado;
	
	public Ventana() {
		pantallas = new HashMap<String,JPanel>();
		pantallas.put("pantallaInicio", new PantallaInicioPrograma (this));
		pantallas.put("login",new PantallaLogin(this));
		pantallas.put("registro", new PantallaRegistro(this));
		pantallas.put("empresa", new PantallaEmpresa(this));
		
		
		this.setSize(700,500);  //TAMAÑO VENTANA
		this.setLocationRelativeTo(null); //PONE EN LA MITAD DE LA PANTALLA
		
		this.setIconImage(new ImageIcon("./iconos/logo.png").getImage());
		this.setTitle("Agro Manager");
		//LA VENTANA SE PONER POR ENCIMA Y NO ME PUEDE MOVER
			//this.setAlwaysOnTop(true);
			//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			//this.setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //CUANDO CIERRA VENTANA SE APAGA EL PROGRAMA
		//this.setContentPane(new PantallaLogin(this));
		this.setContentPane(this.pantallas.get("pantallaInicio"));
		
		
		this.setResizable(false);
		this.setVisible(true);
	
	}
	
	public void cambiarPantallas(String nombrePantalla) {
		Iterator it = this.pantallas.values().iterator();
		while(it.hasNext()) {
			JPanel actual = (JPanel)it.next();
			actual.setVisible(false);
		}
		this.pantallas.get(nombrePantalla).setVisible(true);
		this.setContentPane(this.pantallas.get(nombrePantalla));
	}
}
