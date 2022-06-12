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

import clases.Proveedor;
import clases.Trabajador;
import elementosVisuales.ElementosListaProveedor;
import elementosVisuales.ElementosListraTrabajador;
import exceptions.TelefonoInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.awt.SystemColor;

/**
 * Clase que extiende de JPanel es la pantalla donde se muestran y se registran
 * los proveedores de la empresa
 * 
 * @author Juanmi
 *
 */
public class PantallaProveedor extends JPanel {
	/** ventana sobre la que aparece la ventana **/
	private Ventana ventana;
	/** nombre del proveedor **/
	private JTextField campoNombre;
	/** numero de telefono del proveedor **/
	private JTextField campoTelefono;

	/**
	 * Construnctor que crea pantalla de proveedor contiene la etiqueta con todos
	 * los atributos de actividad y los campos donde se recoge la informacion.
	 * Tambien contiene todas las propiedades de dicha pantalla
	 * Tambien crea una lista con los registro insertados
	 * 
	 * @param v es la ventana en la que aparece la pantalla
	 */
	public PantallaProveedor(final Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 27, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Proveedores");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 50));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridheight = 4;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 86, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 33, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JButton botonSalir = new JButton("Salir");
		botonSalir.setToolTipText("BOTON PARA VOLVER AL MENU PRINCIPAL");
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar en el boton salir va hacua la pantalla principal
			 * 
			 * @param e evento de clicar
			 */
			public void mouseClicked(MouseEvent e) {
				v.cambiarPantallas("principal");
			}
		});
		botonSalir.setIcon(new ImageIcon(".\\imagenes\\esquema-de-boton-circular-de-flecha-hacia-atras-izquierda.png"));
		botonSalir.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonSalir = new GridBagConstraints();
		gbc_botonSalir.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonSalir.gridheight = 2;
		gbc_botonSalir.insets = new Insets(0, 0, 0, 5);
		gbc_botonSalir.gridx = 1;
		gbc_botonSalir.gridy = 0;
		panel_2.add(botonSalir, gbc_botonSalir);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 44, 0, 36, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 21, 0, 0, 0, 56, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		campoNombre = new JTextField();
		campoNombre.setToolTipText("INTRODUCIR EL NOMBRE DEL PROVEEDOR");
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 1;
		gbc_campoNombre.gridy = 2;
		panel_1.add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		campoTelefono = new JTextField();
		campoTelefono.setToolTipText("INTRODUCIR TELEFONO DEL PROVEEDOR");
		GridBagConstraints gbc_campoTelefono = new GridBagConstraints();
		gbc_campoTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_campoTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoTelefono.gridx = 1;
		gbc_campoTelefono.gridy = 4;
		panel_1.add(campoTelefono, gbc_campoTelefono);
		campoTelefono.setColumns(10);

		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.setToolTipText("CLICAR PARA A\u00D1ADIR UN PROVEEDOR A LA BASE DE DATOS\r\n");

		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setIcon(new ImageIcon(".\\imagenes\\a\u00F1adir.png"));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 5;
		panel_1.add(btnNewButton, gbc_btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.controlHighlight);
		scrollPane.setColumnHeaderView(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 40, 42, 39, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblNewLabel_3 = new JLabel("Registro de proveedores");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 26));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 3;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridheight = 3;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_3.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JPanel listaProveedores = new JPanel();
		scrollPane.setViewportView(listaProveedores);

		listaProveedores.setLayout(new BoxLayout(listaProveedores, BoxLayout.Y_AXIS));

		ArrayList<Proveedor> todos = Proveedor.getTodos(v.empresaLogada);
		for (int i = 0; i < todos.size(); i++) {
			listaProveedores.add(new ElementosListaProveedor(ventana, todos.get(i)));
		}

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar en el boton añadir, recoge la informacion de todos los
			 * campos y crea un nuevo proveedor. Si no puede crearlo saltan varios errores
			 * 
			 * @param e evento de clicar
			 */
			public void mouseClicked(MouseEvent e) {

				String nombre = campoNombre.getText();
				String telefono = campoTelefono.getText();
				try {
					new Proveedor(nombre, telefono);
					v.cambiarPantallas("proveedor");
				}catch (SQLIntegrityConstraintViolationException e1) {
					JOptionPane.showMessageDialog(ventana,
							"No puedes tener dos proveedores con el mismo nombre",
							"Error", JOptionPane.ERROR_MESSAGE);

				} 
				catch (SQLException | TelefonoInvalidoExceptions | nombreInvalidoExceptions e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}
}
