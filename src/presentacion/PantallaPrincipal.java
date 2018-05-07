package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PantallaPrincipal {
	
	
	public JFrame frame;
	private JPanel contentPane;
	private JLabel lblBienvenidoAlSimulador;
	private JLabel lblAgenteCarToy;
	

	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	/*public static void main(String[] args) throws InterruptedException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal window = new PantallaPrincipal();
					
					window.frame.setVisible(true);				
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		});
		Thread.sleep(3000);
		System.out.println("hola");
		
	} */


	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public PantallaPrincipal() throws InterruptedException{
	

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 815, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBienvenidoAlSimulador = new JLabel("BIENVENIDO AL SIMULADOR ");
		lblBienvenidoAlSimulador.setFont(lblBienvenidoAlSimulador.getFont().deriveFont(lblBienvenidoAlSimulador.getFont().getStyle() | Font.BOLD | Font.ITALIC, 25f));
		lblBienvenidoAlSimulador.setBounds(202, 561, 377, 52);
		contentPane.add(lblBienvenidoAlSimulador);
		
		lblAgenteCarToy = new JLabel("                AGENTE CAR TOY");
		lblAgenteCarToy.setFont(lblAgenteCarToy.getFont().deriveFont(lblAgenteCarToy.getFont().getStyle() | Font.BOLD | Font.ITALIC, 25f));
		lblAgenteCarToy.setBounds(158, 613, 475, 43);
		contentPane.add(lblAgenteCarToy);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 779, 554);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("ImagenPresentacion.jpg"));
		panel.add(lblNewLabel);
	
	frame.setVisible(true);
	
	
	}
	
}
