package elementosVisuales;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import clases.Proveedor;
import pantallas.Ventana;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Font;

public class ElementosListaProveedor  extends JPanel{
	
	private Ventana ventana;
	private Proveedor proveedor;
	
	public ElementosListaProveedor (Ventana v, Proveedor pr) {
		
		this.ventana = v;
		this.proveedor = pr;
		
		setBorder(new LineBorder(new Color(218, 165, 32), 3, true));
		this.setMaximumSize(new Dimension(80000,70));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{67, 0, 109, 35, 75, 0, 49, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 27, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\imagenes\\proveedor.png"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaNombre.gridx = 2;
		gbc_etiquetaNombre.gridy = 0;
		add(etiquetaNombre, gbc_etiquetaNombre);
		
		JLabel etiquetaTelefono = new JLabel("Telefono");
		etiquetaTelefono.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_etiquetaTelefono = new GridBagConstraints();
		gbc_etiquetaTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaTelefono.gridx = 4;
		gbc_etiquetaTelefono.gridy = 0;
		add(etiquetaTelefono, gbc_etiquetaTelefono);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(".\\imagenes\\borrar.png"));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridheight = 3;
		gbc_lblNewLabel_1.gridx = 6;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(pr.getNombre());
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridheight = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(pr.getTelefono());
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridheight = 2;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 1;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		
	}
	

}
