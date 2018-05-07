package ejercicio;

import presentacion.*;

import java.awt.EventQueue;


public class Main {
	private static PantallaPrincipal ventana;
	private static PantallaSeleccionar window;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ventana = new PantallaPrincipal();
					
					
			
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		ventana.frame.setVisible(false);
		
		
		window = new PantallaSeleccionar();

	}

}
