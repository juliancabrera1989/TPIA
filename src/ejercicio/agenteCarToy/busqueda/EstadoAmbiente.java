package ejercicio.agenteCarToy.busqueda;

import frsf.cidisi.faia.state.EnvironmentState;

import ejercicio.agenteCarToy.dominio.*;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {
	
	//TODO: Setup Variables
    //private Other planoCasa;
    //private Other posicionAgente;
    //private Other llamada;
    //private Other listaObstaculos;
    //private Other listaObstaculosTemp;
	
	
	private PlanoCasa planoCasa;
	private Celda posicionAgente;
	private Llamada llamada;
	private List<ObstaculoTemporal> listaObstaculosTemp;
	private List<Evento> listaEventos;
	
    public EstadoAmbiente() {
        
        //TODO: Complete Method
    	/*
			// planoCasa = initData0;
			// posicionAgente = initData1;
			// llamada = initData2;
			// listaObstaculos = initData3;
			// listaObstaculosTemp = initData4;
        */
    	
    	   planoCasa = new PlanoCasa();
    	   posicionAgente = new Celda();
    	   llamada = new Llamada();
    	   listaEventos = new ArrayList<Evento>();
    	   listaObstaculosTemp = new ArrayList<ObstaculoTemporal>();
    	   
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

        //TODO: Complete Method
     	
    	setCeldas();
    	
    	
    	
    	
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }



	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
	
    
	public PlanoCasa getPlanoCasa() {
		return planoCasa;
	}

	public void setPlanoCasa(PlanoCasa planoCasa) {
		this.planoCasa = planoCasa;
	}

	public Celda getPosicionAgente() {
		return posicionAgente;
	}

	public void setPosicionAgente(Celda posicionAgente) {
		this.posicionAgente = posicionAgente;
	}

	public Llamada getLlamada() {
		return llamada;
	}

	public void setLlamada(Llamada llamada) {
		this.llamada = llamada;
	}

	public List<ObstaculoTemporal> getListaObstaculosTemp() {
		return listaObstaculosTemp;
	}

	public void setListaObstaculosTemp(List<ObstaculoTemporal> listaObstaculosTemp) {
		this.listaObstaculosTemp = listaObstaculosTemp;
	}

	public List<Evento> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}

	
	private void setCeldas(){
	 
			   String nombreHabitacion = new String();
			   int cantidadCuadrilateros;
			   int xInicial, xFinal, yInicial, yFinal;
			   	List<String> listaHabAux = new ArrayList<String>(); 
			    int a,b,c;
					   
			    File fileHabitaciones = new File("res/habitaciones.txt");
			    BufferedReader brHabitaciones = null ;
				try {
					brHabitaciones = new BufferedReader(new InputStreamReader(new FileInputStream(fileHabitaciones)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    String lineH = null;
			    try {
					while( (lineH = brHabitaciones.readLine())!= null ){
					    // \\s+ means any number of whitespaces between tokens
									
					    
					    String [] tokensHabitaciones = lineH.split(";");
					    nombreHabitacion = tokensHabitaciones[0];
					    cantidadCuadrilateros = Integer.parseInt(tokensHabitaciones[1]);
					    listaHabAux.add(nombreHabitacion);
					    c = 2;
					    for (int d = 0; d < cantidadCuadrilateros; d++) {
						  xInicial = Integer.parseInt(tokensHabitaciones[c++]) -1;
					      xFinal = Integer.parseInt(tokensHabitaciones[c++]);
					      yInicial = Integer.parseInt(tokensHabitaciones[c++]) - 1;
					      yFinal = Integer.parseInt(tokensHabitaciones[c++]);
					       for (b = yInicial; b < yFinal; b++){
					    	   for (a = xInicial; a < xFinal; a++){


					    		   
					    		   planoCasa.getUnPlano()[a][b].setHabitacion(nombreHabitacion);
					    		 					    		
					    	   }
					       }
					    }
						
					
			   
					}
					planoCasa.setHabitaciones(listaHabAux);
					
					brHabitaciones.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   
		   
	}
	

}

