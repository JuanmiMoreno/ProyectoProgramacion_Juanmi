package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clases.Campo;
import clases.Usuario;

import javax.swing.JComboBox;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import enums.Provincia;
import javax.swing.JCheckBox;
import enums.TipoPlantacion;
import exceptions.nombreInvalidoExceptions;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.SystemColor;

public class PantallaCampo extends JPanel{
	
	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoSuperficie;
	
	public PantallaCampo (Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, -11, 0, 0, 0, 46, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 46, 23};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 22, 19, 47, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		JLabel etiquetaTitulo = new JLabel("Campos");
		etiquetaTitulo.setForeground(new Color(255, 255, 255));
		etiquetaTitulo.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 50));
		GridBagConstraints gbc_etiquetaTitulo = new GridBagConstraints();
		gbc_etiquetaTitulo.anchor = GridBagConstraints.SOUTH;
		gbc_etiquetaTitulo.gridwidth = 17;
		gbc_etiquetaTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaTitulo.gridx = 0;
		gbc_etiquetaTitulo.gridy = 0;
		add(etiquetaTitulo, gbc_etiquetaTitulo);
		
		JLabel lblNewLabel = new JLabel("Nombre del campo");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Registros de campos");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 22));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 9;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 6;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JList listaCampos = new JList();
		listaCampos.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_listaCampos = new GridBagConstraints();
		gbc_listaCampos.gridheight = 7;
		gbc_listaCampos.gridwidth = 11;
		gbc_listaCampos.insets = new Insets(0, 0, 5, 5);
		gbc_listaCampos.fill = GridBagConstraints.BOTH;
		gbc_listaCampos.gridx = 6;
		gbc_listaCampos.gridy = 3;
		add(listaCampos, gbc_listaCampos);
		
		/*final ArrayList<Campo> todos=Campo.getTodos();

		listaCampos.setModel(new AbstractListModel() {

			public int getSize() {
				return todos.size();
			}
			public Object getElementAt(int index) {
				return todos.get(index);
			}
		});
		*/
		
		campoNombre = new JTextField();
		campoNombre.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.gridwidth = 3;
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 1;
		gbc_campoNombre.gridy = 3;
		add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel etiquetaProvincia = new JLabel("Provincia");
		etiquetaProvincia.setForeground(new Color(255, 255, 255));
		etiquetaProvincia.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaProvincia = new GridBagConstraints();
		gbc_etiquetaProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaProvincia.gridx = 2;
		gbc_etiquetaProvincia.gridy = 4;
		add(etiquetaProvincia, gbc_etiquetaProvincia);
		
		final JComboBox selecctorProvincia = new JComboBox();
		selecctorProvincia.setModel(new DefaultComboBoxModel(Provincia.values()));
		GridBagConstraints gbc_selecctorProvincia = new GridBagConstraints();
		gbc_selecctorProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_selecctorProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_selecctorProvincia.gridx = 2;
		gbc_selecctorProvincia.gridy = 5;
		add(selecctorProvincia, gbc_selecctorProvincia);
		
		JLabel etiquetaPlantacion = new JLabel("Plantacion");
		etiquetaPlantacion.setForeground(new Color(255, 255, 255));
		etiquetaPlantacion.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaPlantacion = new GridBagConstraints();
		gbc_etiquetaPlantacion.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaPlantacion.gridx = 2;
		gbc_etiquetaPlantacion.gridy = 6;
		add(etiquetaPlantacion, gbc_etiquetaPlantacion);
		
		final JComboBox selectorPlantacion = new JComboBox();
		selectorPlantacion.setModel(new DefaultComboBoxModel(TipoPlantacion.values()));
		GridBagConstraints gbc_selectorPlantacion = new GridBagConstraints();
		gbc_selectorPlantacion.insets = new Insets(0, 0, 5, 5);
		gbc_selectorPlantacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectorPlantacion.gridx = 2;
		gbc_selectorPlantacion.gridy = 7;
		add(selectorPlantacion, gbc_selectorPlantacion);
		
		JLabel etiquetaSuperficie = new JLabel("Superficie");
		etiquetaSuperficie.setForeground(Color.WHITE);
		etiquetaSuperficie.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_etiquetaSuperficie = new GridBagConstraints();
		gbc_etiquetaSuperficie.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaSuperficie.gridx = 2;
		gbc_etiquetaSuperficie.gridy = 8;
		add(etiquetaSuperficie, gbc_etiquetaSuperficie);
		
		campoSuperficie = new JTextField();
		campoSuperficie.setBackground(SystemColor.info);
		GridBagConstraints gbc_campoSuperficie = new GridBagConstraints();
		gbc_campoSuperficie.insets = new Insets(0, 0, 5, 5);
		gbc_campoSuperficie.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoSuperficie.gridx = 2;
		gbc_campoSuperficie.gridy = 9;
		add(campoSuperficie, gbc_campoSuperficie);
		campoSuperficie.setColumns(10);
		
		JButton botonAñadir = new JButton("A\u00F1adir");

		botonAñadir.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonAñadir = new GridBagConstraints();
		gbc_botonAñadir.insets = new Insets(0, 0, 5, 5);
		gbc_botonAñadir.gridx = 2;
		gbc_botonAñadir.gridy = 10;
		add(botonAñadir, gbc_botonAñadir);
		
		JButton botonEliminar = new JButton("Eliminar campo");
		botonEliminar.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonEliminar = new GridBagConstraints();
		gbc_botonEliminar.anchor = GridBagConstraints.NORTH;
		gbc_botonEliminar.gridwidth = 6;
		gbc_botonEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_botonEliminar.gridx = 6;
		gbc_botonEliminar.gridy = 10;
		add(botonEliminar, gbc_botonEliminar);
		
		JButton botonVolver = new JButton("Volver");

		botonVolver.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonVolver = new GridBagConstraints();
		gbc_botonVolver.gridwidth = 4;
		gbc_botonVolver.gridx = 14;
		gbc_botonVolver.gridy = 11;
		add(botonVolver, gbc_botonVolver);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(".\\imagenes\\campos.png"));
		GridBagConstraints gbc_fondo = new GridBagConstraints();
		gbc_fondo.gridheight = 12;
		gbc_fondo.gridwidth = 18;
		gbc_fondo.insets = new Insets(0, 0, 5, 5);
		gbc_fondo.gridx = 0;
		gbc_fondo.gridy = 0;
		add(fondo, gbc_fondo);
		
	
	
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantallas("principal");
			}
		});
		
		botonAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombreCampo = campoNombre.getText();
					Provincia provincia = (Provincia)selecctorProvincia.getSelectedItem();
					TipoPlantacion plantacion = (TipoPlantacion)selectorPlantacion.getSelectedItem();
					float superficie = Float.parseFloat(campoSuperficie.getText());
					
					new Campo(nombreCampo, provincia, superficie,plantacion, ventana.empresaLogada);
					JOptionPane.showMessageDialog(ventana, "Campo insertado con exito!","Insertado con exito",JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarPantallas("campos");
					
					} catch (nombreInvalidoExceptions  | SQLException e1) {
						JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
				
					}catch(NumberFormatException  e1){
						JOptionPane.showMessageDialog(ventana, "El decimal debe ir con un punto, no con coma","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
		});
		

	}
}
