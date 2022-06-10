package elementosVisuales;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import clases.Apero;
import pantallas.Ventana;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Clase que extiende de JPanel, es una lista de aperos de la empresa
 * 
 * @author Juanmi
 *
 */
public class ElementosListaAperos extends JPanel {
	/** ventana sobre la que aparece la lista **/
	private Ventana ventana;
	/** apero sobre el que se mostrara la informacion **/
	private Apero apero;

	/**
	 * Constructor que crea una lista de aperos, con los registros de los aperos que
	 * se muestran automaticamente. * Tambien contiene todas las propiedades de
	 * dicha lista
	 * 
	 * @param v  ventana sobre la que aparece la lista
	 * @param ap apero sobre el que se mostrara la informacion
	 */
	public ElementosListaAperos(Ventana v, final Apero ap) {
		this.apero = ap;
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.ventana = v;
		this.setMaximumSize(new Dimension(8000, 70));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 75, 86, 91, 0, 136, 79, 0 };
		gridBagLayout.rowHeights = new int[] { 35, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\imagenes\\arado.png"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Que apero es");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Modelo");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tipo");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 0;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel etiquetaMarca = new JLabel(ap.getMarca());
		etiquetaMarca.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaMarca = new GridBagConstraints();
		gbc_etiquetaMarca.gridheight = 2;
		gbc_etiquetaMarca.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaMarca.gridx = 1;
		gbc_etiquetaMarca.gridy = 1;
		add(etiquetaMarca, gbc_etiquetaMarca);

		JLabel etiquetaModelo = new JLabel(ap.getModelo());
		etiquetaModelo.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaModelo = new GridBagConstraints();
		gbc_etiquetaModelo.gridheight = 2;
		gbc_etiquetaModelo.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaModelo.gridx = 2;
		gbc_etiquetaModelo.gridy = 1;
		add(etiquetaModelo, gbc_etiquetaModelo);

		JLabel etiquetaTipo = new JLabel(ap.getTipo().toString());
		etiquetaTipo.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaTipo = new GridBagConstraints();
		gbc_etiquetaTipo.gridheight = 2;
		gbc_etiquetaTipo.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaTipo.gridx = 3;
		gbc_etiquetaTipo.gridy = 1;
		add(etiquetaTipo, gbc_etiquetaTipo);

		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar en el boton borrar elimina un apero de la lista y de la
			 * base de datos
			 * 
			 * @param e evento de clicar
			 */
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				ap.eliminar();
				JOptionPane.showMessageDialog(ventana, "Apero eliminado", "Eliminado", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnNewButton.setIcon(new ImageIcon(".\\imagenes\\borrar.png"));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridheight = 3;
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);

	}

}
