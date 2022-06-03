package pantallas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.ImageIcon;
import com.toedter.components.JLocaleChooser;
import com.toedter.components.JSpinField;

import clases.Actividad;
import clases.Trabajador;
import elementosVisuales.ElementosListaActividades;
import elementosVisuales.ElementosListraTrabajador;
import exceptions.nombreInvalidoExceptions;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;

public class PantallaActividad extends JPanel{
	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoDuracion;

	
	public PantallaActividad (final Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{45, 112, 47, 0};
		gbl_panel.rowHeights = new int[]{0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaNombre.gridx = 1;
		gbc_etiquetaNombre.gridy = 1;
		panel.add(etiquetaNombre, gbc_etiquetaNombre);
		
		campoNombre = new JTextField();
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 1;
		gbc_campoNombre.gridy = 2;
		panel.add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel etiquetaDuracion = new JLabel("Duraci\u00F3n (D\u00EDas)");
		etiquetaDuracion.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaDuracion = new GridBagConstraints();
		gbc_etiquetaDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaDuracion.gridx = 1;
		gbc_etiquetaDuracion.gridy = 3;
		panel.add(etiquetaDuracion, gbc_etiquetaDuracion);
		
		campoDuracion = new JTextField();
		GridBagConstraints gbc_campoDuracion = new GridBagConstraints();
		gbc_campoDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_campoDuracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoDuracion.gridx = 1;
		gbc_campoDuracion.gridy = 4;
		panel.add(campoDuracion, gbc_campoDuracion);
		campoDuracion.setColumns(10);
		
		JLabel etiquetaDescripcion = new JLabel("Descripci\u00F3n");
		etiquetaDescripcion.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaDescripcion = new GridBagConstraints();
		gbc_etiquetaDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaDescripcion.gridx = 1;
		gbc_etiquetaDescripcion.gridy = 5;
		panel.add(etiquetaDescripcion, gbc_etiquetaDescripcion);
		
		final JTextArea campoDescripcion = new JTextArea();
		GridBagConstraints gbc_campoDescripcion = new GridBagConstraints();
		gbc_campoDescripcion.gridheight = 2;
		gbc_campoDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_campoDescripcion.fill = GridBagConstraints.BOTH;
		gbc_campoDescripcion.gridx = 1;
		gbc_campoDescripcion.gridy = 6;
		panel.add(campoDescripcion, gbc_campoDescripcion);
		
		JLabel etiquetaCampo = new JLabel("Campo");
		etiquetaCampo.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaCampo = new GridBagConstraints();
		gbc_etiquetaCampo.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaCampo.gridx = 1;
		gbc_etiquetaCampo.gridy = 8;
		panel.add(etiquetaCampo, gbc_etiquetaCampo);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 9;
		panel.add(comboBox, gbc_comboBox);
		
		JButton botonAñadir = new JButton("");
		
		botonAñadir.setIcon(new ImageIcon("C:\\Users\\34622\\Desktop\\CURSO21-22 CENEC\\ProyectoProgramacion_Juanmi\\ProyectoJuanmi\\imagenes\\a\u00F1adir.png"));
		GridBagConstraints gbc_botonAñadir = new GridBagConstraints();
		gbc_botonAñadir.insets = new Insets(0, 0, 5, 5);
		gbc_botonAñadir.gridx = 1;
		gbc_botonAñadir.gridy = 10;
		panel.add(botonAñadir, gbc_botonAñadir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 24, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Actividades");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 47));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 3;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarPantallas("principal");
			}
		});
		botonSalir.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonSalir = new GridBagConstraints();
		gbc_botonSalir.gridheight = 2;
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
		gbl_panel_3.rowHeights = new int[]{0, 29, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Registro de actividades");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridheight = 2;
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel listaActividades = new JPanel();
		scrollPane.setViewportView(listaActividades);
		
		ArrayList<Actividad> todos=Actividad.getTodos();
		for(int i=0;i<todos.size();i++) {
			listaActividades.add(new ElementosListaActividades(ventana,todos.get(i)));
		}
		
		botonAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				String nombre = campoNombre.getText();
				String descripcion = campoDescripcion.getText();
				byte duracion = Byte.parseByte(campoDuracion.getText());
				String campo = campoCampo.getText();
				try {
					new Actividad (nombre,duracion,campo,descripcion,v.empresaLogada);
					JOptionPane.showMessageDialog(ventana, "Actividad añadida con exito!","Añadida con exito!",JOptionPane.INFORMATION_MESSAGE);
				} catch (nombreInvalidoExceptions | SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
		
	}

}
