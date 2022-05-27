package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.Provincia;
import javax.swing.JCheckBox;
import enums.tipoPlantacion;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaCampo extends JPanel{
	
	private Ventana ventana;
	private JTextField campoNombre;
	
	public PantallaCampo (Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, -11, 0, 0, 0, 46, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 46, 23};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 43, 38, 32, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		JLabel etiquetaTitulo = new JLabel("Campos");
		etiquetaTitulo.setForeground(new Color(255, 255, 255));
		etiquetaTitulo.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 50));
		GridBagConstraints gbc_etiquetaTitulo = new GridBagConstraints();
		gbc_etiquetaTitulo.anchor = GridBagConstraints.SOUTH;
		gbc_etiquetaTitulo.gridwidth = 17;
		gbc_etiquetaTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaTitulo.gridx = 0;
		gbc_etiquetaTitulo.gridy = 0;
		add(etiquetaTitulo, gbc_etiquetaTitulo);
		
		JLabel lblNewLabel = new JLabel("Nombre del campo");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Registros de campos");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 22));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 9;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 6;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JList listaCampos = new JList();
		listaCampos.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_listaCampos = new GridBagConstraints();
		gbc_listaCampos.gridheight = 7;
		gbc_listaCampos.gridwidth = 11;
		gbc_listaCampos.insets = new Insets(0, 0, 5, 5);
		gbc_listaCampos.fill = GridBagConstraints.BOTH;
		gbc_listaCampos.gridx = 6;
		gbc_listaCampos.gridy = 3;
		add(listaCampos, gbc_listaCampos);
		
		campoNombre = new JTextField();
		campoNombre.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.gridwidth = 3;
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 1;
		gbc_campoNombre.gridy = 3;
		add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel etiquetaProvincia = new JLabel("Provincia");
		etiquetaProvincia.setForeground(new Color(255, 255, 255));
		etiquetaProvincia.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaProvincia = new GridBagConstraints();
		gbc_etiquetaProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaProvincia.gridx = 2;
		gbc_etiquetaProvincia.gridy = 4;
		add(etiquetaProvincia, gbc_etiquetaProvincia);
		
		JComboBox selecctorProvincia = new JComboBox();
		selecctorProvincia.setModel(new DefaultComboBoxModel(Provincia.values()));
		GridBagConstraints gbc_selecctorProvincia = new GridBagConstraints();
		gbc_selecctorProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_selecctorProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_selecctorProvincia.gridx = 2;
		gbc_selecctorProvincia.gridy = 5;
		add(selecctorProvincia, gbc_selecctorProvincia);
		
		JLabel etiquetaPlantacion = new JLabel("Plantacion");
		etiquetaPlantacion.setForeground(new Color(255, 255, 255));
		etiquetaPlantacion.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaPlantacion = new GridBagConstraints();
		gbc_etiquetaPlantacion.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaPlantacion.gridx = 2;
		gbc_etiquetaPlantacion.gridy = 6;
		add(etiquetaPlantacion, gbc_etiquetaPlantacion);
		
		JComboBox selectorPlantacion = new JComboBox();
		selectorPlantacion.setModel(new DefaultComboBoxModel(tipoPlantacion.values()));
		GridBagConstraints gbc_selectorPlantacion = new GridBagConstraints();
		gbc_selectorPlantacion.insets = new Insets(0, 0, 5, 5);
		gbc_selectorPlantacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectorPlantacion.gridx = 2;
		gbc_selectorPlantacion.gridy = 7;
		add(selectorPlantacion, gbc_selectorPlantacion);
		
		JButton botonAñadirActividad = new JButton("A\u00F1adir");
		botonAñadirActividad.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonAñadirActividad = new GridBagConstraints();
		gbc_botonAñadirActividad.anchor = GridBagConstraints.SOUTH;
		gbc_botonAñadirActividad.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonAñadirActividad.insets = new Insets(0, 0, 5, 5);
		gbc_botonAñadirActividad.gridx = 2;
		gbc_botonAñadirActividad.gridy = 8;
		add(botonAñadirActividad, gbc_botonAñadirActividad);
		
		JButton botonEliminar = new JButton("Eliminar campo");
		botonEliminar.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonEliminar = new GridBagConstraints();
		gbc_botonEliminar.anchor = GridBagConstraints.NORTH;
		gbc_botonEliminar.gridwidth = 6;
		gbc_botonEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_botonEliminar.gridx = 6;
		gbc_botonEliminar.gridy = 10;
		add(botonEliminar, gbc_botonEliminar);
		
		JButton botonVolver = new JButton("Volver");

		botonVolver.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonVolver = new GridBagConstraints();
		gbc_botonVolver.gridwidth = 4;
		gbc_botonVolver.gridx = 14;
		gbc_botonVolver.gridy = 11;
		add(botonVolver, gbc_botonVolver);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("C:\\Users\\34622\\Desktop\\CURSO21-22 CENEC\\ProyectoProgramacion_Juanmi\\ProyectoJuanmi\\iconos\\campos.png"));
		GridBagConstraints gbc_fondo = new GridBagConstraints();
		gbc_fondo.gridheight = 12;
		gbc_fondo.gridwidth = 18;
		gbc_fondo.insets = new Insets(0, 0, 5, 5);
		gbc_fondo.gridx = 0;
		gbc_fondo.gridy = 0;
		add(fondo, gbc_fondo);

		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantallas("principal");
			}
		});
		

	}
}
