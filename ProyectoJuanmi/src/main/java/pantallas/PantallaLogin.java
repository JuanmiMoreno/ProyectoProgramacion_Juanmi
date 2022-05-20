package pantallas;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;


import java.awt.FlowLayout;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;



public class PantallaLogin extends JPanel {

	private Ventana ventana;
	
	
	public PantallaLogin (Ventana v) {
		setBackground(SystemColor.inactiveCaption);
		this.ventana=v;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\34622\\Desktop\\CURSO21-22 CENEC\\ProyectoProgramacion_Juanmi\\ProyectoJuanmi\\iconos\\agricultura.png"));
		lblNewLabel.setBounds(-48, 126, 981, 641);
		add(lblNewLabel);
		

	}
}




