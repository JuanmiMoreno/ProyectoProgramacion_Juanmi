package pantallas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class PantallaEmpresa extends JPanel{

	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoCif;
	private JTextField campoPresupuesto;

	public PantallaEmpresa(Ventana v) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 90, 130, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 39, 0, 0, 0, 57, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel etiquetaTitulo = new JLabel("Registra tu empresa");
		etiquetaTitulo.setForeground(Color.WHITE);
		etiquetaTitulo.setFont(new Font("Georgia", Font.BOLD, 48));
		GridBagConstraints gbc_etiquetaTitulo = new GridBagConstraints();
		gbc_etiquetaTitulo.anchor = GridBagConstraints.SOUTH;
		gbc_etiquetaTitulo.gridwidth = 4;
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
		gbc_etiquetaNombre.gridx = 1;
		gbc_etiquetaNombre.gridy = 2;
		add(etiquetaNombre, gbc_etiquetaNombre);
		
		campoNombre = new JTextField();
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 2;
		gbc_campoNombre.gridy = 2;
		add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel etiquetaCif = new JLabel("CIF");
		etiquetaCif.setForeground(Color.WHITE);
		etiquetaCif.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_etiquetaCif = new GridBagConstraints();
		gbc_etiquetaCif.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaCif.gridx = 1;
		gbc_etiquetaCif.gridy = 3;
		add(etiquetaCif, gbc_etiquetaCif);
		
		campoCif = new JTextField();
		GridBagConstraints gbc_campoCif = new GridBagConstraints();
		gbc_campoCif.insets = new Insets(0, 0, 5, 5);
		gbc_campoCif.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoCif.gridx = 2;
		gbc_campoCif.gridy = 3;
		add(campoCif, gbc_campoCif);
		campoCif.setColumns(10);
		
		JLabel etiquetaFondos = new JLabel("Fondos");
		etiquetaFondos.setForeground(Color.WHITE);
		etiquetaFondos.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_etiquetaFondos = new GridBagConstraints();
		gbc_etiquetaFondos.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaFondos.gridx = 1;
		gbc_etiquetaFondos.gridy = 4;
		add(etiquetaFondos, gbc_etiquetaFondos);
		
		campoPresupuesto = new JTextField();
		GridBagConstraints gbc_campoPresupuesto = new GridBagConstraints();
		gbc_campoPresupuesto.insets = new Insets(0, 0, 5, 5);
		gbc_campoPresupuesto.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoPresupuesto.gridx = 2;
		gbc_campoPresupuesto.gridy = 4;
		add(campoPresupuesto, gbc_campoPresupuesto);
		campoPresupuesto.setColumns(10);
		
		JButton botonRegistrarEmpresa = new JButton("Registrar empresa");
		botonRegistrarEmpresa.setBackground(SystemColor.info);
		botonRegistrarEmpresa.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_botonRegistrarEmpresa = new GridBagConstraints();
		gbc_botonRegistrarEmpresa.gridwidth = 2;
		gbc_botonRegistrarEmpresa.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistrarEmpresa.gridx = 1;
		gbc_botonRegistrarEmpresa.gridy = 5;
		add(botonRegistrarEmpresa, gbc_botonRegistrarEmpresa);
		ventana=v;
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBackground(UIManager.getColor("Button.light"));
		imagenFondo.setIcon(new ImageIcon("C:\\Users\\34622\\Desktop\\CURSO21-22 CENEC\\ProyectoProgramacion_Juanmi\\ProyectoJuanmi\\iconos\\empresaFondo.png"));
		GridBagConstraints gbc_imagenFondo = new GridBagConstraints();
		gbc_imagenFondo.gridwidth = 4;
		gbc_imagenFondo.gridheight = 7;
		gbc_imagenFondo.gridx = 0;
		gbc_imagenFondo.gridy = 0;
		add(imagenFondo, gbc_imagenFondo);
		
	
	}
}
