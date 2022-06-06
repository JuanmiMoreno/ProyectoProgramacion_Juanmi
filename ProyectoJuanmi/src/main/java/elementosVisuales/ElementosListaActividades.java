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
		gridBagLayout.columnWidths = new int[]{67, 0, 108, 48, 75, 30, 49, 0};
		gridBagLayout.rowHeights = new int[]{0, 27, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(".\\imagenes\\iconoActividad.png"));
		GridBagConstraints gbc_icono = new GridBagConstraints();
		gbc_icono.gridheight = 2;
		gbc_icono.insets = new Insets(0, 0, 0, 5);
		gbc_icono.gridx = 0;
		gbc_icono.gridy = 0;
		add(icono, gbc_icono);
		
		JLabel etiquetaNombre = new JLabel(ac.getNombre());
		etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.gridheight = 2;
		gbc_etiquetaNombre.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaNombre.gridx = 1;
		gbc_etiquetaNombre.gridy = 0;
		add(etiquetaNombre, gbc_etiquetaNombre);
		
		JLabel etiquetaDescripcion = new JLabel(ac.getDescripcion());
		etiquetaDescripcion.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaDescripcion = new GridBagConstraints();
		gbc_etiquetaDescripcion.gridheight = 2;
		gbc_etiquetaDescripcion.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaDescripcion.gridx = 2;
		gbc_etiquetaDescripcion.gridy = 0;
		add(etiquetaDescripcion, gbc_etiquetaDescripcion);
		
		/*JLabel etiquetaDuracion = new JLabel(ac.getDuracion());
		etiquetaDuracion.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaDuracion = new GridBagConstraints();
		gbc_etiquetaDuracion.gridheight = 2;
		gbc_etiquetaDuracion.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaDuracion.gridx = 3;
		gbc_etiquetaDuracion.gridy = 0;
		add(etiquetaDuracion, gbc_etiquetaDuracion);*/
		
		JLabel etiquetaCampo = new JLabel(ac.getCampo());
		etiquetaCampo.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaCampo = new GridBagConstraints();
		gbc_etiquetaCampo.gridheight = 2;
		gbc_etiquetaCampo.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaCampo.gridx = 4;
		gbc_etiquetaCampo.gridy = 0;
		add(etiquetaCampo, gbc_etiquetaCampo);
		
		JButton botonBorrar = new JButton("");
		botonBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				ac.eliminar();
				JOptionPane.showConfirmDialog(ventana, "Actividad eliminada","Eliminada",JOptionPane.INFORMATION_MESSAGE);

			}
		});
		botonBorrar.setIcon(new ImageIcon(".\\imagenes\\borrar.png"));
		GridBagConstraints gbc_botonBorrar = new GridBagConstraints();
		gbc_botonBorrar.gridheight = 2;
		gbc_botonBorrar.gridx = 6;
		gbc_botonBorrar.gridy = 0;
		add(botonBorrar, gbc_botonBorrar);
		
	}

}
