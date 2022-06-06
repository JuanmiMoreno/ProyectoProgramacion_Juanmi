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
		gridBagLayout.columnWidths = new int[]{67, 0, 53, 48, 69, 41, 0};
		gridBagLayout.rowHeights = new int[]{0, 22, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel fotoUsuario = new JLabel("");
		fotoUsuario.setIcon(new ImageIcon("C:\\Users\\34622\\Desktop\\CURSO21-22 CENEC\\ProyectoProgramacion_Juanmi\\ProyectoJuanmi\\imagenes\\usuarioIcono.png"));
		GridBagConstraints gbc_fotoUsuario = new GridBagConstraints();
		gbc_fotoUsuario.gridheight = 2;
		gbc_fotoUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_fotoUsuario.gridx = 0;
		gbc_fotoUsuario.gridy = 0;
		add(fotoUsuario, gbc_fotoUsuario);
		
		JLabel etiquetaNombre = new JLabel(tr.getNombre());
		etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.gridheight = 2;
		gbc_etiquetaNombre.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaNombre.gridx = 1;
		gbc_etiquetaNombre.gridy = 0;
		add(etiquetaNombre, gbc_etiquetaNombre);
		
		JLabel etiquetaApellido = new JLabel(tr.getApellido());
		etiquetaApellido.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_etiquetaApellido = new GridBagConstraints();
		gbc_etiquetaApellido.gridheight = 2;
		gbc_etiquetaApellido.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaApellido.gridx = 2;
		gbc_etiquetaApellido.gridy = 0;
		add(etiquetaApellido, gbc_etiquetaApellido);
		
		JLabel etiquetaDNI = new JLabel(tr.getDni());
		etiquetaDNI.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_etiquetaDNI = new GridBagConstraints();
		gbc_etiquetaDNI.gridheight = 2;
		gbc_etiquetaDNI.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaDNI.gridx = 3;
		gbc_etiquetaDNI.gridy = 0;
		add(etiquetaDNI, gbc_etiquetaDNI);
		
		JButton botonBorrar = new JButton("");
		botonBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				tr.eliminar();
			}
		});
		botonBorrar.setIcon(new ImageIcon("C:\\Users\\34622\\Desktop\\CURSO21-22 CENEC\\ProyectoProgramacion_Juanmi\\ProyectoJuanmi\\imagenes\\borrar.png"));
		GridBagConstraints gbc_botonBorrar = new GridBagConstraints();
		gbc_botonBorrar.gridheight = 2;
		gbc_botonBorrar.gridx = 5;
		gbc_botonBorrar.gridy = 0;
		add(botonBorrar, gbc_botonBorrar);
		
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
