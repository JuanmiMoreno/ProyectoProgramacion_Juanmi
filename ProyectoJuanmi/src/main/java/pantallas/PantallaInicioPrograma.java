package pantallas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaInicioPrograma extends JPanel {

	private Ventana ventana;
	
	public PantallaInicioPrograma (Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Agro Manager");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 54));
		lblNewLabel_1.setBounds(10, 124, 465, 113);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Algunos llaman a esto  \"El medio de la nada\",\r\n");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(20, 220, 333, 69);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("nosotros lo llamamos \"El centro de todo\"");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setBounds(20, 262, 323, 36);
		add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Empezar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantallas("login");
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(268, 339, 126, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBackground(new Color(245, 255, 250));
		lblNewLabel.setIcon(new ImageIcon(".\\imagenes\\Introduccion.jpg"));
		lblNewLabel.setBounds(-17, -56, 768, 595);
		add(lblNewLabel);
		}
}
