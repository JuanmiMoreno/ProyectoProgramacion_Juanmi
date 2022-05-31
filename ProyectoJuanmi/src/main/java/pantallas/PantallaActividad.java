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
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.ImageIcon;
import com.toedter.components.JLocaleChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class PantallaActividad extends JPanel{
	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoDuracion;
	
	public PantallaActividad (Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, -11, 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{50, 91, 0, 0, 0, 0, 0, 0, 35, 34, 38, 46, 96, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel etiquetaTitulo = new JLabel("Actividades");
		etiquetaTitulo.setForeground(new Color(255, 255, 255));
		etiquetaTitulo.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 50));
		GridBagConstraints gbc_etiquetaTitulo = new GridBagConstraints();
		gbc_etiquetaTitulo.anchor = GridBagConstraints.SOUTH;
		gbc_etiquetaTitulo.gridwidth = 21;
		gbc_etiquetaTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_etiquetaTitulo.gridx = 0;
		gbc_etiquetaTitulo.gridy = 1;
		add(etiquetaTitulo, gbc_etiquetaTitulo);
		
		JLabel lblNewLabel = new JLabel("Nombre de la Actividad");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Actividades iniciadas");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 22));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 14;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 6;
		gbc_lblNewLabel_1.gridy = 4;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JList listaActividades = new JList();
		listaActividades.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_listaActividades = new GridBagConstraints();
		gbc_listaActividades.gridheight = 5;
		gbc_listaActividades.gridwidth = 14;
		gbc_listaActividades.insets = new Insets(0, 0, 5, 5);
		gbc_listaActividades.fill = GridBagConstraints.BOTH;
		gbc_listaActividades.gridx = 6;
		gbc_listaActividades.gridy = 5;
		add(listaActividades, gbc_listaActividades);
		
		campoNombre = new JTextField();
		campoNombre.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.gridwidth = 2;
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 1;
		gbc_campoNombre.gridy = 3;
		add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel etiquetaDuracion = new JLabel("Duraci\u00F3n (D\u00EDas)");
		etiquetaDuracion.setForeground(new Color(255, 255, 255));
		etiquetaDuracion.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaDuracion = new GridBagConstraints();
		gbc_etiquetaDuracion.gridwidth = 3;
		gbc_etiquetaDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaDuracion.gridx = 1;
		gbc_etiquetaDuracion.gridy = 4;
		add(etiquetaDuracion, gbc_etiquetaDuracion);
		
		campoDuracion = new JTextField();
		campoDuracion.setBackground(Color.WHITE);
		GridBagConstraints gbc_campoDuracion = new GridBagConstraints();
		gbc_campoDuracion.gridwidth = 2;
		gbc_campoDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_campoDuracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoDuracion.gridx = 1;
		gbc_campoDuracion.gridy = 5;
		add(campoDuracion, gbc_campoDuracion);
		campoDuracion.setColumns(10);
		
		JLabel etiquetaDescripcion = new JLabel("Descripci\u00F3n");
		etiquetaDescripcion.setForeground(new Color(255, 255, 255));
		etiquetaDescripcion.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaDescripcion = new GridBagConstraints();
		gbc_etiquetaDescripcion.gridwidth = 2;
		gbc_etiquetaDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaDescripcion.gridx = 1;
		gbc_etiquetaDescripcion.gridy = 6;
		add(etiquetaDescripcion, gbc_etiquetaDescripcion);
		
		JTextArea campoDescripcion = new JTextArea();
		campoDescripcion.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_campoDescripcion = new GridBagConstraints();
		gbc_campoDescripcion.gridheight = 2;
		gbc_campoDescripcion.gridwidth = 4;
		gbc_campoDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_campoDescripcion.fill = GridBagConstraints.BOTH;
		gbc_campoDescripcion.gridx = 1;
		gbc_campoDescripcion.gridy = 7;
		add(campoDescripcion, gbc_campoDescripcion);
		
		JLabel etiquetaCampos = new JLabel("Campo");
		etiquetaCampos.setForeground(Color.WHITE);
		etiquetaCampos.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_etiquetaCampos = new GridBagConstraints();
		gbc_etiquetaCampos.gridwidth = 2;
		gbc_etiquetaCampos.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaCampos.gridx = 1;
		gbc_etiquetaCampos.gridy = 9;
		add(etiquetaCampos, gbc_etiquetaCampos);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.anchor = GridBagConstraints.SOUTH;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 10;
		add(comboBox, gbc_comboBox);
		
		JButton botonEliminar = new JButton("Elimiar actividad");
		botonEliminar.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonEliminar = new GridBagConstraints();
		gbc_botonEliminar.anchor = GridBagConstraints.SOUTH;
		gbc_botonEliminar.gridwidth = 4;
		gbc_botonEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_botonEliminar.gridx = 8;
		gbc_botonEliminar.gridy = 10;
		add(botonEliminar, gbc_botonEliminar);
		
		JButton botonAñadirActividad = new JButton("A\u00F1adir");
		botonAñadirActividad.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonAñadirActividad = new GridBagConstraints();
		gbc_botonAñadirActividad.gridwidth = 2;
		gbc_botonAñadirActividad.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonAñadirActividad.insets = new Insets(0, 0, 5, 5);
		gbc_botonAñadirActividad.gridx = 1;
		gbc_botonAñadirActividad.gridy = 11;
		add(botonAñadirActividad, gbc_botonAñadirActividad);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonVolver = new GridBagConstraints();
		gbc_botonVolver.insets = new Insets(0, 0, 5, 5);
		gbc_botonVolver.gridwidth = 3;
		gbc_botonVolver.gridx = 17;
		gbc_botonVolver.gridy = 12;
		add(botonVolver, gbc_botonVolver);
		
		
		
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantallas("principal");
			}
		});

		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("C:\\Users\\34622\\Desktop\\CURSO21-22 CENEC\\ProyectoProgramacion_Juanmi\\ProyectoJuanmi\\imagenes\\fondoActividad.png"));
		GridBagConstraints gbc_fondo = new GridBagConstraints();
		gbc_fondo.gridheight = 14;
		gbc_fondo.gridwidth = 21;
		gbc_fondo.gridx = 0;
		gbc_fondo.gridy = 0;
		add(fondo, gbc_fondo);


	}

}
