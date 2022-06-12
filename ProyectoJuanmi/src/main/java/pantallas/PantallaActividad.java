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

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import com.toedter.components.JLocaleChooser;
import com.toedter.components.JSpinField;

import clases.Actividad;
import clases.Trabajador;
import elementosVisuales.ElementosListaActividades;
import elementosVisuales.ElementosListraTrabajador;
import exceptions.NumeroInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

/**
 * Clase que extiende de JPanel es la pantalla donde se registra y muestran las
 * actividades de la empresa
 * 
 * @author Juanmi
 *
 */
public class PantallaActividad extends JPanel {
	/** es la ventana en la que se mostrara **/
	private Ventana ventana;
	/** es el nombre de la actividad **/
	private JTextField campoNombre;
	/** es la duracion de la actividad **/
	private JTextField campoDuracion;
	/** es el campo donde se realiza la actividad **/
	private JTextField campoCampo;
	/** es el tractor que realiza la actividad **/
	private JTextField campoTractor;
	/** es el apero que realiza la actividad **/
	private JTextField campoApero;

	/**
	 * Construnctor que crea pantalla de actividad contiene la etiqueta con todos
	 * los atributos de actividad y los campos donde se recoge la informacion.
	 * Tambien contiene todas las propiedades de dicha pantalla Tambien crea una
	 * lista con los registro insertados
	 * 
	 * @param v es la ventana en la que aparece la pantalla
	 */
	public PantallaActividad(final Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 45, 112, 47, 0 };
		gbl_panel.rowHeights = new int[] { 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 39, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaNombre.gridx = 1;
		gbc_etiquetaNombre.gridy = 1;
		panel.add(etiquetaNombre, gbc_etiquetaNombre);

		campoNombre = new JTextField();
		campoNombre.setToolTipText("INTRODUCIR EL NOMBRE DE LA ACTIVIDAD");
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
		campoDuracion.setToolTipText("INTRODUCIR LA DURACION DE LA ACTIVIDAD EN DIAS");
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
		campoDescripcion.setToolTipText("INTRODUCIR UNA BREVE DESCRIPCION DE LA ACTIVIDAD");
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

		campoCampo = new JTextField();
		campoCampo.setToolTipText("INTRODUCIR NOMBRE DEL CAMPO  EN EL QUE SE VA A REALIZAR LA ACTIVIDAD");
		GridBagConstraints gbc_campoCampo = new GridBagConstraints();
		gbc_campoCampo.insets = new Insets(0, 0, 5, 5);
		gbc_campoCampo.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoCampo.gridx = 1;
		gbc_campoCampo.gridy = 9;
		panel.add(campoCampo, gbc_campoCampo);
		campoCampo.setColumns(10);

		JLabel etiquetaTractor = new JLabel("Tractor (Modelo)");
		etiquetaTractor.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaTractor = new GridBagConstraints();
		gbc_etiquetaTractor.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaTractor.gridx = 1;
		gbc_etiquetaTractor.gridy = 10;
		panel.add(etiquetaTractor, gbc_etiquetaTractor);

		campoTractor = new JTextField();
		campoTractor.setToolTipText("A\u00D1ADIR MODELO DEL TRACTOR");
		GridBagConstraints gbc_campoTractor = new GridBagConstraints();
		gbc_campoTractor.insets = new Insets(0, 0, 5, 5);
		gbc_campoTractor.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoTractor.gridx = 1;
		gbc_campoTractor.gridy = 11;
		panel.add(campoTractor, gbc_campoTractor);
		campoTractor.setColumns(10);

		JLabel etiquetaApero = new JLabel("Apero (Modelo)");
		etiquetaApero.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaApero = new GridBagConstraints();
		gbc_etiquetaApero.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaApero.gridx = 1;
		gbc_etiquetaApero.gridy = 12;
		panel.add(etiquetaApero, gbc_etiquetaApero);

		campoApero = new JTextField();
		campoApero.setToolTipText("INTRODUCIR EL MODELO DEL APERO QUE SE VA A UTILIZAR EN LA ACTIVIDAD");
		GridBagConstraints gbc_campoApero = new GridBagConstraints();
		gbc_campoApero.insets = new Insets(0, 0, 5, 5);
		gbc_campoApero.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoApero.gridx = 1;
		gbc_campoApero.gridy = 13;
		panel.add(campoApero, gbc_campoApero);
		campoApero.setColumns(10);

		JButton botonAñadir = new JButton("A\u00F1adir");
		botonAñadir.setToolTipText("CLICAR PARA A\u00D1ADIR UNA ACTIVIDAD EN LA BASE DE DATOS");
		botonAñadir.setFont(new Font("Arial", Font.BOLD, 13));

		botonAñadir.setIcon(new ImageIcon(".\\imagenes\\a\u00F1adir.png"));
		GridBagConstraints gbc_botonAñadir = new GridBagConstraints();
		gbc_botonAñadir.insets = new Insets(0, 0, 5, 5);
		gbc_botonAñadir.gridx = 1;
		gbc_botonAñadir.gridy = 14;
		panel.add(botonAñadir, gbc_botonAñadir);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlShadow);
		add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 24, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
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
		panel_2.setBackground(SystemColor.controlShadow);
		add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 41, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JButton botonSalir = new JButton("Salir");
		botonSalir.setToolTipText("BOTON PARA VOVLER AL MENU PRINCIPAL");
		botonSalir.setIcon(new ImageIcon(".\\imagenes\\esquema-de-boton-circular-de-flecha-hacia-atras-izquierda.png"));
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar el boton salir cambia a la pantalla principal
			 * 
			 * @param e
			 */
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
		panel_3.setBackground(SystemColor.controlHighlight);
		scrollPane.setColumnHeaderView(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 43, 39, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblNewLabel_1 = new JLabel("Registro de actividades");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 26));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridheight = 3;
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JPanel listaActividades = new JPanel();
		scrollPane.setViewportView(listaActividades);
		listaActividades.setLayout(new BoxLayout(listaActividades, BoxLayout.Y_AXIS));
		ArrayList<Actividad> todos = Actividad.getTodos(v.empresaLogada);
		for (int i = 0; i < todos.size(); i++) {
			listaActividades.add(new ElementosListaActividades(ventana, todos.get(i)));
		}

		botonAñadir.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar en el boton añadir crea una actividad
			 */
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = campoNombre.getText();
					String descripcion = campoDescripcion.getText();
					byte duracion = Byte.parseByte(campoDuracion.getText());
					String campo = campoCampo.getText();
					String tractor = campoTractor.getText();
					String apero = campoApero.getText();
					new Actividad(nombre, duracion, campo, descripcion, tractor, apero, v.empresaLogada);
					JOptionPane.showMessageDialog(ventana, "Actividad añadida con exito!", "Añadida con exito!",
							JOptionPane.INFORMATION_MESSAGE);
					v.cambiarPantallas("actividad");
				} catch (SQLIntegrityConstraintViolationException e1) {
					JOptionPane.showMessageDialog(ventana,
							"En los campos tractor, campos y apero, debes introducir registros ya insertado anteriormente\n EL NOMBRE DE LA ACTIVIDAD NO PUEDE SER IGUAL A ALGUNO QUE YA TENGAS INSERTADO",
							"Error", JOptionPane.ERROR_MESSAGE);

				} catch (nombreInvalidoExceptions | NumeroInvalidoExceptions | SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(ventana,
							"Por favor introduce un numero en duracion menor de 127 dias. Ninguna actividad dura mas de medio año:(",
							"Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});

	}

}
