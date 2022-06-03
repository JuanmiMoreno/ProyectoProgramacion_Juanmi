package principal;

import java.sql.SQLException;

import exceptions.ContraseñaVaciaExceptions;
import exceptions.nombreInvalidoExceptions;
import pantallas.Ventana;

public class Main {

	public static void main(String[] args) {
		
		String usuario=null;
		String contrasena=null;
		
		for(byte i=0;i<args.length;i++ ) {
			
			if(args[i].equals("-usuario")) {
				usuario=args[1+i];
				
				
			}
			if(args[i].equals("-contraseña")){
				contrasena=args[i+1];
				
			}
		}
		try {
			Ventana v = new Ventana(usuario, contrasena);
		} catch (SQLException | ContraseñaVaciaExceptions | nombreInvalidoExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		}
		
		
	}


