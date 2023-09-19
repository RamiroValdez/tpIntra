package tpIntra;

public class CicloLectivo {
	
	private String fechaInicio;
	private String fechaFin;
	private String fechaInscripciones;

	public CicloLectivo(String fechaInicio, String fechaFin, String fechaInscripciones){
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaInscripciones = fechaInscripciones;
	
	}
	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getFechaInscripciones() {
		return fechaInscripciones;
	}

	public void setFechaInscripciones(String fechaInscripciones) {
		this.fechaInscripciones = fechaInscripciones;
	}


}
