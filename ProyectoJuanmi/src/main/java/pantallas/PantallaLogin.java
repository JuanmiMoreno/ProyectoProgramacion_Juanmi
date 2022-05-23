package pantallas;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.FlowLayout;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

import clases.Usuario;
import exceptions.ContraseñaIncorrectaException;
import exceptions.UsuarioNoExisteException;
import exceptions.nombreInvalidoExceptions;

public class PantallaLogin extends JPanel {

	private Ventana ventana;
	private JPasswordField campoContraseña;
	private JTextField campoUsuario;

	public PantallaLogin(Ventana v) {
		setBackground(SystemColor.inactiveCaption);
		this.ventana = v;
		setLayout(null);

		campoContraseña = new JPasswordField();
		campoContraseña.setEchoChar('*');
		campoContraseña.setBackground(Color.LIGHT_GRAY);
		campoContraseña.setBounds(108, 226, 153, 28);
		add(campoContraseña);

		JLabel etiquetaContraseña = new JLabel("Contrase\u00F1a");
		etiquetaContraseña.setFont(new Font("Arial", Font.BOLD, 14));
		etiquetaContraseña.setForeground(new Color(240, 248, 255));
		etiquetaContraseña.setBounds(108, 195, 153, 35);
		add(etiquetaContraseña);

		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		campoUsuario.setToolTipText("Introducir Usuario\r\n");
		campoUsuario.setBounds(108, 167, 153, 28);
		add(campoUsuario);
		campoUsuario.setColumns(10);

		JLabel etiquetaUsuario = new JLabel("Usuario");
		etiquetaUsuario.setForeground(new Color(240, 248, 255));
		etiquetaUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		etiquetaUsuario.setBounds(108, 139, 153, 35);
		add(etiquetaUsuario);

		JButton botonIniciar = new JButton("Iniciar Sesion");
		botonIniciar.setFont(new Font("Arial", Font.PLAIN, 14));
		botonIniciar.setBounds(46, 281, 131, 23);
		add(botonIniciar);

		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantallas("registro");
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setBounds(246, 281, 110, 23);
		add(btnNewButton);

		JLabel lblNewLabel = new JLabel("O");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(202, 281, 20, 23);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Iniciar Sesion");
		lblNewLabel_1.setBackground(new Color(230, 230, 250));
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 66));
		lblNewLabel_1.setBounds(30, 30, 643, 76);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Agro Manager");
		lblNewLabel_2.setForeground(new Color(240, 248, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.ITALIC, 55));
		lblNewLabel_2.setBounds(170, 334, 380, 61);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Juanmi Moreno Rodriguez");
		lblNewLabel_3.setForeground(new Color(240, 248, 255));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(188, 406, 287, 34);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(new Color(46, 139, 87));
		lblNewLabel_4.setIcon(new ImageIcon(
				"C:\\Users\\34622\\Desktop\\CURSO21-22 CENEC\\ProyectoProgramacion_Juanmi\\ProyectoJuanmi\\iconos\\agricultura.png"));
		lblNewLabel_4.setBounds(-13, 0, 844, 517);
		add(lblNewLabel_4);

		botonIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = campoUsuario.getText();
					String contraseña = new String(campoContraseña.getPassword());

					ventana.usuarioLogado = new Usuario(nombre, contraseña);
					JOptionPane.showMessageDialog(ventana, "Bienvenido, "+ventana.usuarioLogado.getNombre(), "Login correcto", JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException | ContraseñaIncorrectaException | UsuarioNoExisteException
						| nombreInvalidoExceptions e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
				
			}
		});

	}
}
