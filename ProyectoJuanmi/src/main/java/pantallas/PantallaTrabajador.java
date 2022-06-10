package pantallas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.Trabajador;
import clases.Usuario;
import elementosVisuales.ElementosListraTrabajador;
import exceptions.nombreInvalidoExceptions;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.SystemColor;

public class PantallaTrabajador extends JPanel{

	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoApellido;
	private JTextField campoDni;
	private JTextField campoSueldo;
	
	public PantallaTrabajador(final Ventana v) {
		this.ventana = v;

		
		setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{57, 109, 52, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 35, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		
		JLabel etiquetaApellido = new JLabel("Apellido ");
		etiquetaApellido.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaApellido = new GridBagConstraints();
		gbc_etiquetaApellido.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaApellido.gridx = 1;
		gbc_etiquetaApellido.gridy = 3;
		panel.add(etiquetaApellido, gbc_etiquetaApellido);
		
		campoApellido = new JTextField();
		GridBagConstraints gbc_campoApellido = new GridBagConstraints();
		gbc_campoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_campoApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoApellido.gridx = 1;
		gbc_campoApellido.gridy = 4;
		panel.add(campoApellido, gbc_campoApellido);
		campoApellido.setColumns(10);
		
		JLabel etiquetaDni = new JLabel("DNI");
		etiquetaDni.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaDni = new GridBagConstraints();
		gbc_etiquetaDni.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaDni.gridx = 1;
		gbc_etiquetaDni.gridy = 5;
		panel.add(etiquetaDni, gbc_etiquetaDni);
		
		campoDni = new JTextField();
		GridBagConstraints gbc_campoDni = new GridBagConstraints();
		gbc_campoDni.insets = new Insets(0, 0, 5, 5);
		gbc_campoDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoDni.gridx = 1;
		gbc_campoDni.gridy = 6;
		panel.add(campoDni, gbc_campoDni);
		campoDni.setColumns(10);
		
		JLabel etiquetaSueldo = new JLabel("Sueldo");
		etiquetaSueldo.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaSueldo = new GridBagConstraints();
		gbc_etiquetaSueldo.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaSueldo.gridx = 1;
		gbc_etiquetaSueldo.gridy = 7;
		panel.add(etiquetaSueldo, gbc_etiquetaSueldo);
		
		campoSueldo = new JTextField();
		GridBagConstraints gbc_campoSueldo = new GridBagConstraints();
		gbc_campoSueldo.insets = new Insets(0, 0, 5, 5);
		gbc_campoSueldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoSueldo.gridx = 1;
		gbc_campoSueldo.gridy = 8;
		panel.add(campoSueldo, gbc_campoSueldo);
		campoSueldo.setColumns(10);
		
		JButton botonAñadir = new JButton("A\u00F1adir");
		botonAñadir.setIcon(new ImageIcon(".\\imagenes\\a\u00F1adir.png"));
	
		botonAñadir.setFont(new Font("Arial", Font.BOLD, 15));
		botonAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_botonAñadir = new GridBagConstraints();
		gbc_botonAñadir.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonAñadir.insets = new Insets(0, 0, 5, 5);
		gbc_botonAñadir.gridx = 1;
		gbc_botonAñadir.gridy = 9;
		panel.add(botonAñadir, gbc_botonAñadir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlShadow);
		add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel etiquetaTitulo = new JLabel("Trabajadores");
		etiquetaTitulo.setForeground(Color.WHITE);
		etiquetaTitulo.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 50));
		GridBagConstraints gbc_etiquetaTitulo = new GridBagConstraints();
		gbc_etiquetaTitulo.gridheight = 4;
		gbc_etiquetaTitulo.gridwidth = 3;
		gbc_etiquetaTitulo.gridx = 0;
		gbc_etiquetaTitulo.gridy = 0;
		panel_1.add(etiquetaTitulo, gbc_etiquetaTitulo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.controlShadow);
		add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 67, 0, 0};
		gbl_panel_2.rowHeights = new int[]{27, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.setIcon(new ImageIcon(".\\imagenes\\esquema-de-boton-circular-de-flecha-hacia-atras-izquierda.png"));
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarPantallas("principal");
			}
		});
		botonSalir.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonSalir = new GridBagConstraints();
		gbc_botonSalir.insets = new Insets(0, 0, 0, 5);
		gbc_botonSalir.gridheight = 2;
		gbc_botonSalir.anchor = GridBagConstraints.WEST;
		gbc_botonSalir.gridx = 1;
		gbc_botonSalir.gridy = 0;
		panel_2.add(botonSalir, gbc_botonSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		scrollPane.setColumnHeaderView(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 61, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel = new JLabel("Registro trabajadores");
		lblNewLabel.setBackground(SystemColor.controlHighlight);
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 26));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel listaTrabajadores = new JPanel();
		scrollPane.setViewportView(listaTrabajadores);
		listaTrabajadores.setLayout(new BoxLayout(listaTrabajadores, BoxLayout.Y_AXIS));
		
		ArrayList<Trabajador> todos=Trabajador.getTodos();
		for(int i=0;i<todos.size();i++) {
			listaTrabajadores.add(new ElementosListraTrabajador(ventana,todos.get(i)));
		}
		
		
	
		botonAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				String nombre = campoNombre.getText();
				String apellido = campoApellido.getText();
				String dni = campoDni.getText();
				int sueldo = Integer.parseInt(campoSueldo.getText());
				new Trabajador(nombre, sueldo, apellido, dni, v.empresaLogada);
				JOptionPane.showMessageDialog(ventana, "Trabajador insertado con exito!", "Insertado con exito", JOptionPane.INFORMATION_MESSAGE);
				v.cambiarPantallas("personal");
				
				} catch (nombreInvalidoExceptions |SQLException e1) {
					System.out.println(e1.getMessage());
					JOptionPane.showMessageDialog(ventana,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(ventana,"El sueldo del empleado debe ser un numero entero!","Error",JOptionPane.ERROR_MESSAGE );

				}
			}
		});
		
	}
}
