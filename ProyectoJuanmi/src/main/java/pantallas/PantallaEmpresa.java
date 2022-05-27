package pantallas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

import clases.Empresa;
import exceptions.EmpresaIncorrectaExceptions;
import exceptions.cifInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PantallaEmpresa extends JPanel {

	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoCif;
	private JTextField campoPresupuesto;
	private JTextField campoNombreEmpresa;

	public PantallaEmpresa(Ventana v) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 90, 130, 92, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 39, 0, 0, 0, 67, 56, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel etiquetaTitulo = new JLabel("Registra tu empresa");
		etiquetaTitulo.setForeground(Color.WHITE);
		etiquetaTitulo.setFont(new Font("Georgia", Font.BOLD, 48));
		GridBagConstraints gbc_etiquetaTitulo = new GridBagConstraints();
		gbc_etiquetaTitulo.anchor = GridBagConstraints.SOUTH;
		gbc_etiquetaTitulo.gridwidth = 6;
		gbc_etiquetaTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_etiquetaTitulo.gridx = 0;
		gbc_etiquetaTitulo.gridy = 0;
		add(etiquetaTitulo, gbc_etiquetaTitulo);

		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setForeground(Color.WHITE);
		etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaNombre.gridx = 2;
		gbc_etiquetaNombre.gridy = 2;
		add(etiquetaNombre, gbc_etiquetaNombre);

		campoNombre = new JTextField();
		campoNombre.setToolTipText("Introducir nombre de la empresa");
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 3;
		gbc_campoNombre.gridy = 2;
		add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);

		JLabel etiquetaCif = new JLabel("CIF");
		etiquetaCif.setForeground(Color.WHITE);
		etiquetaCif.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_etiquetaCif = new GridBagConstraints();
		gbc_etiquetaCif.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaCif.gridx = 2;
		gbc_etiquetaCif.gridy = 3;
		add(etiquetaCif, gbc_etiquetaCif);

		campoCif = new JTextField();
		campoCif.setToolTipText("Introducir CIF de la empresa");
		GridBagConstraints gbc_campoCif = new GridBagConstraints();
		gbc_campoCif.insets = new Insets(0, 0, 5, 5);
		gbc_campoCif.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoCif.gridx = 3;
		gbc_campoCif.gridy = 3;
		add(campoCif, gbc_campoCif);
		campoCif.setColumns(10);

		JLabel etiquetaFondos = new JLabel("Fondos");
		etiquetaFondos.setForeground(Color.WHITE);
		etiquetaFondos.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_etiquetaFondos = new GridBagConstraints();
		gbc_etiquetaFondos.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaFondos.gridx = 2;
		gbc_etiquetaFondos.gridy = 4;
		add(etiquetaFondos, gbc_etiquetaFondos);

		campoPresupuesto = new JTextField();
		campoPresupuesto.setToolTipText("Introduccir fondos de la empresa");
		GridBagConstraints gbc_campoPresupuesto = new GridBagConstraints();
		gbc_campoPresupuesto.insets = new Insets(0, 0, 5, 5);
		gbc_campoPresupuesto.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoPresupuesto.gridx = 3;
		gbc_campoPresupuesto.gridy = 4;
		add(campoPresupuesto, gbc_campoPresupuesto);
		campoPresupuesto.setColumns(10);

		JButton botonRegistrarEmpresa = new JButton("Registrar empresa");

		botonRegistrarEmpresa.setBackground(SystemColor.info);
		botonRegistrarEmpresa.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_botonRegistrarEmpresa = new GridBagConstraints();
		gbc_botonRegistrarEmpresa.anchor = GridBagConstraints.EAST;
		gbc_botonRegistrarEmpresa.gridwidth = 2;
		gbc_botonRegistrarEmpresa.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistrarEmpresa.gridx = 2;
		gbc_botonRegistrarEmpresa.gridy = 5;
		add(botonRegistrarEmpresa, gbc_botonRegistrarEmpresa);

		JLabel lblNewLabel = new JLabel("\u00BFTienes tu empresa ya registrada?");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 6;
		add(lblNewLabel, gbc_lblNewLabel);

		campoNombreEmpresa = new JTextField();
		campoNombreEmpresa.setToolTipText("Introducir NOMBRE de la empresa");
		GridBagConstraints gbc_campoNombreEmpresa = new GridBagConstraints();
		gbc_campoNombreEmpresa.anchor = GridBagConstraints.NORTH;
		gbc_campoNombreEmpresa.insets = new Insets(0, 0, 0, 5);
		gbc_campoNombreEmpresa.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombreEmpresa.gridx = 3;
		gbc_campoNombreEmpresa.gridy = 7;
		add(campoNombreEmpresa, gbc_campoNombreEmpresa);
		campoNombreEmpresa.setColumns(10);

		JButton botonIniciar = new JButton("Entrar");
		botonIniciar.setBackground(SystemColor.info);
		botonIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombreEmpresa = campoNombreEmpresa.getText();
					new Empresa(nombreEmpresa, ventana.usuarioLogado);
					ventana.cambiarPantallas("principal");
				} catch (nombreInvalidoExceptions | SQLException | EmpresaIncorrectaExceptions e1) {

					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		botonIniciar.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_botonIniciar = new GridBagConstraints();
		gbc_botonIniciar.anchor = GridBagConstraints.NORTH;
		gbc_botonIniciar.insets = new Insets(0, 0, 0, 5);
		gbc_botonIniciar.gridx = 4;
		gbc_botonIniciar.gridy = 7;
		add(botonIniciar, gbc_botonIniciar);
		ventana = v;

		botonRegistrarEmpresa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					String nombre = campoNombre.getText();
					int fondos = Integer.parseInt(campoPresupuesto.getText());
					String cif = campoCif.getText();

					new Empresa(nombre, fondos, cif, ventana.usuarioLogado);
					ventana.cambiarPantallas("principal");
				} catch (cifInvalidoExceptions | nombreInvalidoExceptions | SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		JLabel fotoFondo = new JLabel("");
		fotoFondo.setIcon(new ImageIcon(
				".\\imagenes\\empresaFondo.png"));
		GridBagConstraints gbc_fotoFondo = new GridBagConstraints();
		gbc_fotoFondo.gridheight = 8;
		gbc_fotoFondo.gridwidth = 6;
		gbc_fotoFondo.fill = GridBagConstraints.BOTH;
		gbc_fotoFondo.gridx = 0;
		gbc_fotoFondo.gridy = 0;
		add(fotoFondo, gbc_fotoFondo);

	}
}
