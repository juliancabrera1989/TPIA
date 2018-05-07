package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import ejercicio.agenteGuiaSeguridad.busqueda.EstadoCiudad;
import ejercicio.agenteGuiaSeguridad.dominio.*;



public class JAgregarCuadra extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTipoCuadra;
	private JLabel lblCuadra;
	public JComboBox<String> comboTipoCuadra; 
	public JComboBox<String> comboCuadra; 
	public JButton btnAgregar; 
	
	private static final int CUADRAS_HORIZONTALES = 0;
	private static final int CUADRAS_VERTICALES = 1;
	private static final int DIAGONALES = 2;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAgregarCuadra frame = new JAgregarCuadra();
					frame.setVisible(true);
					
					EstadoCiudad unEstado = new EstadoCiudad();	
					unEstado.initState();
					frame.setListas(unEstado);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public JAgregarCuadra() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 598, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTipoCuadra = new JLabel("Tipo de cuadra:");
		lblTipoCuadra.setBounds(10, 31, 144, 25);
		contentPane.add(lblTipoCuadra);
		
		lblCuadra = new JLabel("Seleccione cuadra:");
		lblCuadra.setBounds(10, 116, 144, 25);
		contentPane.add(lblCuadra);
		
		comboTipoCuadra = new JComboBox<String>();
		comboTipoCuadra.setBounds(152, 31, 200, 25);
		contentPane.add(comboTipoCuadra);
		
		comboCuadra = new JComboBox<String>();
		comboCuadra.setBounds(152, 116, 367, 25);
		contentPane.add(comboCuadra);
		
		btnAgregar = new JButton("Confirmar");
		btnAgregar.setBounds(226, 202, 136, 35);
		contentPane.add(btnAgregar);
		
	

	
	}
		
	

	
	
	   public void setListas(final EstadoCiudad estadoCiudadSantaFe){

		   
		   
		   comboTipoCuadra.addItem("Horizontal");
		   comboTipoCuadra.addItem("Vertical");
		   comboTipoCuadra.addItem("Diagonal");
		   
		   setLista(estadoCiudadSantaFe.getMapa().getCuadrasHorizontales());
		   
			comboTipoCuadra.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {	
	      
		    		int tipoCuadra = comboTipoCuadra.getSelectedIndex();
		    		
		    		switch(tipoCuadra){
		    		
		    		case CUADRAS_HORIZONTALES:
		    			comboCuadra.removeAllItems();
		    			setLista(estadoCiudadSantaFe.getMapa().getCuadrasHorizontales());
		    			break;
		    			
		    		case CUADRAS_VERTICALES :
		    			comboCuadra.removeAllItems();
		    			setLista(estadoCiudadSantaFe.getMapa().getCuadrasVerticales());
		    			break;
		    			
		    		case DIAGONALES:
		    			comboCuadra.removeAllItems();
		    			setLista(estadoCiudadSantaFe.getMapa().getDiagonales());
		    			break;
		    		
		    		}
		    
		    		
						
					
				}
				
				
				
			});

		  
	   }
		   
		   
	   public void setLista(List<Cuadra> unaLista){
		   
		   
		   String suma = new String();
		   List<String> calles = new ArrayList<String>();
		   boolean igual = false;
		   for(Cuadra aux : unaLista){
			 suma += ""+aux.getIdCuadra()+" ";
			 for(int i = 0; i < aux.getOrigen().getCalles().size(); i++){
				 for (int j = 0; j < aux.getDestino().getCalles().size();j++){
					 igual = aux.getOrigen().getCalles().get(i).equals(aux.getDestino().getCalles().get(j));
			 		if (igual){
			 			calles.add(aux.getDestino().getCalles().get(j));
			 			break;
			 		}
				 }	
				 if(igual)
					 break;
			 }
			 
			 for(int i = 0; i < aux.getOrigen().getCalles().size(); i++)
				 if(!aux.getOrigen().getCalles().get(i).equals(calles.get(0)))
					 calles.add(aux.getOrigen().getCalles().get(i));
				 
					 
			 for(int i = 0; i < aux.getDestino().getCalles().size(); i++)
				 if(!aux.getDestino().getCalles().get(i).equals(calles.get(0)))
					 calles.add(aux.getDestino().getCalles().get(i));
			 
			 suma += calles.get(0)+" entre ";
			 calles.remove(0);
			 for(String auxCalle : calles){
				 
				 suma += auxCalle;
				 if(!auxCalle.equals(calles.get(calles.size()-1)))
					 suma += " y ";
				 
			 }
	   
			 
				comboCuadra.addItem(suma);
				suma = "";
				calles.clear();
		   	}
	  


		
	   }
	   
	   
	  
	   
	
		
	

}
	   
	   

