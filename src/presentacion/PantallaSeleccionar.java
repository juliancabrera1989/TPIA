package presentacion;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;



import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import javax.swing.*;




import ejercicio.agenteCarToy.busqueda.EstadoAmbiente;
import ejercicio.agenteCarToy.dominio.PlanoCasa;
import ejercicio.agenteCarToy.dominio.Celda;
import ejercicio.agenteCarToy.dominio.Llamada;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;


public class PantallaSeleccionar {

	public JFrame frame;
	private JPanel panel;
	private MiClase labelPlano;
	
	private JLabel labelSeleccionHabitacionAgente;
	private JComboBox comboBoxHabitacionAgente;
	private JLabel lblSeleccionarLaCeldaAgente;
	private ComboBoxHoverOver comboBoxCeldasAgente;
	
	private JLabel labelSeleccionHabitacionLlamada;
	private JComboBox comboBoxHabitacionLlamada;
	private JLabel lblSeleccionarLaPosicionLlamada;
	//private ComboBoxHoverOver2 comboBoxCeldasLlamada;
	
	private JButton btnAgregarObstaculo;
	private JLabel lblSeleccionarLaEstrategia;
	private JComboBox comboSeleccionarEstrategia;
	private JButton btnComenzarSimulacion;
	
	private EstadoAmbiente estadoAmbiente;
	

	private static int coorAutoX,coorAutoY,anchoAuto,altoAuto;
	private static int coordenadaX1,coordenadaY1;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaSeleccionar window = new PantallaSeleccionar();
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
	public PantallaSeleccionar() {
		estadoAmbiente = new EstadoAmbiente();
		estadoAmbiente.initState();
		initialize();
		frame.setVisible(true);
		cargarCombosHabitaciones();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 853, 922);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(278, 11, 561, 862);
		frame.getContentPane().add(panel);
		
		labelPlano = new MiClase();
		labelPlano.setIcon(new ImageIcon("MapaCarToy.png"));
		panel.add(labelPlano);
		
		labelSeleccionHabitacionAgente = new JLabel("Seleccionar la habitaci\u00F3n inicial del agente:");
		labelSeleccionHabitacionAgente.setBounds(10, 32, 221, 14);
		frame.getContentPane().add(labelSeleccionHabitacionAgente);
		
		comboBoxCeldasAgente = new ComboBoxHoverOver();
		comboBoxCeldasAgente.combo.setBounds(10, 125, 221, 20);
		frame.getContentPane().add(comboBoxCeldasAgente.combo);
		
		//comboBoxCeldasLlamada = new ComboBoxHoverOver2();
		//comboBoxCeldasLlamada.setBounds(10, 292, 221, 20);
		//frame.getContentPane().add(comboBoxCeldasLlamada);
		
		labelSeleccionHabitacionLlamada = new JLabel("Seleccionar la habitaci\u00F3n del ni\u00F1o:");
		labelSeleccionHabitacionLlamada.setBounds(10, 194, 202, 14);
		frame.getContentPane().add(labelSeleccionHabitacionLlamada);
		
		btnAgregarObstaculo = new JButton("Agregar Obst\u00E1culo");
		btnAgregarObstaculo.setBounds(10, 381, 221, 38);
		frame.getContentPane().add(btnAgregarObstaculo);
		
		comboSeleccionarEstrategia = new JComboBox();
		comboSeleccionarEstrategia.setBounds(10, 526, 221, 20);
		frame.getContentPane().add(comboSeleccionarEstrategia);
		
		lblSeleccionarLaEstrategia = new JLabel("Seleccionar la estrategia de b\u00FAsqueda");
		lblSeleccionarLaEstrategia.setBounds(10, 501, 202, 14);
		frame.getContentPane().add(lblSeleccionarLaEstrategia);
		
		btnComenzarSimulacion = new JButton("Comenzar Simulaci\u00F3n");
		btnComenzarSimulacion.setBounds(83, 623, 145, 29);
		frame.getContentPane().add(btnComenzarSimulacion);
		
		comboBoxHabitacionAgente = new JComboBox();
		comboBoxHabitacionAgente.setBounds(10, 57, 221, 20);
		frame.getContentPane().add(comboBoxHabitacionAgente);
		
		lblSeleccionarLaCeldaAgente = new JLabel("Seleccionar la celda dentro de la habitaci\u00F3n:");
		lblSeleccionarLaCeldaAgente.setBounds(10, 100, 221, 14);
		frame.getContentPane().add(lblSeleccionarLaCeldaAgente);
		
		comboBoxHabitacionLlamada = new JComboBox();
		comboBoxHabitacionLlamada.setBounds(10, 214, 221, 20);
		frame.getContentPane().add(comboBoxHabitacionLlamada);
		
		lblSeleccionarLaPosicionLlamada = new JLabel("Seleccionar la posici\u00F3n del ni\u00F1o dentro de la habitaci\u00F3n:");
		lblSeleccionarLaPosicionLlamada.setBounds(10, 265, 263, 29);
		frame.getContentPane().add(lblSeleccionarLaPosicionLlamada);
		
		
		
		
		comboBoxHabitacionAgente.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent e) {	
				String value = comboBoxHabitacionAgente.getSelectedItem().toString();
				if(!(value.equals("Seleccione una habitacion..."))){
					
					cargarComboCeldas(value);
     	       
                
               
               
               /*System.out.println(coordenadaX);
               System.out.println(coordenadaY);*/
               
               
				}
			/*	if(value.equals("Seleccione una esquina..."))
					coordenadaX1 = 0;
				    coordenadaY1 = 0;*/
				
				     
				  
					
				
			}
			
			
			
		});
	
		

		

		comboSeleccionarEstrategia.addItem("Costo Uniforme");
		comboSeleccionarEstrategia.addItem("Profundidad");
		comboSeleccionarEstrategia.addItem("A*");
		
		
	}

	   
	
	private void cargarCombosHabitaciones(){


		   List<String> aux = estadoAmbiente.getPlanoCasa().getHabitaciones();
		   comboBoxHabitacionAgente.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una habitacion..."}));
		   comboBoxHabitacionLlamada.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una habitacion..."}));
		   comboBoxCeldasAgente.combo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una celda..."}));
		   for(String hab : aux){
		
			   comboBoxHabitacionAgente.addItem(hab);
			   comboBoxHabitacionLlamada.addItem(hab);
			 
		   }
	   
	   
}
	
	private void cargarComboCeldas(String unaHabitacion){
		String item = new String();
		comboBoxCeldasAgente.combo.removeAllItems();
		comboBoxCeldasAgente.combo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una celda..."}));
		PlanoCasa unPlano = estadoAmbiente.getPlanoCasa();
		for (int b = 0; b < unPlano.Y_CELLS ; b++)
			for (int a= 0; a < unPlano.X_CELLS; a++)
				if (unaHabitacion.equals(unPlano.getUnPlano()[a][b].getHabitacion())){
					
					item+=""+a+" , "+b+"";
					comboBoxCeldasAgente.combo.addItem(item);
					item = "";
				}
				
	}
	
	

	
	   class ComboBoxHoverOver {

			 
			private JComboBox combo = new JComboBox();

		       public ComboBoxHoverOver() {
		           combo.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXX");
		           combo.setRenderer(new ComboToolTipRenderer(combo));
		           combo.addItemListener(new ItemListener() {

		               public void itemStateChanged(ItemEvent e) {
		                /*   System.out.println(combo.getSelectedItem().toString());*/
		               }
		           });
		       
		           
		       }

		       private class ComboToolTipRenderer extends BasicComboBoxRenderer {

		           private static final long serialVersionUID = 1L;
		           private JComboBox combo;
		           private JList comboList;

		           ComboToolTipRenderer(JComboBox combo) {
		               this.combo = combo;
		           }

		           @Override
		           public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		               super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		               if (comboList == null) {
		                   comboList = list;
		                   KeyAdapter listener = new KeyAdapter() {

		                       @Override
		                       public void keyReleased(KeyEvent e) {
		                           if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP) {
		                               int x = 5;
		                               int y = comboList.indexToLocation(comboList.getSelectedIndex()).y;
		                              /* System.out.println(comboList.getSelectedIndex());*/
		                               
		                           }
		                       }
		                   };
		                   combo.addKeyListener(listener);
		                   combo.getEditor().getEditorComponent().addKeyListener(listener);
		               }
		               if (isSelected) {
		                   /*System.out.println(value.toString());*/
		                   
		                   if(!value.toString().equals("Seleccione una celda...")){
		                	       String [] ficha = value.toString().split(" ");
		                	       
		                	 
		                	                  	       
		                   	     

		                           coordenadaX1 = (Integer.parseInt(ficha[0])*10)+5;
		                 
		                           coordenadaY1 =  (Integer.parseInt(ficha[2])*10)+5;
		                           
		                          /*System.out.println(coordenadaX);
		                          System.out.println(coordenadaY);*/
		                          
		                          labelPlano.repaint();
		                   }
		               }
		               return this;
		           }
		       }

		
		   }
	
	
	
	public class MiClase extends JLabel // (o JPanel)
	
	{
	   
		private static final long serialVersionUID = 1L;
		
		public MiClase(){
	
		}

	
	public void paintComponent (Graphics g) {
        super.paintComponent(g);
		

					  try {
						  pintarPlano(g);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}    
			         
			
		}

	
	
	
	public void pintarPlano(Graphics g)	throws IOException{
		
						
	        URL imagenCarToy = getClass().getResource("/agente.png");
	       	Image carToy = new ImageIcon(imagenCarToy).getImage();

			
		
			   
	       	anchoAuto = carToy.getWidth(getRootPane());
			 altoAuto = carToy.getHeight(getRootPane());
			
			   
			   coorAutoX = coordenadaX1 - (anchoAuto/2);
			   coorAutoY = coordenadaY1 - (altoAuto/2);
			
				String value1 = comboBoxCeldasAgente.combo.getSelectedItem().toString();

				 boolean es1 = false;
				 boolean es2 = false;		   
				   
				 es1 =(value1.equals("Seleccione una celda..."));

				 
				if (!es1) 
				  if (coordenadaX1 != 0 && coordenadaY1 !=0)
						g.drawImage(carToy,coorAutoX,coorAutoY,null);
			
			  
			
	}
	
	
	
		
		

		 
	
		  
		

	}
}
