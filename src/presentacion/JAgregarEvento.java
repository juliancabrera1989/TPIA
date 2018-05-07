package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ejercicio.agenteGuiaSeguridad.busqueda.EstadoCiudad;
import ejercicio.agenteGuiaSeguridad.dominio.Esquina;

public class JAgregarEvento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private JPanel contentPane;
	private JLabel lblTipoEvento ;
	public JComboBox comboTipoEvento ;
	private JLabel lblAgregarEsquina;
	public JComboBox comboEsquina;
	private JButton btnConfirmarEsquina;
	
	public JButton btnAgregarEvento ;

	private JTextArea txtrAgregueUnaEsquina;
	private JLabel lblTipoDeCorte;
	public JComboBox comboTipoCorte;
	private JButton btnAgregarCuadra;
	
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JTextArea txtrCuadrasAgregadas;
	
	
	private JLabel lblComienzaEnPaso;
	public JTextField textComienzaEnPaso;
	private JLabel lblTerminaEnPaso;
	public JTextField textTerminaEnPaso;
	

	
	
	
	
	
	private String[] tipoEvento = {"Marcha","Congestion","Evento Social","Accidente","Plan bacheo"};
	private String[] tipoCorte = {"Total","Parcial"};
	
	
	private List<String> cuadraRecibida = new ArrayList<String>();
	
	public List<String> listaEsquinasAgregadas = new ArrayList<String>();
	public HashMap<String,String> listaCuadrasAgregadas = new HashMap<String,String>();
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAgregarEvento frame = new JAgregarEvento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public JAgregarEvento() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 855, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTipoEvento = new JLabel("Seleccionar el tipo de Evento");
		lblTipoEvento.setBounds(10, 11, 151, 27);
		contentPane.add(lblTipoEvento);
		
		comboTipoEvento = new JComboBox();
		comboTipoEvento.setBounds(171, 14, 168, 20);
		contentPane.add(comboTipoEvento);
		
		lblAgregarEsquina = new JLabel("Agregar esquina");
		lblAgregarEsquina.setBounds(10, 65, 151, 14);
		contentPane.add(lblAgregarEsquina);
		
		comboEsquina = new JComboBox();
		comboEsquina.setBounds(171, 60, 273, 20);
		contentPane.add(comboEsquina);
		
		btnConfirmarEsquina = new JButton("Confirmar esquina");
		btnConfirmarEsquina.setBounds(204, 91, 135, 23);
		contentPane.add(btnConfirmarEsquina);
		
		btnAgregarEvento = new JButton("Agregar Evento");
		btnAgregarEvento.setBounds(259, 361, 121, 36);
		contentPane.add(btnAgregarEvento);
				
		lblTipoDeCorte = new JLabel("Tipo de corte");
		lblTipoDeCorte.setBounds(10, 278, 113, 20);
		contentPane.add(lblTipoDeCorte);
		
		comboTipoCorte = new JComboBox();
		comboTipoCorte.setBounds(171, 278, 168, 20);
		contentPane.add(comboTipoCorte);
		
		btnAgregarCuadra = new JButton("Agregar cuadra");
		btnAgregarCuadra.setBounds(197, 146, 157, 36);
		contentPane.add(btnAgregarCuadra);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(485, 10, 344, 172);
		contentPane.add(scrollPane);
		
		txtrAgregueUnaEsquina = new JTextArea();
		txtrAgregueUnaEsquina.setText("Esquinas agregadas:");
		scrollPane.setColumnHeaderView(txtrAgregueUnaEsquina);
		
		textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(485, 207, 344, 172);
		contentPane.add(scrollPane_1);
		
		txtrCuadrasAgregadas = new JTextArea();
		txtrCuadrasAgregadas.setText("Cuadras agregadas:");
		scrollPane_1.setColumnHeaderView(txtrCuadrasAgregadas);
		
		textArea_2 = new JTextArea();
		scrollPane_1.setViewportView(textArea_2);
		

		
		lblComienzaEnPaso = new JLabel("Comienza en paso:");
		lblComienzaEnPaso.setBounds(10, 221, 113, 20);
		contentPane.add(lblComienzaEnPaso);
		
		textComienzaEnPaso = new JTextField();
		textComienzaEnPaso.setBounds(133, 221, 86, 20);
		contentPane.add(textComienzaEnPaso);
		textComienzaEnPaso.setColumns(10);
		
		lblTerminaEnPaso = new JLabel("Termina en paso:");
		lblTerminaEnPaso.setBounds(267, 224, 100, 14);
		contentPane.add(lblTerminaEnPaso);
		
		textTerminaEnPaso = new JTextField();
		textTerminaEnPaso.setBounds(377, 221, 86, 20);
		contentPane.add(textTerminaEnPaso);
		textTerminaEnPaso.setColumns(10);
		
		btnConfirmarEsquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
			    String esquina = comboEsquina.getSelectedItem().toString();
			    
			    
			    
			    listaEsquinasAgregadas.add(esquina);
			    
				String texto = textArea_1.getText();
				texto += esquina+"\n";
				textArea_1.setText(texto);
				esquina = "";
				
				
				
				
			}
		});

		setListasEstaticas();
		
		
		
		
	}
	
	
	private void setListasEstaticas() {

		for (int i= 0; i < tipoEvento.length; i++)
			comboTipoEvento.addItem(tipoEvento[i]);
		
		
		for (int i =0; i< tipoCorte.length; i++)
			comboTipoCorte.addItem(tipoCorte[i]);
		
		
	}


	public void cargarEsquinas(EstadoCiudad estadoCiudadSantaFe){
		
		   String suma = new String();
           List<Esquina> aux = estadoCiudadSantaFe.getMapa().getEsquinas();
		   comboEsquina.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una esquina..."}));
		
		   for(Esquina esq : aux){
			   suma += ""+esq.getIdEsquina()+" ";
			   
			   for (String nombreEsq : esq.getCalles() ){
				   suma += nombreEsq;	   
				   if (!nombreEsq.equals(esq.getCalles().get(esq.getCalles().size()-1)))
					   suma += " y ";
			   }
			  
			   comboEsquina.addItem(suma);
			   suma = "";
		   }
		   
		   
		   
		 
		   
		   
		
		
		
	}
	
	
	public void setearCreacionEvento(final EstadoCiudad estadoCiudadSantaFe){
	    
	btnAgregarCuadra.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
				final JAgregarCuadra agregarCuadra = new JAgregarCuadra();
				agregarCuadra.setVisible(true);
				agregarCuadra.setListas(estadoCiudadSantaFe);
				
				btnAgregarCuadra.setEnabled(false);
                
                
                agregarCuadra.addWindowListener( new WindowAdapter() { 
                	public void windowClosing( WindowEvent evt ) { 
                		btnAgregarCuadra.setEnabled(true);
                	} 
                	} );
		
				agregarCuadra.btnAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					    cuadraRecibida.add(agregarCuadra.comboTipoCuadra.getSelectedItem().toString());
					    cuadraRecibida.add(agregarCuadra.comboCuadra.getSelectedItem().toString());
						String texto = textArea_2.getText();
						texto += cuadraRecibida.get(1)+"\n";
						textArea_2.setText(texto);
						
						listaCuadrasAgregadas.put(cuadraRecibida.get(1),cuadraRecibida.get(0));
					
						cuadraRecibida.clear();
						
						
						
						
					}
				});
				
				
		}
	});
	
	
	}
	
}
