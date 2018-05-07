package ejercicio.agenteCarToy.noInformadaProfundidad;


import ejercicio.agenteCarToy.busqueda.AmbienteCarToy;
import ejercicio.agenteCarToy.busqueda.EstadoAmbiente;
import ejercicio.*;
import frsf.cidisi.faia.exceptions.PrologConnectorException;



public class Profundidad {
	
	  public static void ejecutar(EstadoAmbiente estadoCiudadSantaFe) throws PrologConnectorException {
	        AgenteCarToy agent = new AgenteCarToy();
	        AmbienteCarToy environment = new AmbienteCarToy();
	        
	        
	       
	        environment.setEnvironmentState(estadoCiudadSantaFe);
	        
	        SimuladorPresentacion simulator =
	                new SimuladorPresentacion(environment, agent);
	        
	        simulator.start();
	    }

}
