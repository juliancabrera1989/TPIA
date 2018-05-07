package ejercicio.agenteCarToy.busqueda;

import java.util.*;

import ejercicio.agenteCarToy.dominio.*;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoAgenteCarToy extends SearchBasedAgentState {
	
	//TODO: Setup Variables
    //private Other planoCasa;
    //private Other posicionAgente;
    //private Other posicionLlamada;
    //private Other listaInfoExtra;
    //private Other listaObstaculos;
    //private Other listaObstaculosTemp;
	
      private PlanoCasa planoCasa;
      private Celda posicionAgente;
      private Llamada posicionLlamada;
	  private List<Evento> listaEventos;
	  private List<ObstaculoTemporal> listaObstaculosTemp;
	  
	  
    public EstadoAgenteCarToy() {
    
    	//TODO: Complete Method
    	/*
			// planoCasa = initData0;
			// posicionAgente = initData1;
			// posicionLlamada = initData2;
			// listaInfoExtra = initData3;
			// listaObstaculos = initData4;
			// listaObstaculosTemp = initData5;
        */
    	
    	planoCasa = new PlanoCasa();
    	posicionAgente = new Celda();
    	posicionLlamada = new Llamada();
    	listaEventos = new ArrayList<Evento>();
    	listaObstaculosTemp = new ArrayList<ObstaculoTemporal>();
        this.initState();
    }

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
    	//TODO: Complete Method
    	EstadoAgenteCarToy newState = new EstadoAgenteCarToy();
    	
    	newState.setListaEventos(listaEventos);
    	newState.setListaObstaculosTemp(listaObstaculosTemp);
    	newState.setPlanoCasa(planoCasa);
    	newState.setPosicionAgente(posicionAgente);
    	newState.setPosicionLlamada(posicionLlamada);
		
		
        return newState;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        
        //TODO: Complete Method
    	AgenteCarToyPerception percepcion = (AgenteCarToyPerception) p;
    	
    	this.setListaEventos(percepcion.getListaEventosSignal());
    	this.setListaObstaculosTemp(percepcion.getListaObstaculosTempSignal());
    	this.setPlanoCasa(percepcion.getPlanoCasaSignal());
    	this.setPosicionAgente(percepcion.getPosicionAgenteSignal());
    	this.setPosicionLlamada(percepcion.getLlamadaSignal());
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        
	//TODO: Complete Method

    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
       
       //TODO: Complete Method
        
        return true;
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

	public Llamada getPosicionLlamada() {
		return posicionLlamada;
	}

	public void setPosicionLlamada(Llamada posicionLlamada) {
		this.posicionLlamada = posicionLlamada;
	}

	public List<Evento> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}

	public List<ObstaculoTemporal> getListaObstaculosTemp() {
		return listaObstaculosTemp;
	}

	public void setListaObstaculosTemp(List<ObstaculoTemporal> listaObstaculosTemp) {
		this.listaObstaculosTemp = listaObstaculosTemp;
	}
    
//     public Other getplanoCasa(){
//        return planoCasa;
//     }
//     public void setplanoCasa(Other arg){
//        planoCasa = arg;
//     }
//     public Other getposicionAgente(){
//        return posicionAgente;
//     }
//     public void setposicionAgente(Other arg){
//        posicionAgente = arg;
//     }
//     public Other getposicionLlamada(){
//        return posicionLlamada;
//     }
//     public void setposicionLlamada(Other arg){
//        posicionLlamada = arg;
//     }
//     public Other getlistaInfoExtra(){
//        return listaInfoExtra;
//     }
//     public void setlistaInfoExtra(Other arg){
//        listaInfoExtra = arg;
//     }
//     public Other getlistaObstaculos(){
//        return listaObstaculos;
//     }
//     public void setlistaObstaculos(Other arg){
//        listaObstaculos = arg;
//     }
//     public Other getlistaObstaculosTemp(){
//        return listaObstaculosTemp;
//     }
//     public void setlistaObstaculosTemp(Other arg){
//        listaObstaculosTemp = arg;
//     }
	
}

