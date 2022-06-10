package pantallas;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import enums.Provincia;
import exceptions.ContraseñaVaciaExceptions;
import exceptions.emailInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;

import javax.swing.SwingConstants;

import clases.Usuario;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;

/**
 * Clase que extiende de JPanel es la pantalla de registro donde al principio
 * del programa cada usuario nuevo debe de registrarse
 * 
 * @author Juanmi
 *
 */
public class PantallaRegistro extends JPanel {
	/** ventana sobre la que aparece la pantalla **/
	private Ventana ventana;
	/** nombre del usuario **/
	private JTextField campoUsuario;
	/** contraseña del usuario **/
	private JPasswordField campoContraseña;
	/** email del usuario **/
	private JTextField campoEmail;

	/**
	 * Construnctor que crea pantalla de registro contiene la etiqueta con todos los
	 * atributos de ususario para poder registrarse y los campos donde se recoge la
	 * informacion. Tambien contiene todas las propiedades de dicha pantalla
	 * 
	 * @param v es la ventana en la que aparece la pantalla
	 */
	public PantallaRegistro(Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 107, 146, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 19, 0, 0, 0, 0, 0, 0, 0, 0, 39, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		JLabel etiquetaRegistro = new JLabel("Registro");
		etiquetaRegistro.setForeground(SystemColor.desktop);
		etiquetaRegistro.setBackground(SystemColor.inactiveCaptionBorder);
		etiquetaRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaRegistro.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 54));
		GridBagConstraints gbc_etiquetaRegistro = new GridBagConstraints();
		gbc_etiquetaRegistro.gridwidth = 5;
		gbc_etiquetaRegistro.insets = new Insets(0, 0, 5, 0);
		gbc_etiquetaRegistro.gridx = 0;
		gbc_etiquetaRegistro.gridy = 1;
		add(etiquetaRegistro, gbc_etiquetaRegistro);

		JLabel etiquetaUsuario = new JLabel("Usuario");
		etiquetaUsuario.setFont(new Font("Arial", Font.BOLD, 15));
		etiquetaUsuario.setForeground(SystemColor.desktop);
		etiquetaUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_etiquetaUsuario = new GridBagConstraints();
		gbc_etiquetaUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaUsuario.gridx = 1;
		gbc_etiquetaUsuario.gridy = 2;
		add(etiquetaUsuario, gbc_etiquetaUsuario);

		campoUsuario = new JTextField();
		campoUsuario.setToolTipText("Introducir nombre usuario");
		GridBagConstraints gbc_campoUsuario = new GridBagConstraints();
		gbc_campoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_campoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoUsuario.gridx = 2;
		gbc_campoUsuario.gridy = 2;
		add(campoUsuario, gbc_campoUsuario);
		campoUsuario.setColumns(10);

		JLabel etiquetaContraseña = new JLabel("Contrase\u00F1a");
		etiquetaContraseña.setFont(new Font("Arial", Font.BOLD, 15));
		etiquetaContraseña.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_etiquetaContraseña = new GridBagConstraints();
		gbc_etiquetaContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaContraseña.gridx = 1;
		gbc_etiquetaContraseña.gridy = 3;
		add(etiquetaContraseña, gbc_etiquetaContraseña);

		campoContraseña = new JPasswordField();
		campoContraseña.setToolTipText("introducir contraseña");
		campoContraseña.setEchoChar('$');
		GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
		gbc_campoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_campoContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoContraseña.gridx = 2;
		gbc_campoContraseña.gridy = 3;
		add(campoContraseña, gbc_campoContraseña);

		JLabel etiquetaEmail = new JLabel("Email");
		etiquetaEmail.setFont(new Font("Arial", Font.BOLD, 15));
		etiquetaEmail.setForeground(SystemColor.desktop);
		GridBagConstraints gbc_etiquetaEmail = new GridBagConstraints();
		gbc_etiquetaEmail.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaEmail.gridx = 1;
		gbc_etiquetaEmail.gridy = 4;
		add(etiquetaEmail, gbc_etiquetaEmail);

		campoEmail = new JTextField();
		campoEmail.setToolTipText("Introducir email");
		GridBagConstraints gbc_campoEmail = new GridBagConstraints();
		gbc_campoEmail.insets = new Insets(0, 0, 5, 5);
		gbc_campoEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoEmail.gridx = 2;
		gbc_campoEmail.gridy = 4;
		add(campoEmail, gbc_campoEmail);
		campoEmail.setColumns(10);

		JLabel etiquetaProvincia = new JLabel("Provincia");
		etiquetaProvincia.setFont(new Font("Arial", Font.BOLD, 15));
		etiquetaProvincia.setForeground(SystemColor.desktop);
		GridBagConstraints gbc_etiquetaProvincia = new GridBagConstraints();
		gbc_etiquetaProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaProvincia.gridx = 1;
		gbc_etiquetaProvincia.gridy = 5;
		add(etiquetaProvincia, gbc_etiquetaProvincia);

		final JComboBox selectorProvincia = new JComboBox();
		selectorProvincia.setModel(new DefaultComboBoxModel(Provincia.values()));
		GridBagConstraints gbc_selectorProvincia = new GridBagConstraints();
		gbc_selectorProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_selectorProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectorProvincia.gridx = 2;
		gbc_selectorProvincia.gridy = 5;
		add(selectorProvincia, gbc_selectorProvincia);

		JButton botonRegistrarse = new JButton("Registrarse");

		GridBagConstraints gbc_botonRegistrarse = new GridBagConstraints();
		gbc_botonRegistrarse.anchor = GridBagConstraints.SOUTH;
		gbc_botonRegistrarse.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistrarse.gridx = 2;
		gbc_botonRegistrarse.gridy = 7;
		add(botonRegistrarse, gbc_botonRegistrarse);

		JButton botonSalir = new JButton("Volver");
		botonSalir.setHorizontalAlignment(SwingConstants.LEFT);
		botonSalir.setVerticalAlignment(SwingConstants.TOP);

		GridBagConstraints gbc_botonSalir = new GridBagConstraints();
		gbc_botonSalir.anchor = GridBagConstraints.NORTHEAST;
		gbc_botonSalir.insets = new Insets(0, 0, 0, 5);
		gbc_botonSalir.gridx = 3;
		gbc_botonSalir.gridy = 9;
		add(botonSalir, gbc_botonSalir);

		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar en el boton salir va hacia la pantalla login
			 * 
			 * @param e evento clicar
			 */
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantallas("login");

			}
		});

		botonRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar en el boton de registrarse recoge toda la informacion
			 * de todos los campos e intenta crear un nuevo usuario. Sino puede crearlo
			 * saltan varios errores y si lo crea cambia a la pantalla login
			 * 
			 * @param e evento de clicar
			 */
			public void mouseClicked(MouseEvent e) {
				try {
					String email = campoEmail.getText();
					String nombre = campoUsuario.getText();
					String contraseña = new String(campoContraseña.getPassword());
					Provincia provincia = (Provincia) selectorProvincia.getSelectedItem();
					new Usuario(nombre, provincia, contraseña, email);
					JOptionPane.showMessageDialog(ventana, "Registrado con exito! ", "Registro completo",
							JOptionPane.PLAIN_MESSAGE);
					ventana.cambiarPantallas("login");
				} catch (SQLIntegrityConstraintViolationException e1) {
					JOptionPane.showMessageDialog(ventana, "Ese usuario ya esta registrado", "Error",
							JOptionPane.ERROR_MESSAGE);

				} catch (SQLException | ContraseñaVaciaExceptions | emailInvalidoExceptions
						| nombreInvalidoExceptions e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(".\\imagenes\\registro.png"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.gridheight = 10;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

	}
}