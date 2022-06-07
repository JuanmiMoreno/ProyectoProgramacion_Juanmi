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

public class ElementosListaCampos extends JPanel{
	private Ventana ventana;
	private Campo campo;
	
	public ElementosListaCampos(Ventana v, final Campo c) {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.ventana=v;
		this.campo = c;
		this.setMaximumSize(new Dimension(80000,70));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{68, 47, 57, 71, 136, 58, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon("C:\\Users\\34622\\Desktop\\CURSO21-22 CENEC\\ProyectoProgramacion_Juanmi\\ProyectoJuanmi\\imagenes\\iconoCampo.png"));
		GridBagConstraints gbc_icono = new GridBagConstraints();
		gbc_icono.gridheight = 3;
		gbc_icono.insets = new Insets(0, 0, 0, 5);
		gbc_icono.gridx = 0;
		gbc_icono.gridy = 0;
		add(icono, gbc_icono);
		
		JLabel etiquetaNombre = new JLabel(c.getNombre());
		etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.gridheight = 3;
		gbc_etiquetaNombre.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaNombre.gridx = 1;
		gbc_etiquetaNombre.gridy = 0;
		add(etiquetaNombre, gbc_etiquetaNombre);
		
		JLabel etiquetaPlantacion = new JLabel(c.getPlantacion().toString());
		etiquetaPlantacion.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaPlantacion = new GridBagConstraints();
		gbc_etiquetaPlantacion.gridheight = 3;
		gbc_etiquetaPlantacion.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaPlantacion.gridx = 2;
		gbc_etiquetaPlantacion.gridy = 0;
		add(etiquetaPlantacion, gbc_etiquetaPlantacion);
		
		JLabel etiquetaProvincia = new JLabel(c.getProvincia().toString());
		etiquetaProvincia.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_etiquetaProvincia = new GridBagConstraints();
		gbc_etiquetaProvincia.gridheight = 3;
		gbc_etiquetaProvincia.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaProvincia.gridx = 3;
		gbc_etiquetaProvincia.gridy = 0;
		add(etiquetaProvincia, gbc_etiquetaProvincia);
		
		JButton botonBorrar = new JButton("");

		botonBorrar.setIcon(new ImageIcon(".\\imagenes\\borrar.png"));
		GridBagConstraints gbc_botonBorrar = new GridBagConstraints();
		gbc_botonBorrar.gridheight = 3;
		gbc_botonBorrar.insets = new Insets(0, 0, 5, 0);
		gbc_botonBorrar.gridx = 5;
		gbc_botonBorrar.gridy = 0;
		add(botonBorrar, gbc_botonBorrar);
		
		botonBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				c.eliminar();
			JOptionPane.showConfirmDialog(ventana, "Campo eliminado","Eliminado",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
	}
}
