package ejercicio.agenteCarToy.informada;


import frsf.cidisi.faia.exceptions.PrologConnectorException;


import ejercicio.agenteCarToy.busqueda.AmbienteCarToy;
import ejercicio.agenteCarToy.busqueda.EstadoAmbiente;
import ejercicio.*;



public class Informada {
	
	  public static void ejecutar(EstadoAmbiente estadoAmbiente) throws PrologConnectorException {
	        AgenteCarToy agent = new AgenteCarToy();
	        AmbienteCarToy environment = new AmbienteCarToy();
	        
	        environment.setEnvironmentState(estadoAmbiente);
	        
	        SimuladorPresentacion simulator =
	                new SimuladorPresentacion(environment, agent);
	        
	        simulator.start();
	    }

}
