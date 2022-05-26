package pantallas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import com.toedter.calendar.JCalendar;

public class PantallaPrincipal extends JPanel {

	private Ventana ventana;
	
	public PantallaPrincipal(Ventana v) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{28, 116, 151, 140, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 54, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel etiquetaTitulo = new JLabel("Agro Manager");
		etiquetaTitulo.setBackground(Color.GRAY);
		etiquetaTitulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
		GridBagConstraints gbc_etiquetaTitulo = new GridBagConstraints();
		gbc_etiquetaTitulo.anchor = GridBagConstraints.SOUTH;
		gbc_etiquetaTitulo.gridheight = 2;
		gbc_etiquetaTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_etiquetaTitulo.gridwidth = 5;
		gbc_etiquetaTitulo.gridx = 0;
		gbc_etiquetaTitulo.gridy = 0;
		add(etiquetaTitulo, gbc_etiquetaTitulo);
		
		JButton botonActividad = new JButton("Actividad");
		botonActividad.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonActividad = new GridBagConstraints();
		gbc_botonActividad.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonActividad.insets = new Insets(0, 0, 5, 5);
		gbc_botonActividad.gridx = 1;
		gbc_botonActividad.gridy = 3;
		add(botonActividad, gbc_botonActividad);
		
		JButton botonCampos = new JButton("Campos");
		botonCampos.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonCampos = new GridBagConstraints();
		gbc_botonCampos.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonCampos.insets = new Insets(0, 0, 5, 5);
		gbc_botonCampos.gridx = 2;
		gbc_botonCampos.gridy = 3;
		add(botonCampos, gbc_botonCampos);
		
		JButton botonPersonal = new JButton("Personal");
		botonPersonal.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonPersonal = new GridBagConstraints();
		gbc_botonPersonal.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonPersonal.insets = new Insets(0, 0, 5, 5);
		gbc_botonPersonal.gridx = 3;
		gbc_botonPersonal.gridy = 3;
		add(botonPersonal, gbc_botonPersonal);
		
		JButton botonTractor = new JButton("Tractores");
		botonTractor.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonTractor = new GridBagConstraints();
		gbc_botonTractor.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonTractor.insets = new Insets(0, 0, 5, 5);
		gbc_botonTractor.gridx = 1;
		gbc_botonTractor.gridy = 5;
		add(botonTractor, gbc_botonTractor);
		
		JButton botonApero = new JButton("Aperos");
		botonApero.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonApero = new GridBagConstraints();
		gbc_botonApero.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonApero.insets = new Insets(0, 0, 5, 5);
		gbc_botonApero.gridx = 2;
		gbc_botonApero.gridy = 5;
		add(botonApero, gbc_botonApero);
		
		JButton botonProveedor = new JButton("Proveedores");
		botonProveedor.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonProveedor = new GridBagConstraints();
		gbc_botonProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_botonProveedor.gridx = 3;
		gbc_botonProveedor.gridy = 5;
		add(botonProveedor, gbc_botonProveedor);
	}
}
