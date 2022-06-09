package pantallas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.Apero;
import clases.Trabajador;
import elementosVisuales.ElementosListaAperos;
import elementosVisuales.ElementosListraTrabajador;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import enums.Provincia;
import enums.TipoApero;
import exceptions.AñoInvalidoExceptions;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PantallaApero extends JPanel {

	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoModelo;
	private JTextField campoAño;
	
	public PantallaApero(final Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 37, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 21, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Aperos");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 50));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridheight = 4;
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{38, 0, 34, 0};
		gbl_panel_1.rowHeights = new int[]{0, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		campoNombre = new JTextField();
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 1;
		gbc_campoNombre.gridy = 2;
		panel_1.add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Modelo");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		campoModelo = new JTextField();
		GridBagConstraints gbc_campoModelo = new GridBagConstraints();
		gbc_campoModelo.insets = new Insets(0, 0, 5, 5);
		gbc_campoModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoModelo.gridx = 1;
		gbc_campoModelo.gridy = 4;
		panel_1.add(campoModelo, gbc_campoModelo);
		campoModelo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("A\u00F1o de Aquisici\u00F3n");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 5;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		campoAño = new JTextField();
		GridBagConstraints gbc_campoAño = new GridBagConstraints();
		gbc_campoAño.insets = new Insets(0, 0, 5, 5);
		gbc_campoAño.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoAño.gridx = 1;
		gbc_campoAño.gridy = 6;
		panel_1.add(campoAño, gbc_campoAño);
		campoAño.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo de apero");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 7;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		final JComboBox selectorApero = new JComboBox();
		selectorApero.setModel(new DefaultComboBoxModel(TipoApero.values()));
		GridBagConstraints gbc_selectorApero = new GridBagConstraints();
		gbc_selectorApero.insets = new Insets(0, 0, 5, 5);
		gbc_selectorApero.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectorApero.gridx = 1;
		gbc_selectorApero.gridy = 8;
		panel_1.add(selectorApero, gbc_selectorApero);
		
		JButton botonAñadir = new JButton("A\u00F1adir");

		botonAñadir.setIcon(new ImageIcon("C:\\Users\\34622\\Desktop\\CURSO21-22 CENEC\\ProyectoProgramacion_Juanmi\\ProyectoJuanmi\\imagenes\\a\u00F1adir.png"));
		botonAñadir.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonAñadir = new GridBagConstraints();
		gbc_botonAñadir.insets = new Insets(0, 0, 5, 5);
		gbc_botonAñadir.gridx = 1;
		gbc_botonAñadir.gridy = 10;
		panel_1.add(botonAñadir, gbc_botonAñadir);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 71, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 38, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\34622\\Desktop\\CURSO21-22 CENEC\\ProyectoProgramacion_Juanmi\\ProyectoJuanmi\\imagenes\\esquema-de-boton-circular-de-flecha-hacia-atras-izquierda.png"));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarPantallas("principal");
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		panel_2.add(btnNewButton, gbc_btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		scrollPane.setColumnHeaderView(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{33, 0, 33, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Registro aperos");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.gridwidth = 3;
		gbc_lblNewLabel_5.gridheight = 3;
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 0;
		panel_3.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JPanel listaAperos = new JPanel();
		scrollPane.setViewportView(listaAperos);
		GridBagLayout gbl_listaAperos = new GridBagLayout();
		gbl_listaAperos.columnWidths = new int[]{49, 0};
		gbl_listaAperos.rowHeights = new int[]{14, 0};
		gbl_listaAperos.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_listaAperos.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		listaAperos.setLayout(gbl_listaAperos);
		listaAperos.setLayout(new BoxLayout(listaAperos, BoxLayout.Y_AXIS));

		ArrayList<Apero> todos=Apero.getTodos();
		for(int i=0;i<todos.size();i++) {
			listaAperos.add(new ElementosListaAperos(ventana,todos.get(i)));
		}

		botonAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				String marca = campoNombre.getText();
				String modelo = campoModelo.getText();
				TipoApero tipo = (TipoApero) selectorApero.getSelectedItem();
				short año = Short.parseShort(campoAño.getText());
				new Apero(marca, modelo, año, tipo, v.empresaLogada);
				JOptionPane.showMessageDialog(ventana, "Apero insertado con exito!","Insertado con exito",JOptionPane.INFORMATION_MESSAGE);
				v.cambiarPantallas("apero");
				} catch (SQLException | AñoInvalidoExceptions e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(ventana, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(ventana, "En el año debes de introducir un numero entero de 4 digitos","Error",JOptionPane.ERROR_MESSAGE);
	
				} 
			}
		});
		
		
	}
}
