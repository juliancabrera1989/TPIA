package ejercicio.agenteCarToy.dominio;

import java.util.List;


public class ObstaculoTemporal {

	
	private int idObstaculoTemp;
	
	private String tipoObstaculoTemp;
	
	private List<Celda> ubicacionObstaculoTemp;
	
	private String tipoObstaculo;
	
	private int comienzoObstaculoTemp;
	
	private int terminaObstaculoTemp;
	
	
	public int getIdObstaculo() {
		return idObstaculoTemp;
	}

	public void setIdObstaculoTemp(int idObstaculoTemp) {
		this.idObstaculoTemp = idObstaculoTemp;
	}

	public String getTipoObstaculoTemp() {
		return tipoObstaculoTemp;
	}

	public void setTipoObstaculoTemp(String tipoObstaculoTemp) {
		this.tipoObstaculoTemp = tipoObstaculoTemp;
	}

	public List<Celda> getUbicacionObstaculoTemp() {
		return ubicacionObstaculoTemp;
	}

	public void setUbicacionObstaculoTemp(List<Celda> ubicacionObstaculoTemp) {
		this.ubicacionObstaculoTemp = ubicacionObstaculoTemp;
	}

	public String getTipoObstaculo() {
		return tipoObstaculo;
	}

	public void setTipoObstaculo(String tipoObstaculo) {
		this.tipoObstaculo = tipoObstaculo;
	}

	public int getComienzoObstaculoTemp() {
		return comienzoObstaculoTemp;
	}

	public void setComienzoObstaculoTemp(int comienzoObstaculoTemp) {
		this.comienzoObstaculoTemp = comienzoObstaculoTemp;
	}

	public int getTerminaObstaculoTemp() {
		return terminaObstaculoTemp;
	}

	public void setTerminaObstaculoTemp(int terminaObstaculoTemp) {
		this.terminaObstaculoTemp = terminaObstaculoTemp;
	}

	
	
	
	
	
	
}
