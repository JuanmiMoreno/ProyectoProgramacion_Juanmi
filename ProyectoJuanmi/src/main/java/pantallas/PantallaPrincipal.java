package pantallas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Clase que extiende de JPanel es la pantalla principal del programa donde esta
 * los distintos botones para ir a las diferentes pantalla , el boton de salir y
 * un boton de informacion que recorre todo los archivos y leer las
 * instrucciones del readme
 * 
 * @author Juanmi
 *
 */
public class PantallaPrincipal extends JPanel {
	/** ventana sobre la que aprece la pantalla **/
	private Ventana ventana;

	/**
	 * Construnctor que crea la pantalla princiapal del programa , contiene los
	 * botones para dirigirnos a las diferentes pantallas, un boton de salir para
	 * abandonar la aplicacion y un boton de informacion donde se recorre todos los
	 * archivos y se muestra el Readme. Tambien contiene todas las propiedades de
	 * dicha pantalla
	 * 
	 * @param v es la ventana en la que aparece la pantalla
	 */
	public PantallaPrincipal(final Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 28, 116, 151, 140, 83, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 54, 0, 0, 0, 0, 50, 36, 0, 29, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel etiquetaTitulo = new JLabel("Agro Manager");
		etiquetaTitulo.setForeground(Color.BLACK);
		etiquetaTitulo.setBackground(Color.GRAY);
		etiquetaTitulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
		GridBagConstraints gbc_etiquetaTitulo = new GridBagConstraints();
		gbc_etiquetaTitulo.anchor = GridBagConstraints.SOUTH;
		gbc_etiquetaTitulo.gridheight = 2;
		gbc_etiquetaTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_etiquetaTitulo.gridwidth = 6;
		gbc_etiquetaTitulo.gridx = 0;
		gbc_etiquetaTitulo.gridy = 0;
		add(etiquetaTitulo, gbc_etiquetaTitulo);

		JButton botonPersonal = new JButton("Personal");
		botonPersonal.setBackground(new Color(204, 204, 153));
		botonPersonal.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar en el boton personal va hacia la pantalla de
			 * trabajadores
			 * 
			 * @param e evento de clicar
			 */
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantallas("personal");
			}
		});

		JLabel etiquetaNombreEmpresa = new JLabel(v.empresaLogada.nombre);
		etiquetaNombreEmpresa.setForeground(Color.WHITE);
		etiquetaNombreEmpresa.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		GridBagConstraints gbc_etiquetaNombreEmpresa = new GridBagConstraints();
		gbc_etiquetaNombreEmpresa.anchor = GridBagConstraints.SOUTH;
		gbc_etiquetaNombreEmpresa.gridheight = 2;
		gbc_etiquetaNombreEmpresa.gridwidth = 6;
		gbc_etiquetaNombreEmpresa.insets = new Insets(0, 0, 5, 0);
		gbc_etiquetaNombreEmpresa.gridx = 0;
		gbc_etiquetaNombreEmpresa.gridy = 4;
		add(etiquetaNombreEmpresa, gbc_etiquetaNombreEmpresa);

		JButton botonActividad = new JButton("Actividad");
		botonActividad.setBackground(new Color(204, 204, 153));

		botonActividad.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonActividad = new GridBagConstraints();
		gbc_botonActividad.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonActividad.insets = new Insets(0, 0, 5, 5);
		gbc_botonActividad.gridx = 1;
		gbc_botonActividad.gridy = 7;
		add(botonActividad, gbc_botonActividad);
		botonActividad.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar en el boton actividad va hacia la pantalla actividad
			 * 
			 * @param e evento de clicar
			 */
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantallas("actividad");
			}
		});

		JButton botonCampos = new JButton("Campos");
		botonCampos.setBackground(new Color(204, 204, 153));

		botonCampos.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonCampos = new GridBagConstraints();
		gbc_botonCampos.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonCampos.insets = new Insets(0, 0, 5, 5);
		gbc_botonCampos.gridx = 2;
		gbc_botonCampos.gridy = 7;
		add(botonCampos, gbc_botonCampos);

		botonCampos.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar en el boton campos va hacia la pantalla campos
			 * 
			 * @param e evento de clicar
			 */
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantallas("campos");
			}
		});
		botonPersonal.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonPersonal = new GridBagConstraints();
		gbc_botonPersonal.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonPersonal.insets = new Insets(0, 0, 5, 5);
		gbc_botonPersonal.gridx = 3;
		gbc_botonPersonal.gridy = 7;
		add(botonPersonal, gbc_botonPersonal);

		JButton botonProveedor = new JButton("Proveedores");
		botonProveedor.setBackground(new Color(204, 204, 153));
		botonProveedor.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar en el boton proveedor va hacia la pantalla proveedor
			 * 
			 * @param e evento de clicar
			 */
			public void mouseClicked(MouseEvent e) {
				v.cambiarPantallas("proveedor");
			}
		});
		botonProveedor.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonProveedor = new GridBagConstraints();
		gbc_botonProveedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_botonProveedor.gridx = 4;
		gbc_botonProveedor.gridy = 7;
		add(botonProveedor, gbc_botonProveedor);

		JButton botonApero = new JButton("Aperos");
		botonApero.setBackground(new Color(204, 204, 153));
		botonApero.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar en el boton apero va hacia la pantalla apero
			 * 
			 * @param e evento de clicar
			 */
			public void mouseClicked(MouseEvent e) {
				v.cambiarPantallas("apero");
			}
		});

		JButton botonTractor = new JButton("Tractores");
		botonTractor.setBackground(new Color(204, 204, 153));
		botonTractor.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar en el boton tractores va hacia la pantalla tractores
			 * 
			 * @param e evento de clicar
			 */
			public void mouseClicked(MouseEvent e) {
				v.cambiarPantallas("tractores");
			}
		});
		botonTractor.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonTractor = new GridBagConstraints();
		gbc_botonTractor.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonTractor.insets = new Insets(0, 0, 5, 5);
		gbc_botonTractor.gridx = 2;
		gbc_botonTractor.gridy = 9;
		add(botonTractor, gbc_botonTractor);
		botonApero.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonApero = new GridBagConstraints();
		gbc_botonApero.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonApero.insets = new Insets(0, 0, 5, 5);
		gbc_botonApero.gridx = 3;
		gbc_botonApero.gridy = 9;
		add(botonApero, gbc_botonApero);

		JButton botonSalir = new JButton("Salir");
		botonSalir.setIcon(new ImageIcon(".\\imagenes\\cerrar.png"));
		botonSalir.setBackground(new Color(204, 153, 102));

		botonSalir.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_botonSalir = new GridBagConstraints();
		gbc_botonSalir.gridwidth = 2;
		gbc_botonSalir.insets = new Insets(0, 0, 5, 5);
		gbc_botonSalir.gridx = 2;
		gbc_botonSalir.gridy = 11;
		add(botonSalir, gbc_botonSalir);
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar en el boton salir salta un sonido y una ventana
			 * emergente asegurandote antes de salir de la aplicacion
			 * 
			 * @param e evento de clicar
			 */
			public void mouseClicked(MouseEvent e) {
				AudioInputStream audioInputStream;
				try {
					audioInputStream = AudioSystem.getAudioInputStream(new File("sonido/salir.wav"));
					Clip clip;
					clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {

					e1.printStackTrace();
				}
				int opcion = JOptionPane.showConfirmDialog(ventana, "¿Seguro que quieres salir?", "CUIDADO",
						JOptionPane.WARNING_MESSAGE);

				if (opcion == 0) {

					System.exit(0);
				} else {
					JOptionPane.showMessageDialog(ventana, "Operacion cancelada", "Cancelado",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		JButton botonAyuda = new JButton("");
		botonAyuda.setBackground(new Color(204, 153, 102));

		botonAyuda.setIcon(new ImageIcon(".\\imagenes\\informacion.png"));
		botonAyuda.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		GridBagConstraints gbc_botonAyuda = new GridBagConstraints();
		gbc_botonAyuda.insets = new Insets(0, 0, 5, 5);
		gbc_botonAyuda.gridx = 4;
		gbc_botonAyuda.gridy = 11;
		add(botonAyuda, gbc_botonAyuda);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\imagenes\\fondoPrincipal.png"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.gridheight = 13;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		botonAyuda.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Funcion que al clicar el boton ayudar salta una ventana emergente en la que
			 * se muestra el readme. Para ello se recorren todos los archivos hasta
			 * encontrarlos
			 * 
			 * @param e evento de clicar
			 */
			public void mouseClicked(MouseEvent e) {

				try {
					AudioInputStream audioInputStream;
					audioInputStream = AudioSystem.getAudioInputStream(new File("sonido/info.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
					String texto = "";
					InputStream is = new FileInputStream("./Readme.md");
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					String linea;
					while ((linea = br.readLine()) != null) {
						texto += linea + "\n";
					}
					JOptionPane.showMessageDialog(null, texto);

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {

				}

			}
		});

	}
}
