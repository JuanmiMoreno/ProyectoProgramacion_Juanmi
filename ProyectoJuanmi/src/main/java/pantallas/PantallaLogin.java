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
import java.awt.Color;
import javax.swing.SwingConstants;



public class PantallaLogin extends JPanel {

	private Ventana ventana;
	private JPasswordField passwordField;
	private JTextField campoUsuario;
	
	
	public PantallaLogin (Ventana v) {
		setBackground(SystemColor.inactiveCaption);
		this.ventana=v;
		setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(108, 255, 153, 28);
		add(passwordField);
		
		JLabel etiquetaContraseña = new JLabel("Contrase\u00F1a");
		etiquetaContraseña.setFont(new Font("Arial", Font.BOLD, 14));
		etiquetaContraseña.setForeground(Color.GREEN);
		etiquetaContraseña.setBounds(108, 224, 153, 35);
		add(etiquetaContraseña);
		
		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		campoUsuario.setToolTipText("Introducir Usuario\r\n");
		campoUsuario.setBounds(108, 185, 153, 28);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		JLabel etiquetaUsuario = new JLabel("Usuario");
		etiquetaUsuario.setForeground(Color.GREEN);
		etiquetaUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		etiquetaUsuario.setBounds(108, 156, 153, 35);
		add(etiquetaUsuario);
		
		JButton botonIniciar = new JButton("Iniciar Sesion");
		botonIniciar.setFont(new Font("Arial", Font.PLAIN, 14));
		botonIniciar.setBounds(46, 324, 131, 23);
		add(botonIniciar);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setBounds(246, 324, 110, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("O");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(202, 324, 20, 23);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Iniciar Sesion");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 66));
		lblNewLabel_1.setBounds(10, 31, 643, 76);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Agro Manager");
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setFont(new Font("Arial", Font.ITALIC, 55));
		lblNewLabel_2.setBounds(165, 400, 380, 61);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Juanmi Moreno Rodriguez");
		lblNewLabel_3.setForeground(new Color(0, 128, 0));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(187, 472, 287, 34);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\34622\\Desktop\\CURSO21-22 CENEC\\ProyectoProgramacion_Juanmi\\ProyectoJuanmi\\iconos\\agricultura.png"));
		lblNewLabel_4.setBounds(-14, 0, 850, 562);
		add(lblNewLabel_4);
		

	}
}




