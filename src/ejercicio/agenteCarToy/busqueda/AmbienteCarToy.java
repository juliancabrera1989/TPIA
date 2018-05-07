package ejercicio.agenteCarToy.busqueda;


import java.util.List;

import ejercicio.agenteCarToy.dominio.Evento;
import ejercicio.agenteCarToy.dominio.Llamada;
import ejercicio.agenteCarToy.dominio.PlanoCasa;
import ejercicio.agenteCarToy.dominio.ObstaculoTemporal;
import ejercicio.agenteCarToy.dominio.Celda;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmbienteCarToy extends Environment {

    public AmbienteCarToy() {
        // Create the environment state
        this.environmentState = new EstadoAmbiente();
    }

    public EstadoAmbiente getEnvironmentState() {
        return (EstadoAmbiente) super.getEnvironmentState();
    }

    /**
     * This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.
     * @param agent
     * @return A perception that will be given to the agent by the simulator.
     */
    @Override
    public  AgenteCarToyPerception getPercept() {
        // Create a new perception to return
         AgenteCarToyPerception perception = new AgenteCarToyPerception();
		
		//TODO : Set the perceptions sensors
        perception.setPlanoCasaSignal(this.getPlanoCasa());
        perception.setListaObstaculosTempSignal(this.getObstaculosTemp());
        perception.setLlamadaSignal(this.getLlamada());
        perception.setListaEventosSignal(this.getListaEventos());
        perception.setPosicionAgenteSignal(this.getPosicionAgente());
         
        // Return the perception
        return perception;
    }

    
    public String toString() {
        return environmentState.toString();
    }

    
    public boolean agentFailed(Action actionReturned) {

        EstadoAmbiente envState =
                this.getEnvironmentState();

        // TODO: Complete Method        

        return false;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
    
    public PlanoCasa getPlanoCasa(){
    	  return ((EstadoAmbiente) this.environmentState).getPlanoCasa();
    }
    
    public Llamada getLlamada(){
  	  return ((EstadoAmbiente) this.environmentState).getLlamada();
  }
    
    public List<ObstaculoTemporal> getObstaculosTemp(){
    	  return ((EstadoAmbiente) this.environmentState).getListaObstaculosTemp();
    }
    
    
    public List<Evento> getListaEventos(){
    	return ((EstadoAmbiente) this.environmentState).getListaEventos();
    }
      
    public Celda getPosicionAgente(){
    	return ((EstadoAmbiente) this.environmentState).getPosicionAgente();
    }
}
