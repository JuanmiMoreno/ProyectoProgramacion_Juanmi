package elementosVisuales;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import clases.Actividad;
import clases.Trabajador;
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

public class ElementosListaActividades extends JPanel{
	
	private Ventana ventana;
	private Actividad actividades;
	
	public ElementosListaActividades (Ventana v, final Actividad ac) {
		this.actividades = ac;
		this.ventana = v;
		
		setBorder(new LineBorder(new Color(218, 165, 32), 3, true));
		this.setMaximumSize(new Dimension(80000,70));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{67, 0, 108, 118, 83, 75, 0, 49, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 27, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(".\\imagenes\\iconoActividad.png"));
		GridBagConstraints gbc_icono = new GridBagConstraints();
		gbc_icono.gridheight = 3;
		gbc_icono.insets = new Insets(0, 0, 0, 5);
		gbc_icono.gridx = 0;
		gbc_icono.gridy = 0;
		add(icono, gbc_icono);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("Duraci\u00F3n(Dias)");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 0;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Campo");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tractor");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 0;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Apero");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 6;
		gbc_lblNewLabel_4.gridy = 0;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel etiquetaNombre = new JLabel(ac.getNombre());
		etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.gridheight = 2;
		gbc_etiquetaNombre.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaNombre.gridx = 1;
		gbc_etiquetaNombre.gridy = 1;
		add(etiquetaNombre, gbc_etiquetaNombre);
		
		JLabel etiquetaDescripcion = new JLabel(ac.getDescripcion());
		etiquetaDescripcion.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaDescripcion = new GridBagConstraints();
		gbc_etiquetaDescripcion.gridheight = 2;
		gbc_etiquetaDescripcion.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaDescripcion.gridx = 2;
		gbc_etiquetaDescripcion.gridy = 1;
		add(etiquetaDescripcion, gbc_etiquetaDescripcion);
		
		JLabel etiquetaDuracion = new JLabel(String.valueOf(ac.getDuracion()));
		etiquetaDuracion.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaDuracion = new GridBagConstraints();
		gbc_etiquetaDuracion.gridheight = 2;
		gbc_etiquetaDuracion.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaDuracion.gridx = 3;
		gbc_etiquetaDuracion.gridy = 1;
		add(etiquetaDuracion, gbc_etiquetaDuracion);
		
		JLabel etiquetaCampo = new JLabel(ac.getCampo());
		etiquetaCampo.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaCampo = new GridBagConstraints();
		gbc_etiquetaCampo.gridheight = 2;
		gbc_etiquetaCampo.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaCampo.gridx = 4;
		gbc_etiquetaCampo.gridy = 1;
		add(etiquetaCampo, gbc_etiquetaCampo);
		
		JButton botonBorrar = new JButton("");
		botonBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				ac.eliminar();
				JOptionPane.showMessageDialog(ventana, "Actividad eliminada","Eliminada",JOptionPane.INFORMATION_MESSAGE);

			}
		});
		
		JLabel etiquetaTractor = new JLabel(ac.getModeloTractor());
		etiquetaTractor.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_etiquetaTractor = new GridBagConstraints();
		gbc_etiquetaTractor.gridheight = 2;
		gbc_etiquetaTractor.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaTractor.gridx = 5;
		gbc_etiquetaTractor.gridy = 1;
		add(etiquetaTractor, gbc_etiquetaTractor);
		
		JLabel etiquetaApero = new JLabel(ac.getModeloApero());
		etiquetaApero.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaApero = new GridBagConstraints();
		gbc_etiquetaApero.gridheight = 2;
		gbc_etiquetaApero.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaApero.gridx = 6;
		gbc_etiquetaApero.gridy = 1;
		add(etiquetaApero, gbc_etiquetaApero);
		botonBorrar.setIcon(new ImageIcon(".\\imagenes\\borrar.png"));
		GridBagConstraints gbc_botonBorrar = new GridBagConstraints();
		gbc_botonBorrar.gridheight = 2;
		gbc_botonBorrar.gridx = 7;
		gbc_botonBorrar.gridy = 1;
		add(botonBorrar, gbc_botonBorrar);
		
	}

}
