package elementosVisuales;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import clases.Campo;
import clases.Trabajador;
import pantallas.Ventana;

/**
 * Clase que extiende de JPanel es una lista de los campos de la empresa
 * 
 * @author Juanmi
 *
 */
public class ElementosListaCampos extends JPanel {
	/** ventana sobre la que se mostrara la lista **/
	private Ventana ventana;
	/** campo sobre el que se mostrara la informacion **/
	private Campo campo;

	/**
	 * Constructor que crea una lista de campos, con los registros de los campos y
	 * se muestran automaticamente. * Tambien contiene todas las propiedades de
	 * dicha lista
	 * 
	 * @param v ventana sobre la que aprece la lista
	 * @param c campo del que se mostrara la informacion
	 */
	public ElementosListaCampos(Ventana v, final Campo c) {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.ventana = v;
		this.campo = c;
		this.setMaximumSize(new Dimension(80000, 70));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 68, 80, 79, 84, 90, 58, 0 };
		gridBagLayout.rowHeights = new int[] { 37, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel_1 = new JLabel("Plantaci\u00F3n");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Provincia");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Superficie");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 0;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(".\\imagenes\\iconoCampo.png"));
		GridBagConstraints gbc_icono = new GridBagConstraints();
		gbc_icono.gridheight = 3;
		gbc_icono.insets = new Insets(0, 0, 0, 5);
		gbc_icono.gridx = 0;
		gbc_icono.gridy = 1;
		add(icono, gbc_icono);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel etiquetaNombre = new JLabel(c.getNombre());
		etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.gridheight = 3;
		gbc_etiquetaNombre.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaNombre.gridx = 1;
		gbc_etiquetaNombre.gridy = 1;
		add(etiquetaNombre, gbc_etiquetaNombre);

		JLabel etiquetaPlantacion = new JLabel(c.getPlantacion().toString());
		etiquetaPlantacion.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaPlantacion = new GridBagConstraints();
		gbc_etiquetaPlantacion.gridheight = 3;
		gbc_etiquetaPlantacion.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaPlantacion.gridx = 2;
		gbc_etiquetaPlantacion.gridy = 1;
		add(etiquetaPlantacion, gbc_etiquetaPlantacion);

		JLabel etiquetaProvincia = new JLabel(c.getProvincia().toString());
		etiquetaProvincia.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaProvincia = new GridBagConstraints();
		gbc_etiquetaProvincia.gridheight = 3;
		gbc_etiquetaProvincia.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaProvincia.gridx = 3;
		gbc_etiquetaProvincia.gridy = 1;
		add(etiquetaProvincia, gbc_etiquetaProvincia);

		JButton botonBorrar = new JButton("");

		botonBorrar.setIcon(new ImageIcon(".\\imagenes\\borrar.png"));
		GridBagConstraints gbc_botonBorrar = new GridBagConstraints();
		gbc_botonBorrar.gridheight = 4;
		gbc_botonBorrar.gridx = 5;
		gbc_botonBorrar.gridy = 0;
		add(botonBorrar, gbc_botonBorrar);

		JLabel lblNewLabel_4 = new JLabel(String.valueOf(c.getSuperficie()));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridheight = 3;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 1;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		botonBorrar.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar en el boton borrar elimina un campo de la lista y de la
			 * base de datos
			 * 
			 * @param e evento de clicarr
			 */
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				c.eliminar();
				JOptionPane.showConfirmDialog(ventana, "Campo eliminado", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
			}
		});

	}
}
