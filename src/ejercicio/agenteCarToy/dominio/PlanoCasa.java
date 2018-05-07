package ejercicio.agenteCarToy.dominio;

import java.util.List;


public class PlanoCasa {
       
	public static final int X_CELLS = 50;
	public static final int Y_CELLS = 82;
	
	
    private Celda [][] unPlano = new Celda[X_CELLS][Y_CELLS];
    private List<String> listaHabitaciones;
    
	public PlanoCasa() {
		
		for (int b = 0; b < Y_CELLS; b++)
			for (int a= 0; a < X_CELLS; a++) 
				unPlano[a][b]= new Celda();
	}

	public Celda[][] getUnPlano() {
				
		return unPlano;
	}

	public void setUnPlano(Celda[][] unPlano) {
		this.unPlano = unPlano;
	}

	   public List<String> getHabitaciones(){
		   
		   return listaHabitaciones;
	   }
	   
	   public void setHabitaciones(List<String> listaHab){
		   
		   this.listaHabitaciones = listaHab;
	   }


       
}

