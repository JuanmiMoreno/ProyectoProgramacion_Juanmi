package pantallas;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clases.Actividad;
import clases.Empresa;
import clases.Usuario;
import exceptions.Contrase�aIncorrectaException;
import exceptions.Contrase�aVaciaExceptions;
import exceptions.UsuarioNoExisteException;
import exceptions.NombreInvalidoExceptions;

/**
 * Clase que hereda de JFrame, y que contendr� a las pantallas (Herederas de
 * JPanel) del programa.
 * 
 * @author Juanmi
 *
 */
public class Ventana extends JFrame {
	/** Pantalla actual es un JPanel de la pantalla que se muestra **/
	private JPanel pantallaActual;
	/** usuario con el que se ha inciado sesion **/
	public Usuario usuarioLogado;
	/** empresa con la que se ha iniciado sesion **/
	public Empresa empresaLogada;

	/**
	 * Constructor de ventana que contiene el logo, el tama�o , el titulo y otras
	 * propiedades Tambien contiene un autologin recibido por argumentos
	 * 
	 * @param usuario    es el nombre de usuario
	 * @param contrase�a es la contrase�a del usuario
	 * @throws SQLException              error base de datos
	 * @throws Contrase�aVaciaExceptions error que salta cuando la contrase�a esta
	 *                                   vacia
	 * @throws NombreInvalidoExceptions  error que salta cuando el nombre esta vacio
	 */
	public Ventana(String usuario, String contrase�a)
			throws SQLException, Contrase�aVaciaExceptions, NombreInvalidoExceptions {
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);

		this.setIconImage(new ImageIcon("./imagenes/logo.png").getImage());
		this.setTitle("Agro Manager");

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		if (usuario != null && contrase�a != null) {
			try {
				this.usuarioLogado = new Usuario(usuario, contrase�a);
				this.pantallaActual = new PantallaEmpresa(this);
				this.setContentPane(pantallaActual);
				JOptionPane.showMessageDialog(pantallaActual,
						"Sesion iniciada con argumentos, Bienvenido " + usuarioLogado.getNombre(), "Sesion Iniciada",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (SQLException | Contrase�aIncorrectaException | UsuarioNoExisteException
					| NombreInvalidoExceptions e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(pantallaActual, "No se ha podido inciar sesion por argumentos", "Error",
						JOptionPane.ERROR_MESSAGE);
				this.pantallaActual = new PantallaInicioPrograma(this);
				this.setContentPane(pantallaActual);
			}
		} else {
			JOptionPane.showMessageDialog(pantallaActual, "No se ha podido inciar sesion por argumentos", "Error",
					JOptionPane.ERROR_MESSAGE);
			this.pantallaActual = new PantallaInicioPrograma(this);
			this.setContentPane(pantallaActual);
		}
		this.setResizable(false);
		this.setVisible(true);

	}

	/**
	 * Funcion que sirve para cambiar de pantalla segun el nombre
	 * 
	 * @param nombrePantalla es el nombre de la pantalla a la que se va a cambiar
	 */
	public void cambiarPantallas(String nombrePantalla) {
		this.pantallaActual.setVisible(false);
		this.pantallaActual = null;
		switch (nombrePantalla) {

		case "principal":
			this.pantallaActual = new PantallaPrincipal(this);
			break;

		case "login":
			this.pantallaActual = new PantallaLogin(this);
			break;

		case "registro":
			this.pantallaActual = new PantallaRegistro(this);
			break;

		case "empresa":
			this.pantallaActual = new PantallaEmpresa(this);
			break;

		case "actividad":
			this.pantallaActual = new PantallaActividad(this);
			break;

		case "campos":
			this.pantallaActual = new PantallaCampo(this);
			break;

		case "personal":
			this.pantallaActual = new PantallaTrabajador(this);
			break;
		case "tractores":
			this.pantallaActual = new PantallaTractor(this);
			break;
		case "apero":
			this.pantallaActual = new PantallaApero(this);
			break;
		case "proveedor":
			this.pantallaActual = new PantallaProveedor(this);
			break;
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}
}
