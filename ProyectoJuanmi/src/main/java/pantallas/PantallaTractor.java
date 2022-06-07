package pantallas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;

import clases.Trabajador;
import clases.Tractor;
import elementosVisuales.ElementosListaTractor;
import elementosVisuales.ElementosListraTrabajador;
import exceptions.nombreInvalidoExceptions;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class PantallaTractor extends JPanel {

	private Ventana ventana;
	private JTextField campoMarca;
	private JTextField campoModelo;
	private JTextField campoAño;
	
	public PantallaTractor (final Ventana v) {
		ventana=v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 68, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Tractores");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 50));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{39, 77, 34, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 30, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel etiquetaMarca = new JLabel("Marca");
		etiquetaMarca.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaMarca = new GridBagConstraints();
		gbc_etiquetaMarca.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaMarca.gridx = 1;
		gbc_etiquetaMarca.gridy = 1;
		panel_1.add(etiquetaMarca, gbc_etiquetaMarca);
		
		campoMarca = new JTextField();
		GridBagConstraints gbc_campoMarca = new GridBagConstraints();
		gbc_campoMarca.insets = new Insets(0, 0, 5, 5);
		gbc_campoMarca.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoMarca.gridx = 1;
		gbc_campoMarca.gridy = 2;
		panel_1.add(campoMarca, gbc_campoMarca);
		campoMarca.setColumns(10);
		
		JLabel etiquetaModelo = new JLabel("Modelo");
		etiquetaModelo.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaModelo = new GridBagConstraints();
		gbc_etiquetaModelo.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaModelo.gridx = 1;
		gbc_etiquetaModelo.gridy = 3;
		panel_1.add(etiquetaModelo, gbc_etiquetaModelo);
		
		campoModelo = new JTextField();
		GridBagConstraints gbc_campoModelo = new GridBagConstraints();
		gbc_campoModelo.insets = new Insets(0, 0, 5, 5);
		gbc_campoModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoModelo.gridx = 1;
		gbc_campoModelo.gridy = 4;
		panel_1.add(campoModelo, gbc_campoModelo);
		campoModelo.setColumns(10);
		
		JLabel etiquetaAÑO = new JLabel("A\u00F1o de  adquisici\u00F3n ");
		etiquetaAÑO.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaAÑO = new GridBagConstraints();
		gbc_etiquetaAÑO.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaAÑO.gridx = 1;
		gbc_etiquetaAÑO.gridy = 5;
		panel_1.add(etiquetaAÑO, gbc_etiquetaAÑO);
		
		campoAño = new JTextField();
		GridBagConstraints gbc_campoAño = new GridBagConstraints();
		gbc_campoAño.insets = new Insets(0, 0, 5, 5);
		gbc_campoAño.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoAño.gridx = 1;
		gbc_campoAño.gridy = 6;
		panel_1.add(campoAño, gbc_campoAño);
		campoAño.setColumns(10);
		
		JButton botonAñadir = new JButton("A\u00F1adir");

		botonAñadir.setFont(new Font("Arial", Font.BOLD, 15));
		botonAñadir.setIcon(new ImageIcon("C:\\Users\\34622\\Desktop\\CURSO21-22 CENEC\\ProyectoProgramacion_Juanmi\\ProyectoJuanmi\\imagenes\\a\u00F1adir.png"));
		GridBagConstraints gbc_botonAñadir = new GridBagConstraints();
		gbc_botonAñadir.insets = new Insets(0, 0, 5, 5);
		gbc_botonAñadir.gridx = 1;
		gbc_botonAñadir.gridy = 7;
		panel_1.add(botonAñadir, gbc_botonAñadir);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 49, 0, 0};
		gbl_panel_2.rowHeights = new int[]{48, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.setIcon(new ImageIcon("C:\\Users\\34622\\Desktop\\CURSO21-22 CENEC\\ProyectoProgramacion_Juanmi\\ProyectoJuanmi\\imagenes\\esquema-de-boton-circular-de-flecha-hacia-atras-izquierda.png"));
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarPantallas("principal");
			}
		});
		botonSalir.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonSalir = new GridBagConstraints();
		gbc_botonSalir.insets = new Insets(0, 0, 0, 5);
		gbc_botonSalir.gridx = 1;
		gbc_botonSalir.gridy = 0;
		panel_2.add(botonSalir, gbc_botonSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		scrollPane.setColumnHeaderView(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{38, 35, 41, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Registro tractores");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.gridheight = 3;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel listaTractor = new JPanel();
		scrollPane.setViewportView(listaTractor);
		listaTractor.setLayout(new BoxLayout(listaTractor, BoxLayout.Y_AXIS));
		
		ArrayList<Tractor> todos=Tractor.getTodos();
		for(int i=0;i<todos.size();i++) {
			listaTractor.add(new ElementosListaTractor(ventana,todos.get(i)));
		}
		
		botonAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				String marca = campoMarca.getText();
				String modelo = campoModelo.getText();
				short añoAdquisicion = Short.parseShort(campoAño.getText());
				new Tractor(marca,modelo,añoAdquisicion, v.empresaLogada);
				v.cambiarPantallas("tractor");
				JOptionPane.showMessageDialog(ventana, "Tractor insertado con exito","Insertado con exito",JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		
		
	}
}
