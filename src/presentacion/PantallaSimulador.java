package presentacion;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

import ejercicio.agenteGuiaSeguridad.busqueda.EstadoAgenteGuiaSeguridad;
import ejercicio.agenteGuiaSeguridad.busqueda.EstadoCiudad;
import ejercicio.agenteGuiaSeguridad.dominio.Cuadra;
import ejercicio.agenteGuiaSeguridad.dominio.Esquina;
import ejercicio.agenteGuiaSeguridad.dominio.EventoInesperado;
import frsf.cidisi.faia.state.EnvironmentState;

public class PantallaSimulador {

	private JFrame frame;
	private JPanel panel;
	private MiClase lblNewLabel;
	private JPanel panel_1;
	private JPanel panel_5;
	private JLabel lblAgente;
	private JLabel lblNewLabel_1;
	private JLabel lblEventoInesperado; 
	private JPanel panel_2; 
	private JPanel panel_3;
	private JPanel panel_4;
	
	
	private JLabel lblEstadoDelAgente;
	private JLabel lblEstadoDelAmbiente;
	
	private JScrollPane scrollPaneAgente;
	private JScrollPane scrollPaneAmbiente;
	
	private JTextArea textEstadoAgente;
	private JTextArea textEstadoAmbiente;
	
	
	private JScrollPane scrollPane;
	private JTextArea textArea;
	
	
	private JToggleButton togglePlay;
	private JButton buttonNext;
	private JSeparator separator;

	
	
	
	
    private static int coorAutoX,coorAutoY,anchoAuto,altoAuto;
    
    private static int coorIncidenteX,coorIncidenteY,anchoIncidente,altoIncidente;
    
    private static int coorEventoX,coorEventoY,anchoEvento,altoEvento;
    
    private static int coordenadaX1,coordenadaY1,coordenadaX2,coordenadaY2,coordenadaX3,coordenadaY3;
    
    private static List<List<List<List<Integer>>>> coordenadasEventos; 
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaSimulador window = new PantallaSimulador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	/**
	 * Create the application.
	 */
	public PantallaSimulador() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */ 
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1391, 880);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(1355, 11, -857, 777);
		frame.getContentPane().add(panel);
		
		lblNewLabel = new MiClase();
		lblNewLabel.setIcon(new ImageIcon("Mapa.png"));
		lblNewLabel.setBounds(553, 11, 792, 807);
		frame.getContentPane().add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBounds(553, 829, 799, 202);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		panel_5 = new JPanel();
		panel_5.setBounds(291, 423, 226, 180);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		lblAgente = new JLabel("     Agente");
		lblAgente.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblAgente.setIcon(new ImageIcon("src/Sim/agente.png"));
		lblAgente.setBounds(10, 10, 200, 50);
		panel_5.add(lblAgente);
		
		lblNewLabel_1 = new JLabel("     Incidente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_1.setIcon(new ImageIcon("src/Sim/incidente.png"));
		lblNewLabel_1.setBounds(10, 66, 200, 50);
		panel_5.add(lblNewLabel_1);
		
		lblEventoInesperado = new JLabel("Evento Inesperado");
		lblEventoInesperado.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblEventoInesperado.setIcon(new ImageIcon("src/Sim/eventoInesp.png"));
		lblEventoInesperado.setBounds(10, 120, 200, 50);
		panel_5.add(lblEventoInesperado);
		
		panel_2 = new JPanel();
		panel_2.setBounds(10, 25, 528, 54);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		
		panel_3 = new JPanel();
		panel_3.setBounds(10, 91, 528, 306);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		

		textEstadoAgente = new JTextArea();

		
		textEstadoAmbiente = new JTextArea();

		
		
		scrollPaneAgente = new JScrollPane();
		scrollPaneAgente.setBounds(46, 37, 430, 165);
		panel_3.add(scrollPaneAgente);
		
		
		scrollPaneAgente.setViewportView(textEstadoAgente);
		
		scrollPaneAmbiente = new JScrollPane();
		scrollPaneAmbiente.setBounds(46, 238, 430, 57);
		panel_3.add(scrollPaneAmbiente);
		
		scrollPaneAmbiente.setViewportView(textEstadoAmbiente);
		
		lblEstadoDelAgente = new JLabel("Estado del agente :");
		lblEstadoDelAgente.setBounds(10, 12, 116, 14);
		panel_3.add(lblEstadoDelAgente);
		
		lblEstadoDelAmbiente = new JLabel("Estado del ambiente :");
		lblEstadoDelAmbiente.setBounds(10, 213, 155, 14);
		panel_3.add(lblEstadoDelAmbiente);
		
		
		
		
		panel_4 = new JPanel();
		panel_4.setBounds(10, 408, 234, 428);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 214, 406);
		panel_4.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		

		
		buttonNext = new JButton("");
		buttonNext.setBounds(0, 0, 65, 54);
		buttonNext.setIcon(new ImageIcon("src/Sim/next.png"));
		buttonNext.setToolTipText("Realizar próxima acción.");
		panel_2.add(buttonNext);
		buttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorPresentacion.avanzar();
			}
		});
		
		
		
		togglePlay = new JToggleButton("");
		togglePlay.setBounds(75, 0, 65, 54);		
		togglePlay.setIcon(new ImageIcon("src/Sim/play.png"));
		togglePlay.setToolTipText("Iniciar/Pausar ejecución.");
		panel_2.add(togglePlay);
		togglePlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorPresentacion.setAutoStep(togglePlay.isSelected());
				if (togglePlay.isSelected()) {
					buttonNext.setEnabled(false);
					togglePlay.setIcon(new ImageIcon("src/Sim/pause.png"));
				} else {
					buttonNext.setEnabled(true);
					togglePlay.setIcon(new ImageIcon("src/Sim/play.png"));
				}
			}
		});
		
		JButton buttonNew = new JButton("");
		buttonNew.setBounds(463, 0, 65, 54);
		buttonNew.setIcon(new ImageIcon("src/Sim/new.png"));
		buttonNew.setToolTipText("Comenzar nuevo escenario.");
		buttonNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(frame,
						"¿Está seguro de iniciar una nueva simulación? Se perderá el escenario actual.",
						"Advertencia", dialogButton);
				if(dialogResult==JOptionPane.YES_OPTION)
					ControladorPresentacion.mostrarConfigurador();
			}

		
		});
		panel_2.add(buttonNew);
		
		separator = new JSeparator();
		separator.setBounds(148, 31, 305, 12);
		panel_2.add(separator);
		

		
	}
	
	public void addEvent(String mensaje) {
		String texto = textArea.getText();
		texto += mensaje+"\n";
		textArea.setText(texto);
	}

	
	/*
		public void terminar() {
			btnNext.setEnabled(false);
			tglbtnPlay.setEnabled(false);
			tglbtnPlay.setSelected(false);
			tglbtnPlay.setIcon(new ImageIcon("res/ui/play.png"));
		}
		public void cerrar() {
			frame.setVisible(false);
			frame.dispose();
		}*/

	
	   public class MiClase extends JLabel // (o JPanel)
		
		{
		   
			private static final long serialVersionUID = 1L;
			
			public MiClase(){
		
			}

			
			
			
		
			
			
			
		public void paintComponent (Graphics g) {
	        super.paintComponent(g);
			
		  					
	
					
						  try {
							  pintarMapa(g);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}      
				         
				
			}
		
		
		
		
		
		
		
		
		
		public void pintarMapa(Graphics g)	throws IOException{
			
			
	        URL imagenAuto = getClass().getResource("/Sim/agentePaint.png");
	        
	
			
			Image auto = new ImageIcon(imagenAuto).getImage();

			
			anchoAuto = auto.getWidth(getRootPane());
			altoAuto = auto.getHeight(getRootPane());
			
			   
			   coorAutoX = coordenadaX1 - (anchoAuto/2);
			   coorAutoY = coordenadaY1 - (altoAuto/4);
			   
		        URL imagenIncidente = getClass().getResource("/Sim/incidentePaint.png");
		        
		    	
				
				Image incidente = new ImageIcon(imagenIncidente).getImage();

				anchoIncidente = incidente.getWidth(getRootPane());
				altoIncidente = incidente.getHeight(getRootPane());
				
				   
				   coorIncidenteX = coordenadaX2 - (anchoIncidente/2);
				   coorIncidenteY = coordenadaY2 - (altoIncidente/4);
		
				   
		 	        URL imagenEvento = getClass().getResource("/Sim/eventoInespPaint.png");
			        
			 	   	
					
					Image eventoInesp = new ImageIcon(imagenEvento).getImage();


					anchoEvento = eventoInesp.getWidth(getRootPane());
					altoEvento = eventoInesp.getHeight(getRootPane());
					   
					   
						g.drawImage(auto,coorAutoX,coorAutoY, null);
			     
			
			    		 g.drawImage(incidente,coorIncidenteX,coorIncidenteY, null);
			    		 
          
        	  
        
			 if(coordenadasEventos.size() != 0)  { 		 
				for (int i=0;i < coordenadasEventos.size();i++){
					
					
				 if  ( coordenadasEventos.get(i).size() == 2){
					for (int j=0; j < coordenadasEventos.get(i).get(0).size();j++){
						
						coordenadaX3 = coordenadasEventos.get(i).get(0).get(j).get(0);
						coordenadaY3 = coordenadasEventos.get(i).get(0).get(j).get(1);
						coorEventoX = coordenadaX3 - (anchoEvento/2);
						coorEventoY = coordenadaY3 - (altoEvento/4);	
						g.drawImage(eventoInesp,coorEventoX,coorEventoY, null);
					}
				
				
				
					for (int k=0; k < coordenadasEventos.get(i).get(1).size();k++){
						
						
						
						coordenadaX3 = coordenadasEventos.get(i).get(1).get(k).get(0);
						coordenadaY3 = coordenadasEventos.get(i).get(1).get(k).get(1);
						coorEventoX = coordenadaX3 - (anchoEvento/2);
						coorEventoY = coordenadaY3 - (altoEvento/4);
						g.drawImage(eventoInesp,coorEventoX,coorEventoY, null);
					}	
					
				 }
				 
				 if(coordenadasEventos.get(i).size() == 1){
						for (int k=0; k < coordenadasEventos.get(i).get(0).size();k++){
							
							
							
							coordenadaX3 = coordenadasEventos.get(i).get(0).get(k).get(0);
							coordenadaY3 = coordenadasEventos.get(i).get(0).get(k).get(1);
							coorEventoX = coordenadaX3 - (anchoEvento/2);
							coorEventoY = coordenadaY3 - (altoEvento/4);
							g.drawImage(eventoInesp,coorEventoX,coorEventoY, null);
						}
				 }
					
				}
				
			 } // end if
           
			   		
			    		 
			    		 
			    		 
			    		 
			    		 
			    		 
				  
				
		} //End method Paint
		
	} //End Class MiClase
		
			
			  
			
	
		
	   
	   
	   
	   
	   public void MostrarMapa(EstadoCiudad estadoAmbiente,EstadoAgenteGuiaSeguridad estadoAgente){
       	
	         coordenadaX1 = estadoAmbiente.getPosicionAgente().getCoordenadaX();
	         coordenadaY1 =	estadoAmbiente.getPosicionAgente().getCoordenadaY();
	         
	         coordenadaX2 = estadoAmbiente.getIncidente().getUbicacion().getCoordenadaX();
	         coordenadaY2 =	estadoAmbiente.getIncidente().getUbicacion().getCoordenadaY();
		//  if(estadoAgente.geteventosInesperados() != null) { 
			   
	         
	         coordenadasEventos.clear();	
	         setCoordenadasEventos(estadoAmbiente);
	         
	         this.textEstadoAgente.setText(estadoAgente.toString());
	         this.textEstadoAmbiente.setText(estadoAmbiente.toString());

       	
		//   }
       	    lblNewLabel.repaint();
       	
       	
       }

	public void inicializarMapa(EnvironmentState environmentState) {
		// TODO Auto-generated method stub
		
		EstadoCiudad estado =((EstadoCiudad) environmentState);		
	      coordenadaX1 = estado.getPosicionAgente().getCoordenadaX();
	         coordenadaY1 =	estado.getPosicionAgente().getCoordenadaY();
	         
	         coordenadaX2 = estado.getIncidente().getUbicacion().getCoordenadaX();
	         coordenadaY2 =	estado.getIncidente().getUbicacion().getCoordenadaY();
	         coordenadasEventos = new ArrayList<List<List<List<Integer>>>>();
	         
	     setCoordenadasEventos(estado);
	     
	     this.textEstadoAmbiente.setText(estado.toString());
	     
	     
	         
	         
		lblNewLabel.repaint();
		
	}

	
	
	
	
	
	
	
	
	
	public void setCoordenadasEventos(EstadoCiudad estadoAmbiente){
    
	
   	
		
		
		
		
	if(estadoAmbiente.getListaEventosActuales().size() != 0){
		List<EventoInesperado> auxListaEventosAct = estadoAmbiente.getListaEventosActuales(); 
		List<List<List<Integer>>> listCoorEvento = new ArrayList<List<List<Integer>>>(2);
		for(int k=0; k < auxListaEventosAct.size();k++){
			List<Cuadra> auxCuadras = auxListaEventosAct.get(k).getUbicacionCuadras();
			if(auxCuadras.size() != 0){
			List<List<Integer>> listCoorCuad = new ArrayList<List<Integer>>(auxCuadras.size());
			for (int j1=0; j1 < auxCuadras.size();j1++){
    		  	   Cuadra auxCuad = auxCuadras.get(j1);
                   List<Integer> coorCuad = new ArrayList<Integer>(2);
                   int coorCuadX = (auxCuad.getOrigen().getCoordenadaX()+auxCuad.getDestino().getCoordenadaX())/2;
                   int coorCuadY = (auxCuad.getOrigen().getCoordenadaY()+auxCuad.getDestino().getCoordenadaY())/2;
                   coorCuad.add(coorCuadX);
                   coorCuad.add(coorCuadY);
    		       listCoorCuad.add(coorCuad);
    		  
    	  }
    		listCoorEvento.add(listCoorCuad);

			}
    	  
    	  List<Esquina> auxEsquinas = auxListaEventosAct.get(k).getUbicacionEsquinas();
    	  if(auxEsquinas.size() != 0){

    	  
    	  List<List<Integer>> listCoorEsq = new ArrayList<List<Integer>>(auxEsquinas.size());       
    	  for (int j2=0; j2 < auxEsquinas.size();j2++){
      
                   Esquina auxEsq = auxEsquinas.get(j2);
                   List<Integer> coorEsq = new ArrayList<Integer>(2);
                   int coorEsqX = auxEsq.getCoordenadaX();
                   int coorEsqY = auxEsq.getCoordenadaY();
                   coorEsq.add(coorEsqX);
                   coorEsq.add(coorEsqY);
                   listCoorEsq.add(coorEsq);
                   
    	  }
    	  listCoorEvento.add(listCoorEsq);
    	  }
    	  coordenadasEventos.add(listCoorEvento);	
    	  }
    	  
   	    
   	    
		} // End If
	} // End metodo
	   
	   

	public void cerrar() {
		frame.setVisible(false);
		frame.dispose();
	}

	public void terminar() {
		buttonNext.setEnabled(false);
		togglePlay.setEnabled(false);
		togglePlay.setSelected(false);
		togglePlay.setIcon(new ImageIcon("src/Sim/play.png"));
		
	}
	
	
}



