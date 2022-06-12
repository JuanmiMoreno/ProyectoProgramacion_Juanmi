package pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clases.Campo;
import clases.Trabajador;
import clases.Usuario;
import elementosVisuales.ElementosListaCampos;
import elementosVisuales.ElementosListraTrabajador;

import javax.swing.JComboBox;
import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import enums.Provincia;
import javax.swing.JCheckBox;
import enums.TipoPlantacion;
import exceptions.NumeroInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;

import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

/**
 * Clase que extiende de JPanel es la pantalla donde se registra y muestra todos
 * los campos de la empresa
 * 
 * @author Juanmi
 *
 */
public class PantallaCampo extends JPanel {
	/** Ventana donde aparecera la pantalla **/
	private Ventana ventana;

	/** superficie del campo **/
	private JTextField campoSuperficie1;
	/** nombre del campo **/
	private JTextField campoNombre;

	/**
	 * Construnctor que crea pantalla de campo contiene la etiqueta con todos los
	 * atributos de campo y los campos donde se recoge la informacion. Tambien
	 * contiene todas las propiedades de dicha pantalla Tambien crea una lista con
	 * los registro insertados
	 * 
	 * @param v es la ventana en la que aparece la pantalla
	 */
	public PantallaCampo(final Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 37, 103, 38, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 27, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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

		JLabel etiquetaProvincia = new JLabel("Provincia");
		etiquetaProvincia.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaProvincia = new GridBagConstraints();
		gbc_etiquetaProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaProvincia.gridx = 1;
		gbc_etiquetaProvincia.gridy = 3;
		panel.add(etiquetaProvincia, gbc_etiquetaProvincia);

		final JComboBox selectorProvincia = new JComboBox();
		selectorProvincia.setModel(new DefaultComboBoxModel(Provincia.values()));
		GridBagConstraints gbc_selectorProvincia = new GridBagConstraints();
		gbc_selectorProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_selectorProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectorProvincia.gridx = 1;
		gbc_selectorProvincia.gridy = 4;
		panel.add(selectorProvincia, gbc_selectorProvincia);

		JLabel etiquetaPlantacion = new JLabel("Plantaci\u00F3n");
		etiquetaPlantacion.setFont(new Font("Arial", Font.BOLD, 15));
		etiquetaPlantacion.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_etiquetaPlantacion = new GridBagConstraints();
		gbc_etiquetaPlantacion.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaPlantacion.gridx = 1;
		gbc_etiquetaPlantacion.gridy = 5;
		panel.add(etiquetaPlantacion, gbc_etiquetaPlantacion);

		final JComboBox selectorPlantacion = new JComboBox();
		selectorPlantacion.setModel(new DefaultComboBoxModel(TipoPlantacion.values()));
		GridBagConstraints gbc_selectorPlantacion = new GridBagConstraints();
		gbc_selectorPlantacion.insets = new Insets(0, 0, 5, 5);
		gbc_selectorPlantacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectorPlantacion.gridx = 1;
		gbc_selectorPlantacion.gridy = 6;
		panel.add(selectorPlantacion, gbc_selectorPlantacion);

		JLabel etiquetaSuperficie = new JLabel("Superficie");
		etiquetaSuperficie.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaSuperficie = new GridBagConstraints();
		gbc_etiquetaSuperficie.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaSuperficie.gridx = 1;
		gbc_etiquetaSuperficie.gridy = 7;
		panel.add(etiquetaSuperficie, gbc_etiquetaSuperficie);

		campoSuperficie1 = new JTextField();
		GridBagConstraints gbc_campoSuperficie1 = new GridBagConstraints();
		gbc_campoSuperficie1.insets = new Insets(0, 0, 5, 5);
		gbc_campoSuperficie1.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoSuperficie1.gridx = 1;
		gbc_campoSuperficie1.gridy = 8;
		panel.add(campoSuperficie1, gbc_campoSuperficie1);
		campoSuperficie1.setColumns(10);

		JButton botonAñadir = new JButton("A\u00F1adir");
		botonAñadir.setFont(new Font("Arial", Font.BOLD, 13));

		botonAñadir.setIcon(new ImageIcon(".\\imagenes\\a\u00F1adir.png"));
		GridBagConstraints gbc_botonAñadir = new GridBagConstraints();
		gbc_botonAñadir.insets = new Insets(0, 0, 5, 5);
		gbc_botonAñadir.gridx = 1;
		gbc_botonAñadir.gridy = 9;
		panel.add(botonAñadir, gbc_botonAñadir);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlShadow);
		add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel etiquetaTitulo = new JLabel("Campos");
		etiquetaTitulo.setForeground(Color.WHITE);
		etiquetaTitulo.setBackground(Color.GRAY);
		etiquetaTitulo.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 50));
		GridBagConstraints gbc_etiquetaTitulo = new GridBagConstraints();
		gbc_etiquetaTitulo.gridheight = 3;
		gbc_etiquetaTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_etiquetaTitulo.gridx = 0;
		gbc_etiquetaTitulo.gridy = 0;
		panel_1.add(etiquetaTitulo, gbc_etiquetaTitulo);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.controlShadow);
		add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 38, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JButton botonSalir = new JButton("Salir");
		botonSalir.setIcon(new ImageIcon(".\\imagenes\\esquema-de-boton-circular-de-flecha-hacia-atras-izquierda.png"));
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que cuando clicas en el boton salir vuelve a la pantalla principal
			 */
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
		panel_3.setBackground(SystemColor.controlHighlight);
		scrollPane.setColumnHeaderView(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 37, 50, 40, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblNewLabel = new JLabel("Registro de Campos");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridheight = 3;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);

		JPanel listaCampos = new JPanel();
		scrollPane.setViewportView(listaCampos);
		listaCampos.setLayout(new BoxLayout(listaCampos, BoxLayout.Y_AXIS));

		ArrayList<Campo> todos = Campo.getTodos(v.empresaLogada);
		for (int i = 0; i < todos.size(); i++) {
			listaCampos.add(new ElementosListaCampos(ventana, todos.get(i)));
		}

		botonAñadir.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clica en el boton añadir se crea un nuevo campo con toda la
			 * informacion anterior
			 * 
			 * @param e
			 */
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = campoNombre.getText();
					TipoPlantacion plantacion = (TipoPlantacion) selectorPlantacion.getSelectedItem();
					Provincia provincia = (Provincia) selectorProvincia.getSelectedItem();
					float superficie = Float.parseFloat(campoSuperficie1.getText());
					new Campo(nombre, provincia, superficie, plantacion, v.empresaLogada);
					JOptionPane.showMessageDialog(ventana, "Campo insertado con exito", "",
							JOptionPane.INFORMATION_MESSAGE);
					v.cambiarPantallas("campos");
				}catch (SQLIntegrityConstraintViolationException e1) {
					JOptionPane.showMessageDialog(ventana,
							"No puedes tener dos campos con el mismo nombre",
							"Error", JOptionPane.ERROR_MESSAGE);

				} 
				catch (NumberFormatException  e1) {
					JOptionPane.showMessageDialog(ventana, "El decimal lo debes de poner con el punto\nSi has introducido una cadena de carecteres debes de borrar e introducir un numero", "Error",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (nombreInvalidoExceptions | NumeroInvalidoExceptions | SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}
}
