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

public class ElementosListaAperos extends JPanel{
	
	private Ventana ventana;
	private Apero apero;
	
	public ElementosListaAperos(Ventana v, final Apero ap) {
		this.apero = ap;
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	this.ventana=v;
	this.setMaximumSize(new Dimension(8000,70));
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{75, 86, 91, 0, 136, 70, 0};
	gridBagLayout.rowHeights = new int[]{35, 0, 0};
	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	setLayout(gridBagLayout);
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon(".\\imagenes\\arado.png"));
	GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	gbc_lblNewLabel.gridheight = 2;
	gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
	gbc_lblNewLabel.gridx = 0;
	gbc_lblNewLabel.gridy = 0;
	add(lblNewLabel, gbc_lblNewLabel);
	
	JLabel etiquetaMarca = new JLabel(ap.getMarca());
	etiquetaMarca.setFont(new Font("Arial", Font.BOLD, 12));
	GridBagConstraints gbc_etiquetaMarca = new GridBagConstraints();
	gbc_etiquetaMarca.gridheight = 2;
	gbc_etiquetaMarca.insets = new Insets(0, 0, 0, 5);
	gbc_etiquetaMarca.gridx = 1;
	gbc_etiquetaMarca.gridy = 0;
	add(etiquetaMarca, gbc_etiquetaMarca);
	
	JLabel etiquetaModelo = new JLabel(ap.getModelo());
	etiquetaModelo.setFont(new Font("Arial", Font.BOLD, 12));
	GridBagConstraints gbc_etiquetaModelo = new GridBagConstraints();
	gbc_etiquetaModelo.gridheight = 2;
	gbc_etiquetaModelo.insets = new Insets(0, 0, 0, 5);
	gbc_etiquetaModelo.gridx = 2;
	gbc_etiquetaModelo.gridy = 0;
	add(etiquetaModelo, gbc_etiquetaModelo);
	
	JLabel etiquetaTipo = new JLabel(ap.getTipo().toString());
	etiquetaTipo.setFont(new Font("Arial", Font.BOLD, 12));
	GridBagConstraints gbc_etiquetaTipo = new GridBagConstraints();
	gbc_etiquetaTipo.gridheight = 2;
	gbc_etiquetaTipo.insets = new Insets(0, 0, 0, 5);
	gbc_etiquetaTipo.gridx = 3;
	gbc_etiquetaTipo.gridy = 0;
	add(etiquetaTipo, gbc_etiquetaTipo);
	
	JButton btnNewButton = new JButton("");
	btnNewButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			setVisible(false);
			ap.eliminar();
			JOptionPane.showMessageDialog(ventana, "Apero eliminado","Eliminado",JOptionPane.INFORMATION_MESSAGE);

		}
	});
	btnNewButton.setIcon(new ImageIcon(".\\imagenes\\borrar.png"));
	GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
	gbc_btnNewButton.gridheight = 2;
	gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
	gbc_btnNewButton.gridx = 5;
	gbc_btnNewButton.gridy = 0;
	add(btnNewButton, gbc_btnNewButton);
	
		
	}

}
