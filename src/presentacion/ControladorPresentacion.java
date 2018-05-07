package presentacion;




import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import ejercicio.SimuladorPresentacion;
import ejercicio.agenteCarToy.busqueda.EstadoAgenteCarToy;
import ejercicio.agenteCarToy.busqueda.EstadoAmbiente;
import ejercicio.agenteCarToy.noInformadaCostoUniforme.*;
import ejercicio.agenteCarToy.noInformadaProfundidad.*;
import ejercicio.agenteCarToy.informada.*;
import ejercicio.agenteCarToy.dominio.Evento;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.state.EnvironmentState;

public class ControladorPresentacion {
	
	private static SimuladorPresentacion simulador;
	private static PantallaSimulador window;
	private static Timer autoStep;
	private static final int COSTO_UNIFORME = 0;
	private static final int PROFUNDIDAD = 1;
	private static final int INFORMADA = 2;
	
	
	public static void comenzarSimulador(EstadoAmbiente estadoCasa,
			int estrategia) {
		
		
		
		try {
			switch(estrategia){
			
			case COSTO_UNIFORME:
				CostoUniforme.ejecutar(estadoCasa);
				break;
			case PROFUNDIDAD :	
				Profundidad.ejecutar(estadoCasa);
				break;
			case INFORMADA :
				Informada.ejecutar(estadoCasa);
				break;
			}
			
			
		} catch (PrologConnectorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void setSimulator(SimuladorPresentacion sim,EnvironmentState environmentState){
		simulador = sim;
		window = new PantallaSimulador();
		window.inicializarMapa(environmentState);
		autoStep = new Timer(1000, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        autoStep();
		    }
		});
		
		
	}
	
	
	public static void mostrarElementos(EstadoAmbiente estadoAmbiente, EstadoAgenteCarToy estadoAgente) {
		
		
		window.MostrarMapa(estadoAmbiente,estadoAgente);
		
		
	}


	public static void actualizarEventosInesperados(EstadoAmbiente estadoAmbiente, int stepNumber) {
	
		
		int a = -1;
		int b = -1;
		boolean terminaAhora = false;
		if(estadoAmbiente.getListaEventos().size() != 0){
		List<EventoInesperado> auxListaEventosAct = estadoAmbiente.getListaEventosActuales();
		for(EventoInesperado auxEv : estadoAmbiente.getListaEventos()){
			if(auxEv.getTerminaEvento() == stepNumber){
				
				a = auxEv.getIdEvento();
				for(int i = 0; i <auxListaEventosAct.size(); i++){
					if(auxListaEventosAct.get(i).getIdEvento() == a){
						b = i;
						terminaAhora = true;
						
						break;
						
					}
					
				}
				if(terminaAhora)
					auxListaEventosAct.remove(b);
				
			}
			
			terminaAhora = false;
			b = -1;
			
			
			if(auxEv.getComienzoEvento() == stepNumber){
				
				auxListaEventosAct.add(auxEv);
				
			}
			
			
			
			
		}
		
		estadoAmbiente.setListaEventosActuales(auxListaEventosAct);
		
	}
		
		
	}



	public static void registrarEvento(String string) {
	window.addEvent(string);
		
	}

	public static void autoStep() {
		if (autoStep.isRunning())
			avanzar();
	}



	public static void avanzar() {
		int res = simulador.avanzar();
		
		if (res == 1) {
			autoStep.stop();
			window.terminar();
			simulador.terminar();
		}
		
	}


	public static void setAutoStep(boolean activar) {
		if (activar)
			autoStep.start();
		else
			autoStep.stop();
	}

	public static void mostrarConfigurador() {
		
			window.cerrar();
			try {
				PantallaSeleccionar ventana = new PantallaSeleccionar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	



	
	
}
