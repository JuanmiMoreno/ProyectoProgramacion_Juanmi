package pantallas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	public Ventana() {
	this.setSize(800,600);  //TAMAÑO VENTANA
	this.setLocationRelativeTo(null); //PONE EN LA MITAD DE LA PANTALLA
	
	this.setIconImage(new ImageIcon("./iconos/icono.jpg").getImage());
	this.setTitle("Agro Manager Proyecto");
	//LA VENTANA SE PONER POR ENCIMA Y NO ME PUEDE MOVER
		//this.setAlwaysOnTop(true);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setUndecorated(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE); //CUANDO CIERRA VENTANA SE APAGA EL PROGRAMA
	this.setContentPane(new PantallaLogin(this));
	
	
	
	this.setResizable(false);
	this.setVisible(true);
	
	

}

}
