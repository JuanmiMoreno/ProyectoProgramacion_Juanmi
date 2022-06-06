package elementosVisuales;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import clases.Tractor;
import exceptions.nombreInvalidoExceptions;
import pantallas.Ventana;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

public class ElementosListaTractor extends JPanel {
	
	private Ventana ventana;
	private Tractor tractor;
	
	public ElementosListaTractor (Ventana v, final Tractor tr) {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	this.ventana=v;
	this.setMaximumSize(new Dimension(800,70));
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{75, 86, 91, 136, 70, 0};
	gridBagLayout.rowHeights = new int[]{35, 0, 0};
	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	setLayout(gridBagLayout);
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon(".\\imagenes\\tractor.png"));
	GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	gbc_lblNewLabel.gridheight = 2;
	gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
	gbc_lblNewLabel.gridx = 0;
	gbc_lblNewLabel.gridy = 0;
	add(lblNewLabel, gbc_lblNewLabel);
	
	JLabel etiquetaMarca = new JLabel(tr.getMarca());
	etiquetaMarca.setFont(new Font("Arial", Font.BOLD, 15));
	GridBagConstraints gbc_etiquetaMarca = new GridBagConstraints();
	gbc_etiquetaMarca.gridheight = 2;
	gbc_etiquetaMarca.insets = new Insets(0, 0, 0, 5);
	gbc_etiquetaMarca.gridx = 1;
	gbc_etiquetaMarca.gridy = 0;
	add(etiquetaMarca, gbc_etiquetaMarca);
	
	JLabel etiquetaModelo = new JLabel(tr.getModelo());
	etiquetaModelo.setFont(new Font("Arial", Font.BOLD, 15));
	GridBagConstraints gbc_etiquetaModelo = new GridBagConstraints();
	gbc_etiquetaModelo.gridheight = 2;
	gbc_etiquetaModelo.insets = new Insets(0, 0, 0, 5);
	gbc_etiquetaModelo.gridx = 2;
	gbc_etiquetaModelo.gridy = 0;
	add(etiquetaModelo, gbc_etiquetaModelo);
	
	JLabel lblNewLabel_1 = new JLabel("");
	lblNewLabel_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			setVisible(false);
		
			tr.eliminar();
		JOptionPane.showMessageDialog(ventana, "Tractor eliminado","Error",JOptionPane.INFORMATION_MESSAGE);
	
		}
	});
	lblNewLabel_1.setIcon(new ImageIcon(".\\imagenes\\borrar.png"));
	GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
	gbc_lblNewLabel_1.gridheight = 2;
	gbc_lblNewLabel_1.gridx = 4;
	gbc_lblNewLabel_1.gridy = 0;
	add(lblNewLabel_1, gbc_lblNewLabel_1);
	
	

}
}
