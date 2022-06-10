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
import exceptions.TelefonoInvalidoExceptions;
import exceptions.nombreInvalidoExceptions;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PantallaProveedor extends JPanel {

	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoTelefono;
	
	public PantallaProveedor (final Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 27, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{40, 0, 30, 0};
		gbl_panel_1.rowHeights = new int[]{0, 17, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaNombre.gridx = 1;
		gbc_etiquetaNombre.gridy = 1;
		panel_1.add(etiquetaNombre, gbc_etiquetaNombre);
		
		campoNombre = new JTextField();
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 1;
		gbc_campoNombre.gridy = 2;
		panel_1.add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel etiquetaTelefono = new JLabel("Telefono");
		etiquetaTelefono.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaTelefono = new GridBagConstraints();
		gbc_etiquetaTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaTelefono.gridx = 1;
		gbc_etiquetaTelefono.gridy = 3;
		panel_1.add(etiquetaTelefono, gbc_etiquetaTelefono);
		
		campoTelefono = new JTextField();
		GridBagConstraints gbc_campoTelefono = new GridBagConstraints();
		gbc_campoTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_campoTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoTelefono.gridx = 1;
		gbc_campoTelefono.gridy = 4;
		panel_1.add(campoTelefono, gbc_campoTelefono);
		campoTelefono.setColumns(10);
		
		JButton btnNewButton = new JButton("A\u00F1adir");

		btnNewButton.setIcon(new ImageIcon(".\\imagenes\\a\u00F1adir.png"));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 6;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 33, 0};
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
		botonSalir.setIcon(new ImageIcon(".\\imagenes\\esquema-de-boton-circular-de-flecha-hacia-atras-izquierda.png"));
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
		gbl_panel_3.rowHeights = new int[]{0, 39, 41, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Registro de proveedores");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.gridheight = 3;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				String nombre = campoNombre.getText();
				String telefono = campoTelefono.getText();
					new Proveedor(nombre, telefono);
					
				} catch (SQLException | TelefonoInvalidoExceptions | nombreInvalidoExceptions e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
