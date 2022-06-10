package elementosVisuales;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import clases.Trabajador;
import clases.Usuario;
import pantallas.Ventana;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ElementosListraTrabajador extends JPanel {

	private Ventana ventana;
	private Trabajador trabajador;
	
	public ElementosListraTrabajador(Ventana v, final Trabajador tr) {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.ventana=v;
		this.trabajador=tr;
		this.setMaximumSize(new Dimension(80000,70));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{67, 0, 86, 48, 55, 41, 0};
		gridBagLayout.rowHeights = new int[]{31, 22, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel fotoUsuario = new JLabel("");
		fotoUsuario.setIcon(new ImageIcon(".\\imagenes\\usuarioIcono.png"));
		GridBagConstraints gbc_fotoUsuario = new GridBagConstraints();
		gbc_fotoUsuario.gridheight = 3;
		gbc_fotoUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_fotoUsuario.gridx = 0;
		gbc_fotoUsuario.gridy = 0;
		add(fotoUsuario, gbc_fotoUsuario);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DNI");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sueldo");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 0;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel etiquetaNombre = new JLabel(tr.getNombre());
		etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.gridheight = 2;
		gbc_etiquetaNombre.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaNombre.gridx = 1;
		gbc_etiquetaNombre.gridy = 1;
		add(etiquetaNombre, gbc_etiquetaNombre);
		
		JLabel etiquetaApellido = new JLabel(tr.getApellido());
		etiquetaApellido.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaApellido = new GridBagConstraints();
		gbc_etiquetaApellido.gridheight = 2;
		gbc_etiquetaApellido.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaApellido.gridx = 2;
		gbc_etiquetaApellido.gridy = 1;
		add(etiquetaApellido, gbc_etiquetaApellido);
		
		JLabel etiquetaDNI = new JLabel(tr.getDni());
		etiquetaDNI.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaDNI = new GridBagConstraints();
		gbc_etiquetaDNI.gridheight = 2;
		gbc_etiquetaDNI.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaDNI.gridx = 3;
		gbc_etiquetaDNI.gridy = 1;
		add(etiquetaDNI, gbc_etiquetaDNI);
		
		JButton botonBorrar = new JButton("");
		botonBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				tr.eliminar();
			}
		});
		

		botonBorrar.setIcon(new ImageIcon(".\\imagenes\\borrar.png"));
		GridBagConstraints gbc_botonBorrar = new GridBagConstraints();
		gbc_botonBorrar.gridheight = 3;
		gbc_botonBorrar.gridx = 5;
		gbc_botonBorrar.gridy = 0;
		add(botonBorrar, gbc_botonBorrar);
		
		JLabel lblNewLabel_4 = new JLabel(String.valueOf(tr.getDinero()));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridheight = 2;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 1;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
	
		
		JLabel labelNombre = new JLabel("nombre");
		labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		labelNombre.setFont(new Font("Segoe UI", Font.BOLD, 17));
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.anchor = GridBagConstraints.WEST;
		gbc_labelNombre.gridwidth = 3;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 1;
		gbc_labelNombre.gridy = 0;
		
		
}
}
