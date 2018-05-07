package ejercicio.agenteCarToy.busqueda;


import java.util.List;
import java.util.Queue;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

import ejercicio.agenteCarToy.dominio.*;


public class AgenteCarToyPerception extends Perception {

	//TODO: Setup Statics
    //public static int UNKNOWN_PERCEPTION = -1;   
	
	
	//TODO: Setup Sensors
	/*private int llamada;
	private int agua;
	private int basura;
	private int ropa;
	private int nueva_info_extra;
	private int nuevo_obst_temp;
	private int corre_obstaculo;
	private int abre_puerta;
	private int cierra_puerta;
	
 */

	private Llamada llamadaSignal;
	private List<ObstaculoTemporal> listaObstaculosTempSignal;
	private PlanoCasa planoCasaSignal;
	private List<Evento> listaEventosSignal;
	private Celda posicionAgenteSignal;
	
	
    public  AgenteCarToyPerception() {
    	//TODO: Complete Method
    }

    public AgenteCarToyPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
    	
    	//TODO: Complete Method
        
        //AgenteCarToy agent = (AgenteCarToy) agentIn;
        //AmbienteCarToy environment = (AmbienteCarToy) environmentIn;
        //EstadoAmbiente environmentState =
        //        environment.getEnvironmentState();
       
        
    }
    
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        //TODO: Complete Method

        return str.toString();
    }



    // The following methods are agent-specific:
    //TODO: Complete this section with the agent-specific methods
	public Llamada getLlamadaSignal() {
		return llamadaSignal;
	}

	public void setLlamadaSignal(Llamada llamadaSignal) {
		this.llamadaSignal = llamadaSignal;
	}

	public List<ObstaculoTemporal> getListaObstaculosTempSignal() {
		return listaObstaculosTempSignal;
	}

	public void setListaObstaculosTempSignal(List<ObstaculoTemporal> listaObstaculosTempSignal) {
		this.listaObstaculosTempSignal = listaObstaculosTempSignal;
	}

	public PlanoCasa getPlanoCasaSignal() {
		return planoCasaSignal;
	}

	public void setPlanoCasaSignal(PlanoCasa planoCasaSignal) {
		this.planoCasaSignal = planoCasaSignal;
	}

	public List<Evento> getListaEventosSignal() {
		return listaEventosSignal;
	}

	public void setListaEventosSignal(List<Evento> listaEventosSignal) {
		this.listaEventosSignal = listaEventosSignal;
	}

	public Celda getPosicionAgenteSignal() {
		return posicionAgenteSignal;
	}

	public void setPosicionAgenteSignal(Celda posicionAgenteSignal) {
		this.posicionAgenteSignal = posicionAgenteSignal;
	}

	
   
}
