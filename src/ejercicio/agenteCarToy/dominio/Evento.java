package ejercicio.agenteCarToy.dominio;

import java.util.ArrayList;
import java.util.List;

public class Evento {

	
	private int idEvento;
	
	private String tipoEvento;
	
	private List<Celda> lugarEvento = new ArrayList<Celda>();
	
	private int ocurrenciaEvento;

	
	
	public Evento() {
		super();
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public List<Celda> getLugarEvento() {
		return lugarEvento;
	}

	public void setLugarEvento(List<Celda> lugarEvento) {
		this.lugarEvento = lugarEvento;
	}

	public int getOcurrenciaEvento() {
		return ocurrenciaEvento;
	}

	public void setOcurrenciaEvento(int ocurrenciaEvento) {
		this.ocurrenciaEvento = ocurrenciaEvento;
	}	

	
	
		
}
